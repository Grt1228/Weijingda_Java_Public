package com.jgsu.vo;

import lombok.Data;

import java.util.Date;

/**
 * 描述:
 * 新闻返回类
 *
 * @author grt
 * @create 2018-04-29 21:53
 */
@Data
public class NewResponse {
    private Long pkId;

    private String newId;

    private String newTitle;
    /**
     * 新闻类别
     * SCHOOL_NEW(1,"校园新闻"),
         ADVICE_NEW(2,"通知公告"),
         LECTURE_NEW(3,"学术讲座"),
         RESEARCH_NEW(4,"科研信息"),
         TEACHING_NEW(5,"教务通知"),
         COLLEGE_NEW(6,"学院动态");
     */
    private String newType;
    private String newTypeDesc;

    private String newDate;

    private String newCreater;

    private String newDetail;
    /**
     * '新闻状态，1-有效，0-无效',
     */
    private String newStatus;
    private String newStatusDesc;

    private Integer lookNum;
    private String imageUrl;
    private String imageId;

    private String createTime;

    private String modifiedTime;


    public NewResponse(Long pkId, String newId, String newTitle, String newType, String newTypeDesc, String newDate, String newCreater, String newDetail, String newStatus, String newStatusDesc, Integer lookNum, String imageUrl, String imageId, String createTime, String modifiedTime) {
        this.pkId = pkId;
        this.newId = newId;
        this.newTitle = newTitle;
        this.newType = newType;
        this.newTypeDesc = newTypeDesc;
        this.newDate = newDate;
        this.newCreater = newCreater;
        this.newDetail = newDetail;
        this.newStatus = newStatus;
        this.newStatusDesc = newStatusDesc;
        this.lookNum = lookNum;
        this.imageUrl = imageUrl;
        this.imageId = imageId;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public NewResponse() {
    }
}