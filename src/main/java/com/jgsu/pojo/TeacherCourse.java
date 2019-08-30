package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class TeacherCourse {
    private Long pkId;

    private String teacherId;

    private String courseId;

    private Date createTime;

    private Date modifiedTime;

    public TeacherCourse(Long pkId, String teacherId, String courseId, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public TeacherCourse() {
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

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
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