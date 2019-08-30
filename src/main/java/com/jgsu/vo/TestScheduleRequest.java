package com.jgsu.vo;

/**
 * 描述:
 * 考试安排request
 *
 * @author grt
 * @create 2018-05-17 19:38
 */
public class TestScheduleRequest extends PageRequest{
    private String cookie;
    private String loginName;
    private String studentId;

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "TestScheduleRequest{" +
                "cookie='" + cookie + '\'' +
                ", loginName='" + loginName + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}