package com.jgsu.vo;

import lombok.Data;

/**
 * 描述:
 * 微信相关信息‘
 *
 * @author grt
 * @create 2018-06-11 19:51
 */
@Data
public class WechatInfoVo extends PageRequest {
    private String jscode;
    private String appName;
    private String platform;
    private String v;
    private String openId;
    private String nickName;
    private String avatarUrl;
    private String country;
    private String gender;
    private String sessionKey;
    /**
     * QQ -- QQ
     * WX -- 微信
     */
    private String type;
}