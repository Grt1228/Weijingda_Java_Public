package com.jgsu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jgsu.common.Const;
import com.jgsu.common.ServerResponse;
import com.jgsu.dao.MapGroupMapper;
import com.jgsu.pojo.MapGroup;
import com.jgsu.service.IMapGroupService;
import com.jgsu.utils.DateUtil;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.vo.map.MapGroupResponse;
import com.jgsu.vo.map.MapRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * 点分组实现类
 *
 * @author lqd12
 * @create 2018-08-05 10:17
 */
@Service("iMapGroupService")
@Slf4j
public class MapGroupServiceImpl implements IMapGroupService {

    @Autowired
    private MapGroupMapper mapGroupMapper;

    @Override
    public ServerResponse getListPortal(MapRequest mapRequest) {
        log.info("获取MapGroup分组列表："+mapRequest);
        try {
            List<MapGroup> mapGroupList =  mapGroupMapper.list(mapRequest);
            return ServerResponse.createBySuccess(mapGroupList);
        }catch (Exception e){
            log.error("获取MapGroup分组列表异常："+e);
            e.printStackTrace();
        }
        return ServerResponse.createByError("获取MapGroup分组列表异常");
    }

    @Override
    public ServerResponse addOrUpdate(MapGroup mapGroup) {
        log.info("新增或修改MapGroup分组参数："+mapGroup);
        try {
            if(StringUtils.isEmpty(mapGroup.getMapGroupId())){
                mapGroup.setMapGroupId(UUIDUtil.getUUID());
                int insert = mapGroupMapper.insert(mapGroup);
                if(insert>0){
                    return ServerResponse.createBySuccess("新增成功");
                }
                return ServerResponse.createByError("新增失败");
            }
            int update = mapGroupMapper.updateByPrimaryKeySelective(mapGroup);
            if(update>0){
                return ServerResponse.createBySuccess("修改成功");
            }
            return ServerResponse.createByError("修改失败");
        }catch (Exception e){
            log.error("新增或修改MapGroup分组异常："+e);
            e.printStackTrace();
        }
        return ServerResponse.createByError("新增或修改MapGroup分组异常");
    }

    @Override
    public ServerResponse<PageInfo> getListBack(MapRequest mapRequest) {
        log.info("查询MapGroup参数："+mapRequest);
        try {
            //后台
            PageHelper.startPage(mapRequest.getPageNum(),mapRequest.getPageSize());
            List<MapGroup> mapPointList = mapGroupMapper.list(mapRequest);
            List<MapGroupResponse> mapGroupVoList = Lists.newArrayList();
            buildMapGroupResponse(mapPointList,mapGroupVoList);
            PageInfo pageResult = new PageInfo(mapPointList);
            pageResult.setList(mapGroupVoList);
            return ServerResponse.createBySuccess(pageResult);
        }catch (Exception e){
            e.printStackTrace();
            log.error("查询MapGroup异常："+e);
        }
        return ServerResponse.createByError("查询MapGroup异常");
    }

    private void buildMapGroupResponse(List<MapGroup> mapPointList, List<MapGroupResponse> mapGroupVoList) {
        for(MapGroup mapGroup :mapPointList){
            MapGroupResponse vo = new MapGroupResponse();
            vo.setCreateTime(DateUtil.dateToStr(mapGroup.getCreateTime()));
            vo.setMapGroupName(mapGroup.getMapGroupName());
            vo.setMapGroupId(mapGroup.getMapGroupId());
            vo.setMapGroupDesc(mapGroup.getMapGroupDesc());
            vo.setModifiedTime(DateUtil.dateToStr(mapGroup.getModifiedTime()));
            vo.setPkId(mapGroup.getPkId());
            vo.setStatus(mapGroup.getStatus());
            vo.setStatusDesc(mapGroup.getStatus().toString().
                    equals(Const.Status.YES.toString())?Const.Status.YES_DESC:Const.Status.NO_DESC);
            mapGroupVoList.add(vo);
        }
    }
}