package com.jgsu.common;

/**
 * 描述:
 * 地图分组类别枚举
 *
 * @author grt
 * @create 2018-08-05 14:59
 */
public enum MapGroupType {
    SCHOOLGATE(10,"校门"),
    TEACHINGBUILDING(20,"教学楼"),
    CANTEEN(30,"食堂"),
    PLAYGROUND(40,"运动场"),
    VENUE(50,"场馆"),
    BUS(60,"公交站"),
    DORMITORY(70,"宿舍"),
    OTHER(80,"其他");

    private Integer code;
    private String desc;

    public Integer getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

    MapGroupType(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }
}