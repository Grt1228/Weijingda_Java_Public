package com.jgsu.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author grt
 *
 */
@Data
public class CourseInfo implements Serializable{
    private static final long serialVersionUID = 6046059562090260372L;
    /**
     * pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
     `course_id` varchar(50) NOT NULL COMMENT '课程id_uuid',
     `course_code` varchar(20) NOT NULL COMMENT '课程编号-官方提供',
     `course_start_code` varchar(20) NOT NULL COMMENT '开课编号',
     `login_name` varchar(20) NOT NULL COMMENT '学号/登录名',
     `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
     `course_name` varchar(20) NOT NULL COMMENT '课程名称',
     `course_teacher` varchar(20) NOT NULL COMMENT '授课教师',
     `course_time` varchar(20) NOT NULL COMMENT '开课时间',
     `course_week` varchar(20) NOT NULL COMMENT '上课周次',
     `course_place` varchar(20) NOT NULL COMMENT '开课地点',
     `course_class` varchar(20) NOT NULL COMMENT '上课班级',
     `course_coordinate` varchar(20) NOT NULL COMMENT '课程所在坐标，开课学期_周次_星期_节次。例如：(2016-2017-1_1_1_1) 第一周_星期一_第一二节',
     `
     */
    private Long pkId;

    private String courseId;

    private String courseCode;

    private String courseStartCode;

    private String loginName;

    private String studentName;

    private String courseName;

    private String courseTeacher;

    private String courseTime;

    private String courseWeek;

    private String coursePlace;

    private String courseClass;

    private String courseCoordinate;

    private Date createTime;

    private Date modifiedTime;

    public CourseInfo(Long pkId, String courseId, String courseCode, String courseStartCode, String loginName, String studentName, String courseName, String courseTeacher, String courseTime, String courseWeek, String coursePlace, String courseClass, String courseCoordinate, Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseStartCode = courseStartCode;
        this.loginName = loginName;
        this.studentName = studentName;
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
        this.courseTime = courseTime;
        this.courseWeek = courseWeek;
        this.coursePlace = coursePlace;
        this.courseClass = courseClass;
        this.courseCoordinate = courseCoordinate;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public CourseInfo() {
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

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode == null ? null : courseCode.trim();
    }

    public String getCourseStartCode() {
        return courseStartCode;
    }

    public void setCourseStartCode(String courseStartCode) {
        this.courseStartCode = courseStartCode == null ? null : courseStartCode.trim();
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher == null ? null : courseTeacher.trim();
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime == null ? null : courseTime.trim();
    }

    public String getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(String courseWeek) {
        this.courseWeek = courseWeek == null ? null : courseWeek.trim();
    }

    public String getCoursePlace() {
        return coursePlace;
    }

    public void setCoursePlace(String coursePlace) {
        this.coursePlace = coursePlace == null ? null : coursePlace.trim();
    }

    public String getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(String courseClass) {
        this.courseClass = courseClass == null ? null : courseClass.trim();
    }

    public String getCourseCoordinate() {
        return courseCoordinate;
    }

    public void setCourseCoordinate(String courseCoordinate) {
        this.courseCoordinate = courseCoordinate == null ? null : courseCoordinate.trim();
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
        return "CourseInfo{" +
                "pkId=" + pkId +
                ", courseId='" + courseId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseStartCode='" + courseStartCode + '\'' +
                ", loginName='" + loginName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseTeacher='" + courseTeacher + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", courseWeek='" + courseWeek + '\'' +
                ", coursePlace='" + coursePlace + '\'' +
                ", courseClass='" + courseClass + '\'' +
                ", courseCoordinate='" + courseCoordinate + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}