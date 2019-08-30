package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Message {
    private Long pkId;

    private String messageId;

    private String loginName;

    private String openid;

    private String content;

    private Integer likedcount;

    private String incognito;

    private String status;

    private Date createTime;

    private Date modifiedTime;


    public Message(Long pkId, String messageId, String loginName, String openid, String content, Integer likedcount, String incognito, String status, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.messageId = messageId;
        this.loginName = loginName;
        this.openid = openid;
        this.content = content;
        this.likedcount = likedcount;
        this.incognito = incognito;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public Message() {
        super();
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getLikedcount() {
        return likedcount;
    }

    public void setLikedcount(Integer likedcount) {
        this.likedcount = likedcount;
    }

    public String getIncognito() {
        return incognito;
    }

    public void setIncognito(String incognito) {
        this.incognito = incognito == null ? null : incognito.trim();
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "Message{" +
                "pkId=" + pkId +
                ", messageId='" + messageId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", openid='" + openid + '\'' +
                ", content='" + content + '\'' +
                ", likedcount=" + likedcount +
                ", incognito='" + incognito + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}