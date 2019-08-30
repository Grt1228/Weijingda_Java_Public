package com.jgsu.vo.idea;

import lombok.Data;

/**
 * 描述:
 * idea后台返回值
 *
 * @author grt
 * @create 2018-04-24 21:20
 */
@Data
public class IdeaResponse {
    private Long pkId;

    private String ideaId;

    /**
     * 学号
     */
    private String openid;
    /**
     * 学生id
     */
    private String studentId;
    /**
     * 学生id
     */
    private String studentName;

    private String ideaDetail;

    private String createTime;

    private String modifiedTime;
}