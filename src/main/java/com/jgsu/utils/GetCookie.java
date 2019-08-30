package com.jgsu.utils;

import com.jgsu.common.UrlEnum;
import com.jgsu.utils.httpclientutil.HttpClientUtil;
import com.jgsu.utils.httpclientutil.common.HttpConfig;
import com.jgsu.utils.httpclientutil.exception.HttpProcessException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.cookie.Cookie;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述:
 * 获取登陆cookie
 *
 * @author grt
 * @create 2018-02-06 22:16
 */
public  class GetCookie {

    public static void main(String[] args) throws HttpProcessException {
        getCookie();
    }

    public static void getCookie() throws HttpProcessException {
        HttpClientContext context = new HttpClientContext();
        CookieStore cookieStore = new BasicCookieStore();
        context.setCookieStore(cookieStore);

        HttpConfig config =HttpConfig.custom().url(UrlEnum.CHECKCODE_URL.getUrl()).context(context);
        //获取参数
        String loginform = HttpClientUtil.send(config);//可以用.send(config)代替，但是推荐使用明确的get方法
        System.out.println(loginform);
        /*System.out.println("获取登录所需参数");
        String lt = regex("\"lt\" value=\"([^\"]*)\"", loginform)[0];
        String execution = regex("\"execution\" value=\"([^\"]*)\"", loginform)[0];
        String _eventId = regex("\"_eventId\" value=\"([^\"]*)\"", loginform)[0];*/

        cookieStore = context.getCookieStore();
        for (Cookie cookie : cookieStore.getCookies()) {
			System.out.println(cookie.getName()+"="+cookie.getValue());
		}
    }

    /**
     * 通过正则表达式获取内容
     *
     * @param regex		正则表达式
     * @param from		原字符串
     * @return
     */
    public static String[] regex(String regex, String from){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(from);
        List<String> results = new ArrayList<String>();
        while(matcher.find()){
            for (int i = 0; i < matcher.groupCount(); i++) {
                results.add(matcher.group(i+1));
            }
        }
        return results.toArray(new String[]{});
    }
}