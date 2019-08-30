package com.jgsu.dao;

import com.jgsu.pojo.Idea;
import com.jgsu.vo.idea.IdeaRequest;

import java.util.List;

public interface IdeaMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(Idea record);

    int insertSelective(Idea record);

    Idea selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(Idea record);

    int updateByPrimaryKey(Idea record);

    List<Idea> getAllIdea(IdeaRequest ideaRequest);
}