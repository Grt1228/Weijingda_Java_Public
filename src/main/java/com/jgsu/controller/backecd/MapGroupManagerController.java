package com.jgsu.controller.backecd;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.MapGroup;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IMapGroupService;
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
 * 后台点分组
 *
 * @author grt
 * @create 2018-08-05 10:56
 */
@Controller
@RequestMapping(value = "/back/map/group")
public class MapGroupManagerController {
    @Autowired
    private IMapGroupService iMapGroupService;

    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map getList( @RequestBody MapRequest mapRequest, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ResponseToEasyUiData.toEasyUiData(
                    ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc()));
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            //Integer pageNum = Integer.valueOf(request.getParameter("page"));
            //Integer pageSize = Integer.valueOf(request.getParameter("rows"));
            //mapRequest.setPageNum(pageNum);
            //mapRequest.setPageSize(pageSize);
            ServerResponse<PageInfo> mapGroupList = iMapGroupService.getListBack(mapRequest);
            return ResponseToEasyUiData.toEasyUiData(mapGroupList);
        }else{
            return ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError("没有管理员权限"));
        }
    }

    @RequestMapping(value = "addOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse save(HttpSession session,@RequestBody MapGroup mapGroup){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iMapGroupService.addOrUpdate(mapGroup);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }
}