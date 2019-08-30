package com.jgsu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jgsu.common.ServerResponse;
import com.jgsu.dao.IdeaMapper;
import com.jgsu.pojo.Idea;
import com.jgsu.service.IIdeaService;
import com.jgsu.utils.DateUtil;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.vo.idea.IdeaRequest;
import com.jgsu.vo.idea.IdeaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * 意见
 *
 * @author grt
 * @create 2018-03-04 21:27
 */
@Service
public class IdeaServiceImpl implements IIdeaService {
    private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private IdeaMapper ideaMapper;

    @Override
    public ServerResponse addIdea(Idea idea) {
        logger.info("增加反馈意见："+idea);
        try {
            idea.setIdeaId(UUIDUtil.getUUID());
            int insert = ideaMapper.insert(idea);
            if(insert>0){
                logger.info("增加反馈意见成功");
                return ServerResponse.createBySuccess("建议已收录，谢谢你的宝贵意见");
            }
        } catch (Exception e) {
            logger.error("增加反馈意见系统异常："+e);
            e.printStackTrace();
        }
        logger.info("增加反馈意见系统异常");
        return ServerResponse.createByError("系统异常，请联系管理员");
    }

    @Override
    public ServerResponse<PageInfo> getAllIdea(IdeaRequest ideaRequest) {
        logger.info("后台查询反馈意见");
        try {
            PageHelper.startPage(ideaRequest.getPageNum(),ideaRequest.getPageSize());
            List<Idea> ideaList = ideaMapper.getAllIdea(ideaRequest);
            List<IdeaResponse> ideaResponseList = Lists.newArrayList();
            buildIdeaResponseList(ideaList,ideaResponseList);
            PageInfo pageResult = new PageInfo(ideaList);
            pageResult.setList(ideaResponseList);
            return ServerResponse.createBySuccess(pageResult);
        }catch (Exception e){
            logger.error("后台查询反馈意见异常："+e);
            e.printStackTrace();
        }
        return ServerResponse.createByError("后台查询反馈意见异常");
    }

    private void buildIdeaResponseList(List<Idea> ideaList, List<IdeaResponse> ideaResponseList) {
        for(Idea idea :ideaList){
            IdeaResponse vo = new IdeaResponse();
            vo.setCreateTime(DateUtil.dateToStr(idea.getCreateTime()));
            vo.setIdeaDetail(idea.getIdeaDetail());
            vo.setIdeaId(idea.getIdeaId());
            vo.setModifiedTime(DateUtil.dateToStr(idea.getModifiedTime()));
            vo.setPkId(idea.getPkId());
            vo.setOpenid(idea.getOpenid());
            vo.setStudentName(idea.getStudentName());
            vo.setStudentId(idea.getStudentId());
            ideaResponseList.add(vo);
        }
    }
}