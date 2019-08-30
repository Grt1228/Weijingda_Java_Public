package com.jgsu.service;

import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.SchoolCalendar;

import java.util.List;

/**
 * 描述:
 * 校历
 *
 * @author grt
 * @create 2018-03-05 22:06
 */
public interface ISchoolCalendarService {
    /**
     * 获取当前学期的校历
     * @return
     */
    ServerResponse<SchoolCalendar> getCurrentCalendar();

    /**
     * 后台获取全部的校历
     * @return
     */
    ServerResponse<List<SchoolCalendar>> getAllCalendar();
}
