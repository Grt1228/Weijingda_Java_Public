package com.jgsu.controller.backecd;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.LostGood;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.ILostGoodService;
import com.jgsu.service.IUserInfoService;
import com.jgsu.utils.ResponseToEasyUiData;
import com.jgsu.vo.LostGoodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 失物招领
 *
 * @author grt
 * @create 2018-02-28 19:59
 */
@Controller
@RequestMapping("/back/lostgood")
public class LostGoodManagerController {
    @Autowired
    private ILostGoodService iLostGoodService;
    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping(value = "/list.do",method = RequestMethod.POST)
    @ResponseBody
    public Map getLostGoodList(HttpSession session, HttpServletRequest request, LostGoodRequest lostGoodRequest){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ResponseToEasyUiData.toEasyUiData(
                    ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc()));
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            Integer pageNum = Integer.valueOf(request.getParameter("page"));
            Integer pageSize = Integer.valueOf(request.getParameter("rows"));
            lostGoodRequest.setPageNum(pageNum);
            lostGoodRequest.setPageSize(pageSize);
            ServerResponse<PageInfo> lostGoodList = iLostGoodService.getLostGoodList( lostGoodRequest);
            return ResponseToEasyUiData.toEasyUiData(lostGoodList);
        }else{
            return ResponseToEasyUiData.toEasyUiData(ServerResponse.createByError("没有管理员权限"));
        }
    }

    @RequestMapping(value = "/save.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateOneById(HttpSession session,HttpServletRequest request){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if(iUserInfoService.checkAdminRole(user).isSuccess()){
            String lostGoodId = request.getParameter("lostGoodId");
            String status = request.getParameter("status");
            return iLostGoodService.updateStatus(lostGoodId,status);
        }else{
            return ServerResponse.createByError("没有管理员权限");
        }
    }
}