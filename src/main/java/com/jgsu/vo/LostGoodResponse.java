package com.jgsu.vo;

import lombok.Data;

/**
 * 描述:
 * 失物招领返回值
 *
 * @author grt
 * @create 2018-05-01 18:02
 */
@Data
public class LostGoodResponse {
    /**
     `lost_good_id`  '遗失/寻找物品id',
     `adder_name`  '发布人姓名',
     `adder_mobile`  '发布人联系方式',
     `good_detail`  '物品详情',
     `good_position`  '丢失或发现的位置',
     `good_type`  '物品的类型,1-发布捡到物品,2-发布寻找物品',
     `good_status`  '失物招领状态,01-完成,02-未完成',
     `status` '记录的有效状态,11-有效,12-无效',
     */
    private Long pkId;

    private String lostGoodId;
    /**
     * openid
     */
    private String openid;
    /**
     * 发布者匿名称
     */
    private String adderName;

    private String adderMobile;
    /**
     * 标题
     */
    private String goodTitle;

    private String goodDetail;

    private String goodPosition;
    /**
     *     `good_type`  '物品的类型,1-发布捡到物品,2-发布寻找物品'
     */
    private String goodType;
    private String goodTypeDesc;
    /**
     *      `good_status`  '失物招领状态,01-完成,02-未完成',
     */
    private String goodStatus;
    private String goodStatusDesc;
    /**
     *      `status` '记录的有效状态,11-有效,12-无效'
     */
    private String status;
    private String statusDesc;
    private String image;

    private String createTime;

    private String modifiedTime;


}