package com.jgsu.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:
 * 电话簿返回值
 *
 * @author grt
 * @create 2018-04-24 0:28
 */
public class PhoneBookVo implements Serializable {
    private Long pkId;

    private String phoneBookId;

    private String phoneName;

    private String phoneNumber;

    private String phoneLevelCode;

    private String phoneLevelDesc;

    private String statusCode;

    private String statusDesc;

    private String createTime;

    private String modifiedTime;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getPhoneBookId() {
        return phoneBookId;
    }

    public void setPhoneBookId(String phoneBookId) {
        this.phoneBookId = phoneBookId;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneLevelCode() {
        return phoneLevelCode;
    }

    public void setPhoneLevelCode(String phoneLevelCode) {
        this.phoneLevelCode = phoneLevelCode;
    }

    public String getPhoneLevelDesc() {
        return phoneLevelDesc;
    }

    public void setPhoneLevelDesc(String phoneLevelDesc) {
        this.phoneLevelDesc = phoneLevelDesc;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "PhoneBookVo{" +
                "pkId=" + pkId +
                ", phoneBookId='" + phoneBookId + '\'' +
                ", phoneName='" + phoneName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneLevelCode='" + phoneLevelCode + '\'' +
                ", phoneLevelDesc='" + phoneLevelDesc + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", statusDesc='" + statusDesc + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }
}