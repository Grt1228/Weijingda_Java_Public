package com.jgsu.utils;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.ServerResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 返回值转称easyui需要的类型
 *
 * @author grt
 * @create 2018-04-23 17:56
 */
public class ResponseToEasyUiData {
    /**
     * 转换数据
     * @param response
     * @return
     */
    public static Map toEasyUiData(ServerResponse response){
        Map map = new HashMap<>();
        PageInfo data = (PageInfo)response.getData();
        if(data!=null){
            map.put("rows",data.getList());
            map.put("total",data.getTotal());
        }else{
            map.put("rows",0);
            map.put("total",0);
        }
        map.put("msg",response.getMsg());
        map.put("status",response.getStatus());
        map.put("isSuccess",response.isSuccess());
        return map;
    }
}