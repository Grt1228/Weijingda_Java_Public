package com.jgsu.service;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.Calendar;
import com.jgsu.vo.CalendarRequest; /**
 * 描述:
 * 日历相关
 *
 * @author grt
 * @create 2018-06-12 22:27
 */
public interface ICalendarService {
    /**
     * 获取日历list
     * @param calendarRequest
     * @return
     */
    ServerResponse<PageInfo> list(CalendarRequest calendarRequest);

    /**
     * 新增或修改日历
     * @param calendarRequest
     * @return
     */
    ServerResponse add(CalendarRequest calendarRequest);

    ServerResponse update(Calendar calendar);

    ServerResponse delete(Calendar calendar);

    /**
     * 添加描述校历信息
     * @param calendar
     * @return
     */
    ServerResponse addDesc(Calendar calendar);
}