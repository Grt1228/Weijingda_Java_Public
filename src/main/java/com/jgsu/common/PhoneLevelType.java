package com.jgsu.common;

public enum  PhoneLevelType {

    SCHOOL_LEVEL(0,"校级"),
    COLLEGE_LEVEL(1,"院级"),
    SHOP_LEVEL(2,"校园商铺");

    private Integer code;
    private String desc;

    public Integer getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

    PhoneLevelType(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }
}
