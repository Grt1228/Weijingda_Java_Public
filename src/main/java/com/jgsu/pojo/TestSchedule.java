package com.jgsu.pojo;

import lombok.Data;

/**
 * 描述:
 * 用户考试安排
 *
 * @author grt
 * @create 2018-05-17 19:41
 */
@Data
public class TestSchedule {
    private String testScheduleId;
    private String studentId;

    private String loginName;

    private String studentName;
    /**
     * 学年学期号
     */
    private String testYear;
    /**
     * 考试类别
     */
    private String testType;
    /**
     * 考试时间
     */
    private String testTime;
    /**
     * 科目代码
     */
    private String testCode;
    /**
     * 科目名称
     */
    private String testName;
    /**
     * 考试地点
     */
    private String testLocation;
    /**
     * 座位号
     */
    private String testRoomNumber;

    public String getTestYear() {
        return testYear;
    }

    public void setTestYear(String testYear) {
        this.testYear = testYear;
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

    public String getTestScheduleId() {
        return testScheduleId;
    }

    public void setTestScheduleId(String testScheduleId) {
        this.testScheduleId = testScheduleId;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public String getTestCode() {
        return testCode;
    }

    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestLocation() {
        return testLocation;
    }

    public void setTestLocation(String testLocation) {
        this.testLocation = testLocation;
    }

    public String getTestRoomNumber() {
        return testRoomNumber;
    }

    public void setTestRoomNumber(String testRoomNumber) {
        this.testRoomNumber = testRoomNumber;
    }

    @Override
    public String toString() {
        return "TestSchedule{" +
                "testScheduleId='" + testScheduleId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", testYear='" + testYear + '\'' +
                ", testType='" + testType + '\'' +
                ", testTime='" + testTime + '\'' +
                ", testCode='" + testCode + '\'' +
                ", testName='" + testName + '\'' +
                ", testLocation='" + testLocation + '\'' +
                ", testRoomNumber='" + testRoomNumber + '\'' +
                '}';
    }
}