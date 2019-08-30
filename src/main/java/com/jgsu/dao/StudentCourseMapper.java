package com.jgsu.dao;

import com.jgsu.pojo.StudentCourse;

public interface StudentCourseMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    StudentCourse selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);
}