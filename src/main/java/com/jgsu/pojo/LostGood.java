package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author grt
 */
@Data
public class LostGood {
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
     * 学号
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

    private String goodType;

    private String goodStatus;

    private String status;

    private String image;

    private Date createTime;

    private Date modifiedTime;

    public LostGood(Long pkId, String lostGoodId, String openid,  String adderName, String adderMobile, String goodTitle, String goodDetail, String goodPosition, String goodType, String goodStatus, String status, String image,Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.lostGoodId = lostGoodId;
        this.openid = openid;
        this.adderName = adderName;
        this.adderMobile = adderMobile;
        this.goodTitle = goodTitle;
        this.goodDetail = goodDetail;
        this.goodPosition = goodPosition;
        this.goodType = goodType;
        this.goodStatus = goodStatus;
        this.status = status;
        this.image = image;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public LostGood() {
        super();
    }


}