package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class AppText {
    private Long pkId;

    private String appTextId;

    private String textTitle;

    private String textType;

    private String textContext;

    private String status;

    private Date createTime;

    private Date modifiedTime;

    public AppText(Long pkId, String appTextId, String textTitle, String textType, String textContext, String status, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.appTextId = appTextId;
        this.textTitle = textTitle;
        this.textType = textType;
        this.textContext = textContext;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public AppText() {
        super();
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getAppTextId() {
        return appTextId;
    }

    public void setAppTextId(String appTextId) {
        this.appTextId = appTextId == null ? null : appTextId.trim();
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle == null ? null : textTitle.trim();
    }

    public String getTextType() {
        return textType;
    }

    public void setTextType(String textType) {
        this.textType = textType == null ? null : textType.trim();
    }

    public String getTextContext() {
        return textContext;
    }

    public void setTextContext(String textContext) {
        this.textContext = textContext == null ? null : textContext.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
}