package com.jgsu.vo;

/**
 * 描述:
 * 查询成绩相关的参数
 *
 * @author grt
 * @create 2018-02-25 0:00
 */
public class ScoreVo {
    private String cookie;
    private String loginName;

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "ScoreVo{" +
                "cookie='" + cookie + '\'' +
                ", loginName='" + loginName + '\'' +
                '}';
    }
}