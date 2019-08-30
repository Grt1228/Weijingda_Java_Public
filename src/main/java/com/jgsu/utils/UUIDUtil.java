package com.jgsu.utils;

import java.util.UUID;

/**
 * 描述:
 * 获取uuid工具类
 *
 * @author grt
 * @create 2018-02-25 20:58
 */
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}