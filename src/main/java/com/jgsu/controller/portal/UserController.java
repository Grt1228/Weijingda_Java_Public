package com.jgsu.controller.portal;

import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IUserInfoService;
import com.jgsu.vo.CheckCodeVo;
import com.jgsu.vo.LoginVo;
import com.jgsu.vo.WechatInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 描述:
 * 登陆controller
 *
 * @author grt
 * @create 2018-02-07 21:45
 */
@Controller
@RequestMapping(value = "/portal/user/")
public class UserController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserInfo> login(@RequestBody LoginVo loginVo , HttpSession session){
        CheckCodeVo checkCodeVo = (CheckCodeVo) session.getAttribute(Const.USER_CHECKCODE_COOKIE);
        loginVo.setCookie(checkCodeVo.getCookie());
        ServerResponse<UserInfo> response =
                iUserInfoService.login(loginVo);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    @RequestMapping(value = "/getcheckcode.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<CheckCodeVo> getCheckCode(HttpSession session,HttpServletRequest request){
        ServerResponse<CheckCodeVo> response = iUserInfoService.getCheckCode();
        CheckCodeVo data = response.getData();
        data.setSessionId(request.getSession().getId());
        if(response.isSuccess()){
            session.setAttribute(Const.USER_CHECKCODE_COOKIE, data);
        }
        return response;
    }

    @RequestMapping(value = "/getScore.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getScore(HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iUserInfoService.getScore(user);
    }
    @RequestMapping(value = "/getTestSchedule.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getTestSchedule(HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iUserInfoService.getTestSchedule(user);
    }
    @RequestMapping(value = "/updateScore.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateScore(HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iUserInfoService.updateScore(user);
    }

    @RequestMapping(value = "/getWechatInfo.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<WechatInfoVo> getWechatInfo(@RequestBody WechatInfoVo wechatInfoVo){
        ServerResponse<WechatInfoVo> response = iUserInfoService.getWechatInfo(wechatInfoVo);
        return response;
    }

    @RequestMapping(value = "/saveWechatInfo.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse saveWechatInfo(@RequestBody WechatInfoVo wechatInfoVo){
        ServerResponse response = iUserInfoService.saveWechatInfo(wechatInfoVo);
        return response;
    }
}