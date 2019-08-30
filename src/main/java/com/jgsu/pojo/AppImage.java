package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class AppImage {
    private Long pkId;

    private String imageId;
    private String imageName;
    private String imageUrl;
    /**
     * '状态：0：失效，1：生效',
     */
    private String status;
    /**
     * '图片类型 0轮播图，1首页图标',2新闻头图
     */
    private String imageType;
    /**
     * 排序
     */
    private Integer sortNum;

    private Date createTime;

    private Date modifiedTime;

    public AppImage(Long pkId, String imageId,String imageName, String imageUrl, String status, String imageType, Integer sortNum, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.imageId = imageId;
        this.imageName = imageName;
        this.imageUrl = imageUrl;
        this.status = status;
        this.imageType = imageType;
        this.sortNum = sortNum;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public AppImage() {
        super();
    }

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
        this.imageId = imageId == null ? null : imageId.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType == null ? null : imageType.trim();
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}