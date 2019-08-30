package com.jgsu.vo;

/**
 * 描述:
 * cetvo
 *
 * @author grt
 * @create 2018-03-01 23:03
 */
public class CetVo {
    private String studentName;
    private String cetNumber;
    private String checkCode;
    private String cookie;

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCetNumber() {
        return cetNumber;
    }

    public void setCetNumber(String cetNumber) {
        this.cetNumber = cetNumber;
    }

    @Override
    public String toString() {
        return "CetVo{" +
                "studentName='" + studentName + '\'' +
                ", cetNumber='" + cetNumber + '\'' +
                ", cookie='" + cookie + '\'' +
                ", checkCode='" + checkCode + '\'' +
                '}';
    }
}