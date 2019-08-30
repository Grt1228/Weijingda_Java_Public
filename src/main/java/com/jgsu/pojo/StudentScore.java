package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class StudentScore {
    private Long pkId;

    private String studentId;

    private String scoreId;

    private Date createTime;

    private Date modifiedTime;

    public StudentScore(Long pkId, String studentId, String scoreId, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.studentId = studentId;
        this.scoreId = scoreId;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public StudentScore() {
        super();
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId == null ? null : scoreId.trim();
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