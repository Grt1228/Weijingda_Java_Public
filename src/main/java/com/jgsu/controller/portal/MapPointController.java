package com.jgsu.controller.portal;

import com.jgsu.common.ServerResponse;
import com.jgsu.service.IMapPointService;
import com.jgsu.service.IUserInfoService;
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

/**
 * 描述:
 * 地图点后台管理
 *
 * @author grt
 * @create 2018-08-03 0:13
 */
@Controller
@RequestMapping("/portal/map/point")
public class MapPointController {
    @Autowired
    private IMapPointService iMapPointService;
    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getList(@RequestBody MapRequest mapRequest){
        return iMapPointService.getListPortal(mapRequest);
    }
}