package com.jgsu.dao;

import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.ScoreInfo;
import com.jgsu.vo.UserBackRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreInfoMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(ScoreInfo record);

    int insertSelective(ScoreInfo record);

    ScoreInfo selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(ScoreInfo record);

    int updateByPrimaryKey(ScoreInfo record);

    /**
     * 检查成绩单是否已存在
     * @param studentId
     * @return
     */
    List<ScoreInfo> checkScore(@Param("studentId") String studentId);

    /**
     * 批量插入成绩
     * @param scoreList
     * @return
     */
    int insertScoreList(@Param("scoreList") List<ScoreInfo> scoreList);
    /**
     * 后台查询成绩单
     * @param userBackRequest
     * @return
     */
    List<ScoreInfo> selectAllUserScoreInfo(UserBackRequest userBackRequest);

    /***
     * 更新成绩单，先删除旧得成绩单
     */
    int deleteByLoginName(String loginName);
}