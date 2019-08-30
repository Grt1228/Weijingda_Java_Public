package com.jgsu.controller.portal;

import com.jgsu.common.ServerResponse;
import com.jgsu.service.IBookService;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.vo.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 描述:
 * 图书馆相关
 *
 * @author grt
 * @create 2018-05-25 0:46
 */
@Controller
@RequestMapping("/portal/book")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @RequestMapping(value = "/bookLogin.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse bookLogin(@RequestBody BookRequest bookRequest){
        bookRequest.setOpenId(UUIDUtil.getUUID().substring(1,28));
        return iBookService.bookLogin(bookRequest);
    }

    @RequestMapping(value = "/bookSearch.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse bookSearch(@RequestBody BookRequest bookRequest){
        return iBookService.bookSearch(bookRequest);
    }

    @RequestMapping(value = "/bookRenew.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse bookRenew(@RequestBody BookRequest bookRequest){
        return iBookService.bookRenew(bookRequest);
    }

    @RequestMapping(value = "/bookDetail.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse bookDetail(@RequestBody BookRequest bookRequest){
        return iBookService.bookDetail(bookRequest);
    }

}