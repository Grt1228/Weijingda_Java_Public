package com.jgsu.controller.backecd;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.AppImage;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IAppImageService;
import com.jgsu.service.IUserInfoService;
import com.jgsu.utils.ResponseToEasyUiData;
import com.jgsu.vo.ImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 图片管理
 *
 * @author grt
 * @create 2018-05-29 17:14
 */
@Controller
@RequestMapping("/back/image")
public class AppImageManagerController {
    @Autowired
    private IAppImageService iAppImageService;
    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public Map list(HttpSession session, @RequestBody ImageRequest imageRequest){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            ServerResponse response = ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
            return ResponseToEasyUiData.toEasyUiData(response);
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){

            ServerResponse<PageInfo> response = iAppImageService.list(imageRequest);
            return ResponseToEasyUiData.toEasyUiData(response);
        }else{
            return ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError("没有管理员权限"));
        }
    }
    @RequestMapping(value = "/addOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addOrUpdate(HttpSession session,  @RequestBody AppImage image){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            ServerResponse response = ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
            return response;
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            ServerResponse response = iAppImageService.addOrUpdate(image);
            return response;
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addOrUpdate(HttpSession session
            ,@RequestParam("file") MultipartFile multipartFile) throws IOException {
        /*UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            ServerResponse response = ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
            return response;
        }*/
        ///if(iUserInfoService.checkAdminRole(user).isSuccess()){
            FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();
            ServerResponse response = iAppImageService.uploadImg(inputStream);
            return response;
        /*}else{
            return ServerResponse.createByError("没有管理员权限");
        }*/
    }

}