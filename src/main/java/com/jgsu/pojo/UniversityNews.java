package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class UniversityNews {
    private Long pkId;

    private String newId;

    private String newTitle;

    private String newType;

    private String newDate;

    private String newCreater;

    private String newDetail;

    private String newStatus;

    private Integer lookNum;

    private Date createTime;

    private Date modifiedTime;

    private String imageUrl;
    private String imageId;

    public UniversityNews(Long pkId, String newId, String newTitle, String newType, String newDate, String newCreater, String newDetail, String newStatus, Integer lookNum,String imageId,String imageUrl, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.newId = newId;
        this.newTitle = newTitle;
        this.newType = newType;
        this.newDate = newDate;
        this.newCreater = newCreater;
        this.newDetail = newDetail;
        this.newStatus = newStatus;
        this.lookNum = lookNum;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.imageUrl = imageUrl;
        this.imageId = imageId;
    }

    public UniversityNews() {
        super();
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId == null ? null : newId.trim();
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle == null ? null : newTitle.trim();
    }

    public String getNewType() {
        return newType;
    }

    public void setNewType(String newType) {
        this.newType = newType == null ? null : newType.trim();
    }

    public String getNewDate() {
        return newDate;
    }

    public void setNewDate(String newDate) {
        this.newDate = newDate == null ? null : newDate.trim();
    }

    public String getNewCreater() {
        return newCreater;
    }

    public void setNewCreater(String newCreater) {
        this.newCreater = newCreater == null ? null : newCreater.trim();
    }

    public String getNewDetail() {
        return newDetail;
    }

    public void setNewDetail(String newDetail) {
        this.newDetail = newDetail == null ? null : newDetail.trim();
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus == null ? null : newStatus.trim();
    }

    public Integer getLookNum() {
        return lookNum;
    }

    public void setLookNum(Integer lookNum) {
        this.lookNum = lookNum;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}