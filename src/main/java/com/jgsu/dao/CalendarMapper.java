package com.jgsu.dao;

import com.jgsu.pojo.Calendar;
import com.jgsu.vo.CalendarRequest;

import java.util.List;

public interface CalendarMapper {
    int deleteByPrimaryKey(String calendarId);

    int insert(Calendar record);

    int insertSelective(Calendar record);

    Calendar selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(Calendar record);

    int updateByPrimaryKey(Calendar record);

    List<Calendar> list(CalendarRequest calendarRequest);

    int insertBatch(List<Calendar> calendarList);
}