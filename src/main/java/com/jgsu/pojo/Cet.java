package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Cet {
    private Long pkId;

    private String cetId;

    private String cetNumber;

    private String studentId;

    private String studentName;

    private String university;

    private String cet4Score;

    private String cet6Score;

    private String cet6ListenScore;

    private String cet4ListenScore;

    private String cet6ReadScore;

    private String cet4ReadScore;

    private String cet6WriteScore;

    private String cet4WriteScore;

    private String cet4Status;

    private String cet6Status;

    private String cetType;

    private Date createTime;

    private Date modifiedTime;

    public Cet(Long pkId, String cetId, String cetNumber, String studentId, String studentName, String university, String cet4Score, String cet6Score, String cet6ListenScore, String cet4ListenScore, String cet6ReadScore, String cet4ReadScore, String cet6WriteScore, String cet4WriteScore, String cet4Status, String cet6Status, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.cetId = cetId;
        this.cetNumber = cetNumber;
        this.studentId = studentId;
        this.studentName = studentName;
        this.university = university;
        this.cet4Score = cet4Score;
        this.cet6Score = cet6Score;
        this.cet6ListenScore = cet6ListenScore;
        this.cet4ListenScore = cet4ListenScore;
        this.cet6ReadScore = cet6ReadScore;
        this.cet4ReadScore = cet4ReadScore;
        this.cet6WriteScore = cet6WriteScore;
        this.cet4WriteScore = cet4WriteScore;
        this.cet4Status = cet4Status;
        this.cet6Status = cet6Status;
        this.cetType = cetType;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public Cet() {
        super();
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getCetId() {
        return cetId;
    }

    public void setCetId(String cetId) {
        this.cetId = cetId == null ? null : cetId.trim();
    }

    public String getCetNumber() {
        return cetNumber;
    }

    public void setCetNumber(String cetNumber) {
        this.cetNumber = cetNumber == null ? null : cetNumber.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university == null ? null : university.trim();
    }

    public String getCet4Score() {
        return cet4Score;
    }

    public void setCet4Score(String cet4Score) {
        this.cet4Score = cet4Score == null ? null : cet4Score.trim();
    }

    public String getCet6Score() {
        return cet6Score;
    }

    public void setCet6Score(String cet6Score) {
        this.cet6Score = cet6Score == null ? null : cet6Score.trim();
    }

    public String getCet6ListenScore() {
        return cet6ListenScore;
    }

    public void setCet6ListenScore(String cet6ListenScore) {
        this.cet6ListenScore = cet6ListenScore == null ? null : cet6ListenScore.trim();
    }

    public String getCet4ListenScore() {
        return cet4ListenScore;
    }

    public void setCet4ListenScore(String cet4ListenScore) {
        this.cet4ListenScore = cet4ListenScore == null ? null : cet4ListenScore.trim();
    }

    public String getCet6ReadScore() {
        return cet6ReadScore;
    }

    public void setCet6ReadScore(String cet6ReadScore) {
        this.cet6ReadScore = cet6ReadScore == null ? null : cet6ReadScore.trim();
    }

    public String getCet4ReadScore() {
        return cet4ReadScore;
    }

    public void setCet4ReadScore(String cet4ReadScore) {
        this.cet4ReadScore = cet4ReadScore == null ? null : cet4ReadScore.trim();
    }

    public String getCet6WriteScore() {
        return cet6WriteScore;
    }

    public void setCet6WriteScore(String cet6WriteScore) {
        this.cet6WriteScore = cet6WriteScore == null ? null : cet6WriteScore.trim();
    }

    public String getCet4WriteScore() {
        return cet4WriteScore;
    }

    public void setCet4WriteScore(String cet4WriteScore) {
        this.cet4WriteScore = cet4WriteScore == null ? null : cet4WriteScore.trim();
    }

    public String getCet4Status() {
        return cet4Status;
    }

    public void setCet4Status(String cet4Status) {
        this.cet4Status = cet4Status == null ? null : cet4Status.trim();
    }

    public String getCet6Status() {
        return cet6Status;
    }

    public void setCet6Status(String cet6Status) {
        this.cet6Status = cet6Status == null ? null : cet6Status.trim();
    }

    public String getCetType() {
        return cetType;
    }

    public void setCetType(String cetType) {
        this.cetType = cetType;
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