package com.jgsu.dao;

import com.jgsu.pojo.UserInfo;
import com.jgsu.vo.UserBackRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    /**
     * deleteByStudentId
     * @param studentId
     * @return
     */
    int deleteByStudentId(String studentId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 检查用户是否存在
     * @param loginName
     * @return
     */
    UserInfo checkUsername(@Param("loginName") String loginName);

    /**
     * 后台管理员登陆
     * @param loginName
     * @param password
     * @return
     */
    UserInfo selectLogin(@Param("loginName") String loginName,@Param("password") String password);

    /**
     * 登陆成功更新用户密码
     * @param loginName
     * @return
     */
    int updatePasswordByLoginName(@Param("loginName") String loginName,@Param("password") String password);

    /**
     * 多条件查询用户列表
     * @param userBackRequest
     * @return
     */
    List<UserInfo> selectAllUserInfo(UserBackRequest userBackRequest);

    /**
     * 通过loginNAmeList查询微信信息List
     * @param openIdList
     * @return
     */
    List<UserInfo> findWecatInfoListByOpenidList(@Param("openIdList") List<String> openIdList);

    /**
     *
     * @param openid
     * @return
     */
    UserInfo findUserByOpenid(@Param("openid") String openid);

}