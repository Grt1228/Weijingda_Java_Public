package com.jgsu.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:
 * 图书实体类
 *
 * @author grt
 * @create 2018-05-25 0:14
 */
@Data
public class Book implements Serializable{
    /**
     * 书Id
     */
    private String bookId;
    /**
     * 条码号
     */
    private String bookCode;
    /**
     * 索书号
     */
    private String bookIndexNum;
    /**
     * 续借码
     */
    private String renewCode;
    /**
     * 书名
     */
    private String bookName;
    /**
     * 作者
     */
    private String bookAuthor;
    /**
     * 出版社
     */
    private String bookPress;
    /**
     * 出版日期
     */
    private String bookPressDate;
    /**
     * 借书日期
     */
    private String lendDate;
    /**
     * 还书日期
     */
    private String sendDate;
    /**
     * 馆藏地点(在图书馆哪个类别的)，位置例如：	文史哲书库，综合图书库
     */
    private String hideLocation;
    /**
     * 位置
     */
    private String location;
    /**
     * 馆藏状态
     */
    private String hideStatus;
    /**
     * 续借状态
     */
    private String renewStatus;
    /**
     * 借阅次数
     */
    private String lendNum;
    /**
     * 续借次数
     */
    private String renewNum;
    private Date createTime;
    private Date modifiedTime;

}