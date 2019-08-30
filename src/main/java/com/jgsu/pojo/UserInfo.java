package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class UserInfo {
    private Long pkId;

    private String studentId;

    private String openid;

    private String gender;

    private String loginName;

    private String studentName;

    private String orgCode;

    private String password;

    private String universityName;

    private String collegeName;

    private String majorsName;

    private String collegeId;

    private String majorsId;

    private String className;

    private String classId;

    private String mobile;

    private String email;

    private String status;

    private String role;

    /**
     * 微信名称
     */
    private String nickName;
    /**
     * 微信头像
     */
    private String avatarUrl;

    private String cookie;

    private Date createTime;

    private Date modifiedTime;

    public UserInfo(Long pkId, String studentId,String gender, String loginName, String studentName, String orgCode,
                    String password, String universityName, String collegeName, String majorsName, String collegeId,
                    String majorsId, String className, String classId, String mobile, String email, String status,
                    String role, String openid, String nickName,String avatarUrl,Date createTime, Date modifiedTime) {
        this.pkId = pkId;
        this.studentId = studentId;
        this.gender = gender;
        this.loginName = loginName;
        this.studentName = studentName;
        this.orgCode = orgCode;
        this.password = password;
        this.universityName = universityName;
        this.collegeName = collegeName;
        this.majorsName = majorsName;
        this.collegeId = collegeId;
        this.majorsId = majorsId;
        this.className = className;
        this.classId = classId;
        this.mobile = mobile;
        this.email = email;
        this.status = status;
        this.role = role;
        this.openid = openid;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public UserInfo() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
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

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName == null ? null : universityName.trim();
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }

    public String getMajorsName() {
        return majorsName;
    }

    public void setMajorsName(String majorsName) {
        this.majorsName = majorsName == null ? null : majorsName.trim();
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId == null ? null : collegeId.trim();
    }

    public String getMajorsId() {
        return majorsId;
    }

    public void setMajorsId(String majorsId) {
        this.majorsId = majorsId == null ? null : majorsId.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "pkId=" + pkId +
                ", studentId='" + studentId + '\'' +
                ", gender='" + gender + '\'' +
                ", loginName='" + loginName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", password='" + password + '\'' +
                ", universityName='" + universityName + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", majorsName='" + majorsName + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", majorsId='" + majorsId + '\'' +
                ", className='" + className + '\'' +
                ", classId='" + classId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                ", cookie='" + cookie + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                ", nickName=" + nickName +
                ", avatarUrl=" + avatarUrl +
                ", openid=" + openid +
                '}';
    }
}