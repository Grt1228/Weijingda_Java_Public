package com.jgsu.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Idea {
    private Long pkId;

    private String ideaId;
    /**
     * openid
     */
    private String openid;
    /**
     * 学号
     */
    private String studentName;
    /**
     * 学生id
     */
    private String studentId;

    private String ideaDetail;
    /**
     * 联系方式
     */
    private String linkType;

    private Date createTime;

    private Date modifiedTime;


}