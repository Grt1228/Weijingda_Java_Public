package com.jgsu.dao;

import com.jgsu.pojo.Cet;

public interface CetMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(Cet record);

    int insertSelective(Cet record);

    Cet selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(Cet record);

    int updateByPrimaryKey(Cet record);
}