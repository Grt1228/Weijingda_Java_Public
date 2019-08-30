package com.jgsu.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author grt
 */
@Data
public class ScoreInfo implements Serializable{
    private static final long serialVersionUID = 713404328610885992L;
    private Long pkId;

    private String scoreId;

    private String studentId;

    private String loginName;

    private String studentName;

    private String courseId;

    private String courseName;

    private String courseProperty;

    private String courseType;

    private String testProperty;

    private String testType;

    private String repairTime;

    private String learningTime;

    private String score;

    private String credit;

    private String hours;

    private String countCredit;

    private String countHours;

    private String countCourse;

    private String countFail;

    private String mustCredit;

    private String majorElectiveCredit;

    private String publicElectiveCredit;

    private String avgScorePoint;

    private String status;

    private Date createTime;

    private Date modifiedTime;

    public ScoreInfo(Long pkId, String scoreId, String studentId, String loginName, String studentName, String courseId, String courseName, String courseProperty, String courseType, String testProperty, String testType, String repairTime, String learningTime, String score, String credit, String hours, String countCredit, String countHours, String countCourse, String countFail, String mustCredit, String majorElectiveCredit, String publicElectiveCredit, String avgScorePoint, String status, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.loginName = loginName;
        this.studentName = studentName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseProperty = courseProperty;
        this.courseType = courseType;
        this.testProperty = testProperty;
        this.testType = testType;
        this.repairTime = repairTime;
        this.learningTime = learningTime;
        this.score = score;
        this.credit = credit;
        this.hours = hours;
        this.countCredit = countCredit;
        this.countHours = countHours;
        this.countCourse = countCourse;
        this.countFail = countFail;
        this.mustCredit = mustCredit;
        this.majorElectiveCredit = majorElectiveCredit;
        this.publicElectiveCredit = publicElectiveCredit;
        this.avgScorePoint = avgScorePoint;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public ScoreInfo() {
        super();
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId == null ? null : scoreId.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseProperty() {
        return courseProperty;
    }

    public void setCourseProperty(String courseProperty) {
        this.courseProperty = courseProperty == null ? null : courseProperty.trim();
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }

    public String getTestProperty() {
        return testProperty;
    }

    public void setTestProperty(String testProperty) {
        this.testProperty = testProperty == null ? null : testProperty.trim();
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType == null ? null : testType.trim();
    }

    public String getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(String repairTime) {
        this.repairTime = repairTime == null ? null : repairTime.trim();
    }

    public String getLearningTime() {
        return learningTime;
    }

    public void setLearningTime(String learningTime) {
        this.learningTime = learningTime == null ? null : learningTime.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit == null ? null : credit.trim();
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours == null ? null : hours.trim();
    }

    public String getCountCredit() {
        return countCredit;
    }

    public void setCountCredit(String countCredit) {
        this.countCredit = countCredit == null ? null : countCredit.trim();
    }

    public String getCountHours() {
        return countHours;
    }

    public void setCountHours(String countHours) {
        this.countHours = countHours == null ? null : countHours.trim();
    }

    public String getCountCourse() {
        return countCourse;
    }

    public void setCountCourse(String countCourse) {
        this.countCourse = countCourse == null ? null : countCourse.trim();
    }

    public String getCountFail() {
        return countFail;
    }

    public void setCountFail(String countFail) {
        this.countFail = countFail == null ? null : countFail.trim();
    }

    public String getMustCredit() {
        return mustCredit;
    }

    public void setMustCredit(String mustCredit) {
        this.mustCredit = mustCredit == null ? null : mustCredit.trim();
    }

    public String getMajorElectiveCredit() {
        return majorElectiveCredit;
    }

    public void setMajorElectiveCredit(String majorElectiveCredit) {
        this.majorElectiveCredit = majorElectiveCredit == null ? null : majorElectiveCredit.trim();
    }

    public String getPublicElectiveCredit() {
        return publicElectiveCredit;
    }

    public void setPublicElectiveCredit(String publicElectiveCredit) {
        this.publicElectiveCredit = publicElectiveCredit == null ? null : publicElectiveCredit.trim();
    }

    public String getAvgScorePoint() {
        return avgScorePoint;
    }

    public void setAvgScorePoint(String avgScorePoint) {
        this.avgScorePoint = avgScorePoint == null ? null : avgScorePoint.trim();
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

    @Override
    public String toString() {
        return "ScoreInfo{" +
                "pkId=" + pkId +
                ", scoreId='" + scoreId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseProperty='" + courseProperty + '\'' +
                ", courseType='" + courseType + '\'' +
                ", testProperty='" + testProperty + '\'' +
                ", testType='" + testType + '\'' +
                ", repairTime='" + repairTime + '\'' +
                ", learningTime='" + learningTime + '\'' +
                ", score='" + score + '\'' +
                ", credit='" + credit + '\'' +
                ", hours='" + hours + '\'' +
                ", countCredit='" + countCredit + '\'' +
                ", countHours='" + countHours + '\'' +
                ", countCourse='" + countCourse + '\'' +
                ", countFail='" + countFail + '\'' +
                ", mustCredit='" + mustCredit + '\'' +
                ", majorElectiveCredit='" + majorElectiveCredit + '\'' +
                ", publicElectiveCredit='" + publicElectiveCredit + '\'' +
                ", avgScorePoint='" + avgScorePoint + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}