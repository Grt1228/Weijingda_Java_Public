package com.jgsu.dao;

import com.jgsu.pojo.UniversityNews;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UniversityNewsMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(UniversityNews record);

    int insertSelective(UniversityNews record);

    UniversityNews selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(UniversityNews record);

    int updateByPrimaryKey(UniversityNews record);

    List<UniversityNews> selectYesStatusNews(@Param("status") String status);

    List<UniversityNews> selectAllNews(@Param("newCreater") String newCreater,@Param("newType") String newType
            ,@Param("newStatus") String newStatus,@Param("newTitle") String newTitle);
}