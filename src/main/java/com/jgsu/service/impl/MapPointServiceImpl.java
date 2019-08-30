package com.jgsu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jgsu.common.Const;
import com.jgsu.common.MapPointType;
import com.jgsu.common.ServerResponse;
import com.jgsu.dao.MapGroupMapper;
import com.jgsu.dao.MapPointMapper;
import com.jgsu.pojo.MapGroup;
import com.jgsu.pojo.MapPoint;
import com.jgsu.service.IMapPointService;
import com.jgsu.utils.DateUtil;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.vo.map.MapPointResponse;
import com.jgsu.vo.map.MapRequest;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * MapPoint点实现
 *
 * @author grt
 * @create 2018-08-03 0:20
 */
@Service("iMapPointService")
@Slf4j
public class MapPointServiceImpl implements IMapPointService{


    @Autowired
    private MapPointMapper mapPointMapper;
    @Autowired
    private MapGroupMapper mapGroupMapper;
    @Override
    public ServerResponse<PageInfo> getListBack(MapRequest mapRequest) {
        log.info("查询MapPoint参数："+mapRequest);
        try {
            //后台
            PageHelper.startPage(mapRequest.getPageNum(),mapRequest.getPageSize());
            List<MapPoint> mapPointList = mapPointMapper.list(mapRequest);
            List<MapPointResponse> responseList = Lists.newArrayList();
            buildResponse(mapPointList,responseList);
            PageInfo pageResult = new PageInfo(mapPointList);
            pageResult.setList(responseList);
            return ServerResponse.createBySuccess(pageResult);
        }catch (Exception e){
            e.printStackTrace();
            log.error("查询MapPoint异常："+e);
        }
        return ServerResponse.createByError("查询MapPoint异常");
    }



    @Override
    public ServerResponse getListPortal(MapRequest mapRequest) {
        log.info("前台MapPoint参数："+mapRequest);
        try {
            //前台
            List<MapPoint> mapPointList = mapPointMapper.list(mapRequest);
            List<MapPointResponse> responseList = Lists.newArrayList();
            buildResponse(mapPointList,responseList);
            return ServerResponse.createBySuccess(responseList);
        }catch (Exception e){
            e.printStackTrace();
            log.error("查询MapPoint异常："+e);
        }
        return ServerResponse.createByError("查询MapPoint异常");
    }

    @Override
    public ServerResponse addOrUpdate(MapPoint mapPoint) {
        log.info("前台保存MapPoint参数:"+mapPoint);
        try {
            if(StringUtils.isEmpty(mapPoint.getMapPointId())){
                //新增
                mapPoint.setMapPointId(UUIDUtil.getUUID());
                MapGroup mapGroup = mapGroupMapper.selectByPrimaryKey(mapPoint.getMapGroupId());
                if(mapGroup!=null){
                    mapPoint.setMapGroupName(mapGroup.getMapGroupName());
                }
                int insert = mapPointMapper.insert(mapPoint);
                if(insert>0){
                    return ServerResponse.createBySuccess("新增成功");
                }
                return ServerResponse.createByError("新增异常失败");
            }
            MapGroup mapGroup = mapGroupMapper.selectByPrimaryKey(mapPoint.getMapGroupId());
            mapPoint.setMapGroupName(mapGroup.getMapGroupName());
            int update = mapPointMapper.updateByPrimaryKeySelective(mapPoint);
            if(update>0){
                return ServerResponse.createBySuccess("修改MapPoint成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("新增或修改MapPoint异常："+e);
        }
        return ServerResponse.createByError("修改MapPoint异常失败");
    }

    /**
     * 后台删除
     *
     * @param mapPoint
     * @return
     */
    @Override
    public ServerResponse delete(MapPoint mapPoint) {
        log.info("删除MapPoint参数:"+mapPoint);
        int i = mapPointMapper.deleteByPrimaryKey(mapPoint.getMapPointId());
        if(i>=1){
            return ServerResponse.createBySuccess("删除成功！");
        }
        return ServerResponse.createByError("删除异常！");
    }


    private void buildResponse(List<MapPoint> mapPointList,
                               List<MapPointResponse> responseList) {
        for(MapPoint mapPoint:mapPointList){
            MapPointResponse vo = new MapPointResponse();
            vo.setCreateTime(DateUtil.dateToStr(mapPoint.getCreateTime()));
            vo.setMapGroupId(mapPoint.getMapGroupId());
            vo.setMapGroupName(mapPoint.getMapGroupName());
            vo.setMapPointDesc(mapPoint.getMapPointDesc());
            vo.setMapPointId(mapPoint.getMapPointId());
            vo.setMapPointLatitude(mapPoint.getMapPointLatitude());
            vo.setMapPointLongitude(mapPoint.getMapPointLongitude());
            vo.setMapPointName(mapPoint.getMapPointName());
            vo.setModifiedTime(DateUtil.dateToStr(mapPoint.getModifiedTime()));
            vo.setPkId(mapPoint.getPkId());
            vo.setPointType(mapPoint.getPointType());
            vo.setPointTypeDesc(mapPoint.getPointType().equals(MapPointType.COMMON_POINT.getCode().toString())?
                                    MapPointType.COMMON_POINT.getDesc():
                                    MapPointType.LINE_NEW.getDesc());
            vo.setSort(mapPoint.getSort());
            vo.setStatus(mapPoint.getStatus());
            vo.setStatusDesc(mapPoint.getStatus().equals(Const.Status.YES.toString())?
                    Const.Status.YES_DESC:Const.Status.NO_DESC);
            responseList.add(vo);
        }
    }
}