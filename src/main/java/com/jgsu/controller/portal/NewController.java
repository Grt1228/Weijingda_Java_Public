package com.jgsu.controller.portal;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.NewContent;
import com.jgsu.pojo.UniversityNews;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.INewService;
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

/**
 * 描述:
 * 校园新闻前端
 *
 * @author grt
 * @create 2018-03-04 22:32
 */
@Controller
@RequestMapping(value = "/portal/new")
public class NewController {
    @Autowired
    private INewService iNewService;

    /**
     * 前台查询所有的新闻
     * @param newRequest
     * @return
     */
    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> getAllNews( HttpServletRequest request, @RequestBody NewRequest newRequest){
        /*UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }*/
        //newRequest.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
        //newRequest.setPageNum(Integer.parseInt(request.getParameter("pageNum")));
        //return iNewService.getAllNew(newRequest,user.getRole());
        return iNewService.getAllNew(newRequest,String.valueOf(Const.Role.ROLE_CUSTOMER));
    }

    /**
     * 前台查询所有的新闻
     * @param session
     * @return
     */
    @RequestMapping(value = "newType.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<String>> getAllNewType(HttpSession session){
        /*UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }*/
        return iNewService.getAllNewType();
    }
    /**
     * 前台查询所有的新闻
     * @param newContent
     * @return
     */
    @RequestMapping(value = "byId",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<NewContent> findById(@RequestBody NewContent newContent){
        return iNewService.findById(newContent);
    }

}