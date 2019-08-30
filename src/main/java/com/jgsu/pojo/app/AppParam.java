package com.jgsu.pojo.app;

import com.alibaba.fastjson.annotation.JSONField;

public class AppParam {
    /**
     * 方法名
     */
    @JSONField(name = "method")
    private String method;
    /**
     * 学号
     */
    @JSONField(name = "xh")
    private String userId;

    /**
     * 学年学期id
     */
    @JSONField(name = "xnxqid")
    private String learnDateId;


    /**
     * 周次
     */
    @JSONField(name = "zc")
    private String week;


    /**
     * 校区
     */
    @JSONField(name = "xqid")
    private String schoolAreaId;

    /**
     * 空教室查询是时间
     */
    @JSONField(name = "time")
    private String classRoomTime;


    /**
     * 空闲时间
     * 0102-0304-0506-0708(节次)（晚上-night|全天|allday|am-上午|pm|下午）
     */
    @JSONField(name = "idleTime")
    private String freeTime;


    /**
     * 教学楼id
     */
    @JSONField(name = "jxlid")
    private String schoolBuildId;

    /**
     * 教室容量
     * 0-30，30-40，40-50，+50
     */
    @JSONField(name = "classroomNumber")
    private String classroomNumber;


    /**
     * 字典名称
     * 0-30，30-40，40-50，+50
     */
    @JSONField(name = "dictName")
    private String dictName;
}
