package com.jgsu.service.impl;

import com.jgsu.common.ServerResponse;
import com.jgsu.pojo.Cet;
import com.jgsu.requestrelated.CetRequest;
import com.jgsu.service.ICetService;
import com.jgsu.utils.httpclientutil.exception.HttpProcessException;
import com.jgsu.vo.CetVo;
import com.jgsu.vo.CheckCodeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 描述:
 * cetServiceImpl
 *
 * @author lqd12
 * @create 2018-03-04 17:40
 */
@Service("iCetService")
public class CetServiceImpl implements ICetService{
    private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Override
    public ServerResponse<Cet> getCetScore(CetVo cetVo) {
        logger.info("查询四六级参数："+cetVo);
        ServerResponse<Cet> cetScore = null;
        try {
            cetScore = CetRequest.getCetScore(cetVo);
        } catch (HttpProcessException e) {
            logger.error("查询四六级异常："+e);
            e.printStackTrace();
        }
        logger.info("查询四六级返回值："+cetScore);
        return cetScore;
    }

    @Override
    public ServerResponse<CheckCodeVo> getCetCheckCode() {
        logger.info("获取四六级验证码");
        try {
            return CetRequest.getCetCheckCode();
        } catch (HttpProcessException e) {
            logger.error("获取四六级验证码："+e);
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("获取四六级验证码："+e);
            e.printStackTrace();
        }
        logger.info("获取四六级验证码结束");
        return ServerResponse.createByError("获取cet验证码失败");
    }
}