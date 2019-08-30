package com.jgsu.vo;

import lombok.Data;

import java.util.Arrays;
import java.util.Date;

/**
 * 描述:
 * 日历相关response
 *
 * @author grt
 * @create 2018-06-12 22:23
 */
@Data
public class CalendarResponse {
    private Long pkId;

    private String calendarId;

    private String calendarDate;

    private String calendarType;
    private String calendarTypeDesc;

    private String calendarYear;

    private String calendarMonth;

    private String calendarDay;

    private String calendarTitle;

    private String calendarInfo;

    private String isCurrentYear;
    private String isCurrentYearDesc;

    private String createTime;

    private String modifiedTime;

    private String status;
    private String statusDesc;

}