package com.jgsu.vo;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;

/**
 * 描述:
 * 最终返回值scoreInfo
 *
 * @author guorutao
 * @create 2018-05-03 16:41
 */
public class ScoreInfoResult implements Serializable{
    private PageInfo pageInfo;
    private UserScoreInfoBackResponse userScoreInfoBackResponse;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public UserScoreInfoBackResponse getUserScoreInfoBackResponse() {
        return userScoreInfoBackResponse;
    }

    public void setUserScoreInfoBackResponse(UserScoreInfoBackResponse userScoreInfoBackResponse) {
        this.userScoreInfoBackResponse = userScoreInfoBackResponse;
    }

    @Override
    public String toString() {
        return "ScoreInfoResult{" +
                "pageInfo=" + pageInfo +
                ", userScoreInfoBackResponse=" + userScoreInfoBackResponse +
                '}';
    }
}
