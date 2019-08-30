package com.jgsu.dao;

import com.jgsu.pojo.SchoolCalendar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SchoolCalendarMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(SchoolCalendar record);

    int insertSelective(SchoolCalendar record);

    SchoolCalendar selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(SchoolCalendar record);

    int updateByPrimaryKey(SchoolCalendar record);

    SchoolCalendar getCurrentCalendar(@Param("isCurrentYear") String isCurrentYear);

    List<SchoolCalendar> getAllCalendar();
}