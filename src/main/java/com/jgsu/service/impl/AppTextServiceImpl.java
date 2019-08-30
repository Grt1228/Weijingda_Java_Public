package com.jgsu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jgsu.common.Const;
import com.jgsu.common.ServerResponse;
import com.jgsu.dao.AppTextMapper;
import com.jgsu.pojo.AppText;
import com.jgsu.service.IAppTextService;
import com.jgsu.utils.DateUtil;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.vo.apptext.AppTextRequest;
import com.jgsu.vo.apptext.AppTextResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("iAppTextService")
@Slf4j
public class AppTextServiceImpl implements IAppTextService {

    @Autowired
    private AppTextMapper appTextMapper;

    @Override
    public ServerResponse insert(AppText appText) {
        //日志
        log.info("新增文本："+appText);
        appText.setAppTextId(UUIDUtil.getUUID());
        int insert = appTextMapper.insert(appText);
        if(insert<=0){
            log.error("新增出错了："+appText);
            return ServerResponse.createByError("新增文本数据出错了");
        }
        return ServerResponse.createBySuccess("新增文本成功",appText);
    }

    @Override
    public ServerResponse update(AppText appText) {
        log.info("更新文本："+appText);
        int i = appTextMapper.updateByPrimaryKeySelective(appText);
        if(i<=0){
            log.error("更新文本："+appText);
            return ServerResponse.createByError("修改文本数据出错了");
        }
        return ServerResponse.createBySuccess("修改成功",appText);
    }

    @Override
    public ServerResponse<PageInfo> list(AppTextRequest request) {
        //log
        log.info("查询文本列表："+request);
        try{
            PageHelper.startPage(request.getPageNum(),request.getPageSize());
            List<AppText> appTextList =  appTextMapper.list(request);
            List<AppTextResponse> appTextResponseList = Lists.newArrayList();
            buildResponse(appTextList,appTextResponseList);
            PageInfo result = new PageInfo(appTextList);
            result.setList(appTextResponseList);
            return ServerResponse.createBySuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            log.error("查询文本列表异常"+e);
        }
        return ServerResponse.createByError("查询文本列表异常");
    }

    private void buildResponse(List<AppText> appTextList, List<AppTextResponse> appTextResponseList) {
        for(AppText appText:appTextList){
            AppTextResponse appTextResponse = new AppTextResponse();
            BeanUtils.copyProperties(appText,appTextResponse);
            appTextResponse.setCreateTime(DateUtil.dateToStr(appText.getCreateTime()));
            appTextResponse.setModifiedTime(DateUtil.dateToStr(appText.getModifiedTime()));
            appTextResponse.setStatusDesc(appText.getStatus().equals(Const.Status.YES.toString())?Const.Status.YES_DESC:Const.Status.NO_DESC);
            appTextResponse.setTextTypeDesc(Const.AppTextType.codeOf(Integer.parseInt(appText.getTextType())).getValue());
            appTextResponseList.add(appTextResponse);
        }
    }
}
