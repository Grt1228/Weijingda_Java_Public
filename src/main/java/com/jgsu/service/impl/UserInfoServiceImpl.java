package com.jgsu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jgsu.common.Const;
import com.jgsu.common.OrgType;
import com.jgsu.dao.ScoreInfoMapper;
import com.jgsu.dao.UserInfoMapper;
import com.jgsu.pojo.ScoreInfo;
import com.jgsu.pojo.TestSchedule;
import com.jgsu.pojo.UserInfo;
import com.jgsu.requestrelated.UserRequest;
import com.jgsu.common.ServerResponse;
import com.jgsu.service.IUserInfoService;
import com.jgsu.utils.DateUtil;
import com.jgsu.utils.Md5Util;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.utils.httpclientutil.exception.HttpProcessException;
import com.jgsu.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * 描述:
 * 用户相关service
 *
 * @author grt
 * @create 2018-02-07 21:57
 */
@Slf4j
@Service("iUserInfoService")
public class UserInfoServiceImpl implements IUserInfoService{
    private Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private ScoreInfoMapper scoreInfoMapper;

    @Override
    public ServerResponse<UserInfo> login(LoginVo loginVo) {
        logger.info("前台用户登陆参数："+loginVo);
        ServerResponse<UserInfo> loginResponse = null;
        try {
            // 先登陆
            loginResponse = UserRequest.login(loginVo);
            // 判断登陆不成功
            if(!loginResponse.isSuccess()){
                return loginResponse;
            }
        } catch (Exception e) {
            logger.error("前台用户登陆异常"+e);
            e.printStackTrace();
        }
        return loginResponse;
    }

    @Override
    public ServerResponse<CheckCodeVo> getCheckCode() {
        logger.info("前台用户获取验证码");
        ServerResponse<CheckCodeVo> checkCodeVo = null;
        try {
            //todo 发送验证码请求
            checkCodeVo = UserRequest.getCookieAndParam();
            //todo 上传验证码到服务器
            //todo 返回checkCodeUrl，cookie，checkCode
        } catch (HttpProcessException e) {
            logger.error("前台用户获取验证码异常");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("前台用户获取验证码异常");
            e.printStackTrace();
        }
        return checkCodeVo;
    }

    @Override
    public ServerResponse<List<ScoreInfo>> getScore(UserInfo user) {
        ScoreVo scoreVo = new ScoreVo();
        scoreVo.setCookie(user.getCookie());
        scoreVo.setLoginName(user.getLoginName());
        logger.info("前台用户获取成绩单"+scoreVo);
        List<ScoreInfo> result = null;
        try {
            //发送请求获取成绩单
            ServerResponse<List<ScoreInfo>> scoreList = UserRequest.getScoreList(scoreVo,user);
            if(!scoreList.isSuccess()){
                //查询失败直接return
                return scoreList;
            }
            return scoreList;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("前台用户获取成绩单异常"+e);
        }
        return ServerResponse.createByError("前台用户获取成绩单异常");
    }

    @Override
    public ServerResponse<UserInfo> backLogin(String username, String password) {
        logger.info("后台用户登陆参数："+username,password);
        try {
            UserInfo userInfo = userInfoMapper.checkUsername(username);
            if(userInfo==null){
                return ServerResponse.createByError("用户名不存在");
            }
            //TODO 密码登陆MD5
            String MD5Password = Md5Util.MD5EncodeUtf8(password);
            UserInfo user = userInfoMapper.selectLogin(username,MD5Password);
            if(user==null){
                return ServerResponse.createByError("密码错误");
            }
            user.setPassword(StringUtils.EMPTY);
            return ServerResponse.createBySuccess("登陆成功",user);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("后台用户登陆异常"+e);
        }
        return ServerResponse.createByError("后台用户登陆异常");
    }

    @Override
    public ServerResponse<UserInfo> checkAdminRole(UserInfo user) {
        if(user!=null && String.valueOf(Const.Role.ROLE_ADMIN).equals(user.getRole())){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse<PageInfo> getUserList(UserBackRequest userBackRequest) {
        logger.info("后台获取用户列表参数："+userBackRequest);
        try {
            PageHelper.startPage(userBackRequest.getPageNum(),userBackRequest.getPageSize());
            List<UserInfo> userInfoList = userInfoMapper.selectAllUserInfo(userBackRequest);
            List<UserBackResponse> userInfoListVo = Lists.newArrayList();
            buildUserBackResponse(userInfoList,userInfoListVo);
            PageInfo pageInfo = new PageInfo(userInfoList);
            pageInfo.setList(userInfoListVo);
            return ServerResponse.createBySuccess(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("后台获取用户列表异常"+e);
        }
        return ServerResponse.createByError("后台获取用户列表异常");
    }

    /**
     * 后台返回用户成绩单
     * 【已经移除】
     * @param userBackRequest
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getUserScoreList(UserBackRequest userBackRequest) {
        logger.info("后台获取用户成绩列表参数："+userBackRequest);
        try {
            PageHelper.startPage(userBackRequest.getPageNum(),userBackRequest.getPageSize());
            List<ScoreInfo> userScoreInfoList = scoreInfoMapper.selectAllUserScoreInfo(userBackRequest);
            List<ScoreInfoResponse> scoreInfoResponseListVo  = Lists.newArrayList();
            buildUserScoreInfoBackResponse(userScoreInfoList,scoreInfoResponseListVo);
            PageInfo pageInfo = new PageInfo(userScoreInfoList);
            pageInfo.setList(scoreInfoResponseListVo);
            return ServerResponse.createBySuccess(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("后台获取用户成绩列表异常"+e);
        }
        return ServerResponse.createByError("后台获取用户成绩列表异常");
    }

    @Override
    public ServerResponse getTestSchedule(UserInfo user) {
        logger.info("前台获取用户考试安排参数："+user);
        try {
            TestScheduleRequest request = new TestScheduleRequest();
            request.setCookie(user.getCookie());
            request.setLoginName(user.getLoginName());
            request.setStudentId(user.getStudentId());
            ServerResponse<List<TestSchedule>> result = UserRequest.getTestSchedule(request,user);
            return ServerResponse.createBySuccess("获取考试安排成功",result);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("前台获取用户考试安排异常"+e);
        }
        return ServerResponse.createByError("获取考试安排异常");
    }

    @Override
    public ServerResponse updateScore(UserInfo user) {
        logger.info("前台更新用户成绩参数："+user);
        try {
            ScoreVo scoreVo = new ScoreVo();
            scoreVo.setCookie(user.getCookie());
            scoreVo.setLoginName(user.getLoginName());
            //发送请求获取成绩单
            ServerResponse<List<ScoreInfo>> scoreList = UserRequest.getScoreList(scoreVo,user);
            if(!scoreList.isSuccess()){
                //查询失败直接return
                return scoreList;
            }
            return scoreList;

        }catch (Exception e){
            e.printStackTrace();
            logger.error("前台更新用户成绩异常"+e);
        }
        return ServerResponse.createByError("更新成绩出错，重试或反馈。");
    }

    @Override
    public ServerResponse<WechatInfoVo> getWechatInfo(WechatInfoVo wechatInfoVo) {
        logger.info("获取openid："+wechatInfoVo);
        try {
            if(wechatInfoVo.getOpenId()==""||wechatInfoVo.getOpenId()==null){
                //获取用户openid
                ServerResponse<WechatInfoVo> response = UserRequest.getWechatInfo(wechatInfoVo);
                /*//存储用户openid
                List<String> openid = Lists.newArrayList();
                openid.add(response.getData().getOpenId());
                List<UserInfo> user = userInfoMapper.findWecatInfoListByOpenidList(openid);
                if(user.size()==0){
                    UserInfo userInfo = new UserInfo();
                    userInfo.setStudentId(UUIDUtil.getUUID());
                    userInfo.setOpenid(response.getData().getOpenId());
                    userInfo.setRole(String.valueOf(Const.Role.ROLE_CUSTOMER));
                    userInfo.setStatus(Const.Status.YES.toString());
                    int insert = userInfoMapper.insert(userInfo);
                    if(insert<0){
                        log.error("首页插入用户openid出错");
                        return ServerResponse.createByError();
                    }
                }*/
                return response;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("获取用户微信信息或保存用户微信信息出错");
        }
        return null;
    }

    @Override
    public List<UserInfo> findWecatInfoListByLoginNameList(List<String> openIdList) {
        List<UserInfo> wecatInfoList = userInfoMapper.findWecatInfoListByOpenidList(openIdList);
        return wecatInfoList;
    }

    @Override
    public ServerResponse saveWechatInfo(WechatInfoVo wechatInfoVo) {
        log.info("前台获取用户微信相关信息："+wechatInfoVo);
        if(wechatInfoVo.getOpenId()!=""&&wechatInfoVo.getOpenId()!=null&&wechatInfoVo.getOpenId()!="undefined"){
            UserInfo user = userInfoMapper.findUserByOpenid(wechatInfoVo.getOpenId());
            if(user==null){

                user.setRole(Integer.toString(Const.Role.ROLE_CUSTOMER));
                user.setStatus(Const.Status.YES.toString());
                user.setStudentId(UUIDUtil.getUUID());
                int insert = userInfoMapper.insert(user);
                if(insert<=0){
                    log.error("新增用户失败");
                    return ServerResponse.createByError();
                }
                return ServerResponse.createBySuccess();
            }else{
                BeanUtils.copyProperties(wechatInfoVo,user);
                user.setOpenid(wechatInfoVo.getOpenId());
                int update = userInfoMapper.updateByPrimaryKeySelective(user);
                if(update<=0){
                    log.error("修改用户失败");
                    return ServerResponse.createByError();
                }
                return ServerResponse.createBySuccess();
            }
        }
        return ServerResponse.createByError("微信信息失败了");
    }

    /**
     * 构建返回成绩返回值
     * @param userScoreInfoList
     * @param scoreInfoResponseListVo
     */
    private void buildUserScoreInfoBackResponse
    (List<ScoreInfo> userScoreInfoList, List<ScoreInfoResponse> scoreInfoResponseListVo) {
        for(ScoreInfo scoreInfo:userScoreInfoList){
            ScoreInfoResponse vo = new ScoreInfoResponse();
            vo.setCourseId(scoreInfo.getCourseId());
            vo.setCourseName(scoreInfo.getCourseName());
            vo.setCourseProperty(scoreInfo.getCourseProperty());
            vo.setCourseType(scoreInfo.getCourseType());
            vo.setCreateTime(DateUtil.dateToStr(scoreInfo.getCreateTime()));
            vo.setCredit(scoreInfo.getCredit());
            vo.setHours(scoreInfo.getHours());
            vo.setLearningTime(scoreInfo.getLearningTime());
            vo.setModifiedTime(DateUtil.dateToStr(scoreInfo.getModifiedTime()));
            vo.setPkId(scoreInfo.getPkId());
            vo.setRepairTime(scoreInfo.getRepairTime());
            vo.setScore(scoreInfo.getScore());
            vo.setScoreId(scoreInfo.getScoreId());
            vo.setStatus(scoreInfo.getStatus());
            vo.setStatusDesc(Integer.valueOf(Const.ScoreStatus.YES).toString().
                    equals(scoreInfo.getStatus())?Const.ScoreStatus.PASS_YES_DESC:Const.ScoreStatus.PASS_NO_DESC);
            vo.setTestProperty(scoreInfo.getTestProperty());
            vo.setTestType(scoreInfo.getTestType());
            vo.setCountCourse(scoreInfo.getCountCourse());
            vo.setCountCredit(scoreInfo.getCountCredit());
            vo.setCountHours(scoreInfo.getCountHours());
            vo.setLoginName(scoreInfo.getLoginName());
            vo.setStudentId(scoreInfo.getStudentId());
            vo.setStudentName(scoreInfo.getStudentName());
            scoreInfoResponseListVo.add(vo);
        }
    }

    /**
     * 构建用户列表返回值
     * @param userInfoList
     * @param userInfoListVo
     */
    private void buildUserBackResponse(List<UserInfo> userInfoList, List<UserBackResponse> userInfoListVo) {
        for(UserInfo userInfo:userInfoList){
            UserBackResponse vo = new UserBackResponse();
            vo.setClassId(userInfo.getClassId());
            vo.setClassName(userInfo.getClassName());
            vo.setCollegeId(userInfo.getCollegeId());
            vo.setCollegeName(userInfo.getCollegeName());
            vo.setCreateTime(DateUtil.dateToStr(userInfo.getCreateTime()));
            vo.setEmail(userInfo.getEmail());
            vo.setGender(userInfo.getGender());
            vo.setLoginName(userInfo.getLoginName());
            vo.setMajorsId(userInfo.getMajorsId());
            vo.setMajorsName(userInfo.getMajorsName());
            vo.setMobile(userInfo.getMobile());
            vo.setModifiedTime(DateUtil.dateToStr(userInfo.getModifiedTime()));
            vo.setOrgCode(userInfo.getOrgCode());
            if(userInfo.getOrgCode()!=null){
                vo.setOrgCodeDesc(OrgType.getValueByCode(Integer.valueOf(userInfo.getOrgCode())).getName());
            }
            vo.setPkId(userInfo.getPkId());
            vo.setRole(userInfo.getRole());
            vo.setRoleDesc(Integer.valueOf(Const.Role.ROLE_ADMIN).toString().
                    equals(userInfo.getRole())?Const.Role.ROLE_ADMIN_DESC:Const.Role.ROLE_CUSTOMER_DESC);
            vo.setStatus(userInfo.getStatus());
            vo.setStatusDesc(userInfo.getStatus().toString().
                    equals(Const.Status.YES.toString())?Const.Status.YES_DESC:Const.Status.NO_DESC);
            vo.setStudentId(userInfo.getStudentId());
            vo.setStudentName(userInfo.getStudentName());
            vo.setUniversityName(userInfo.getUniversityName());
            userInfoListVo.add(vo);
        }
    }
}