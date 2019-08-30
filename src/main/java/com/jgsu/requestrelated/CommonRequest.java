package com.jgsu.requestrelated;

import com.aliyun.oss.OSS;
import com.jgsu.common.ServerResponse;
import com.jgsu.common.UrlEnum;
import com.jgsu.utils.OSSUtils;
import com.jgsu.utils.PropertiesUtil;
import com.jgsu.utils.QiNiuYunUtil;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.utils.httpclientutil.HttpClientUtil;
import com.jgsu.utils.httpclientutil.common.HttpConfig;
import com.jgsu.utils.httpclientutil.exception.HttpProcessException;
import com.jgsu.vo.CheckCodeVo;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;

import java.io.IOException;
import java.io.InputStream;

/**
 * 描述:
 * 公共的requst类
 *
 * @author grt
 * @create 2018-03-01 23:09
 */
public class CommonRequest {

    /**
     * 获取cookie和保存本地图片
     * @return
     * @throws HttpProcessException
     */
    public static ServerResponse<CheckCodeVo> getCookieAndParam(HttpConfig config,String bucketName,HttpClientContext context
                                                                ,String bucketHostName,CookieStore cookieStore) throws HttpProcessException, IOException {
        CheckCodeVo checkCodeVo = new CheckCodeVo();
        context.setCookieStore(cookieStore);
        InputStream inputStream = HttpClientUtil.getInputStream(config);
        String checkCodeUUid = UUIDUtil.getUUID();
        OSS ossClient = OSSUtils.getOSSClient();
        OSSUtils.uploadByInputStream(ossClient,inputStream,bucketName,checkCodeUUid);
        String checkCodeUrl = OSSUtils.getUrl(ossClient, checkCodeUUid, bucketName);
        ossClient.shutdown();
        //QiNiuYunUtil.uploadFile(inputStream,bucketName,checkCodeUUid);
        //String checkCodeUrl = QiNiuYunUtil.getFileAccessUrl(checkCodeUUid,bucketHostName);
        //   保存验证码  保存图片地址应该设置为  常量
        String[] cookie = new String[10];
        cookieStore = context.getCookieStore();
        for(int i = 0;i<cookieStore.getCookies().size();i++){
            Cookie c = cookieStore.getCookies().get(i);
            cookie[i] = c.getName() + "=" + c.getValue()+";";
        }
        if(cookie==null || cookie.length<=0){
            return ServerResponse.createByError("获取cookie失败");
        }
        checkCodeVo.setCookie(cookie[0]);
        checkCodeVo.setCheckCodeUrl(checkCodeUrl);
        return ServerResponse.createBySuccess("获取cookie成功",checkCodeVo);
    }
}