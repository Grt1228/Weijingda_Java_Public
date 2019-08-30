package com.jgsu.controller.backecd;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.Calendar;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.ICalendarService;
import com.jgsu.service.IUserInfoService;
import com.jgsu.utils.ResponseToEasyUiData;
import com.jgsu.vo.CalendarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 描述:
 * 后台日历相关操作
 *
 * @author grt
 * @create 2018-06-12 22:24
 */
@Controller
@RequestMapping("/back/calendar")
public class CalendarManagerController {
    @Autowired
    private ICalendarService iCalendarService;
    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public Map list(HttpSession session, @RequestBody CalendarRequest calendarRequest){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            ServerResponse response = ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
            return ResponseToEasyUiData.toEasyUiData(response);
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            ServerResponse<PageInfo> response = iCalendarService.list(calendarRequest);
            return ResponseToEasyUiData.toEasyUiData(response);
        }else{
            return ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError("没有管理员权限"));
        }
    }

    /**
     * 新增支持批量新增
     * @param session
     * @param calendarRequest
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse add(HttpSession session, @RequestBody CalendarRequest calendarRequest){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            ServerResponse response = ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
            return response;
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            ServerResponse response = iCalendarService.add(calendarRequest);
            return response;
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }

    /**
     * 新增支持批量新增
     * @param session
     * @param calendar
     * @return
     */
    @RequestMapping(value = "/addDesc",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse add(HttpSession session, @RequestBody Calendar calendar){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            ServerResponse response = ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
            return response;
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            ServerResponse response = iCalendarService.addDesc(calendar);
            return response;
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse update(HttpSession session, @RequestBody Calendar calendar){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            ServerResponse response = ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
            return response;
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            ServerResponse response = iCalendarService.update(calendar);
            return response;
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse delete(HttpSession session, @RequestBody Calendar calendar){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            ServerResponse response = ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
            return response;
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            ServerResponse response = iCalendarService.delete(calendar);
            return response;
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }

}