package com.jgsu.vo;

/**
 * 描述:
 * 课程表request
 *
 * @author grt
 * @create 2018-06-01 5:04
 */
public class CourseRequest {
    /**
     * cookie
     */
    private String cookie;
    /**
     * loginName
     */
    private String loginName;
    /**
     * 当前学年
     */
    private String currentYear;
    /**
     * 当前第几周
     */
    private String currentWeek;
    /**
     * 星期几 周日用0代替
     */
    private String week;

    /**
     * VIEWSTATE
     * @return
     */
    private  String viewState;

    public String getViewState() {
        return viewState;
    }

    public void setViewState(String viewState) {
        this.viewState = viewState;
    }

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

    public String getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(String currentYear) {
        this.currentYear = currentYear;
    }

    public String getCurrentWeek() {
        return currentWeek;
    }

    public void setCurrentWeek(String currentWeek) {
        this.currentWeek = currentWeek;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "CourseRequest{" +
                "cookie='" + cookie + '\'' +
                ", loginName='" + loginName + '\'' +
                ", currentYear='" + currentYear + '\'' +
                ", currentWeek='" + currentWeek + '\'' +
                ", week='" + week + '\'' +
                ", viewState='" + viewState + '\'' +
                '}';
    }
}