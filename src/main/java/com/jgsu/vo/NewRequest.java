package com.jgsu.vo;

import lombok.Data;

/**
 * 描述:
 * 查看新闻请求request
 *
 * @author grt
 * @create 2018-04-28 16:00
 */
@Data
public class NewRequest extends PageRequest {
    /**
     * 新闻状态，1-有效，0-无效
     */
    private String newStatus;
    /**
     * 新闻类别查询
     */
    private String newType;
    /**
     * 发布人
     */
    private String newCreater;
    /**
     * 发布人
     */
    private String newTitle;

    /**
     * newID
     */

    private String newId;
}