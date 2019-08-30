package com.jgsu.vo;

import lombok.Data;

/**
 * 描述:
 * 登陆所需参数vo
 *
 * @author grt
 * @create 2018-02-23 22:49
 */
@Data
public class LoginVo {
    private String loginName;
    private String password;
    private String checkCode;
    private String cookie;
    private String openId;


}