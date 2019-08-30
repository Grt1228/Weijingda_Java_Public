package com.jgsu.test;

import com.jgsu.common.RequestHeaders;
import com.jgsu.common.UrlEnum;
import com.jgsu.requestrelated.CetRequest;
import com.jgsu.utils.httpclientutil.HttpClientUtil;
import com.jgsu.utils.httpclientutil.common.HttpConfig;
import com.jgsu.utils.httpclientutil.exception.HttpProcessException;
import com.jgsu.vo.CetVo;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.message.BasicHeader;

/**
 * 描述:
 * cet
 *
 * @author grt
 * @create 2018-03-02 0:32
 */
public class TestCet {

    public static void main(String[] args) throws HttpProcessException {
        /*CetVo cetVo = new CetVo();
        cetVo.setCetNumber("");
        cetVo.setStudentName("");
        CetRequest.getCetScore(cetVo);*/
        HttpClientContext context = new HttpClientContext();
        CookieStore cookieStore = new BasicCookieStore();
        Header[] header = {new BasicHeader(RequestHeaders.BOOK_Login_Header_Host.getKey(),
                RequestHeaders.BOOK_Login_Header_Host.getValue()),new BasicHeader("Cookie","DSSTASH_LOG=C%5f4%2dUN%5f1213%2dUS%5f%2d1%2dT%5f1527319428561; mgid=274; maid=1213; msign_dsr=1527319428573; mduxiu=musername%2c%3dblmobile%2c%21muserid%2c%3d1000086%2c%21mcompcode%2c%3d1279%2c%21menc%2c%3d0E3D21DB87F4A3EBB00B8A8590BB82E7; xc=6; mmr_enc=643F91DCB0C526C03454F334CFEC2457; mmr_userid=21534778; mmr_uid=73E1F19EC948C6DD034FF2E7EFA8D8EDACF76FED45672B4F90942F4D0C5AC65594197B292C023B86; 3gemail=\"\"; DSSTASH_LOG=C%5f4%2dUN%5f1213%2dUS%5f21534778%2dT%5f1527319428573; JSESSIONID=B3CCCFA7117E38C32ECA98D63EC22917.irdmbl72b; route=adca4ab36618701710473a6c4da78b7c")
                };
        HttpConfig httpConfig = HttpConfig.custom().url(UrlEnum.BOOK_LEND_URL2.getUrl()).headers(header).context(context);
        context.setCookieStore(cookieStore);
        String body = HttpClientUtil.get(httpConfig);
        int status= HttpClientUtil.status(httpConfig);
        cookieStore = context.getCookieStore();
        String cookie_url1 = "";
        for(int i = 0;i<cookieStore.getCookies().size();i++){
            Cookie c = cookieStore.getCookies().get(i);
            cookie_url1 = c.getName() + "=" + c.getValue()+";";
        }
    }
}