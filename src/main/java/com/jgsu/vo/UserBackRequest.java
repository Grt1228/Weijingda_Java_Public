package com.jgsu.vo;

/**
 * 描述:
 * 后台用户request
 *
 * @author guorutao
 * @create 2018-05-03 13:31
 */
public class UserBackRequest extends PageRequest {
    /**
     * 学号
     */
    private String loginName;
    /**
     * 姓名
     */
    private String studentName;

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

    @Override
    public String toString() {
        return "UserBackRequest{" +
                "loginName='" + loginName + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
