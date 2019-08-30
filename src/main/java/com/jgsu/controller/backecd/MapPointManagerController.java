package com.jgsu.controller.backecd;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.MapPoint;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IMapPointService;
import com.jgsu.service.IUserInfoService;
import com.jgsu.utils.ResponseToEasyUiData;
import com.jgsu.vo.map.MapRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 描述:
 * 地图点后台管理
 *
 * @author grt
 * @create 2018-08-03 0:13
 */
@Controller
@RequestMapping("/back/map/point")
public class MapPointManagerController {
    @Autowired
    private IMapPointService iMapPointService;
    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map getList(@RequestBody MapRequest mapRequest, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ResponseToEasyUiData.toEasyUiData(
                    ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc()));
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            ServerResponse<PageInfo> lostGoodList = iMapPointService.getListBack(mapRequest);
            return ResponseToEasyUiData.toEasyUiData(lostGoodList);
        }else{
            return ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError("没有管理员权限"));
        }
    }

    @RequestMapping(value = "addOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse save(HttpSession session, @RequestBody MapPoint mapPoint){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iMapPointService.addOrUpdate(mapPoint);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse delete(HttpSession session, @RequestBody MapPoint mapPoint){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iMapPointService.delete(mapPoint);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }
}