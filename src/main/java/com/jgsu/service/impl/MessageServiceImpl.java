package com.jgsu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jgsu.common.Const;
import com.jgsu.common.ServerResponse;
import com.jgsu.dao.MessageMapper;
import com.jgsu.dao.UserInfoMapper;
import com.jgsu.pojo.Message;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IMessageService;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.vo.message.MessageForm;
import com.jgsu.vo.message.MessageRequest;
import com.jgsu.vo.message.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;


/**
 * 描述:
 * 留言
 *
 * @author lqd12
 * @create 2018-09-02 18:31
 */
@Service("iMessageService")
@Slf4j
public class MessageServiceImpl implements IMessageService{
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    private static Integer ONE = 1;
    private static Integer ZERO = 0;

    @Override
    public ServerResponse insert(MessageForm messageForm) {
        log.info("新增留言信息参数："+messageForm);
        //判断openid是否存在
        List<String> openid = Lists.newArrayList();
        openid.add(messageForm.getOpenid());
        List<UserInfo> user = userInfoMapper.findWecatInfoListByOpenidList(openid);
        if(user.size()==0){
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(messageForm,userInfo);
            userInfo.setStudentId(UUIDUtil.getUUID());
            userInfo.setRole(String.valueOf(Const.Role.ROLE_CUSTOMER));
            userInfo.setStatus(Const.Status.YES.toString());
            int insert = userInfoMapper.insert(userInfo);
            if(insert<0){
                log.error("新增留言插入用户出错");
                return ServerResponse.createByError("新增失败，请反馈");
            }
        }
        Message message = new Message();
        BeanUtils.copyProperties(messageForm,message);
        if(message.getStatus()==null||message.getStatus()==""){
            message.setStatus(Const.Status.YES.toString());
        }
        message.setLikedcount(ZERO);
        message.setMessageId(UUIDUtil.getUUID());
        int insert = messageMapper.insert(message);
        if(insert<=0){
            log.error("新增留言失败");
            return ServerResponse.createByError("新增失败，请反馈");
        }
        return ServerResponse.createBySuccess("新增成功");
    }

    @Override
    public ServerResponse updateById(Message message) {
        log.info("修改留言信息参数："+message);
        int update = messageMapper.updateByPrimaryKeySelective(message);
        if(update<0){
            log.error("修改留言失败");
            return ServerResponse.createByError("修改失败，请反馈");
        }
        return ServerResponse.createBySuccess("修改成功");
    }

    @Override
    public ServerResponse<Message> selectById(String messageId) {
        log.info("查询一条留言信息参数："+messageId);
        Message message = messageMapper.selectByPrimaryKey(messageId);
        if(message==null){
            log.error("查询一条留言失败");
            return ServerResponse.createByError("获取失败，请反馈");
        }
        return ServerResponse.createBySuccess(message);
    }

    @Override
    public ServerResponse<PageInfo> list(MessageRequest messageRequest) {
        log.info("获取留言列表参数："+messageRequest);
        try {
            //后台
            PageHelper.startPage(messageRequest.getPageNum(),messageRequest.getPageSize());
            List<MessageResponse> messageList = messageMapper.list(messageRequest);
            buildResponse(messageList);
            PageInfo pageResult = new PageInfo();
            pageResult.setList(messageList);
            return ServerResponse.createBySuccess(pageResult);
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取留言列表异常："+e);
        }
        return ServerResponse.createByError("获取留言列表异常");
    }

    @Override
    @Transactional
    public ServerResponse liked(String messageId) {
        //先查询
        Message message = messageMapper.selectByPrimaryKey(messageId);
        if(message==null){
            log.error("留言不存在："+messageId);
            return ServerResponse.createByError("操作失败");
        }
        //再增加更新
        Integer resultLiked = message.getLikedcount() + ONE;
        message.setLikedcount(resultLiked);
        int i = messageMapper.updateByPrimaryKeySelective(message);
        if(i<=0){
            log.error("点在留言失败："+messageId);
            return ServerResponse.createByError("操作失败");
        }
        return ServerResponse.createBySuccess(message);
    }

    @Override
    @Transactional
    public ServerResponse unLiked(String messageId) {
        //先查询
        Message message = messageMapper.selectByPrimaryKey(messageId);
        if(message==null){
            log.error("留言不存在："+messageId);
            return ServerResponse.createByError("操作失败");
        }
        //再减少更新
        if(message.getLikedcount()<=ZERO){
            message.setLikedcount(ZERO);
        }else{
            Integer resultLiked = message.getLikedcount() - ONE;
            message.setLikedcount(resultLiked);
        }
        int i = messageMapper.updateByPrimaryKeySelective(message);
        if(i<=0){
            log.error("取消留言失败："+messageId);
            return ServerResponse.createByError("操作失败");
        }
        return ServerResponse.createBySuccess(message);
    }

    private void buildResponse( List<MessageResponse> responseList) throws InvocationTargetException, IllegalAccessException {
        //for循环查询用户的微信信息
        List<String> openIdList = Lists.newArrayList();
        for(MessageResponse message:responseList){
            message.setStatusCode(message.getStatus().toString().
                    equals(Const.Status.YES.toString())?Const.Status.YES_DESC:Const.Status.NO_DESC);
            message.setIncognitoDesc(Const.IncognitoEnum.codeOf(Integer.parseInt(message.getIncognito())).getValue());
        }
    }
}