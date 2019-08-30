package com.jgsu.vo;

/**
 * 描述:
 *
 *
 * @author guorutao
 * @create 2018-05-03 14:42
 */
public class ScoreInfoResponse {
    private Long pkId;
    /**
     * 记录id
     */
    private String scoreId;

    private String studentId;

    private String loginName;

    private String studentName;

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
     * 课程编号
     */
    private String courseId;

    private String courseName;
    /**
     * 课程性质，限选，任选，必修，实践
     */
    private String courseProperty;
    /**
     * 课程类别，C2限选，A1必修...
     */
    private String courseType;
    /**
     * 考试性质，正常考试，补考
     */
    private String testProperty;
    /**
     * 考核方式，考试，考查
     */
    private String testType;
    /**
     * 补重学期
     */
    private String repairTime;
    /**
     * 开课时间
     */
    private String learningTime;
    /**
     * 总成绩
     */
    private String score;
    /**
     * 学分
     */
    private String credit;
    /**
     * 学时
     */
    private String hours;

    /**
     * 是否及格,1-及格,2-不及格
     */
    private String status;
    private String statusDesc;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String modifiedTime;

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
        this.scoreId = scoreId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseProperty() {
        return courseProperty;
    }

    public void setCourseProperty(String courseProperty) {
        this.courseProperty = courseProperty;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getTestProperty() {
        return testProperty;
    }

    public void setTestProperty(String testProperty) {
        this.testProperty = testProperty;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(String repairTime) {
        this.repairTime = repairTime;
    }

    public String getLearningTime() {
        return learningTime;
    }

    public void setLearningTime(String learningTime) {
        this.learningTime = learningTime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "ScoreInfoResponse{" +
                "pkId=" + pkId +
                ", scoreId='" + scoreId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", countCredit='" + countCredit + '\'' +
                ", countHours='" + countHours + '\'' +
                ", countCourse='" + countCourse + '\'' +
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
                ", status='" + status + '\'' +
                ", statusDesc='" + statusDesc + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }
}
