package com.jgsu.dao;

import com.jgsu.pojo.StudentScore;

public interface StudentScoreMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(StudentScore record);

    int insertSelective(StudentScore record);

    StudentScore selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(StudentScore record);

    int updateByPrimaryKey(StudentScore record);
}