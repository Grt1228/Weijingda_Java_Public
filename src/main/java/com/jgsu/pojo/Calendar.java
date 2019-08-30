package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Calendar {
    private Long pkId;

    private String calendarId;

    private String calendarDate;

    private String calendarType;

    private String calendarYear;

    private String calendarMonth;

    private String calendarDay;

    private String calendarTitle;

    private String calendarInfo;

    private String isCurrentYear;

    private Date createTime;

    private Date modifiedTime;

    private String status;

    public Calendar(Long pkId, String calendarId, String calendarDate, String calendarType, String calendarYear, String calendarMonth, String calendarDay, String calendarTitle, String calendarInfo, String isCurrentYear, Date createTime, Date modifiedTime,String status) {
        this.pkId = pkId;
        this.calendarId = calendarId;
        this.calendarDate = calendarDate;
        this.calendarType = calendarType;
        this.calendarYear = calendarYear;
        this.calendarMonth = calendarMonth;
        this.calendarDay = calendarDay;
        this.calendarTitle = calendarTitle;
        this.calendarInfo = calendarInfo;
        this.isCurrentYear = isCurrentYear;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.status = status;
    }

    public Calendar() {
        super();
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId == null ? null : calendarId.trim();
    }

    public String getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(String calendarDate) {
        this.calendarDate = calendarDate == null ? null : calendarDate.trim();
    }

    public String getCalendarType() {
        return calendarType;
    }

    public void setCalendarType(String calendarType) {
        this.calendarType = calendarType == null ? null : calendarType.trim();
    }

    public String getCalendarYear() {
        return calendarYear;
    }

    public void setCalendarYear(String calendarYear) {
        this.calendarYear = calendarYear == null ? null : calendarYear.trim();
    }

    public String getCalendarMonth() {
        return calendarMonth;
    }

    public void setCalendarMonth(String calendarMonth) {
        this.calendarMonth = calendarMonth == null ? null : calendarMonth.trim();
    }

    public String getCalendarDay() {
        return calendarDay;
    }

    public void setCalendarDay(String calendarDay) {
        this.calendarDay = calendarDay;
    }

    public String getCalendarTitle() {
        return calendarTitle;
    }

    public void setCalendarTitle(String calendarTitle) {
        this.calendarTitle = calendarTitle == null ? null : calendarTitle.trim();
    }

    public String getCalendarInfo() {
        return calendarInfo;
    }

    public void setCalendarInfo(String calendarInfo) {
        this.calendarInfo = calendarInfo == null ? null : calendarInfo.trim();
    }

    public String getIsCurrentYear() {
        return isCurrentYear;
    }

    public void setIsCurrentYear(String isCurrentYear) {
        this.isCurrentYear = isCurrentYear == null ? null : isCurrentYear.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}