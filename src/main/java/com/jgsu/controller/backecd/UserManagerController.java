package com.jgsu.controller.backecd;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IUserInfoService;
import com.jgsu.utils.ResponseToEasyUiData;
import com.jgsu.vo.UserBackRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 描述:
 * 后台管理员登陆
 *
 * @author grt
 * @create 2018-02-28 21:46
 */
@Controller
@RequestMapping("/back/user/")
public class UserManagerController {

    @Autowired
    private IUserInfoService iUserInfoService;
    /**
     * 管理员登陆
     * @param session
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserInfo> login(HttpSession session, @RequestBody Map map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        ServerResponse<UserInfo> response = iUserInfoService.backLogin(username, password);
        //判断是不是管理员账号
        if(response.isSuccess()){
            UserInfo user = response.getData();
            if(user.getRole().equals(String.valueOf(Const.Role.ROLE_ADMIN))){
                //是管理员
                session.setAttribute(Const.CURRENT_USER,user);
                return response;
            }else{
                return ServerResponse.createByError("不是管理员账号，无法登陆");
            }
        }
        return response;
    }

    /**
     * 登出（注销）
     * @param session
     * @return
     */
    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    /**
     * 后台获取用户列表
     * @param session
     * @param userBackRequest
     * @param request
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map getUserList(HttpSession session, @RequestBody UserBackRequest userBackRequest, HttpServletRequest request){
        UserInfo userInfo = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(userInfo==null){
            return ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc()));
        }
        if(iUserInfoService.checkAdminRole(userInfo).isSuccess()){
            //Integer pageNum = Integer.valueOf(request.getParameter("offset"));
            //Integer pageSize = Integer.valueOf(request.getParameter("limit"));
            //userBackRequest.setPageNum(pageNum);
            //userBackRequest.setPageSize(pageSize);
            ServerResponse<PageInfo> userList = iUserInfoService.getUserList(userBackRequest);
            return ResponseToEasyUiData.toEasyUiData(userList);
        }else{
            return  ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError("没有管理员权限"));
        }
    }
    /**
     * 后台获取成绩单
     * @param session
     * @param userBackRequest
     * @param request
     * @return
     */
    @RequestMapping(value = "/score/list.do",method = RequestMethod.POST)
    @ResponseBody
    public Map getUserScoreList(HttpSession session, UserBackRequest userBackRequest, HttpServletRequest request){
        UserInfo userInfo = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(userInfo==null){
            return ResponseToEasyUiData.toEasyUiData
                    (ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc()));
        }
        if(iUserInfoService.checkAdminRole(userInfo).isSuccess()){
            Integer pageNum = Integer.valueOf(request.getParameter("page"));
            Integer pageSize = Integer.valueOf(request.getParameter("rows"));
            userBackRequest.setPageNum(pageNum);
            userBackRequest.setPageSize(pageSize);
            ServerResponse<PageInfo> userScoreList = iUserInfoService.getUserScoreList(userBackRequest);
            return ResponseToEasyUiData.toEasyUiData(userScoreList);
        }else{
            return  ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError("没有管理员权限"));
        }
    }
}