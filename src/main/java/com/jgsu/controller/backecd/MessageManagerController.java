package com.jgsu.controller.backecd;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.Message;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IMessageService;
import com.jgsu.service.IUserInfoService;
import com.jgsu.utils.ResponseToEasyUiData;
import com.jgsu.vo.message.MessageForm;
import com.jgsu.vo.message.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 描述:
 * 后台留言管理
 *
 * @author grt
 * @create 2018-09-03 23:39
 */
@Controller
@RequestMapping("/back/message")
public class MessageManagerController {

    @Autowired
    private IUserInfoService iUserInfoService;
    @Autowired
    private IMessageService iMessageService;

    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    @ResponseBody
    public Map list(HttpServletRequest request,
                    MessageRequest messageRequest, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc()));
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            Integer pageNum = Integer.valueOf(request.getParameter("page"));
            Integer pageSize = Integer.valueOf(request.getParameter("rows"));
            messageRequest.setPageNum(pageNum);
            messageRequest.setPageSize(pageSize);
            ServerResponse<PageInfo> response = iMessageService.list(messageRequest);
            return ResponseToEasyUiData.toEasyUiData(response);
        }else{
            return ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError("没有管理员权限"));
        }
    }

    @RequestMapping(value = "update.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse update(HttpServletRequest request,Message message, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return  iMessageService.updateById(message);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }

    @RequestMapping(value = "add.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse add(HttpServletRequest request, HttpServletResponse response,
                              MessageForm messageForm, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iMessageService.insert(messageForm);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }

}