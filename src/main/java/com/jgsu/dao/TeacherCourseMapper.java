package com.jgsu.dao;

import com.jgsu.pojo.TeacherCourse;

public interface TeacherCourseMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(TeacherCourse record);

    int insertSelective(TeacherCourse record);

    TeacherCourse selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(TeacherCourse record);

    int updateByPrimaryKey(TeacherCourse record);
}