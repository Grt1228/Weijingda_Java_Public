package com.jgsu.vo;

/**
 * 描述:
 * 与验证码有关的实体类
 *
 * @author grt
 * @create 2018-02-24 22:56
 */
public class CheckCodeVo {
    private String cookie;
    private String checkCodeUrl;
    private String sessionId;

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getCheckCodeUrl() {
        return checkCodeUrl;
    }

    public void setCheckCodeUrl(String checkCodeUrl) {
        this.checkCodeUrl = checkCodeUrl;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "CheckCodeVo{" +
                ", cookie='" + cookie + '\'' +
                ", checkCodeUrl='" + checkCodeUrl + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}