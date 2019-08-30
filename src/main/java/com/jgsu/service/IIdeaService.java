package com.jgsu.service;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.Idea;
import com.jgsu.vo.idea.IdeaRequest;

import java.util.List;

/**
 * 描述:
 * 意见
 *
 * @author grt
 * @create 2018-03-04 21:26
 */
public interface IIdeaService {
    /**
     * 前端添加意见
     * @param idea
     * @return
     */
    ServerResponse addIdea(Idea idea);

    /**
     * 后台得到所有idea
     * @return
     */
    ServerResponse<PageInfo> getAllIdea(IdeaRequest ideaRequest);
}
