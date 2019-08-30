package com.jgsu.service;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.MapPoint;
import com.jgsu.vo.map.MapRequest; /**
 * 描述:
 * MapPoint接口
 *
 * @author grt
 * @create 2018-08-03 0:17
 */
public interface IMapPointService {
    /**
     * 获取map点列表后台分页
     * @param mapRequest
     * @return
     */
    ServerResponse<PageInfo> getListBack(MapRequest mapRequest);

    /**
     * 获取map点列表前台
     * @param mapRequest
     * @return
     */
    ServerResponse getListPortal(MapRequest mapRequest);

    /**
     * 后台新增或更新数据
     * @param mapPoint
     * @return
     */
    ServerResponse addOrUpdate(MapPoint mapPoint);

    /**
     * 后台删除
     * @param mapPoint
     * @return
     */
    ServerResponse delete(MapPoint mapPoint);
}
