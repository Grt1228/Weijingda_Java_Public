package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class StudentCourse {
    private Long pkId;

    private String courseId;

    private String studentId;

    private Date createTime;

    private Date modifiedTime;

    public StudentCourse(Long pkId, String courseId, String studentId, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.courseId = courseId;
        this.studentId = studentId;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public StudentCourse() {
        super();
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
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