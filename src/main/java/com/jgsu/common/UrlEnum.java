package com.jgsu.common;

import java.io.Serializable;

/**
 * 描述:
 * 请求地址常量
 *
 * @author grt
 * @create 2018-02-04 22:49
 */
public enum UrlEnum implements Serializable{

    CHECKCODE_URL(0,"","验证码url"),
    LOGIN_URL(1,"","登陆url"),
    DEFAULT_URL(2,"","登陆完成后默认的请求url"),
    SCORE_URL(3,"","查询成绩url"),
    COURSE_URL(4,"","查询课表url"),
    TESTSCHEDULE_URL(5,"","考试安排url"),
    CET_URL(6,"http://www.chsi.com.cn/cet/query","四六级查询url"),
    CET_CHECKCODE_URL(7,"http://www.chsi.com.cn/cet/ValidatorIMG.JPG?ID=3664.0968221639846","四六级查询验证码"),
    BOOK_LOGIN_URL(8,"","图书馆登陆url"),
    BOOK_SEARCH_URL(9,"","图书检索url"),
    BOOK_RENEW_URL(9,"","图书续借url"),
    BOOK_LEND_URL1(9,"","图书借阅信息url"),
    BOOK_LEND_URL2(9,"","图书借阅信息url"),
    BOOK_LEND_URL3(10,"","图书借阅信息url"),
    BOOK_DETAIL_URL(11,"","图书详情查询"),
    WECHAT_OPENID_URL(1,"https://api.weixin.qq.com/sns/jscode2session","微信获取微信openidurl"),
    QQ_OPENID_URL(1,"https://api.q.qq.com/sns/jscode2session","微信获取QQopenidurl");

    private final int code;
    private final String url;
    private final String desc;

    public int getCode(){
        return code;
    }
    public String getUrl(){
        return url;
    }
    public String getDesc(){
        return desc;
    }

    UrlEnum(int code,String url,String desc){
        this.code = code;
        this.url = url;
        this.desc = desc;
    }
}