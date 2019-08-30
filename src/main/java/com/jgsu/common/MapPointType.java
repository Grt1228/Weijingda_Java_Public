package com.jgsu.common;

/**
 * 描述:
 * 地图点类别
 *
 * @author grt
 * @create 2018-08-05 15:01
 */
public enum  MapPointType {
    /**
     * '点类别，0-普通点，1-线路点',
     */
    COMMON_POINT(0,"普通点"),
    LINE_NEW(1,"线路点");

    private Integer code;
    private String desc;

    public Integer getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

    MapPointType(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }
}