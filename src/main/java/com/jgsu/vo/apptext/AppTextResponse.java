package com.jgsu.vo.apptext;

import lombok.Data;

@Data
public class AppTextResponse  {

    private Long pkId;

    private String appTextId;

    private String textTitle;

    private String textType;

    private String textTypeDesc;

    private String textContext;

    private String status;

    private String statusDesc;

    private String createTime;

    private String modifiedTime;
}
