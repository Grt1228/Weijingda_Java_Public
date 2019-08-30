package com.jgsu.dao;

import com.jgsu.pojo.AppText;
import com.jgsu.vo.apptext.AppTextRequest;

import java.util.List;

public interface AppTextMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(AppText record);

    int insertSelective(AppText record);

    AppText selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(AppText record);

    int updateByPrimaryKey(AppText record);

    /**
     * 查询列表
     * @param request
     * @return
     */
    List<AppText> list(AppTextRequest request);
}