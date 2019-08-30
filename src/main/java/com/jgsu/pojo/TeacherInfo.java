package com.jgsu.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author grt
 */
@Data
public class TeacherInfo implements Serializable {
    private static final long serialVersionUID = -4231362449861856570L;
    private Long pkId;

    private String teacherId;

    private String teacherCode;

    private String teacherName;

    private Date createTime;

    private Date modifiedTime;

    public TeacherInfo(Long pkId, String teacherId, String teacherCode, String teacherName, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.teacherId = teacherId;
        this.teacherCode = teacherCode;
        this.teacherName = teacherName;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public TeacherInfo() {
        super();
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode == null ? null : teacherCode.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
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

    @Override
    public String toString() {
        return "TeacherInfo{" +
                "pkId=" + pkId +
                ", teacherId='" + teacherId + '\'' +
                ", teacherCode='" + teacherCode + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}