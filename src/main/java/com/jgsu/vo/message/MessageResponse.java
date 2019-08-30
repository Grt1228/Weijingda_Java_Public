package com.jgsu.vo.message;

import lombok.Data;

import java.util.Date;

/**
 * 描述:
 * 留言
 *
 * @author grt
 * @create 2018-09-02 18:23
 */
@Data
public class MessageResponse {
    private Long pkId;

    private String messageId;

    private String loginName;
    /**
     * openid
     */
    private String openid;
    /**
     * 微信名称
     */
    private String nickName;
    /**
     * 微信头像
     */
    private String avatarUrl;
    /**
     * 留言详情
     */
    private String content;
    /**
     * 点赞数量
     */
    private Integer likedcount;
    /**
     * 是否匿名
     */
    private String incognito;
    /**
     * 是否匿名
     */
    private String incognitoDesc;
    /**
     * 状态
     */
    private String status;
    /**
     * 状态描述
     */
    private String statusCode;

    private Date createTime;

    private Date modifiedTime;

    public MessageResponse(Long pkId, String messageId, String loginName, String openid, String nickName, String avatarUrl, String content, Integer likedcount, String incognito, String status, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.messageId = messageId;
        this.loginName = loginName;
        this.openid = openid;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.content = content;
        this.likedcount = likedcount;
        this.incognito = incognito;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }
}