package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class SchoolCalendar {
    private Long pkId;

    private String calendarId;

    private String calendarDate;

    private String calendarUrl;

    private String isCurrentYear;

    private Date createTime;

    private Date modifiedTime;

    public SchoolCalendar(Long pkId, String calendarId, String calendarDate, String calendarUrl, String isCurrentYear, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.calendarId = calendarId;
        this.calendarDate = calendarDate;
        this.calendarUrl = calendarUrl;
        this.isCurrentYear = isCurrentYear;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public SchoolCalendar() {
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

    public String getCalendarUrl() {
        return calendarUrl;
    }

    public void setCalendarUrl(String calendarUrl) {
        this.calendarUrl = calendarUrl == null ? null : calendarUrl.trim();
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
}