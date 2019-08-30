package com.jgsu.requestrelated;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.jgsu.common.*;
import com.jgsu.pojo.CourseInfo;
import com.jgsu.pojo.ScoreInfo;
import com.jgsu.pojo.TestSchedule;
import com.jgsu.pojo.UserInfo;
import com.jgsu.utils.PropertiesUtil;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.utils.httpclientutil.HttpClientUtil;
import com.jgsu.utils.httpclientutil.common.HttpConfig;
import com.jgsu.utils.httpclientutil.common.HttpMethods;
import com.jgsu.utils.httpclientutil.exception.HttpProcessException;
import com.jgsu.vo.*;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 用户相关请求
 *
 * @author grt
 * @create 2018-02-07 22:10
 */
public class UserRequest {
    //周一 0 7 14 21---1
    //周二 1 8 15 22---2
    //周三 2 9 16 23---3
    //周四 3 10 17 24---4
    //周五 4 11 18 25---5
    //周六 5 12 19 26---6
    //周日 6 13 20 27---0
    private static int[] WEEK1 = {0 ,7 ,14 ,21};
    private static int[] WEEK2 = {1 ,8 ,15 ,22};
    private static int[] WEEK3 = {2 ,9 ,16 ,23};
    private static int[] WEEK4 = {3 ,10 ,17 ,24};
    private static int[] WEEK5 = {4 ,11 ,18 ,25};
    private static int[] WEEK6 = {5 ,12 ,19 ,26};
    private static int[] WEEK7 = {6 ,13 ,20 ,27};
    /**
     *
     * @param scoreVo
     * @return
     */
    public static ServerResponse<List<ScoreInfo>> getScoreList(ScoreVo scoreVo,UserInfo user){
        //todo 可以减少SoreInfo的参数个数，创建ScoreInfoVo封装参数进去
        String body = "";
        String cookie = scoreVo.getCookie();
        String scoreUrl = UrlEnum.SCORE_URL.getUrl()/*+scoreVo.getLoginName()*/;
        try {
            body = send(scoreUrl,null, Const.Charset.CHRRSET.getValue(),
                    RequestHeaders.Header_Referer.getValue(),cookie);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        //判断是否获取成功
        if(!body.contains("成绩查询")){
            return ServerResponse.createByError("获取成绩失败");
        }
        //解析网页获取成绩单
        List<ScoreInfo> scoreInfoList = jsoupScore(body,scoreVo,user);
        return ServerResponse.createBySuccess("获取成绩成功",scoreInfoList);
    }

    /**
     *
     * @param request
     * @param user
     * @return
     */
    public static ServerResponse<List<TestSchedule>> getTestSchedule(TestScheduleRequest request, UserInfo user) {

        String body = "";
        String testScheduleUrl = UrlEnum.TESTSCHEDULE_URL.getUrl();
        Header[] header = {
                new BasicHeader("Cookie",request.getCookie())};
        Map map = new HashMap();
        HttpClientContext context = new HttpClientContext();
        HttpConfig httpConfig = HttpConfig.custom().url(testScheduleUrl).headers(header).map(null).context(context);
        try {
            body = HttpClientUtil.get(httpConfig);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }

        /*String body = "";
        String cookie = request.getCookie();
        String testScheduleUrl = UrlEnum.TESTSCHEDULE_URL.getUrl();
        try {
            body = send(testScheduleUrl,null, Const.Charset.CHRRSET.getValue(),
                    RequestHeaders.Header_Referer.getValue(),cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //判断是否获取成功
        if(!body.contains("考试安排")){
            return ServerResponse.createByError("获取考试安排失败，反馈给管理员吧");
        }
        ServerResponse loginRepeat = loginRepeat(body);
        ServerResponse payStatus = payStatus(body);
        if(loginRepeat.getStatus()==10){
            return loginRepeat;
        }
        if(loginRepeat.getStatus()==20){
            return payStatus;
        }
        //解析网页获取成绩单
        List<TestSchedule> testScheduleList = jsoupTestSchedule(body,request,user);
        return ServerResponse.createBySuccess("获取考试安排成功",testScheduleList);
    }

    private static List<TestSchedule> jsoupTestSchedule(String body, TestScheduleRequest request, UserInfo user) {
        //System.out.println(body);
        List<TestSchedule> testScheduleList = new ArrayList<>();
        Document document = Jsoup.parse(body);
        Element element = document.getElementById("mxh");
        Elements testTimeElement = document.getElementById("tab1").select("font");
        String testInfo = testTimeElement.text();
        String[] testTimeArray = testInfo.split("：");
        String testTime = testTimeArray[testTimeArray.length-1];
        Elements trs = element.select("tr");
        if(trs.size()==0){
            return testScheduleList;
        }
        for(int i = 0;i<trs.size();i++){
            Elements tds = trs.get(i).select("td");
            TestSchedule testSchedule = new TestSchedule();
            testSchedule.setTestScheduleId(UUIDUtil.getUUID());
            testSchedule.setStudentName(user.getStudentName());
            testSchedule.setStudentId(user.getStudentId());
            testSchedule.setLoginName(request.getLoginName());
            testSchedule.setTestYear(testTime);
            testSchedule.setTestType(tds.get(0).text());
            testSchedule.setTestTime(tds.get(1).text());
            testSchedule.setTestCode(tds.get(2).text());
            testSchedule.setTestName(tds.get(3).text());
            testSchedule.setTestLocation(tds.get(4).text());
            testSchedule.setTestRoomNumber(tds.get(5).text());
            System.out.println("a");
            testScheduleList.add(testSchedule);
        }
        return testScheduleList;
    }

    /**
     * 解析成绩单
     * @param body
     * @return
     */
    private static List<ScoreInfo> jsoupScore(String body,ScoreVo scoreVo,UserInfo user) {
        List<ScoreInfo> scoreInfoList = Lists.newArrayList();
        Document doc = Jsoup.parse(body);
        Elements trs = doc.select("tbody").eq(1).select("tr");
        for(int i = 1;i<trs.size();i++){
            Elements tds = trs.get(i).select("td");
            ScoreInfo scoreInfo = new ScoreInfo();
            scoreInfo.setScoreId(UUIDUtil.getUUID());
            scoreInfo.setStudentName(user.getStudentName());
            scoreInfo.setStudentId(user.getStudentId());
            scoreInfo.setLoginName(scoreVo.getLoginName());
            scoreInfo.setLearningTime(tds.get(1).text());
            scoreInfo.setCourseId(tds.get(2).text());
            scoreInfo.setCourseName(tds.get(3).text());
            scoreInfo.setScore(tds.get(4).text());
            if(!(Double.parseDouble(tds.get(4).text())>=60.0)){
                scoreInfo.setStatus(String.valueOf(Const.ScoreStatus.NO));
            }else{
                scoreInfo.setStatus(String.valueOf(Const.ScoreStatus.YES));
            }
            scoreInfo.setCredit(tds.get(5).text());
            scoreInfo.setHours(tds.get(6).text());
            scoreInfo.setCourseProperty(tds.get(7).text());
            scoreInfo.setCourseType(tds.get(8).text());
            scoreInfo.setTestProperty(tds.get(9).text());
            scoreInfo.setTestType(tds.get(10).text());
            scoreInfo.setRepairTime(tds.get(12).text());
            scoreInfo.setCountCredit(doc.getElementById("lbzxf").text());
            scoreInfo.setMustCredit(doc.getElementById("lbbxxf").text());
            scoreInfo.setMajorElectiveCredit(doc.getElementById("lblzyxxxf").text());
            scoreInfo.setPublicElectiveCredit(doc.getElementById("lblggxxxf").text());
            scoreInfo.setAvgScorePoint(doc.getElementById("lblpgxfjd").text());
            scoreInfo.setCountHours(doc.getElementById("lbzxs").text());
            scoreInfo.setCountCourse(doc.getElementById("lbkcms").text());
            scoreInfo.setCountFail(doc.getElementById("lbbjgms").text());
            scoreInfoList.add(scoreInfo);
        }
        return scoreInfoList;
    }

    /**
     * 获取cookie和保存本地图片
     * @return
     * @throws HttpProcessException
     */
    public static ServerResponse<CheckCodeVo> getCookieAndParam() throws HttpProcessException, IOException {
        HttpClientContext context = new HttpClientContext();
        CookieStore cookieStore = new BasicCookieStore();
        HttpConfig config =HttpConfig.custom().url(UrlEnum.CHECKCODE_URL.getUrl()).context(context);
        return CommonRequest.getCookieAndParam(config,PropertiesUtil.getProperty("ALIYUN_BUCKET_NMAE_CODE",""),
                context,PropertiesUtil.getProperty("ALIYUN_ENDPOINT"),cookieStore);
        /*return CommonRequest.getCookieAndParam(config,PropertiesUtil.getProperty("QINIUYUN_BUCKET_NAME_LOGIN",""),
                context,PropertiesUtil.getProperty("QINIUYUN_BUCKET_HOST_NAME_LOGIN"),cookieStore);*/
    }

    /**
     * 模拟登陆
     * @param loginVo
     * @return
     * @throws ParseException
     * @throws IOException
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     */
    public static ServerResponse<UserInfo> login(LoginVo loginVo)
            throws ParseException, IOException, KeyManagementException, NoSuchAlgorithmException {
        Map<String, String> map = new HashMap<>(8);
        map.put(RequestParam.LOGIN_ACCOUNT.getValue(), loginVo.getLoginName());
        map.put(RequestParam.LOGIN_PWD.getValue(), loginVo.getPassword());
        map.put(RequestParam.LOGIN_CHECKCODE.getValue(), loginVo.getCheckCode());
        map.put("__VIEWSTATE", "/wEPDwUJODM2MDEyOTk3D2QWAgIDD2QWAgILDw8WAh4EVGV4dGVkZGQOCC3asSiQPPQYurwSUiHMe9D57A==");
        map.put("__VIEWSTATEGENERATOR", "C2EE9ABB");
        map.put("__EVENTVALIDATION","/wEWBQKZ3JOQCgKvo8HwCwKG85bvBgLO44u1DQLAiqigB+GLQA8RzNzjT3UrMWd8WFEyhYS/");
        map.put(RequestParam.LOGIN_CHARSET.getValue(), Const.Charset.CHRRSET.getValue());
        map.put(RequestParam.LOGIN_CMDOK.getValue(), "");
        String otherBody = null;
        String cookie = loginVo.getCookie();
        try {
            String body = send(UrlEnum.LOGIN_URL.getUrl(), map, Const.Charset.CHRRSET.getValue(), RequestHeaders.Header_Referer.getValue(), cookie);
            if(body.contains("用户名或密码错误")){
                return ServerResponse.createByError("用户名或密码错误");
            }
            if(body.contains("验证码不正确")){
                return ServerResponse.createByError("验证码不正确，请重新输入!");
            }
            otherBody = send(UrlEnum.DEFAULT_URL.getUrl(),null, Const.Charset.CHRRSET.getValue(),
                    RequestHeaders.Header_Referer.getValue(),cookie);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }
        if(!otherBody.contains("欢迎进入强智数字化校园平台")){
            return ServerResponse.createByError("登录失败");
        }
        UserInfo userInfo = new UserInfo();
        Document document = Jsoup.parse(otherBody);
        userInfo.setStudentName(document.getElementById("users").text());
        userInfo.setCookie(cookie);
        userInfo.setLoginName(loginVo.getLoginName());
        return ServerResponse.createBySuccess("登陆成功",userInfo);
    }

    /**
     * 设置信任自定义的证书
     *
     * @param keyStorePath		密钥库路径
     * @param keyStorepass		密钥库密码
     * @return
     */
    public static SSLContext custom(String keyStorePath, String keyStorepass) {
        SSLContext sc = null;
        FileInputStream instream = null;
        KeyStore trustStore = null;
        try {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            instream = new FileInputStream(new File(keyStorePath));
            trustStore.load(instream, keyStorepass.toCharArray());
            // 相信自己的CA和所有自签名的证书
            sc = SSLContexts.custom().loadTrustMaterial(trustStore, new TrustSelfSignedStrategy()).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                instream.close();
            } catch (IOException e) {
            }
        }
        return sc;
    }

    /**
     * 绕过验证
     *
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSLv3");

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sc.init(null, new TrustManager[] { trustManager }, null);
        return sc;
    }

    /**
     * 设置代理
     * @param hostOrIP
     * @param port
     */
    public static HttpClientBuilder proxy(String hostOrIP, int port){
        // 依次是代理地址，代理端口号，协议类型
        HttpHost proxy = new HttpHost(hostOrIP, port, "http");
        DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
        return HttpClients.custom().setRoutePlanner(routePlanner);
    }

    public static String send(String url, Map<String,String> map, String encoding, String referer,String cookie)
            throws KeyManagementException, NoSuchAlgorithmException, ClientProtocolException, IOException, HttpProcessException {
        String body = "";
        //绕过证书验证，处理https请求
        SSLContext sslcontext = createIgnoreVerifySSL();

        // 设置协议http和https对应的处理socket链接工厂的对象
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(sslcontext))
                .build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);

        //创建自定义的httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        URI uri = null;
        //
        try{
            URL url1 = new URL(url);
            uri = new URI(url1.getProtocol(), url1.getHost(), url1.getPath(), url1.getQuery(), null);
        }catch(Exception e){
            e.printStackTrace();
        }

        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(uri);

        //装填参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if(map!=null){
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        //设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));

        System.out.println("请求地址："+url);
        System.out.println("请求参数："+nvps.toString());

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader(RequestHeaders.Header_Accept.getKey(), RequestHeaders.Header_Accept.getValue());
        httpPost.setHeader(RequestHeaders.Header_AcceptEncoding.getKey(), RequestHeaders.Header_AcceptEncoding.getValue());
        httpPost.setHeader(RequestHeaders.Header_AcceptLanguage.getKey(), RequestHeaders.Header_AcceptLanguage.getValue());
        httpPost.setHeader(RequestHeaders.Header_Connection.getKey(), RequestHeaders.Header_Connection.getValue());
        httpPost.setHeader(RequestHeaders.Header_CacheControl.getKey(), RequestHeaders.Header_CacheControl.getValue());
        httpPost.setHeader(RequestHeaders.Header_ContentType.getKey(), RequestHeaders.Header_ContentType.getValue());
        httpPost.setHeader(RequestHeaders.Header_UserAgent.getKey(), RequestHeaders.Header_UserAgent.getValue());
        httpPost.setHeader(RequestHeaders.Header_Referer.getKey(), referer);
        httpPost.setHeader(RequestHeaders.Header_Origin.getKey(), RequestHeaders.Header_Origin.getValue());
        httpPost.setHeader(RequestHeaders.Header_Host.getKey(), RequestHeaders.Header_Host.getValue());
        httpPost.setHeader("Cookie", cookie);
        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return body;
    }

    public static ServerResponse getCourseList(CourseRequest courseRequest) throws Exception{
        List<List<CourseInfo>> courseData = null;
        List<List<CourseInfo>> responseCourseData = null;
        String body = "";
        String courseListUrl ="http://xuanke.jgsu.edu.cn/JWXS/pkgl/XsKB_List.aspx";
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
                    new BasicHeader("Cookie",courseRequest.getCookie()),};
            Map map = new HashMap();
            map.put(RequestParam.COURSE_EVENTARGUMENT.getValue(),RequestParam.COURSE_EVENTARGUMENT.getDesc());
            map.put(RequestParam.COURSE_EVENTTARGET.getValue(),RequestParam.COURSE_EVENTTARGET.getDesc());
            map.put(RequestParam.COURSE_LASTFOCUS.getValue(),RequestParam.COURSE_LASTFOCUS.getDesc());
            //map.put(RequestParam.COURSE_VIEWSTATE.getValue(),RequestParam.COURSE_VIEWSTATE.getDesc());
            map.put(RequestParam.COURSE_VIEWSTATE.getValue(),courseRequest.getViewState());
            map.put(RequestParam.COURSE_VIEWSTATEGENERATOR.getValue(),RequestParam.COURSE_VIEWSTATEGENERATOR.getDesc());
            //当前学年
            map.put(RequestParam.COURSE_ddlxnxqh.getValue(),courseRequest.getCurrentYear());
            //放大
            map.put(RequestParam.COURSE_mx.getValue(),"on");
            //当前周
            map.put(RequestParam.COURSE_zc.getValue(),courseRequest.getCurrentWeek());
            map.put("usermain","x2015000017");
            HttpClientContext context = new HttpClientContext();
            HttpConfig httpConfig = HttpConfig.custom().url(courseListUrl).headers(header).map(map).context(context);
            body = HttpClientUtil.post(httpConfig);
            int status = HttpClientUtil.status(httpConfig);
            if (status!=HttpStatus.SC_OK){
                return ServerResponse.createByError("获取课表body异常");
            }
            courseData = jsoupCourse(courseRequest.getLoginName(), body);
            responseCourseData = new ArrayList<>();
            //根据前台传参当天周几
            int[] weekArray = getWeekArrayByWeek(Integer.parseInt(courseRequest.getWeek()));
            for(int i = 0;i<weekArray.length;i++){
                responseCourseData.add(courseData.get(weekArray[i]));
            }
        }catch (HttpProcessException e) {
            e.printStackTrace();
        }
        //todo 解析课程表
        return ServerResponse.createBySuccess("获取课表成功",responseCourseData);
    }

    private static List<List<CourseInfo>> jsoupCourse(String loginName, String body) {
        List<List<CourseInfo>> responseList = Lists.newArrayList();
        Document doc = Jsoup.parse(body);
        //获得课表table的所有tr
        Elements trs = doc.select("table").eq(3).select("tr");
        for(int i = 1;i<trs.size()-1;i++){
            //获得 所有td
            Elements tds = trs.get(i).select("td");
            for(int j = 1;j<tds.size();j++){
                Elements a = tds.get(j).select("nobr").select("a");
                if(a.size()==0){
                    //没有a标签，说明没课
                    List<CourseInfo> courseInfoList = Lists.newArrayList();
                    CourseInfo courseInfo = new CourseInfo();
                    courseInfo.setCourseId(UUIDUtil.getUUID());
                    courseInfo.setLoginName(loginName);
                    courseInfoList.add(courseInfo);
                    responseList.add(courseInfoList);
                    //System.out.println("``````````````````````````");
                    continue;
                }
                //可能存在有两个a的情况
                for (int x = 0;x<a.size();x++){
                    String courseDetail = a.attr("title");
                    courseDetail = courseDetail.replace("\t\t\t\t\t\t\t\t\t\t","");
                    courseDetail = courseDetail.replace("\\r\\n","\n");
                    String[] split = courseDetail.split("\n");
                    List<CourseInfo> courseInfoList = Lists.newArrayList();
                    CourseInfo courseInfo = new CourseInfo();
                    courseInfo.setLoginName(loginName);
                    courseInfo.setCourseId(UUIDUtil.getUUID());
                    if(isTow(split[0].split("："))){
                        courseInfo.setCourseStartCode(split[0].split("：")[1]);
                    }else{
                        courseInfo.setCourseStartCode("");
                    }
                    if(isTow(split[1].split("："))){
                        courseInfo.setCourseCode(split[1].split("：")[1]);
                    }else{
                        courseInfo.setCourseCode("");
                    }
                    if(isTow(split[2].split("："))){
                        courseInfo.setCourseName(split[2].split("：")[1]);
                    }else{
                        courseInfo.setCourseName("");
                    }
                    if(isTow(split[3].split("："))){
                        courseInfo.setCourseTeacher(split[3].split("：")[1]);
                    }else{
                        courseInfo.setCourseTeacher("");
                    }
                    if(isTow(split[4].split("："))){
                        courseInfo.setCourseTime(split[4].split("：")[1]);
                    }else{
                        courseInfo.setCourseTime("");
                    }
                    if(isTow(split[5].split("："))){
                        courseInfo.setCourseWeek(split[5].split("：")[1]);
                    }else{
                        courseInfo.setCourseWeek("");
                    }
                    if(isTow(split[6].split("："))){
                        courseInfo.setCoursePlace(split[6].split("：")[1]);
                    }else{
                        courseInfo.setCoursePlace("");
                    }
                    if(isTow(split[7].split("："))){
                        courseInfo.setCourseClass(split[7].split("：")[1]);
                    }else{
                        courseInfo.setCourseClass("");
                    }
                    courseInfoList.add(courseInfo);
                    responseList.add(courseInfoList);
                    /*for(int y = 0;y<split.length;y++){
                        String[] courseType = split[y].split("：");
                        if(courseType.length!=2){
                            System.out.println(courseType[0]);
                            System.out.println("");
                            continue;
                        }
                        System.out.println(courseType[0]);
                        System.out.println(courseType[1]);
                    }*/
                }
                //System.out.println("``````````````````````````");
            }
        }
        return responseList;
    }

    private static boolean isTow(String[] courseType){
        if(courseType.length!=2){
            return false;
        }
        return true;
    }

    public static ServerResponse currentWeekYear(String loginName, String cookie)throws Exception {
        try {
            ServerResponse<String> courseBody = getCourseBody(loginName,cookie);
            if(courseBody.getStatus()==10){
                return courseBody;
            }else if (courseBody.isSuccess()){
                //获取当前周，学期
                Map map = jsoupCurrentWeekYear(courseBody.getData());
                return ServerResponse.createBySuccess("解析当前周学期成功",map);
            }else if(courseBody.getStatus()==20){
                return courseBody;
            }
        }catch (HttpProcessException e) {
            e.printStackTrace();
        }
        //todo 解析课程表

        return ServerResponse.createByError("获取当前周和学期异常");
    }

    private static Map jsoupCurrentWeekYear(String courseBody) {
        Map map = new HashMap();
        Document doc = Jsoup.parse(courseBody);
        Element form = doc.getElementById("form1");
        String viewState = form.select("input").get(3).val();
        Elements selects = doc.select("select");
        String currentYear = selects.get(0).select("option[selected]").val();
        String currentWeek = selects.get(1).select("option[selected]").val();
        if("".equals(currentWeek)||currentWeek==null){
            currentWeek = "1";
        }
        map.put("currentYear",currentYear);
        map.put("currentWeek",currentWeek);
        map.put("viewState",viewState);
        return map;
    }

    public static ServerResponse<String> getCourseBody(String loginName, String cookie)throws Exception{
        String body = "";
        String courseListUrl = UrlEnum.COURSE_URL.getUrl()/*+loginName*/;
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
                    new BasicHeader("Cookie",cookie)};
            Map map = new HashMap();
            HttpClientContext context = new HttpClientContext();
            HttpConfig httpConfig = HttpConfig.custom().url(courseListUrl).headers(header).map(null).context(context);
            body = HttpClientUtil.get(httpConfig);
            int status = HttpClientUtil.status(httpConfig);
            if (status!=HttpStatus.SC_OK){
                return ServerResponse.createByError("获取课表body异常");
            }
            ServerResponse loginRepeat = loginRepeat(body);
            ServerResponse payStatus = payStatus(body);
            if(loginRepeat.getStatus()==10){
                return loginRepeat;
            }
            if(payStatus.getStatus()==20){
                return payStatus;
            }
        }catch (HttpProcessException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess("获取课表body成功",body);
    }


    public static int[] getWeekArrayByWeek(int i){
        if(i==0){
            return WEEK7;
        }else if(i==1){
            return WEEK1;
        }else if(i==2){
            return WEEK2;
        }else if(i==3){
            return WEEK3;
        }else if(i==4){
            return WEEK4;
        }else if(i==5){
            return WEEK5;
        }else if(i==6){
            return WEEK6;
        }
        return null;
    }

    public static ServerResponse<WechatInfoVo> getWechatInfo(WechatInfoVo wechatInfoVo) throws HttpProcessException {
        String appId = null;
        String appSecret = null;
        String url = null;
        if(Const.UserType.QQ.equals(wechatInfoVo.getType())){
            appId = PropertiesUtil.getProperty("QQ_APP_Id");
            appSecret = PropertiesUtil.getProperty("QQ_APP_Secret");
            url = UrlEnum.QQ_OPENID_URL.getUrl();
        }else{
            appId = PropertiesUtil.getProperty("WE_CHAT_APP_Id");
            appSecret = PropertiesUtil.getProperty("WE_CHAT_APP_Secret");
            url = UrlEnum.WECHAT_OPENID_URL.getUrl();
        }

        Map map = new HashMap();
        map.put("appid",appId);
        map.put("secret",appSecret);
        map.put("js_code",wechatInfoVo.getJscode());
        map.put("grant_type","authorization_code");
        HttpConfig httpConfig = HttpConfig.custom().url(url).map(map);
        String body = HttpClientUtil.post(httpConfig);
        JSONObject jsonObject = JSONObject.parseObject(body);
        String openid =String.valueOf(jsonObject.get("openid"));
        String sessionKey =String.valueOf(jsonObject.get("session_key"));
        wechatInfoVo.setOpenId(openid);
        wechatInfoVo.setSessionKey(sessionKey);
        return ServerResponse.createBySuccess(wechatInfoVo);
    }

    /**
     * 判断是否重复登陆
     * @param body
     * @return
     */
    public static ServerResponse loginRepeat(String body){
        if(body.contains("你的帐号已在别处登陆，你被强迫下线！")){
            return ServerResponse.createByError(10,"你的帐号已在别处登陆，请重新登陆。");
        }
        return ServerResponse.createBySuccess();
    }

    /**
     * 判断官网报错
     * @param body
     * @return
     */
    public static ServerResponse payStatus(String body){
        if(body.contains("未设置缴费状态")){
            return ServerResponse.createByError(20,"官网提示：未设置缴费状态，请登陆官网查看！");
        }
        return ServerResponse.createBySuccess();
    }


}