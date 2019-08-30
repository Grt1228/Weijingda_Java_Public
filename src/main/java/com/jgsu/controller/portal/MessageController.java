package com.jgsu.controller.portal;

import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.Message;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IMessageService;
import com.jgsu.vo.message.MessageForm;
import com.jgsu.vo.message.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 描述:
 * 留言板
 *
 * @author grt
 * @create 2018-09-03 23:12
 */
@Controller
@RequestMapping("/portal/message")
public class MessageController {
    @Autowired
    private IMessageService iMessageService;

    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse list(HttpServletRequest request,
                               @RequestBody  MessageRequest messageRequest, HttpSession session){
        //Integer pageNum = Integer.valueOf(request.getParameter("page"));
        //Integer pageSize = Integer.valueOf(request.getParameter("rows"));
        //messageRequest.setPageNum(pageNum);
        // messageRequest.setPageSize(pageSize);
        return iMessageService.list(messageRequest);
    }

    @RequestMapping(value = "add.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse add(@RequestBody MessageForm messageForm){
        return iMessageService.insert(messageForm);
    }

    @PostMapping(value = "liked.do")
    @ResponseBody
    public ServerResponse liked(@RequestBody Map map){
        String messageId = (String)map.get("messageId");
        if(messageId==null || "".equals(messageId)){
            return ServerResponse.createByError("Id为空啊");
        }
        return iMessageService.liked(messageId);
    }
    @PostMapping(value = "unLiked.do")
    @ResponseBody
    public ServerResponse unLiked(@RequestBody Map map){
        String messageId = (String)map.get("messageId");
        if(messageId==null || "".equals(messageId)){
            return ServerResponse.createByError("Id为空啊");
        }
        return iMessageService.unLiked(messageId);
    }

    @PostMapping(value = "getOne.do")
    @ResponseBody
    public ServerResponse getOne(@RequestBody Map map){
        String messageId = (String)map.get("messageId");
        if(messageId==null || "".equals(messageId)){
            return ServerResponse.createByError("Id为空啊");
        }
        return iMessageService.selectById(messageId);
    }
}