package com.jgsu.dao;

import com.jgsu.pojo.MapGroup;
import com.jgsu.vo.map.MapRequest;

import java.util.List;

public interface MapGroupMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(MapGroup record);

    int insertSelective(MapGroup record);

    MapGroup selectByPrimaryKey(String mapGroupId);

    int updateByPrimaryKeySelective(MapGroup record);

    int updateByPrimaryKey(MapGroup record);

    /**
     * 获取分组信息
     * @param mapRequest
     * @return
     */
    List<MapGroup> list(MapRequest mapRequest);
}