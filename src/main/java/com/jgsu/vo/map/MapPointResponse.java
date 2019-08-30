package com.jgsu.vo.map;

import lombok.Data;

/**
 * 描述:
 * 地图点Response
 *
 * @author grt
 * @create 2018-08-05 19:07
 */
@Data
public class MapPointResponse {
    private Long pkId;

    private String mapPointId;

    private String mapPointName;

    private String mapPointLongitude;

    private String mapPointLatitude;
    /**
     * 点描述
     */
    private String mapPointDesc;
    /**
     * 点类别 1 普通  2线路
     */
    private String pointType;
    private String pointTypeDesc;

    private String sort;

    private String mapGroupId;

    private String mapGroupName;

    private String status;
    private String statusDesc;

    private String createTime;

    private String modifiedTime;

}