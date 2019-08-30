package com.jgsu.dao;

import com.jgsu.pojo.PhoneBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhoneBookMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(PhoneBook record);

    int insertSelective(PhoneBook record);

    PhoneBook selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(PhoneBook record);

    int updateByPrimaryKey(PhoneBook record);

    List<PhoneBook> selectByStatus(@Param("status") String status);

/*
    List<PhoneBook> selectAllLostGood(@Param("phoneLevel") String phoneLevel,@Param("phoneName") String phoneName,@Param("start")Integer start,@Param("length")Integer length);
*/

    List<PhoneBook> selectAllLostGood(@Param("status")String status,@Param("phoneLevel") String phoneLevel,@Param("phoneName") String phoneName);

    List<PhoneBook> selectYesStatusPhoneBook(@Param("status") String status);

    int updateStatusByLostGoodId(@Param("phoneBookId") String phoneBookId,@Param("status") String status );
}