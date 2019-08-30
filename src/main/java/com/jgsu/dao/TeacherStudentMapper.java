package com.jgsu.dao;

import com.jgsu.pojo.TeacherStudent;

public interface TeacherStudentMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(TeacherStudent record);

    int insertSelective(TeacherStudent record);

    TeacherStudent selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(TeacherStudent record);

    int updateByPrimaryKey(TeacherStudent record);
}