package com.jgsu.controller.portal;

import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.Cet;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.ICetService;
import com.jgsu.vo.CetVo;
import com.jgsu.vo.CheckCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 描述:
 * 四六级查询
 *
 * @author grt
 * @create 2018-03-04 17:38
 */
@Controller
@RequestMapping(value = "/portal/cet")
public class CetController {
    @Autowired
    private ICetService iCetService;

    @RequestMapping(value = "/cetCheckCode.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getCetCheckCode(HttpSession session){
        /*UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }*/
        ServerResponse response = iCetService.getCetCheckCode();
        if(response.isSuccess()){
            session.setAttribute(Const.CET_CHECKCODE_COOKIE,response.getData());
        }
        return response;
    }

    @RequestMapping(value = "/score.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Cet> getCetScore(HttpSession session,@RequestBody CetVo cetVo){
        CheckCodeVo checkCodeVo = (CheckCodeVo) session.getAttribute(Const.CET_CHECKCODE_COOKIE);
        /*UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }*/
        cetVo.setCookie(checkCodeVo.getCookie());
        return iCetService.getCetScore(cetVo);
    }



}