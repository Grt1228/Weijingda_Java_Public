package com.jgsu.service;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.MapGroup;
import com.jgsu.vo.map.MapRequest; /**
 * 描述:
 * Map点分组
 *
 * @author lqd12
 * @create 2018-08-05 10:17
 */
public interface IMapGroupService {
    /**
     * 获得点分组列表
     * @param mapRequest
     * @return
     */
    ServerResponse getListPortal(MapRequest mapRequest);

    /**
     * 后台新增或修改一条数据
     * @param mapGroup
     * @return
     */
    ServerResponse addOrUpdate(MapGroup mapGroup);

    /**
     * 后台获取分组列表
     * @param mapRequest
     * @return
     */
    ServerResponse<PageInfo> getListBack(MapRequest mapRequest);
}
