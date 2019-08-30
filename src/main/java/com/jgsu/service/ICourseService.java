package com.jgsu.service;

import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.CourseInfo;
import com.jgsu.vo.CourseRequest;

import java.util.List;

/**
 * 描述:
 * 课程表
 *
 * @author guorutao
 * @create 2018-04-27 16:43
 */
public interface ICourseService {
    /**
     *
     * @param courseRequest
     * @return
     */
    ServerResponse<List<CourseInfo>> getCourseList(CourseRequest courseRequest);

    /**
     * 获取当前周和当前学期
     * @param loginName
     * @param cookie
     * @return
     */
    ServerResponse currentWeekYear(String loginName, String cookie);
}
