package com.jgsu.service;

import com.jgsu.common.Const;
import com.jgsu.common.ServerResponse;
import com.jgsu.dao.SchoolCalendarMapper;
import com.jgsu.pojo.SchoolCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * 校历
 *
 * @author grt
 * @create 2018-03-05 22:07
 */
@Service
public class SchoolCalendarService implements ISchoolCalendarService {
    @Autowired
    private SchoolCalendarMapper schoolCalendarMapper;

    @Override
    public ServerResponse<SchoolCalendar> getCurrentCalendar() {
        SchoolCalendar schoolCalendar =
                schoolCalendarMapper.getCurrentCalendar(String.valueOf(Const.IsCurrentCalendar.YES));
        return ServerResponse.createBySuccess(schoolCalendar);
    }

    @Override
    public ServerResponse<List<SchoolCalendar>> getAllCalendar() {
        List<SchoolCalendar> schoolCalendarList =
                schoolCalendarMapper.getAllCalendar();
        return ServerResponse.createBySuccess(schoolCalendarList);
    }
}