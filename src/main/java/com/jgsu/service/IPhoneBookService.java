package com.jgsu.service;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.PhoneBook;
import com.jgsu.vo.phone.PhoneBookRequest;

import java.util.List;

/**
 * 描述:
 * PhoneBook
 *
 * @author grt
 * @create 2018-02-27 21:19
 */
public interface IPhoneBookService {
    /**
     * 根据不同状态获取通讯录
     * @param role
     * @return
     */
    ServerResponse<PageInfo> getPhoneBookList(String role, PhoneBookRequest phoneBookRequest);

    /**
     * 插入一条电话记录
     * @param phoneBook
     * @return
     */
    ServerResponse addOnePhoneNumber(PhoneBook phoneBook);

    /**
     * 修改电话记录
     * @param phoneBook
     * @return
     */
    ServerResponse updateOnePhoneBook(PhoneBook phoneBook);
    /**
     * 后台将发布消息改为有效状态
     * @param phoneBookId
     * @param status
     * @return
     */
    ServerResponse updateStatus(String phoneBookId, String status);
}
