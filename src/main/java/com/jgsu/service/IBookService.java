package com.jgsu.service;

import com.jgsu.common.ServerResponse;
import com.jgsu.vo.BookRequest; /**
 * 描述:
 * 图书馆相关接口
 *
 * @author grt
 * @create 2018-05-25 1:00
 */
public interface IBookService {
    /**
     * 图书馆登陆
     * @param bookRequest
     * @return
     */
    ServerResponse bookLogin(BookRequest bookRequest);

    /**
     * 检索图书
     * @param bookRequest
     * @return
     */
    ServerResponse bookSearch(BookRequest bookRequest);

    /**
     * 续借图书
     * @param bookRequest
     * @return
     */
    ServerResponse bookRenew(BookRequest bookRequest);

    /**
     * 检索详情
     * @param bookRequest
     * @return
     */
    ServerResponse bookDetail(BookRequest bookRequest);
}
