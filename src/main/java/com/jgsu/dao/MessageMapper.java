package com.jgsu.dao;

import com.jgsu.pojo.Message;
import com.jgsu.vo.message.MessageRequest;
import com.jgsu.vo.message.MessageResponse;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Long pkId);

    /**
     * 新增记录
     * @param record
     * @return
     */
    int insert(Message record);

    int insertSelective(Message record);

    /**
     * 通过messageId查询一条记录
     * @param messageId
     * @return
     */
    Message selectByPrimaryKey(String messageId);

    /**
     * 更新一条记录
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    /**
     * 查询留言List
     * 可以查询某人的留言列表
     * 或者查询全部的留言列表
     * @param messageRequest
     * @return
     */
    List<MessageResponse> list(MessageRequest messageRequest);

}