package com.jgsu.vo;

import java.util.Date;

/**
 * 描述:
 * 图片管理
 *
 * @author grt
 * @create 2018-05-29 20:21
 */
public class ImageResponse {
    private Long pkId;

    private String imageId;
    private String imageName;

    private String imageUrl;
    /**
     * '状态：0：失效，1：生效',
     */
    private String status;
    private String statusDesc;
    /**
     * '图片类型 0轮播图，1首页图标',
     */
    private String imageType;
    private String imageTypeDesc;
    /**
     * 排序
     */
    private Integer sortNum;

    private Date createTime;

    private Date modifiedTime;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getImageTypeDesc() {
        return imageTypeDesc;
    }

    public void setImageTypeDesc(String imageTypeDesc) {
        this.imageTypeDesc = imageTypeDesc;
    }

    @Override
    public String toString() {
        return "ImageResponse{" +
                "pkId=" + pkId +
                ", imageId='" + imageId + '\'' +
                ", imageName='" + imageName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", status='" + status + '\'' +
                ", statusDesc='" + statusDesc + '\'' +
                ", imageType='" + imageType + '\'' +
                ", imageTypeDesc='" + imageTypeDesc + '\'' +
                ", sortNum=" + sortNum +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}