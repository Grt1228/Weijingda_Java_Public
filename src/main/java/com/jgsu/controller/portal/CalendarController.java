package com.jgsu.controller.portal;

import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.Calendar;
import com.jgsu.service.ICalendarService;
import com.jgsu.utils.ResponseToEasyUiData;
import com.jgsu.vo.CalendarRequest;
import com.jgsu.vo.ImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 前端日历相关
 *
 * @author grt
 * @create 2018-06-12 23:51
 */
@Controller
@RequestMapping(value = "/portal/calendar")
public class CalendarController {
    @Autowired
    private ICalendarService iCalendarService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse list( @RequestBody CalendarRequest calendarRequest){
        calendarRequest.setPageNum(1);
        calendarRequest.setPageSize(31);
        return iCalendarService.list(calendarRequest);
    }
}