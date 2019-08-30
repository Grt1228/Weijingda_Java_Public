package com.jgsu.controller.backecd;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.NewContent;
import com.jgsu.pojo.UniversityNews;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.INewService;
import com.jgsu.service.IUserInfoService;
import com.jgsu.utils.ResponseToEasyUiData;
import com.jgsu.vo.NewRequest;
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
 * 校园新闻
 *
 * @author grt
 * @create 2018-03-04 22:30
 */
@Controller
@RequestMapping("/back/new")
public class NewManagerController {

    @Autowired
    private IUserInfoService iUserInfoService;
    @Autowired
    private INewService iNewService;

    /**
     * 后台展示新闻列表
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public Map getLostGoodList(HttpSession session, HttpServletRequest request,@RequestBody NewRequest newRequest){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc()));
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            //Integer pageNum = Integer.valueOf(request.getParameter("offset"));
            //Integer pageSize = Integer.valueOf(request.getParameter("limit"));
            //newRequest.setPageNum(pageNum);
            //newRequest.setPageSize(pageSize);
            ServerResponse<PageInfo> response = iNewService.getAllNew(newRequest,user.getRole());
            return ResponseToEasyUiData.toEasyUiData(response);
        }else{
            return ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError("没有管理员权限"));
        }
    }

    /**
     * 后台添加一条通讯录
     * @param session
     * @param universityNews
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse add(HttpSession session,@RequestBody UniversityNews universityNews){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iNewService.addOneNew(universityNews);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }

    /**
     * 修改一条记录
     * @param session
     * @param universityNews
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse update(HttpSession session,@RequestBody UniversityNews universityNews){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iNewService.updateOneNew(universityNews);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }

    /**
     * 修改一条记录
     * @param session
     * @param newContent
     * @return
     */
    @RequestMapping(value = "/content/add",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addContent(HttpSession session,@RequestBody NewContent newContent){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iNewService.addContent(newContent);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }


    /**
     * 修改一条记录
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/content/list",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getNewContentList(HttpSession session,@RequestBody NewRequest request){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iNewService.getNewContentList(request);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }


    /**
     * 修改一条记录
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/content/delete",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse deleteContent(HttpSession session,@RequestBody NewRequest request){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            return iNewService.deleteContent(request);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }

}