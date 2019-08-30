package com.jgsu.vo;

import lombok.Data;

import java.util.Date;

/**
 * 描述:
 * 日历相关request
 *
 * @author grt
 * @create 2018-06-12 22:23
 */
@Data
public class CalendarRequest extends PageRequest {
    /**
     * 日历记录id
     */
    private String calendarId;
    /**
     * 学年
     * '校历学期 2018-09~2019-06',
     */
    private String calendarDate;
    /**
     * 日历类型
     * '校历类型 0日期，1描述',
     */
    private String calendarType;
    /**
     * 日历年份
     */
    private String calendarYear;
    /**
     * 当前学年
     * '是不是当前学期，0-是，1-不是',
     */
    private String isCurrentYear;

    private String calendarMonth;

    private String calendarDay;

    private Date beginDate;

    private Date endDate;

    private String calendarInfo;

    private String status;

}