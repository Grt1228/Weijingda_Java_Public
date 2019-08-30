package com.jgsu.dao;

import com.jgsu.pojo.NewContent;
import com.jgsu.vo.NewResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewContentMapper {
    int deleteByPrimaryKey(String newId);

    int insert(NewContent record);

    int insertSelective(NewContent record);

    NewContent selectByPrimaryKey(String newId);

    int updateByPrimaryKeySelective(NewContent record);

    int updateByPrimaryKeyWithBLOBs(NewContent record);

    List<NewContent> findAll( @Param("newId") String newId);
}