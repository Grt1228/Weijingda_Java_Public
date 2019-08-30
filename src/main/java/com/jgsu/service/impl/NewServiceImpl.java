package com.jgsu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jgsu.common.Const;
import com.jgsu.common.NewType;
import com.jgsu.common.ServerResponse;
import com.jgsu.dao.NewContentMapper;
import com.jgsu.dao.UniversityNewsMapper;
import com.jgsu.pojo.NewContent;
import com.jgsu.pojo.UniversityNews;
import com.jgsu.service.INewService;
import com.jgsu.utils.DateUtil;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.vo.NewRequest;
import com.jgsu.vo.NewResponse;
import org.apache.commons.lang3.EnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 校园新闻
 *
 * @author lqd12
 * @create 2018-03-04 22:37
 */
@Service("iNewService")
public class NewServiceImpl implements INewService{
    private Logger logger = LoggerFactory.getLogger(NewServiceImpl.class);
    @Autowired
    private UniversityNewsMapper universityNewsMapper;
    @Autowired
    private NewContentMapper newContentMapper;
    @Override
    public ServerResponse<PageInfo> getAllNew(NewRequest newRequest, String role) {
        logger.info("查询校园新闻参数："+newRequest);
        try {
            if(String.valueOf(Const.Role.ROLE_ADMIN).equals(role)){
                logger.info("后台查询校园新闻参数："+newRequest);
                //后台
                PageHelper.startPage(newRequest.getPageNum(),newRequest.getPageSize());
                List<UniversityNews> newsList = universityNewsMapper
                        .selectAllNews(newRequest.getNewCreater()
                                ,newRequest.getNewType(),newRequest.getNewStatus()
                                ,newRequest.getNewTitle());
                List<NewResponse> newVoLit = Lists.newArrayList();
                buildNewResponse(newsList,newVoLit);
                PageInfo pageResult = new PageInfo(newsList);
                pageResult.setList(newVoLit);
                return ServerResponse.createBySuccess(pageResult);
            }
            //前台只要有效值
            logger.info("前台查询校园新闻参数："+newRequest);
            PageHelper.startPage(newRequest.getPageNum(),newRequest.getPageSize());
            List<UniversityNews> yesStatusNewsList = universityNewsMapper.selectYesStatusNews(String.valueOf(Const.NewStatus.YES));
            List<NewResponse> newVoLit = Lists.newArrayList();
            buildNewResponse(yesStatusNewsList,newVoLit);
            PageInfo pageResult = new PageInfo(yesStatusNewsList);
            pageResult.setList(newVoLit);
            return ServerResponse.createBySuccess(pageResult);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("查询校园新闻异常："+e);
        }
        return ServerResponse.createByError("查询校园新闻异常");
    }

    private void buildNewResponse(List<UniversityNews> newsList, List<NewResponse> newVoLit) {
        for(UniversityNews news : newsList){
            NewResponse vo = new NewResponse();
            vo.setCreateTime(DateUtil.dateToStr(news.getCreateTime()));
            vo.setLookNum(news.getLookNum());
            vo.setModifiedTime(DateUtil.dateToStr(news.getModifiedTime()));
            vo.setNewCreater(news.getNewCreater());
            vo.setNewDate(news.getNewDate());
            vo.setNewDetail(news.getNewDetail());
            vo.setNewId(news.getNewId());
            vo.setNewStatus(news.getNewStatus());
            vo.setNewTitle(news.getNewTitle());
            vo.setNewType(news.getNewType());
            vo.setImageId(news.getImageId());
            vo.setImageUrl(news.getImageUrl());
            NewType[] values = NewType.values();
            for(NewType newType:values){
                if(newType.getCode().toString().equals(news.getNewType())){
                    vo.setNewTypeDesc(newType.getDesc());
                }
            }
            vo.setPkId(news.getPkId());
            vo.setNewStatusDesc((news.getNewStatus().equals(Const.NewStatus.YES.toString()))?"有效":"失效");
            newVoLit.add(vo);
        }
    }

    @Override
    public ServerResponse addOneNew(UniversityNews universityNews) {
        logger.info("新增校园新闻参数："+universityNews);
        try {
            universityNews.setNewId(UUIDUtil.getUUID());
            int insert = universityNewsMapper.insert(universityNews);
            if(insert>0){
                return ServerResponse.createBySuccess("添加新闻成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("新增校园新闻异常："+e);
        }
        return ServerResponse.createByError("添加失败，系统错误");
    }

    @Override
    public ServerResponse updateOneNew(UniversityNews universityNews) {
        logger.info("更新校园新闻参数："+universityNews);
        try {
            int i = universityNewsMapper.updateByPrimaryKeySelective(universityNews);
            if(i>0){
                return ServerResponse.createBySuccess("修改新闻成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("更新校园新闻异常："+e);
        }
        return ServerResponse.createByError("修改失败，系统错误");
    }

    @Override
    public ServerResponse<List<String>> getAllNewType() {
        /*Map<Integer,String> newTypeList = Maps.newHashMap();
        newTypeList.put(Const.NewType.SCHOOL_NEW.getCode(),Const.NewType.SCHOOL_NEW.getDesc());
        newTypeList.put(Const.NewType.ADVICE_NEW.getCode(),Const.NewType.ADVICE_NEW.getDesc());
        newTypeList.put(Const.NewType.LECTURE_NEW.getCode(),Const.NewType.LECTURE_NEW.getDesc());
        newTypeList.put(Const.NewType.RESEARCH_NEW.getCode(),Const.NewType.RESEARCH_NEW.getDesc());
        newTypeList.put(Const.NewType.TEACHING_NEW.getCode(),Const.NewType.TEACHING_NEW.getDesc());
        newTypeList.put(Const.NewType.COLLEGE_NEW.getCode(),Const.NewType.COLLEGE_NEW.getDesc());*/
        List<String> newTypeList = new ArrayList<>();
        newTypeList.add(NewType.SCHOOL_NEW.getDesc());
        newTypeList.add(NewType.ADVICE_NEW.getDesc());
        newTypeList.add(NewType.LECTURE_NEW.getDesc());
        newTypeList.add(NewType.RESEARCH_NEW.getDesc());
        newTypeList.add(NewType.TEACHING_NEW.getDesc());
        newTypeList.add(NewType.COLLEGE_NEW.getDesc());
        return ServerResponse.createBySuccess(newTypeList);
    }

    @Override
    public ServerResponse addContent(NewContent newContent) {
        logger.info("新增新闻主体信息："+newContent.getNewId());
        int i = newContentMapper.insert(
                newContent
        );
        if(i>0){
            return ServerResponse.createBySuccess("添加主体信息成功");
        }

        return ServerResponse.createByError("添加主体信息出错了");
    }

    @Override
    public ServerResponse<NewContent> findById(NewContent newContent) {
        newContent = newContentMapper.selectByPrimaryKey(newContent.getNewId());
        return ServerResponse.createBySuccess(newContent);
    }

    @Override
    public ServerResponse getNewContentList(NewRequest newRequest) {

        PageHelper.startPage(newRequest.getPageNum(),newRequest.getPageSize());
        List<NewContent> resp =  newContentMapper.findAll(newRequest.getNewId());
        PageInfo pageResult = new PageInfo(resp);
        pageResult.setList(resp);
        return ServerResponse.createBySuccess(pageResult);
    }

    @Override
    public ServerResponse deleteContent(NewRequest request) {
        if(request.getNewId()==null||"".equals(request.getNewId())){
            return ServerResponse.createBySuccess("newId为空");
        }

        int i = newContentMapper.deleteByPrimaryKey(request.getNewId());
        if(i>0){
            return ServerResponse.createBySuccess("删除成功");
        }
        return ServerResponse.createByError("删除异常");
    }
}