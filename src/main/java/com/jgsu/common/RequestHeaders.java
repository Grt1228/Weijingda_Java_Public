package com.jgsu.common;

import java.io.Serializable;

/**
 * 描述:
 * 请求消息头相关常量
 *
 * @author grt
 * @create 2018-02-04 22:39
 */
public enum  RequestHeaders implements Serializable{
    Header_Accept(0,"Accept","image/gif, image/jpeg, image/pjpeg, application/x-ms-application, application/xaml+xml, application/x-ms-xbap, */*"),
    Header_AcceptEncoding(1,"Accept-Encoding","gzip, deflate"),
    Header_AcceptLanguage(2,"Accept-Language","zh-CN,zh;q=0.8"),
    Header_CacheControl(3,"Cache-Control","max-age=0"),
    Header_Connection(4,"Connection","Keep-Alive"),
    Header_ContentType(5,"Content-type","application/x-www-form-urlencoded"),
    Header_Host(6,"Host",""),
    Header_Origin(7,"Origin",""),
    Header_Referer(8,"Referer",""),
    Header_UserAgent(9,"User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.9 Safari/537.36"),
    CET_Header_UserAgent(10,"Referer","http://www.chsi.com.cn/cet/"),
    BOOK_Login_Header_Host(10,"Host","mc.m.5read.com"),
    BOOK_Lend_Header_Host(10,"Host","ms.jgsu.edu.cn");

    private final int code;
    private final String key;
    private final String value;

    public int getCode(){
        return code;
    }
    public String getKey(){
        return key;
    }
    public String getValue(){
        return value;
    }

    RequestHeaders(int code,String key, String value) {
        this.code = code;
        this.key = key;
        this.value = value;
    }
}