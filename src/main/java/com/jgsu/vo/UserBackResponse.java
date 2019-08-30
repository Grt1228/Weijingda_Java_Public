package com.jgsu.vo;

/**
 * 描述:
 * 后台返回用户vo
 *
 * @author guorutao
 * @create 2018-05-03 13:42
 */
public class UserBackResponse {
    private Long pkId;

    private String studentId;

    private String gender;

    private String loginName;

    private String studentName;
    /**
     * '组织编号,1本科，2研究生，3教师'
     */
    private String orgCode;

    private String orgCodeDesc;
    /**
     * 学校名称
     */
    private String universityName;
    /**
     * 学院名称
     */
    private String collegeName;
    /**
     * 学科名称
     */
    private String majorsName;
    /**
     * 学院编号
     */
    private String collegeId;
    /**
     * 学科编号
     */
    private String majorsId;
    /**
     * 班级名称
     */
    private String className;
    /**
     * 班级编号
     */
    private String classId;

    private String mobile;

    private String email;
    /**
     * '状态：0：失效，1：生效'
     */
    private String status;

    private String statusDesc;
    /**
     * '角色：0：普通用户，1：管理员'
     */
    private String role;

    private String roleDesc;

    private String createTime;

    private String modifiedTime;
    /**
     * 微信名称
     */
    private String nickName;
    /**
     * 微信头像
     */
    private String avatarUrl;

    /**
     * openid
     * @return
     */
    private String openid;
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
        this.studentId = studentId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgCodeDesc() {
        return orgCodeDesc;
    }

    public void setOrgCodeDesc(String orgCodeDesc) {
        this.orgCodeDesc = orgCodeDesc;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getMajorsName() {
        return majorsName;
    }

    public void setMajorsName(String majorsName) {
        this.majorsName = majorsName;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getMajorsId() {
        return majorsId;
    }

    public void setMajorsId(String majorsId) {
        this.majorsId = majorsId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "UserBackResponse{" +
                "pkId=" + pkId +
                ", studentId='" + studentId + '\'' +
                ", gender='" + gender + '\'' +
                ", loginName='" + loginName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", orgCodeDesc='" + orgCodeDesc + '\'' +
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
                ", statusDesc='" + statusDesc + '\'' +
                ", role='" + role + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                ", openid='" + openid + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
