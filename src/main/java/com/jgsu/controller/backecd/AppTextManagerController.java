package com.jgsu.controller.backecd;


import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.AppText;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IAppTextService;
import com.jgsu.service.IUserInfoService;
import com.jgsu.utils.ResponseToEasyUiData;
import com.jgsu.vo.apptext.AppTextRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/back/text")
public class AppTextManagerController {

    @Autowired
    private IAppTextService iAppTextService;
    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public Map list(HttpSession session, @RequestBody AppTextRequest appTextRequest){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ResponseToEasyUiData.toEasyUiData(
                    ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc()));
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            ServerResponse<PageInfo> appTextList = iAppTextService.list(appTextRequest);
            return ResponseToEasyUiData.toEasyUiData(appTextList);
        }else{
            return ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError("没有管理员权限"));
        }
    }
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse insert(@RequestBody AppText appText,HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iAppTextService.insert(appText);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }


    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ServerResponse update(@RequestBody AppText appText,HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iAppTextService.update(appText);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }
}
