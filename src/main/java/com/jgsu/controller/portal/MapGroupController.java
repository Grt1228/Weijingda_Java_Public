package com.jgsu.controller.portal;

import com.jgsu.common.ServerResponse;
import com.jgsu.service.IMapGroupService;
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
 * 点分类Controller
 *
 * @author grt
 * @create 2018-08-04 23:38
 */
@Controller
@RequestMapping("/portal/map/group")
public class MapGroupController {
    @Autowired
    private IMapGroupService iMapGroupService;

    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getList(
                                  @RequestBody MapRequest mapRequest){
        return iMapGroupService.getListPortal(mapRequest);
    }
}