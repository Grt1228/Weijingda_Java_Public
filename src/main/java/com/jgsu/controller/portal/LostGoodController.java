package com.jgsu.controller.portal;

import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.LostGood;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.ILostGoodService;
import com.jgsu.vo.LostGoodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 描述:
 * 失物招领
 *
 * @author grt
 * @create 2018-02-28 19:59
 */
@Controller
@RequestMapping("/portal/lostgood")
public class LostGoodController {

    @Autowired
    private ILostGoodService iLostGoodService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getLostGoodList(@RequestBody LostGoodRequest request){

        return iLostGoodService.getLostGoodList(request);
    }

    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse add(@RequestBody LostGood lostGood){
        return iLostGoodService.add(lostGood);
    }

    @PostMapping(value = "findByid")
    @ResponseBody
    public ServerResponse liked(@RequestBody LostGoodRequest request){

        return iLostGoodService.findById(request.getLostGoodId());
    }
    @RequestMapping(value = "/save.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateOneById(@RequestBody LostGood lostGood){
        ServerResponse response = iLostGoodService.addOrUpdate(lostGood);
        return response;
    }

}