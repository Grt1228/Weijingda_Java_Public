package com.jgsu.controller.portal;

import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.Idea;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IIdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 描述:
 * 意见
 *
 * @author grt
 * @create 2018-03-04 21:25
 */
@Controller
@RequestMapping(value = "/portal/idea")
public class IdeaController {
    @Autowired
    private IIdeaService iIdeaService;

    @RequestMapping(value = "add.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse add(@RequestBody Idea idea){
        return iIdeaService.addIdea(idea);
    }
}