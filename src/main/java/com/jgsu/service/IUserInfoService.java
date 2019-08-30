package com.jgsu.service;

import com.github.pagehelper.PageInfo;
import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.ScoreInfo;
import com.jgsu.pojo.UserInfo;
import com.jgsu.vo.CheckCodeVo;
import com.jgsu.vo.LoginVo;
import com.jgsu.vo.UserBackRequest;
import com.jgsu.vo.WechatInfoVo;

import java.util.List;

/**
 * 描述:
 * 用户相关service
 * @author grt
 * @create 2018-02-07 21:55
 */
public interface IUserInfoService {

    /**
     * 用户登陆接口
     * @param loginVo
     * @return
     */
    ServerResponse<UserInfo> login(LoginVo loginVo);

    /**
     * 获取验证码链接
     * @return
     */
    ServerResponse<CheckCodeVo> getCheckCode();

    /**
     * 获得成绩单
     * @return
     */
    ServerResponse<List<ScoreInfo>> getScore(UserInfo user);

    /**
     * 后台管理员登陆
     * @param username
     * @param password
     * @return
     */
    ServerResponse<UserInfo> backLogin(String username, String password);

    /**
     * 判断是不是管理员
     * @param user
     * @return
     */
    ServerResponse<UserInfo> checkAdminRole(UserInfo user);
    /**
     * 后台返回用户列表
     * @param userBackRequest
     * @return
     */
    ServerResponse<PageInfo> getUserList(UserBackRequest userBackRequest);

    /**
     * 后台返回查询所有用户的成绩
     * @param userBackRequest
     * @return
     */
    ServerResponse<PageInfo> getUserScoreList(UserBackRequest userBackRequest);

    /**
     * 获取学生的考试安排
     * @param user
     * @return
     */
    ServerResponse getTestSchedule(UserInfo user);

    /**
     * 更新成绩单
     * @param user
     * @return
     */
    ServerResponse updateScore(UserInfo user);

    /**
     * 获取用户微信相关信息
     * @param wechatInfoVo
     * @return
     */
    ServerResponse<WechatInfoVo> getWechatInfo(WechatInfoVo wechatInfoVo);

    /**
     * 通过loginNAmeList查询微信信息List
     * @param loginNameList
     * @return
     */
    List<UserInfo> findWecatInfoListByLoginNameList(List<String> loginNameList);

    /**
     * 保存用户微信信息
     * @param wechatInfoVo
     * @return
     */
    ServerResponse saveWechatInfo(WechatInfoVo wechatInfoVo);
}
