package com.jgsu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jgsu.common.Const;
import com.jgsu.common.ServerResponse;
import com.jgsu.dao.LostGoodMapper;
import com.jgsu.pojo.LostGood;
import com.jgsu.pojo.UniversityNews;
import com.jgsu.service.ILostGoodService;
import com.jgsu.utils.DateUtil;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.vo.LostGoodRequest;
import com.jgsu.vo.LostGoodResponse;
import com.jgsu.vo.NewResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.Length;

import java.util.List;

/**
 * 描述:
 * 失物招领
 *
 * @author grt
 * @create 2018-02-28 20:01
 */
@Service("iLostGoodService")
public class LostGoodServiceImpl implements ILostGoodService {
    private Logger logger = LoggerFactory.getLogger(LostGoodServiceImpl.class);
    @Autowired
    private LostGoodMapper lostGoodMapper;

    @Override
    public ServerResponse<PageInfo> getLostGoodList(LostGoodRequest lostGoodRequest) {
        logger.info("查询失物招领参数："+lostGoodRequest);
        try {
            PageHelper.startPage(lostGoodRequest.getPageNum(),lostGoodRequest.getPageSize());
            List<LostGood> lostGoodList = lostGoodMapper.selectAllLostGood(lostGoodRequest);
            List<LostGoodResponse> lostGoodVoLit = Lists.newArrayList();
            buildLostGoodResponse(lostGoodList,lostGoodVoLit);
            PageInfo pageResult = new PageInfo(lostGoodList);
            pageResult.setList(lostGoodVoLit);
            return ServerResponse.createBySuccess(pageResult);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("查询失物招领异常："+e);
        }
        return ServerResponse.createByError("查询失物招领异常");
    }


    @Override
    public ServerResponse addOrUpdate(LostGood lostGood) {
        logger.info("更新或更新失物招领参数："+lostGood);
        try {
            if(lostGood!=null){
                //判断新增还是修改
                if(lostGood.getLostGoodId()== null){
                    lostGood.setLostGoodId(UUIDUtil.getUUID());
                    int insert = lostGoodMapper.insert(lostGood);
                    if(insert>0){
                        return ServerResponse.createBySuccess("发布消息成功，等待管理员审核");
                    }
                    return ServerResponse.createByError("发布消息失败，联系管理员");
                }else{
                    int update = lostGoodMapper.updateByLostGoodId(lostGood);
                    if(update>0){
                        return ServerResponse.createBySuccess("修改消息成功，等待管理员审核");
                    }
                    return ServerResponse.createByError("修改信息失败，联系管理员");
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("更新或更新失物招领异常"+e);
        }
        return ServerResponse.createByError("修改或新增失物招领记录参数错误");
    }


    @Override
    public ServerResponse add(LostGood lostGood) {
        logger.info("新增失物招领参数："+lostGood);
        try {
            //需要设置lostGoodId，没有传过来
            lostGood.setLostGoodId(UUIDUtil.getUUID());
            int insert = lostGoodMapper.insert(lostGood);
            if(insert>0){
                return ServerResponse.createBySuccess("发布消息成功，等待管理员审核");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("新增失物招异常："+e);
        }
        return ServerResponse.createByError("发布消息失败，联系管理员");
    }

    @Override
    public ServerResponse updateStatus(String lostGoodId, String status) {
        logger.info("后台更新失物招领状态");
        try {
            int i = lostGoodMapper.updateStatusByLostGoodId(lostGoodId,status);
            if(i>0){
                return ServerResponse.createBySuccess("修改状态成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("更新失物招领异常"+e);
        }
        return ServerResponse.createByError("修改状态失败");
    }

    @Override
    public ServerResponse findById(String lostGoodId) {
        if(lostGoodId==null || "".equals(lostGoodId)){
            ServerResponse.createByError("数据出错。");
        }
        LostGood good = lostGoodMapper.selectByPrimaryKey(lostGoodId);
        if(good==null){
            ServerResponse.createByError("数据出错。");
        }
        return ServerResponse.createBySuccess("成功",good);
    }

    /**
     * 装配返回值
     * @param lostGoodList
     * @param lostGoodVoLit
     */
    private void buildLostGoodResponse(List<LostGood> lostGoodList, List<LostGoodResponse> lostGoodVoLit) {
        for(LostGood lostGood:lostGoodList){
            LostGoodResponse vo = new LostGoodResponse();
            vo.setAdderMobile(lostGood.getAdderMobile());
            vo.setAdderName(lostGood.getAdderName());
            vo.setCreateTime(DateUtil.dateToStr(lostGood.getCreateTime()));
            vo.setGoodDetail(lostGood.getGoodDetail());
            vo.setGoodPosition(lostGood.getGoodPosition());
            vo.setGoodStatus(lostGood.getGoodStatus());
            vo.setGoodStatusDesc(lostGood.getGoodStatus().toString().
                    equals(Const.LostGoodStatus.YES_COMPLETE.toString())?Const.LostGoodStatus.YES_COMPLETE_DESC:Const.LostGoodStatus.NO_COMPLETE_DESC);
            vo.setGoodType(lostGood.getGoodType());
            vo.setGoodTypeDesc(lostGood.getGoodType().toString().
                    equals(Const.LostGoodType.GOOD_TYPE_IN.toString())?Const.LostGoodType.GOOD_TYPE_IN_DESC:Const.LostGoodType.GOOD_TYPE_OUT_DESC);
            vo.setOpenid(lostGood.getOpenid());
            vo.setLostGoodId(lostGood.getLostGoodId());
            vo.setModifiedTime(DateUtil.dateToStr(lostGood.getModifiedTime()));
            vo.setPkId(lostGood.getPkId());
            vo.setStatus(lostGood.getStatus());
            vo.setStatusDesc(lostGood.getStatus().toString().
                    equals(Const.Status.YES.toString())?Const.Status.YES_DESC:Const.Status.NO_DESC);
            vo.setGoodTitle(lostGood.getGoodTitle());
            vo.setImage(lostGood.getImage());
            lostGoodVoLit.add(vo);
        }
    }

}