package com.jgsu.service;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.NewContent;
import com.jgsu.pojo.UniversityNews;
import com.jgsu.vo.NewRequest;

import java.util.List;

/**
 * 描述:
 * 新闻Service
 *
 * @author grt
 * @create 2018-03-04 22:35
 */
public interface INewService {
    /**
     * 根据权限湖区new列表
     * @param role
     * @return
     */
    ServerResponse<PageInfo> getAllNew(NewRequest newRequest, String role);

    /**
     * 后台添加一条新闻
     * @param universityNews
     * @return
     */
    ServerResponse addOneNew(UniversityNews universityNews);

    /**
     * 修改一条新闻
     * @param universityNews
     * @return
     */
    ServerResponse updateOneNew(UniversityNews universityNews);

    /**
     * 获取新闻全部类型
     * @return
     */
    ServerResponse<List<String>> getAllNewType();

    /**
     * 添加新闻主题内容
     * @param newContent
     * @return
     */
    ServerResponse addContent(NewContent newContent);

    ServerResponse<NewContent> findById(NewContent newContent);

    ServerResponse getNewContentList(NewRequest request);

    ServerResponse deleteContent(NewRequest request);
}