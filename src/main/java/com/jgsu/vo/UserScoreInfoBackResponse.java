package com.jgsu.vo;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 描述:
 *  后台用户成绩返回值
 * @author guorutao
 * @create 2018-05-03 14:40
 */
public class UserScoreInfoBackResponse {
    private String studentId;

    private String loginName;

    private String studentName;
    /**
     * 存储多条成绩
     */
    List<ScoreInfoResponse> scoreInfoList = Lists.newArrayList();
    /**
     * 总学分
     */
    private String countCredit;
    /**
     * 总学时
     */
    private String countHours;
    /**
     * 总课程数
     */
    private String countCourse;
    /**
     * 不及格数必修学分
     */
    private String countFail;
    /**
     * 必修学分
     */
    private String mustCredit;
    /**
     * 专业选修学分
     */
    private String majorElectiveCredit;
    /**
     * 公共选修学分
     */
    private String publicElectiveCredit;
    /**
     * 平均学分绩点
     */
    private String avgScorePoint;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<ScoreInfoResponse> getScoreInfoList() {
        return scoreInfoList;
    }

    public void setScoreInfoList(List<ScoreInfoResponse> scoreInfoList) {
        this.scoreInfoList = scoreInfoList;
    }

    public String getCountCredit() {
        return countCredit;
    }

    public void setCountCredit(String countCredit) {
        this.countCredit = countCredit;
    }

    public String getCountHours() {
        return countHours;
    }

    public void setCountHours(String countHours) {
        this.countHours = countHours;
    }

    public String getCountCourse() {
        return countCourse;
    }

    public void setCountCourse(String countCourse) {
        this.countCourse = countCourse;
    }

    public String getCountFail() {
        return countFail;
    }

    public void setCountFail(String countFail) {
        this.countFail = countFail;
    }

    public String getMustCredit() {
        return mustCredit;
    }

    public void setMustCredit(String mustCredit) {
        this.mustCredit = mustCredit;
    }

    public String getMajorElectiveCredit() {
        return majorElectiveCredit;
    }

    public void setMajorElectiveCredit(String majorElectiveCredit) {
        this.majorElectiveCredit = majorElectiveCredit;
    }

    public String getPublicElectiveCredit() {
        return publicElectiveCredit;
    }

    public void setPublicElectiveCredit(String publicElectiveCredit) {
        this.publicElectiveCredit = publicElectiveCredit;
    }

    public String getAvgScorePoint() {
        return avgScorePoint;
    }

    public void setAvgScorePoint(String avgScorePoint) {
        this.avgScorePoint = avgScorePoint;
    }

    @Override
    public String toString() {
        return "UserScoreInfoBackResponse{" +
                "studentId='" + studentId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", scoreInfoList=" + scoreInfoList +
                ", countCredit='" + countCredit + '\'' +
                ", countHours='" + countHours + '\'' +
                ", countCourse='" + countCourse + '\'' +
                ", countFail='" + countFail + '\'' +
                ", mustCredit='" + mustCredit + '\'' +
                ", majorElectiveCredit='" + majorElectiveCredit + '\'' +
                ", publicElectiveCredit='" + publicElectiveCredit + '\'' +
                ", avgScorePoint='" + avgScorePoint + '\'' +
                '}';
    }
}
