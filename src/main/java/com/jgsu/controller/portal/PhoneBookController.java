package com.jgsu.controller.portal;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.Const;
import com.jgsu.common.ResponseCode;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.PhoneBook;
import com.jgsu.pojo.UserInfo;
import com.jgsu.service.IPhoneBookService;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.vo.phone.PhoneBookRequest;
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
 * 校园通讯录
 *
 * @author grt
 * @create 2018-03-04 18:33
 */
@Controller
@RequestMapping("/portal/phonebook")
public class PhoneBookController {
    @Autowired
    private IPhoneBookService iPhoneBookService;

    /**
     * 前台展示通讯录列表
     * @return
     */
    @RequestMapping(value = "/list.do" ,method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> getPhoneBookList(@RequestBody PhoneBookRequest phoneBookRequest){
        phoneBookRequest.setPageNum(1);
        phoneBookRequest.setPageSize(100);
        return iPhoneBookService.getPhoneBookList("0", phoneBookRequest);
    }

    /**
     * 前台添加一条记录
     * @return
     */
    @RequestMapping(value = "/insertOne.do" ,method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<PhoneBook>> addOnePhoneNumber(@RequestBody PhoneBook phoneBook){
        phoneBook.setStatus(String.valueOf(Const.PhoneNumberStatus.NO));
        ServerResponse response = iPhoneBookService.addOnePhoneNumber(phoneBook);
        return response;
    }

    @RequestMapping(value = "/updateOne.do" ,method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateOnePhoneBook(HttpSession session,HttpServletRequest request){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setPhoneLevel(request.getParameter("phoneLevel"));
        phoneBook.setPhoneNumber(request.getParameter("phoneNumber"));
        phoneBook.setPhoneName(request.getParameter("phoneName"));
        phoneBook.setStatus(String.valueOf(Const.PhoneNumberStatus.NO));
        ServerResponse response = iPhoneBookService.updateOnePhoneBook(phoneBook);
        return response;
    }
}