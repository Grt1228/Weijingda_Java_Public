package com.jgsu.exception;


import com.jgsu.common.ResultEnum;

/**
 * 描述:
 * 异常
 *
 * @author grt
 * @create 2018-08-18 22:43
 */
public class JgsuException extends RuntimeException {

    private Integer code;


    public JgsuException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public JgsuException(Integer code, String msg){
        super(msg);
        this.code = code;
    }
}