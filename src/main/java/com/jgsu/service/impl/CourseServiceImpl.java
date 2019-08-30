package com.jgsu.service.impl;

import com.jgsu.common.ServerResponse;
import com.jgsu.dao.CourseInfoMapper;
import com.jgsu.pojo.CourseInfo;
import com.jgsu.requestrelated.UserRequest;
import com.jgsu.service.ICourseService;
import com.jgsu.vo.CourseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * 课程表
 *
 * @author guorutao
 * @create 2018-04-27 16:43
 */
@Service
public class CourseServiceImpl implements ICourseService {
    private Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
    @Autowired
    private CourseInfoMapper courseInfoMapper;
    @Override
    public ServerResponse getCourseList(CourseRequest courseRequest) {
        logger.info("获取用户课表开始");
        try {
            /*List<CourseInfo> courseInfoList =
                    courseInfoMapper.selectCourseListByLoginName(courseRequest.getLoginName());
            if(courseInfoList.size()==0){
                //todo 说明数据库没有记录需要发送请求去查询课程信息+cookie
                //todo 存储课程信息到数据库
            }*/
            ServerResponse response = UserRequest.getCourseList(courseRequest);

            return response;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("获取课表异常"+e);
        }
        return ServerResponse.createByError("获取课表异常");
    }

    @Override
    public ServerResponse currentWeekYear(String loginName, String cookie) {
        logger.info("获取当前周当前学期");
        try {
            ServerResponse response = UserRequest.currentWeekYear(loginName, cookie);

            return response;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("获取当前周当前学期异常"+e);
        }
        return ServerResponse.createByError("获取当前周当前学期异常");
    }
}
