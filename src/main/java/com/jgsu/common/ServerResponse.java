package com.jgsu.common;


import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * 描述:
 * 返回json对象
 * JsonSerialize 保证序列化json的时候，如果是null的对象，key也会消失
 * @author grt
 * @create 2018-02-02 22:51
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
public class ServerResponse<T> implements Serializable{

    private static final long serialVersionUID = 5470604341511825956L;


    private int status;
    private String msg;
    private T data;
    private int total;

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(String msg) {
        this.msg = msg;
    }

    private ServerResponse(T data) {
        this.data = data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status, T data,int total) {
        this.status = status;
        this.data = data;
        this.total = total;
    }
    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }
    public static <T> ServerResponse<T> createBySuccess(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T> ServerResponse<T> createBySuccess(T data,int total){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data,total);
    }
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T> ServerResponse<T> createBySuccess(String msg,T data ){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }
    // 错误的返回类型

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    public static <T> ServerResponse<T> createByError(String errorMsg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMsg);
    }
    public static <T> ServerResponse<T> createByError(int errorCode,String errorMsg){
        return new ServerResponse<T>(errorCode,errorMsg);
    }

    @JsonIgnore
    //使之不再json序列化

    public boolean isSuccess(){
        return this.status==ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public int getTotal() {
        return total;
    }
}