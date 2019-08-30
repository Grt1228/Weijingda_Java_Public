package com.jgsu.service.impl;

import com.jgsu.common.ServerResponse;
import com.jgsu.service.IBookService;
import com.jgsu.utils.httpclientutil.exception.HttpProcessException;
import com.jgsu.vo.BookRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 图书馆相关
 *
 * @author lqd12
 * @create 2018-05-25 1:00
 */
@Service("iBookService")
public class BookServiceImpl implements IBookService {
    private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private com.jgsu.requestrelated.BookRequest bookHttpRequest;
    @Override
    public ServerResponse bookLogin(BookRequest bookRequest) {
        logger.info("图书登陆参数："+bookRequest);
        ServerResponse response = null;
        try {
            response = bookHttpRequest.bookLogin(bookRequest);
        } catch (HttpProcessException e) {
            e.printStackTrace();
            logger.error("图书登陆异常："+e);
        }
        logger.info("图书登陆成功返回值：",response);
        return response;
    }

    @Override
    public ServerResponse bookSearch(BookRequest bookRequest) {
        logger.info("图书检索参数："+bookRequest);
        ServerResponse response = null;
        try {
            response = bookHttpRequest.bookSearch(bookRequest);
        } catch (Exception e) {
            logger.error("图书检索异常："+e);
            e.printStackTrace();
        }
        logger.info("图书检索返回值："+response);
        return response;
    }

    @Override
    public ServerResponse bookRenew(BookRequest bookRequest) {
        logger.info("图书续借参数："+bookRequest);
        ServerResponse response = null;
        try {
            response = bookHttpRequest.bookRenew(bookRequest);
        } catch (Exception e) {
            logger.error("图书续借异常："+e);
            e.printStackTrace();
        }
        logger.info("图书续借返回值："+response);
        return response;
    }

    @Override
    public ServerResponse bookDetail(BookRequest bookRequest) {
        logger.info("图书检索详情参数："+bookRequest);
        ServerResponse response = null;
        try {
            response = bookHttpRequest.bookDetail(bookRequest);
        } catch (Exception e) {
            logger.error("图书详情异常："+e);
            e.printStackTrace();
        }
        logger.info("图书详情返回值："+response);
        return response;
    }
}