package com.jgsu.common;

/**
 * 描述:
 * 定义公共返回的枚举值
 *
 * @author grt
 * @create 2018-02-02 22:52
 */
public enum  ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}