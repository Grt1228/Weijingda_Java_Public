package com.jgsu.common;

import com.google.common.collect.Sets;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * 描述:
 * 存放通用枚举常量
 *
 * @author grt
 * @create 2018-02-02 22:49
 */
public class  Const {

    public enum Charset{
        CHRRSET(001,"utf-8","字符编码");

        private int code;
        private String value;
        private String desc;

        public int getCode(){
            return code;
        }
        public String getValue(){
            return value;
        }
        public String getDesc(){
            return desc;
        }

        Charset(int code,String value,String desc){
            this.code = code;
            this.value = value;
            this.desc = desc;
        }
    }

    public static final String CURRENT_USER="currentUser";
    public static final String USER_CHECKCODE_COOKIE="userCheckCodeAndCookie";
    public static final String CET_CHECKCODE_COOKIE="cetCheckCodeAndCookie";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface ProductListOrderBy{
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc","price_asc");
    }
    //权限

    public interface Role{
        int ROLE_CUSTOMER = 0;//普通用户

        int ROLE_ADMIN = 1;//管理员
        String ROLE_CUSTOMER_DESC = "普通用户";
        String ROLE_ADMIN_DESC = "管理员";

    }
    public interface UserType{
        String QQ = "QQ";//普通用户

        String WX = "WX";//管理员
    }

    /**
     * 1-及格,2-不及格
     */
    public interface ScoreStatus{
        int YES = 1;//及格

        int NO = 2;//不及格
        String PASS_YES_DESC = "及格";
        String PASS_NO_DESC = "不及格";
    }

    /**
     * 是不是当前学期，0-是，1-不是
     */
    public interface IsCurrentCalendar{
        int YES = 0;

        int NO = 1;

    }

    /**
     * `status` varchar(2) NOT NULL COMMENT '状态：0：失效，1：生效',
     */
    public interface PhoneNumberStatus{
        int YES = 1;//有效

        int NO = 0;//无效

    }

    public interface NewStatus{
        Integer YES = 1;//有效

        Integer NO = 0;//无效
        String NO_DESC = "无效";
        String YES_DESC = "有效";

    }
    /**
     * `status` '记录的有效状态,1-有效,0-无效',
     */
    public interface Status{
        Integer YES = 1;//有效

        Integer NO = 0;//无效
        String NO_DESC = "无效";
        String YES_DESC = "有效";

    }


    public interface LostGoodStatus{
        /**
         * '失物招领状态,01-完成,02-未完成',
         */
        Integer YES_COMPLETE = 01;//完成

        Integer NO_COMPLETE = 02;//未完成
        String YES_COMPLETE_DESC = "完成";
        String NO_COMPLETE_DESC = "未完成";
    }

    /**
     *   `good_type` '物品的状态,1-发布捡到物品,2-发布寻找物品',
     */
    public interface LostGoodType{
        Integer GOOD_TYPE_IN = 1;

        Integer GOOD_TYPE_OUT = 2;
        String GOOD_TYPE_IN_DESC = "发布捡到物品";
        String GOOD_TYPE_OUT_DESC = "发布寻找物品";
    }


    /**
     * CalendarType 校历类型 0日期，1描述',
     */
    public interface calendarType{
        Integer CALENDAR_TYPE_DATE = 0;

        Integer CALENDAR_TYPE_INFO = 1;
        String CALENDAR_TYPE_DATE_DESC = "日期";
        String CALENDAR_TYPE_INFO_DESC = "描述";
    }
    /**
     * is_current_year'是不是当前学期，0-是，1-不是',
     */
    public interface IsCurrentYear{
        Integer IsCurrentYear_YES = 0;

        Integer IsCurrentYear_NO = 1;
        String IsCurrentYear_YES_DESC = "是";
        String IsCurrentYear_NO_DESC = "否";
    }
    /**
     * 学生状态
     */
    public interface StudentStatus{
        int NOT_VALID = 0;//失效

        int VALID= 1;//有效

    }
    //购物车选中状态以及库存限制

    public interface Cart{
        int CHECKED = 1;//选中

        int UN_CHECKED = 0;//未选中

        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
    }


    public enum ProductStatusEnum{
        ON_SALE(1,"在线");
        private String value;
        private int code;
        ProductStatusEnum(int code,String value){
            this.code=code;
            this.value=value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum ImageType{
        WIPER(0,"轮播图"),
        ICON(1,"首页图标"),
        NEW(2,"新闻头图");
        private String value;
        private int code;
        ImageType(int code,String value){
            this.code=code;
            this.value=value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        public static ImageType codeOf(int code){
            for (ImageType imageType : values()) {
                if(imageType.getCode()==code){
                    return imageType;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }
    }


    public interface AlipayCallBack{
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

        String RESPONSE_SUCCESS = "success";
        String RESPONSE_FAILED = "failed";
    }


    /**
     * 是否匿名
     */
    public enum IncognitoEnum{
        YES(1,"匿名"),
        NO(0,"不匿名");
        private String value;
        private int code;
        IncognitoEnum(int code,String value){
            this.code=code;
            this.value=value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
        public static IncognitoEnum codeOf(int code){
            for (IncognitoEnum incognitoEnum : values()) {
                if(incognitoEnum.getCode()==code){
                    return incognitoEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }
    }

    public enum AppTextType{

        NOTICE(0,"通知"),
        OTHER(1,"其他");
        private String value;
        private int code;
        AppTextType(int code,String value){
            this.code=code;
            this.value=value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
        public static AppTextType codeOf(int code){
            for (AppTextType appTextType : values()) {
                if(appTextType.getCode()==code){
                    return appTextType;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }
    }

}