package com.jgsu.vo.message;

import lombok.Data;

/**
 * 描述:
 * 表单提交数据
 *
 * @author grt
 * @create 2018-09-05 22:29
 */
@Data
public class MessageForm {
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
     * 是否匿名
     */
    private String incognito;
    /**
     * 状态
     */
    private String status;


}