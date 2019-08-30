package com.jgsu.requestrelated;

import com.jgsu.common.*;
import com.jgsu.pojo.Cet;
import com.jgsu.utils.PropertiesUtil;
import com.jgsu.utils.httpclientutil.HttpClientUtil;
import com.jgsu.utils.httpclientutil.common.HttpConfig;
import com.jgsu.utils.httpclientutil.exception.HttpProcessException;
import com.jgsu.vo.CetVo;
import com.jgsu.vo.CheckCodeVo;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.message.BasicHeader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *  四六级查询
 * @author grt
 * @create 2018-03-01 22:56
 */
public class CetRequest {

    /**
     * 发送请求查询四六级
     * @param cetVo
     * @return
     * @throws HttpProcessException
     */
    public static ServerResponse<Cet> getCetScore(CetVo cetVo) throws HttpProcessException {
        Header[] header = {new BasicHeader(RequestHeaders.CET_Header_UserAgent.getKey(),
                RequestHeaders.CET_Header_UserAgent.getValue()),new BasicHeader("Cookie",cetVo.getCookie())};
        Map map = new HashMap();
        map.put(RequestParam.CET_ZKZH.getValue(),cetVo.getCetNumber());
        map.put(RequestParam.CET_XM.getValue(),cetVo.getStudentName());
        map.put(RequestParam.CET_CHECKCODE.getValue(),cetVo.getCheckCode());
        HttpConfig httpConfig = HttpConfig.custom().url(UrlEnum.CET_URL.getUrl()).map(map).headers(header).encoding(Const.Charset.CHRRSET.getValue());
        String body = HttpClientUtil.post(httpConfig);
        int status = HttpClientUtil.status(httpConfig);
        if(status!= HttpStatus.SC_OK){
            return ServerResponse.createByError("查询失败，请联系管理员查看原因");
        }
        //查询成功，解析网页获取分数
        Cet cetInfo = getCetInfo(body);
        return ServerResponse.createBySuccess(cetInfo);
    }

    /**
     * 解析网页获取返回信息
     * @param body
     * @return
     */
    public static Cet getCetInfo(String body){
        Document doc = Jsoup.parse(body);
        Elements trs = doc.select(".cetTable").select("tr");
        Cet cet = new Cet();
        cet.setStudentName(trs.get(0).select("td").text());
        cet.setUniversity(trs.get(1).select("td").text());
        cet.setCetType(trs.get(2).select("td").text());
        cet.setCetNumber(trs.get(4).select("td").text());
        cet.setCet4Score(trs.get(5).select("td").select("span").text());
        cet.setCet4ListenScore(trs.get(6).select("td").get(1).text());
        cet.setCet4ReadScore(trs.get(7).select("td").get(1).text());
        cet.setCet4WriteScore(trs.get(8).select("td").get(1).text());
        return cet;
    }


    /**
     * 获取cookie和保存本地图片
     * @return
     * @throws HttpProcessException
     */
    public static ServerResponse<CheckCodeVo> getCetCheckCode() throws HttpProcessException, IOException {
        HttpClientContext context = new HttpClientContext();
        CookieStore cookieStore = new BasicCookieStore();
        HttpConfig config =HttpConfig.custom().url(UrlEnum.CET_CHECKCODE_URL.getUrl()).context(context);
        return CommonRequest.getCookieAndParam(config, PropertiesUtil.getProperty("QINIUYUN_BUCKET_NAME_CET"),context,
                PropertiesUtil.getProperty("QINIUYUN_BUCKET_HOST_NAME_CET"),cookieStore);
    }
}