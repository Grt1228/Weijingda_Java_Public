package com.jgsu.common;

import lombok.Getter;

/**
 * 描述:
 * 返回结果状态
 *
 * @author grt
 * @create 2018-08-18 22:45
 */
@Getter
public enum  ResultEnum {
    PARAM_ERROR(1,"参数不正确"),
    INSERT_ERROR(10,"新增失败"),
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

}