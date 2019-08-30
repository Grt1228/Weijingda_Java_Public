package com.jgsu.dao;

import com.jgsu.pojo.LostGood;
import com.jgsu.vo.LostGoodRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LostGoodMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(LostGood record);

    int insertSelective(LostGood record);

    LostGood selectByPrimaryKey(String  lostGoodId);

    int updateByPrimaryKeySelective(LostGood record);

    int updateByPrimaryKey(LostGood record);

    List<LostGood> selectAllLostGood(LostGoodRequest lostGoodRequest);

    List<LostGood> selectYesStatusLostGood(@Param("status") String status);

    int updateStatusByLostGoodId(@Param("lostGoodId") String lostGoodId,@Param("status") String status);

    int updateByLostGoodId(LostGood lostGood);
}