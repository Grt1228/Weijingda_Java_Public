package com.jgsu.service;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.LostGood;
import com.jgsu.pojo.UserInfo;
import com.jgsu.vo.LostGoodRequest;

import java.util.List;

/**
 * 描述:
 * 失物招领
 *
 * @author grt
 * @create 2018-02-28 20:01
 */
public interface ILostGoodService {
    /**
     * 前台/后台获取失物招领列表
     * @return
     * @param lostGoodRequest
     */
    ServerResponse<PageInfo> getLostGoodList( LostGoodRequest lostGoodRequest);

    /**
     * 前台请求，根据lostGoodId有无判断，新增或修改
     * @param lostGood
     * @return
     */
    ServerResponse addOrUpdate(LostGood lostGood);

    /**
     * 前台新增一条失物招领记录
     * @param lostGood
     * @return
     */
    ServerResponse add(LostGood lostGood);

    /**
     * 后台将发布消息改为有效状态
     * @param lostGoodId
     * @param status
     * @return
     */
    ServerResponse updateStatus(String lostGoodId, String status);

    ServerResponse findById(String lostGoodId);
}
