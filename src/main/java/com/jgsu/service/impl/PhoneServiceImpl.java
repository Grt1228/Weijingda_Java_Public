package com.jgsu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jgsu.common.Const;
import com.jgsu.common.PhoneLevelType;
import com.jgsu.common.ServerResponse;
import com.jgsu.dao.PhoneBookMapper;
import com.jgsu.pojo.PhoneBook;
import com.jgsu.service.IPhoneBookService;
import com.jgsu.utils.DateUtil;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.vo.PhoneBookVo;
import com.jgsu.vo.phone.PhoneBookRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * phoneBookImpl
 *
 * @author lqd12
 * @create 2018-02-27 21:28
 */
@Service("iPhoneBookService")
public class PhoneServiceImpl implements IPhoneBookService {
    private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private PhoneBookMapper phoneBookMapper;

    @Override
    public ServerResponse<PageInfo> getPhoneBookList(String role, PhoneBookRequest phoneBookRequest) {
        logger.info("查询通讯录参数："+phoneBookRequest.getPhoneLevel()+phoneBookRequest.getPhoneName());
        try {
            if(String.valueOf(Const.Role.ROLE_ADMIN).equals(role)){
                //后台
                logger.info("后台查询通讯录参数："+phoneBookRequest.getPhoneLevel()+phoneBookRequest.getPhoneName());
                PageHelper.startPage(phoneBookRequest.getPageNum(),phoneBookRequest.getPageSize());
                List<PhoneBook> phoneList = phoneBookMapper.selectAllLostGood(phoneBookRequest.getStatus(),phoneBookRequest.getPhoneLevel()
                        ,phoneBookRequest.getPhoneName());
                List<PhoneBookVo> phoneBookVoList = Lists.newArrayList();
                buildPoneListVo(phoneList,phoneBookVoList);
                PageInfo pageResult = new PageInfo(phoneList);
                pageResult.setList(phoneBookVoList);
                return ServerResponse.createBySuccess(pageResult);
            }
            //前台只要有效值
            logger.info("前台查询通讯录参数："+phoneBookRequest.getPhoneLevel()+phoneBookRequest.getPhoneName());
            PageHelper.startPage(phoneBookRequest.getPageNum(),phoneBookRequest.getPageSize());
            List<PhoneBook> phoneList = phoneBookMapper.selectAllLostGood(String.valueOf(Const.PhoneNumberStatus.YES),phoneBookRequest.getPhoneLevel()
                    , phoneBookRequest.getPhoneName());
            List<PhoneBookVo> phoneBookVoList = Lists.newArrayList();
            buildPoneListVo(phoneList,phoneBookVoList);
            PageInfo pageResult = new PageInfo(phoneList);
            pageResult.setList(phoneBookVoList);
            return ServerResponse.createBySuccess(pageResult);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("查询通讯录异常："+e);
        }
        return ServerResponse.createByError("查询通讯录异常");
    }


    @Override
    public ServerResponse addOnePhoneNumber(PhoneBook phoneBook) {
        logger.info("新增通讯录参数："+phoneBook);
        try {
            phoneBook.setPhoneBookId(UUIDUtil.getUUID());
            int insert = phoneBookMapper.insert(phoneBook);
            if(insert>0){
                if(StringUtils.equals(phoneBook.getStatus(), String.valueOf(Const.PhoneNumberStatus.YES))){
                    return ServerResponse.createBySuccess("新增通讯录成功");
                }
                return ServerResponse.createBySuccess("新增通讯录成功，待审核！");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("新增通讯录异常："+e);
        }
        return ServerResponse.createByError("新增通讯录异常，请联系管理员");
    }

    @Override
    public ServerResponse updateOnePhoneBook(PhoneBook phoneBook) {
        logger.info("更新通讯录参数："+phoneBook);
        try {
            int i = phoneBookMapper.updateByPrimaryKeySelective(phoneBook);
            if(i>0){
                if(StringUtils.equals(phoneBook.getStatus(), String.valueOf(Const.PhoneNumberStatus.YES))){
                    return ServerResponse.createBySuccess("修改电话成功");
                }
                return ServerResponse.createBySuccess("修改电话成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("更新通讯录异常："+e);
        }
        return ServerResponse.createByError("更新通讯录异常，联系管理员");
    }

    @Override
    public ServerResponse updateStatus(String phoneBookId, String status) {
        logger.info("更新通讯录状态参数："+phoneBookId,status);
        try {
            if(String.valueOf(Const.PhoneNumberStatus.YES).equals(status)){
                status = String.valueOf(Const.PhoneNumberStatus.NO);
            }else{
                status = String.valueOf(Const.PhoneNumberStatus.YES);
            }
            int i = phoneBookMapper.updateStatusByLostGoodId(phoneBookId,status);
            if(i>0){
                return ServerResponse.createBySuccess("更新通讯录状态成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("更新通讯录状态异常："+e);
        }
        return ServerResponse.createByError("更新通讯录状态异常");
    }

    /**
     * 封装返回值电话簿集合
     * @param phoneList
     * @param phoneBookVoList
     */
    private void buildPoneListVo(List<PhoneBook> phoneList, List<PhoneBookVo> phoneBookVoList) {
        for (PhoneBook phoneBook:phoneList){
            PhoneBookVo vo = new PhoneBookVo();
            vo.setCreateTime(DateUtil.dateToStr(phoneBook.getCreateTime()));
            vo.setModifiedTime(DateUtil.dateToStr(phoneBook.getModifiedTime()));
            vo.setPhoneBookId(phoneBook.getPhoneBookId());
            vo.setPhoneLevelCode(phoneBook.getPhoneLevel());
            vo.setPhoneName(phoneBook.getPhoneName());
            vo.setPhoneNumber(phoneBook.getPhoneNumber());
            vo.setPkId(phoneBook.getPkId());
            vo.setStatusCode(phoneBook.getStatus());
            PhoneLevelType[] values = PhoneLevelType.values();
            for(PhoneLevelType phoneLevelType:values){
                if(phoneLevelType.getCode().toString().equals(phoneBook.getPhoneLevel())){
                    vo.setPhoneLevelDesc(phoneLevelType.getDesc());
                }
            }
            vo.setStatusDesc(phoneBook.getStatus().equals(Const.NewStatus.YES.toString())?"有效":"失效");
            phoneBookVoList.add(vo);
        }

    }
}