package com.jgsu.vo;

import lombok.Data;

/**
 * 描述:
 * 图书馆相关的请求类
 *
 * @author grt
 * @create 2018-05-25 0:49
 */
@Data
public class BookRequest extends PageRequest {
    /**
     * 图书借阅账号
     */
    private String bookUserName;
    /**
     * 图书借阅密码
     */
    private String bookPassword;
    /**
     * 检索图书关键字
     */
    private String searchKey;
    /**
     * cookie
     */
    private String cookie;
    /**
     * openId微信标识（可随机生成27位）
     */
    private String openId;
    /**
     * 图书续借sn
     */
    private String sn;
    /**
     * 图书续借图书code
     */
    private String barcode;
    /**
     * 图书续借固定值
     */
    private String xc = "3";

    private String pageIndex = "1";
    /**
     * title
     * author
     * isbn
     */
    private String searchType;

    /**
     * 详情查询参数{"bookid":"XXXXX","title":"XXXX"}
     */
    private String detailParam;
}