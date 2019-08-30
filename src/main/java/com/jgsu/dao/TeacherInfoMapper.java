package com.jgsu.dao;

import com.jgsu.pojo.TeacherInfo;

public interface TeacherInfoMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    TeacherInfo selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(TeacherInfo record);

    int updateByPrimaryKey(TeacherInfo record);
}