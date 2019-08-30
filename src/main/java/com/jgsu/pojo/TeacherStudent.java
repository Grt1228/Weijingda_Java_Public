package com.jgsu.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author grt
 */
@Data
public class TeacherStudent implements Serializable {

    private static final long serialVersionUID = 8519699434720951302L;
    private Long pkId;

    private String teacherId;

    private String studentId;

    private Date createTime;

    private Date modifiedTime;

    public TeacherStudent(Long pkId, String teacherId, String studentId, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public TeacherStudent() {
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

    @Override
    public String toString() {
        return "TeacherStudent{" +
                "pkId=" + pkId +
                ", teacherId='" + teacherId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}

