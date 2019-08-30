package com.jgsu.dao;

import com.jgsu.pojo.CourseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseInfoMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    CourseInfo selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(CourseInfo record);

    int updateByPrimaryKey(CourseInfo record);

    List<CourseInfo> selectCourseListByLoginName(@Param("loginName") String loginName);
}