package com.jgsu.requestrelated;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jgsu.common.*;
import com.jgsu.pojo.Book;
import com.jgsu.utils.httpclientutil.HttpClientUtil;
import com.jgsu.utils.httpclientutil.common.HttpConfig;
import com.jgsu.utils.httpclientutil.exception.HttpProcessException;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.message.BasicHeader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 图书馆爬虫相关
 *
 * @author grt
 * @create 2018-05-25 1:10
 */
@Component
public class BookRequest {
    /**
     * 图书馆绑定
     * @param request
     * @return
     * @throws HttpProcessException
     */
    public ServerResponse bookLogin(com.jgsu.vo.BookRequest request)throws HttpProcessException {
        //1606105010
        Header[] header = {new BasicHeader(RequestHeaders.BOOK_Login_Header_Host.getKey(),
                RequestHeaders.BOOK_Login_Header_Host.getValue())};
        Map map = new HashMap();
        map.put(RequestParam.BOOK_WX_PRODUCT_ID.getDesc(),RequestParam.BOOK_WX_PRODUCT_ID.getValue());
        map.put(RequestParam.BOOK_CODE.getDesc(),RequestParam.BOOK_CODE.getValue());
        map.put(RequestParam.BOOK_OPEN_ID.getDesc(),request.getOpenId());
        map.put(RequestParam.BOOK_BACK_URL.getDesc(),RequestParam.BOOK_BACK_URL.getValue());
        map.put(RequestParam.BOOK_SCHOOL_INFO_ID.getDesc(),RequestParam.BOOK_SCHOOL_INFO_ID.getValue());
        map.put(RequestParam.BOOK_SCHOOL_ID.getDesc(),RequestParam.BOOK_SCHOOL_ID.getValue());
        map.put(RequestParam.BOOK_AREA_ID.getDesc(),RequestParam.BOOK_AREA_ID.getValue());
        map.put(RequestParam.BOOK_USER_TYPE.getDesc(),RequestParam.BOOK_USER_TYPE.getValue());
        map.put(RequestParam.BOOK_USER_NAME.getDesc(),request.getBookUserName());
        map.put(RequestParam.BOOK_PASS_WORD.getDesc(),request.getBookPassword());
        HttpClientContext httpClientContext = new HttpClientContext();
        CookieStore cookieStore = new BasicCookieStore();
        HttpConfig httpConfig = HttpConfig.custom().url(UrlEnum.BOOK_LOGIN_URL.getUrl()).headers(header).map(map).context(httpClientContext);
        httpClientContext.setCookieStore(cookieStore);
        String body = HttpClientUtil.post(httpConfig);
        int status = HttpClientUtil.status(httpConfig);
        String[] cookie = new String[11];
        cookieStore = httpClientContext.getCookieStore();
        for(int i = 0;i<cookieStore.getCookies().size();i++){
            Cookie c = cookieStore.getCookies().get(i);
            cookie[i] = c.getName() + "=" + c.getValue()+";";
        }
        String requestCookie = "";
        for(int i = 0;i<cookie.length;i++){
            requestCookie+=cookie[i];
        }
        request.setCookie(requestCookie);
        if(status!= HttpStatus.SC_OK){
            return ServerResponse.createByError("系统错误，联系管理员查看原因");
        }
        if(body.contains("用户名或密码错误")){
            return ServerResponse.createByError("用户名或密码错误");
        }
        //绑定成功,连带查询本人的图书借阅信息
        ServerResponse lendInfo = getLendInfo(request);

        return lendInfo;
    }



    public ServerResponse bookDetail(com.jgsu.vo.BookRequest request) throws HttpProcessException, UnsupportedEncodingException {
        Header[] header = {new BasicHeader(RequestHeaders.BOOK_Lend_Header_Host.getKey(),
                RequestHeaders.BOOK_Lend_Header_Host.getValue())};
        Map<String ,Object> map = new HashMap<>();
        map.put("xc",request.getXc());
        //byte[] bytes = request.getDetailParam().getBytes();
        //String param = new String(bytes,"GBK");
        map.put("detailParam",request.getDetailParam());
        //map.put("detailParam",param);
        HttpClientContext httpClientContext = new HttpClientContext();
        CookieStore cookieStore = new BasicCookieStore();
        HttpConfig httpConfig = HttpConfig.custom().url(UrlEnum.BOOK_DETAIL_URL.getUrl()).headers(header).map(map).context(httpClientContext);
        httpClientContext.setCookieStore(cookieStore);
        String body = HttpClientUtil.post(httpConfig);
        int status = HttpClientUtil.status(httpConfig);
        if(status!= HttpStatus.SC_OK){
            return ServerResponse.createByError("系统错误，联系管理员查看原因");
        }
        String title = (String) JSON.parseObject(request.getDetailParam()).get("title");
        String bookId = (String) JSON.parseObject(request.getDetailParam()).get("bookid");
        ServerResponse<List<Book>> bookDetail = jsoupBookDetail(body,title,bookId);
        return bookDetail;
    }


    public ServerResponse getLendInfo(com.jgsu.vo.BookRequest request)throws HttpProcessException {
        /**
         * url1不要带cookie，重定向到url2
         * url2带绑定的cookie，重定向到url3
         * url3带url1的cookie
         */
        /*HttpClientContext context = new HttpClientContext();
        CookieStore cookieStore = new BasicCookieStore();
        Header[] header = {new BasicHeader(RequestHeaders.BOOK_Lend_Header_Host.getKey(),
                RequestHeaders.BOOK_Lend_Header_Host.getValue())};
        HttpConfig httpConfig = HttpConfig.custom().url(UrlEnum.BOOK_LEND_URL3.getUrl()).headers(header).context(context);
        context.setCookieStore(cookieStore);
        String body = HttpClientUtil.post(httpConfig);
        int status= HttpClientUtil.status(httpConfig);
        cookieStore = context.getCookieStore();
        String cookie_url1 = "";
        for(int i = 0;i<cookieStore.getCookies().size();i++){
            Cookie c = cookieStore.getCookies().get(i);
            cookie_url1 = c.getName() + "=" + c.getValue()+";";
        }


        Header[] header_url1 = {new BasicHeader(RequestHeaders.BOOK_Lend_Header_Host.getKey(),
                RequestHeaders.BOOK_Lend_Header_Host.getValue()),new BasicHeader("Cookie",cookie_url1)};
        HttpClientContext httpClientContext_url1 = new HttpClientContext();
        CookieStore cookieStore_url1 = new BasicCookieStore();
        HttpConfig httpConfig_url1 = HttpConfig.custom().url(UrlEnum.BOOK_LEND_URL1.getUrl()).headers(header_url1).context(httpClientContext_url1);
        httpClientContext_url1.setCookieStore(cookieStore_url1);
        String body_url1 = HttpClientUtil.post(httpConfig_url1);
        int status_url1 = HttpClientUtil.status(httpConfig_url1);

        HttpRequest request1 = httpClientContext_url1.getRequest();*/
        /*Header[] cookies = request1.getHeaders("Cookie");
        String cookie_url = cookies[0].getName() + "=" + cookies[0].getValue()+";";;
        List<URI> redirectLocations = httpClientContext_url1.getRedirectLocations();
        RequestConfig requestConfig = httpClientContext_url1.getRequestConfig();*/
        //请求第二个
        //if(status_url1 == HttpStatus.SC_MOVED_TEMPORARILY){
            HttpClientContext httpClientContext_url2 = new HttpClientContext();
            Header[] header_url2 = {new BasicHeader(RequestHeaders.BOOK_Login_Header_Host.getKey(),
                    RequestHeaders.BOOK_Login_Header_Host.getValue()),new BasicHeader("Cookie",request.getCookie())};
            HttpConfig httpConfig_url2 = HttpConfig.custom().url(UrlEnum.BOOK_LEND_URL2.getUrl()).headers(header_url2).context(httpClientContext_url2);
            String body_url2 = HttpClientUtil.get(httpConfig_url2);
            int status_url2 = HttpClientUtil.status(httpConfig_url2);
        if(status_url2 != HttpStatus.SC_OK){
            return ServerResponse.createByError("系统错误，联系管理员查看原因");
        }
        //查询成功，解析网页获取分数
        ServerResponse<List<Book>> response = jsoupInfo(body_url2);

        //if(status_url2 == HttpStatus.SC_MOVED_TEMPORARILY){
            /*if(true){
                HttpClientContext httpClientContext_url3 = new HttpClientContext();
                Header[] header_url3 = {new BasicHeader(RequestHeaders.BOOK_Lend_Header_Host.getKey(),
                        RequestHeaders.BOOK_Lend_Header_Host.getValue()),new BasicHeader("Cookie",cookie_url1)};
                HttpConfig httpConfig_url3 = HttpConfig.custom().url(UrlEnum.BOOK_LEND_URL3.getUrl()).headers(header_url3).context(httpClientContext_url3);
                String body_url3 = HttpClientUtil.get(httpConfig_url3);
                int status_url3 = HttpClientUtil.status(httpConfig_url3);
                if(status_url3 != HttpStatus.SC_OK){
                    return ServerResponse.createByError("系统错误，联系管理员查看原因");
                }
            }*/
            return response;
        //}
        //return null;
    }

    private ServerResponse<List<Book>> jsoupInfo(String body_url2) {
        List<Book> bookList = new ArrayList<>();
        Document doc = Jsoup.parse(body_url2);
        Elements tableLib = doc.select(".tableLib");
        if(tableLib.size()==0){
            return ServerResponse.createBySuccess(doc.select("h1").text(),bookList);
        }
        for(int i = 0;i<tableLib.size();i++){
            Book book = new Book();
            book.setBookName(tableLib.get(i).select("p").text());
            Elements trs = tableLib.get(i).select("table").select("tr");
            book.setLendDate(trs.get(1).select("td").text());
            book.setSendDate(trs.get(2).select("td").text());
            book.setHideLocation(trs.get(3).select("td").text());
            book.setBookCode(trs.get(trs.size()-1).id());
            String[] strings = trs.get(0).select("a").attr("href").split("'");
            book.setRenewCode(strings[1]);
            bookList.add(book);
        }
        return ServerResponse.createBySuccess(doc.select("h1").text(),bookList);
    }

    public ServerResponse bookSearch(com.jgsu.vo.BookRequest bookRequest)throws HttpProcessException {
        Header[] header = {new BasicHeader(RequestHeaders.BOOK_Lend_Header_Host.getKey(),
                RequestHeaders.BOOK_Lend_Header_Host.getValue())};
        StringBuilder sb = new StringBuilder();
        sb.append("?kw=")
                .append(bookRequest.getSearchKey())
                .append("&xc=")
                .append(bookRequest.getXc())
                .append("&searchtype=")
                .append(bookRequest.getSearchType())
                .append("&pageIndex=")
                .append(bookRequest.getPageIndex());
        HttpClientContext httpClientContext = new HttpClientContext();
        CookieStore cookieStore = new BasicCookieStore();
        HttpConfig httpConfig = HttpConfig.custom().url(UrlEnum.BOOK_SEARCH_URL.getUrl()+sb).headers(header).context(httpClientContext);
        httpClientContext.setCookieStore(cookieStore);
        String body = HttpClientUtil.post(httpConfig);
        int status = HttpClientUtil.status(httpConfig);
        if(status!= HttpStatus.SC_OK){
            return ServerResponse.createByError("系统错误，联系管理员查看原因");
        }
        ServerResponse<List<Book>> bookList = jsoupBookList(body);
        return bookList;
    }

    public ServerResponse bookRenew(com.jgsu.vo.BookRequest bookRequest) throws HttpProcessException{
        Header[] header = {new BasicHeader(RequestHeaders.BOOK_Lend_Header_Host.getKey(),
                RequestHeaders.BOOK_Lend_Header_Host.getValue())};
        Map map = new HashMap();
        map.put("sn",bookRequest.getSn());
        map.put("barcode", bookRequest.getBarcode());
        map.put("xc",bookRequest.getXc());
        String renewBookUrl = UrlEnum.BOOK_RENEW_URL.getUrl()+"?sn="+bookRequest.getSn()+"&barcode="+bookRequest.getBarcode()+"&xc="+bookRequest.getXc();
        HttpClientContext context = new HttpClientContext();
        CookieStore cookieStore = new BasicCookieStore();
        HttpConfig httpConfig = HttpConfig.custom().url(renewBookUrl).headers(header).context(context).encoding(Const.Charset.CHRRSET.getValue());
        context.setCookieStore(cookieStore);
        String body = HttpClientUtil.get(httpConfig);
        int status = HttpClientUtil.status(httpConfig);
        if(status!= HttpStatus.SC_OK){
            return ServerResponse.createByError("系统错误，联系管理员查看原因");
        }
        return ServerResponse.createBySuccess(body);
    }


    private ServerResponse<List<Book>> jsoupBookList(String bookListBody) throws HttpProcessException {
        List<Book> bookList = new ArrayList<>();
        Document doc = Jsoup.parse(bookListBody);
        String sum = doc.getElementsByTag("h1").text();
        Elements lis = doc.getElementsByTag("li");
        if(lis.size()<=0){
            return ServerResponse.createBySuccess(sum,bookList);
        }
        for(Element li : lis){
            Book book = new Book();
            //id 和书名
            JSONObject object = JSON.parseObject(li.select("input").val());
            if(object == null || object.size()<2){
                continue;
            }
            book.setBookId(object.get("bookid").toString());
            book.setBookName(object.get("title").toString());
            Elements pList = li.getElementsByTag("p");
            if (pList.size()<4){
                continue;
            }
            book.setBookAuthor(pList.get(0).text().split("：")[1]);
            book.setBookPress(pList.get(1).text().split("：")[1]);
            book.setBookPressDate(pList.get(2).text().split("： ")[1]);
            bookList.add(book);
        }
        return ServerResponse.createBySuccess(sum,bookList);
    }


    private ServerResponse<List<Book>> jsoupBookDetail(String body, String bookName,String bookId) {
        List<Book> bookList = new ArrayList<>();
        Document doc = Jsoup.parse(body);
        Elements tableLib = doc.select(".tableLib");
        if(tableLib.size()==0){
            return ServerResponse.createBySuccess("没有这个书",bookList);
        }
        for(int i = 0;i<tableLib.size();i++){
            Book book = new Book();
            book.setBookName(bookName);
            //book.setBookName(tableLib.get(i).select("p").text());
            book.setBookId(bookId);
            Elements trs = tableLib.get(i).select("table").select("tr");
            book.setBookCode(trs.get(0).select("td").text());
            book.setBookIndexNum(trs.get(1).select("td").text());
            //藏馆（校本部）
            book.setHideLocation(trs.get(2).select("td").text());
            //位置（样本书库（一））
            book.setLocation(trs.get(3).select("td").text());
            book.setHideStatus(trs.get(5).select("td").text());
            book.setLendNum(trs.get(6).select("td").text());
            book.setRenewNum(trs.get(7).select("td").text());
            bookList.add(book);
        }
        return ServerResponse.createBySuccess("加载详细信息成功",bookList);
    }
}