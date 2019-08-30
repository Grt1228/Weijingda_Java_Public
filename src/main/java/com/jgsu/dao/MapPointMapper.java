package com.jgsu.dao;

import com.jgsu.pojo.MapPoint;
import com.jgsu.vo.map.MapRequest;

import java.util.List;

public interface MapPointMapper {
    int deleteByPrimaryKey(String mapPointId);

    int insert(MapPoint record);

    int insertSelective(MapPoint record);

    MapPoint selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(MapPoint record);

    int updateByPrimaryKey(MapPoint record);

    /**
     * 查询MapPoint列表
     * @param mapRequest
     * @return
     */
    List<MapPoint> list(MapRequest mapRequest);
}