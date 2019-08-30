package com.jgsu.common;

/**
 * 枚举新闻
 *
 * @author grt
 */

public enum NewType {
    SCHOOL_NEW(1,"校园新闻"),
    ADVICE_NEW(2,"通知公告"),
    LECTURE_NEW(3,"学术讲座"),
    RESEARCH_NEW(4,"科研信息"),
    TEACHING_NEW(5,"教务通知"),
    COLLEGE_NEW(6,"学院动态");

    private Integer code;
    private String desc;

    public Integer getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

    NewType(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }
}
