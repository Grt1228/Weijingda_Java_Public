package com.jgsu.vo.map;

import com.jgsu.vo.PageRequest;
import lombok.Data;

/**
 * 描述:
 * map请求对象
 *
 * @author grt
 * @create 2018-08-02 23:57
 */
@Data
public class MapRequest extends PageRequest {
    /**
     * 点id
     */
    private String mapPointId;
    /**
     * 点名称
     */
    private String mapPointName;
    /**
     * '点类别，0-普通点，1-线路点',
     */
    private String pointType;
    /**
     * '点分组id'
     */
    private String mapGroupId;
    /**
     * '状态值，0-有效，1-无效',
     */
    private String status;

}