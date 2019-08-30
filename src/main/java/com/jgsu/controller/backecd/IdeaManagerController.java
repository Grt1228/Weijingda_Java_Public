package com.jgsu.controller.backecd;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.Idea;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IIdeaService;
import com.jgsu.service.IUserInfoService;
import com.jgsu.utils.ResponseToEasyUiData;
import com.jgsu.vo.idea.IdeaRequest;
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
 * 后台idea
 *
 * @author grt
 * @create 2018-03-04 21:32
 */
@Controller
@RequestMapping(value = "/back/idea")
public class IdeaManagerController {
    @Autowired
    private IIdeaService iIdeaService;
    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public Map getAllIdea(HttpSession session, HttpServletRequest request, @RequestBody IdeaRequest ideaRequest){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            ServerResponse response = ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
            return ResponseToEasyUiData.toEasyUiData(response);
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            //Integer pageNum = Integer.valueOf(request.getParameter("page"));
            //Integer pageSize = Integer.valueOf(request.getParameter("rows"));
            ServerResponse<PageInfo> response = iIdeaService.getAllIdea(ideaRequest);
            return ResponseToEasyUiData.toEasyUiData(response);
        }else{
            return ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError("没有管理员权限"));
        }
    }
}