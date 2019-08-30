package com.jgsu.controller.backecd;

import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.SchoolCalendar;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.ISchoolCalendarService;
import com.jgsu.service.IUserInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 描述:
 * 后台校历
 *
 * @author grt
 * @create 2018-03-05 22:30
 */
@Controller
@RequestMapping("/back/calendar/")
public class SchoolCalendarManagerController {
    @Autowired
    private ISchoolCalendarService iSchoolCalendarService;
    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping(value = "/allCalendar.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<SchoolCalendar>> getAllCalendar(HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iSchoolCalendarService.getAllCalendar();
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }
}