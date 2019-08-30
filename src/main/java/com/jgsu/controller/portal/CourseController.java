package com.jgsu.controller.portal;

import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.CourseInfo;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.ICourseService;
import com.jgsu.vo.CheckCodeVo;
import com.jgsu.vo.CourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 描述:
 * 课程表获取
 *
 * @author guorutao
 * @create 2018-04-27 16:42
 */

@Controller
@RequestMapping(value = "/portal/course")
public class CourseController {

    @Autowired
    private ICourseService iCourseService;

    @RequestMapping(value = "courseList.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getCourse(HttpSession session,@RequestBody CourseRequest courseRequest){
        CheckCodeVo checkCodeVo = (CheckCodeVo) session.getAttribute(Const.USER_CHECKCODE_COOKIE);
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        courseRequest.setCookie(checkCodeVo.getCookie());
        courseRequest.setLoginName(user.getLoginName());
        ServerResponse response = iCourseService.getCourseList(courseRequest);
        return response;
    }


    @RequestMapping(value = "currentWeekYear.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse currentWeekYear(HttpServletRequest request,HttpSession session, String loginName){
        CheckCodeVo checkCodeVo = (CheckCodeVo) session.getAttribute(Const.USER_CHECKCODE_COOKIE);
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        ServerResponse response = iCourseService.currentWeekYear(user.getLoginName(),checkCodeVo.getCookie());
        return response;
    }
}
