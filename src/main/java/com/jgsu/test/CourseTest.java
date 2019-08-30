package com.jgsu.test;

import com.jgsu.common.RequestHeaders;
import com.jgsu.common.RequestParam;
import com.jgsu.common.ServerResponse;
import com.jgsu.common.UrlEnum;
import com.jgsu.pojo.CourseInfo;
import com.jgsu.utils.httpclientutil.HttpClientUtil;
import com.jgsu.utils.httpclientutil.common.HttpConfig;
import com.jgsu.utils.httpclientutil.exception.HttpProcessException;
import com.jgsu.vo.CourseRequest;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author grt
 * @create 2018-07-21 20:55
 */
public class CourseTest {
    public static ServerResponse getCourseList() throws Exception{
        List<List<CourseInfo>> courseData = null;
        List<List<CourseInfo>> responseCourseData = null;
        String body = "";
        String courseListUrl = "";
        try {
            Header[] header = {
                    new BasicHeader(RequestHeaders.Header_Accept.getKey(), RequestHeaders.Header_Accept.getValue()),
                    new BasicHeader(RequestHeaders.Header_AcceptEncoding.getKey(), RequestHeaders.Header_AcceptEncoding.getValue()),
                    new BasicHeader(RequestHeaders.Header_AcceptLanguage.getKey(), RequestHeaders.Header_AcceptLanguage.getValue()),
                    new BasicHeader(RequestHeaders.Header_Connection.getKey(), RequestHeaders.Header_Connection.getValue()),
                    new BasicHeader(RequestHeaders.Header_CacheControl.getKey(), RequestHeaders.Header_CacheControl.getValue()),
                    new BasicHeader(RequestHeaders.Header_ContentType.getKey(), RequestHeaders.Header_ContentType.getValue()),
                    new BasicHeader(RequestHeaders.Header_UserAgent.getKey(), RequestHeaders.Header_UserAgent.getValue()),
                    new BasicHeader(RequestHeaders.Header_Host.getKey(), RequestHeaders.Header_Host.getValue()),
                    new BasicHeader("Cookie","ASP.NET_SessionId=olrvla45w3b1th55cs3rh2rk; .ASPXAUTH=89B6AD4DF04F6DC774656F98BFD9EB1FD9CD7B735DDB1B81DAF7AE5115250A0EC72E1C55CB1E4909E4FE703B2DC35E9FF200A8F3458A993797FCF3021D9BEE797383D978BE2C1E10AFF5EAEE82F5DB7401D0476A7F5604905914999F4592FC3F77966C3CC9B558F123E71555F194367F8F0CAA5A"),};
            Map map = new HashMap();
            map.put(RequestParam.COURSE_EVENTARGUMENT.getValue(),RequestParam.COURSE_EVENTARGUMENT.getDesc());
           map.put(RequestParam.COURSE_EVENTTARGET.getValue(),RequestParam.COURSE_EVENTTARGET.getDesc());
            map.put(RequestParam.COURSE_LASTFOCUS.getValue(),RequestParam.COURSE_LASTFOCUS.getDesc());
           map.put(RequestParam.COURSE_VIEWSTATE.getValue(),"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J2NlbnRlcicgPjxub2JyPiAmbmJzcDsmbmJzcDs8L25vYnI+PC90ZD48dGQgd2lkdGg9OTAgaGVpZ2h0PTI4IGFsaWduPSdjZW50ZXInID48bm9icj4gJm5ic3A7Jm5ic3A7PC9ub2JyPjwvdGQ+PHRkIHdpZHRoPTkwIGhlaWdodD0yOCBhbGlnbj0nY2VudGVyJyA+PG5vYnI+ICZuYnNwOyZuYnNwOzwvbm9icj48L3RkPjx0ZCB3aWR0aD05MCBoZWlnaHQ9MjggYWxpZ249J2NlbnRlcicgPjxub2JyPiAmbmJzcDsmbmJzcDs8L25vYnI+PC90ZD48dGQgd2lkdGg9OTAgaGVpZ2h0PTI4IGFsaWduPSdjZW50ZXInID48bm9icj4gJm5ic3A7Jm5ic3A7PC9ub2JyPjwvdGQ+PC90cj48dHI+PHRkIHdpZHRoPTkwIGhlaWdodD0yOCBhbGlnbj1sZWZ0PuesrOS4ieWbm+iKgiZuYnNwOzwvdGQ+PHRkIHdpZHRoPTkwIGhlaWdodD0yOCBhbGlnbj0nY2VudGVyJyA+PG5vYnI+ICZuYnNwOyZuYnNwOzwvbm9icj48L3RkPjx0ZCB3aWR0aD05MCBoZWlnaHQ9MjggYWxpZ249J2NlbnRlcicgPjxub2JyPiAmbmJzcDsmbmJzcDs8L25vYnI+PC90ZD48dGQgd2lkdGg9OTAgaGVpZ2h0PTI4IGFsaWduPSdjZW50ZXInID48bm9icj4gJm5ic3A7Jm5ic3A7PC9ub2JyPjwvdGQ+PHRkIHdpZHRoPTkwIGhlaWdodD0yOCBhbGlnbj0nY2VudGVyJyA+PG5vYnI+ICZuYnNwOyZuYnNwOzwvbm9icj48L3RkPjx0ZCB3aWR0aD05MCBoZWlnaHQ9MjggYWxpZ249J2NlbnRlcicgPjxub2JyPiAmbmJzcDsmbmJzcDs8L25vYnI+PC90ZD48dGQgd2lkdGg9OTAgaGVpZ2h0PTI4IGFsaWduPSdjZW50ZXInID48bm9icj4gJm5ic3A7Jm5ic3A7PC9ub2JyPjwvdGQ+PHRkIHdpZHRoPTkwIGhlaWdodD0yOCBhbGlnbj0nY2VudGVyJyA+PG5vYnI+ICZuYnNwOyZuYnNwOzwvbm9icj48L3RkPjwvdHI+PHRyPjx0ZCB3aWR0aD05MCBoZWlnaHQ9MjggYWxpZ249bGVmdD7nrKzkupTlha3kuIPoioImbmJzcDs8L3RkPjx0ZCB3aWR0aD05MCBoZWlnaHQ9MjggYWxpZ249J2NlbnRlcicgPjxub2JyPiAmbmJzcDsmbmJzcDs8L25vYnI+PC90ZD48dGQgd2lkdGg9OTAgaGVpZ2h0PTI4IGFsaWduPSdjZW50ZXInID48bm9icj4gJm5ic3A7Jm5ic3A7PC9ub2JyPjwvdGQ+PHRkIHdpZHRoPTkwIGhlaWdodD0yOCBhbGlnbj0nY2VudGVyJyA+PG5vYnI+ICZuYnNwOyZuYnNwOzwvbm9icj48L3RkPjx0ZCB3aWR0aD05MCBoZWlnaHQ9MjggYWxpZ249J2NlbnRlcicgPjxub2JyPiAmbmJzcDsmbmJzcDs8L25vYnI+PC90ZD48dGQgd2lkdGg9OTAgaGVpZ2h0PTI4IGFsaWduPSdjZW50ZXInID48bm9icj4gJm5ic3A7Jm5ic3A7PC9ub2JyPjwvdGQ+PHRkIHdpZHRoPTkwIGhlaWdodD0yOCBhbGlnbj0nY2VudGVyJyA+PG5vYnI+ICZuYnNwOyZuYnNwOzwvbm9icj48L3RkPjx0ZCB3aWR0aD05MCBoZWlnaHQ9MjggYWxpZ249J2NlbnRlcicgPjxub2JyPiAmbmJzcDsmbmJzcDs8L25vYnI+PC90ZD48L3RyPjx0cj48dGQgd2lkdGg9OTAgaGVpZ2h0PTI4IGFsaWduPWxlZnQ+56ys5YWr5Lmd6IqCJm5ic3A7PC90ZD48dGQgd2lkdGg9OTAgaGVpZ2h0PTI4IGFsaWduPSdjZW50ZXInID48bm9icj4gJm5ic3A7Jm5ic3A7PC9ub2JyPjwvdGQ+PHRkIHdpZHRoPTkwIGhlaWdodD0yOCBhbGlnbj0nY2VudGVyJyA+PG5vYnI+ICZuYnNwOyZuYnNwOzwvbm9icj48L3RkPjx0ZCB3aWR0aD05MCBoZWlnaHQ9MjggYWxpZ249J2NlbnRlcicgPjxub2JyPiAmbmJzcDsmbmJzcDs8L25vYnI+PC90ZD48dGQgd2lkdGg9OTAgaGVpZ2h0PTI4IGFsaWduPSdjZW50ZXInID48bm9icj4gJm5ic3A7Jm5ic3A7PC9ub2JyPjwvdGQ+PHRkIHdpZHRoPTkwIGhlaWdodD0yOCBhbGlnbj0nY2VudGVyJyA+PG5vYnI+ICZuYnNwOyZuYnNwOzwvbm9icj48L3RkPjx0ZCB3aWR0aD05MCBoZWlnaHQ9MjggYWxpZ249J2NlbnRlcicgPjxub2JyPiAmbmJzcDsmbmJzcDs8L25vYnI+PC90ZD48dGQgd2lkdGg9OTAgaGVpZ2h0PTI4IGFsaWduPSdjZW50ZXInID48bm9icj4gJm5ic3A7Jm5ic3A7PC9ub2JyPjwvdGQ+PC90cj48dHI+PHRkICBoZWlnaHQ9MjggYWxpZ249bGVmdD7lpIcgJm5ic3A75rOoPC90ZD48dGQgaGVpZ2h0PTI4IGNvbHNwYW49Nz4mbmJzcDs8L3RkPjwvdHI+PC90YWJsZT5kGAEFHl9fQ29udHJvbHNSZXF1aXJlUG9zdEJhY2tLZXlfXxYBBQJteAa5bJQoSFBWNx/ZghydLBPsSiz3");
            map.put(RequestParam.COURSE_VIEWSTATEGENERATOR.getValue(),RequestParam.COURSE_VIEWSTATEGENERATOR.getDesc());
            //当前学年
            map.put(RequestParam.COURSE_ddlxnxqh.getValue(),"2017-2018-2");
            //放大
            map.put(RequestParam.COURSE_mx.getValue(),"on");
            //当前周
            map.put(RequestParam.COURSE_zc.getValue(),"2");
            map.put("usermain","x2015000017");
            HttpClientContext context = new HttpClientContext();
            HttpConfig httpConfig = HttpConfig.custom().url(courseListUrl).headers(header).map(map).context(context);
            body = HttpClientUtil.post(httpConfig);
            int status = HttpClientUtil.status(httpConfig);
            if (status!= HttpStatus.SC_OK){
                return ServerResponse.createByError("获取课表body异常");
            }
        }catch (HttpProcessException e) {
            e.printStackTrace();
        }
        //todo 解析课程表
        return ServerResponse.createBySuccess("获取课表成功",responseCourseData);
    }

    public static void main(String[] args) throws Exception {
        ServerResponse courseList = CourseTest.getCourseList();
    }
}