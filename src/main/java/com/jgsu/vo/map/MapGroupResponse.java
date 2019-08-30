package com.jgsu.vo.map;

import lombok.Data;

/**
 * 描述:
 * mapGroup返回值
 *
 * @author grt
 * @create 2018-08-05 14:56
 */
@Data
public class MapGroupResponse {
    private Long pkId;

    private String mapGroupId;

    private String mapGroupName;

    private String mapGroupDesc;

    private String status;

    private String statusDesc;

    private String createTime;

    private String modifiedTime;
}