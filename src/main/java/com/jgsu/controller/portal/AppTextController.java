package com.jgsu.controller.portal;


import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IAppTextService;
import com.jgsu.utils.ResponseToEasyUiData;
import com.jgsu.vo.apptext.AppTextRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/portal/text")
public class AppTextController {

    @Autowired
    private IAppTextService iAppTextService;

    /**
     * 获取列表
     * @param appTextRequest
     * @param request
     * @return
     */
    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestBody AppTextRequest appTextRequest,
                    HttpServletRequest request){
        //Integer pageNum = Integer.valueOf(request.getParameter("page"));
        //Integer pageSize = Integer.valueOf(request.getParameter("rows"));
        //appTextRequest.setPageNum(pageNum);
        //appTextRequest.setPageSize(pageSize);
        return iAppTextService.list(appTextRequest);
    }
}
