package com.jgsu.controller.backecd;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.LostGood;
import com.jgsu.pojo.PhoneBook;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IPhoneBookService;
import com.jgsu.service.IUserInfoService;
import com.jgsu.utils.ResponseToEasyUiData;
import com.jgsu.vo.phone.PhoneBookRequest;
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
 * 通讯录管理后台
 *
 * @author grt
 * @create 2018-03-04 18:34
 */
@Controller
@RequestMapping("/back/phonebook")
public class PhoneBookManagerController {

    @Autowired
    private IPhoneBookService iPhoneBookService;
    @Autowired
    private IUserInfoService iUserInfoService;

    /**
     * 后台展示通讯录列表
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public Map getLostGoodList(HttpSession session, HttpServletRequest request
            , @RequestBody PhoneBookRequest phoneBookRequest){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return  ResponseToEasyUiData.toEasyUiData(
                    ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc()));
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            ServerResponse<PageInfo> phoneBookList = iPhoneBookService.getPhoneBookList(user.getRole(), phoneBookRequest);
            return ResponseToEasyUiData.toEasyUiData(phoneBookList);
        }else{
            return  ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError("没有管理员权限"));
        }
    }

    /**
     * 后台修改通讯录状态为有效
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateStatusById(HttpSession session,HttpServletRequest request){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            String phoneBookId = request.getParameter("phoneBookId");
            String status = request.getParameter("status");
            return iPhoneBookService.updateStatus(phoneBookId,status);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }

    /**
     * 后台添加一条通讯录
     * @param session
     * @param phoneBook
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse add(HttpSession session,@RequestBody PhoneBook phoneBook,HttpServletRequest request){
        request.getParameter("phoneNumber");
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iPhoneBookService.addOnePhoneNumber(phoneBook);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }

    /**
     * 修改一条记录
     * @param session
     * @param phoneBook
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse update(HttpSession session,@RequestBody PhoneBook phoneBook){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iPhoneBookService.updateOnePhoneBook(phoneBook);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }
    //todo 查询全部的带你话级别 （用遍历枚举的方法，避免重复更新）
}