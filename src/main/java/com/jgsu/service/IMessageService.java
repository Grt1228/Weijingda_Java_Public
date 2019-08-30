package com.jgsu.service;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.Message;
import com.jgsu.vo.message.MessageForm;
import com.jgsu.vo.message.MessageRequest;

/**
 * 描述:
 * 留言版
 *
 * @author lqd12
 * @create 2018-09-02 18:26
 */
public interface IMessageService {

    /**
     * 新增
     * @param messageForm
     * @return
     */
    ServerResponse insert(MessageForm messageForm);

    /**
     * 更新
     * @param message
     * @return
     */
    ServerResponse updateById(Message message);

    /**
     * 查询Byid
     * @param messageId
     * @return
     */
    ServerResponse<Message> selectById(String messageId);

    /**
     * 查询列表
     * @param messageRequest
     * @return
     */
    ServerResponse<PageInfo> list(MessageRequest messageRequest);

    /**
     * 点赞
     * @param messageId
     * @return
     */
    ServerResponse liked(String messageId);

    /**
     * 取消点赞
     * @param messageId
     * @return
     */
    ServerResponse unLiked(String messageId);

}
