package com.jgsu.controller.portal;

import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.SchoolCalendar;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.ISchoolCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 描述:
 * 校历
 *
 * @author grt
 * @create 2018-03-05 22:05
 */
@Controller
@RequestMapping("/portal/calendar/")
public class SchoolCalendarController {
    @Autowired
    private ISchoolCalendarService iSchoolCalendarService;

    @RequestMapping(value = "currentCalendar.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<SchoolCalendar> getCurrentCalendar(HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iSchoolCalendarService.getCurrentCalendar();
    }
}