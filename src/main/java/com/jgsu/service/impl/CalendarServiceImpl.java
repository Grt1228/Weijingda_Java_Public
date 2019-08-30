package com.jgsu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jgsu.common.Const;
import com.jgsu.common.ServerResponse;
import com.jgsu.dao.CalendarMapper;
import com.jgsu.pojo.Calendar;
import com.jgsu.service.ICalendarService;
import com.jgsu.utils.DateUtil;
import com.jgsu.utils.UUIDUtil;
import com.jgsu.vo.CalendarRequest;
import com.jgsu.vo.CalendarResponse;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 描述:
 * 日历相关
 *
 * @author lqd12
 * @create 2018-06-12 22:28
 */
@Log
@Service("iCalendarService")
public class CalendarServiceImpl implements ICalendarService {

    private Logger logger = LoggerFactory.getLogger(CalendarServiceImpl.class);
    @Autowired
    private CalendarMapper calendarMapper;
    @Override
    public ServerResponse<PageInfo> list(CalendarRequest calendarRequest) {
        logger.info("获取日历相关lis参数："+calendarRequest);
        try {
            PageHelper.startPage(calendarRequest.getPageNum(),calendarRequest.getPageSize());
            List<Calendar> calendarList = calendarMapper.list(calendarRequest);
            List<CalendarResponse> calendarResponseList = Lists.newArrayList();
            buildResponseList(calendarList,calendarResponseList);
            PageInfo pageResult = new PageInfo(calendarList);
            pageResult.setList(calendarResponseList);
            return ServerResponse.createBySuccess(pageResult);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("获取日历相关list异常"+e);
        }
        return ServerResponse.createByError("获取日历相关list异常");
    }

    @Override
    public ServerResponse add(CalendarRequest calendarRequest) {
        logger.info("后台新增日历参数："+calendarRequest);

        List<Date> betweenDates = getBetweenDates(calendarRequest.getBeginDate(), calendarRequest.getEndDate());
        List<Calendar> calendarList = new ArrayList<>();
        betweenDates.forEach(e->{
            Calendar calendar = new  Calendar();
            calendar.setCalendarInfo(calendarRequest.getCalendarInfo());
            calendar.setCalendarYear(DateUtil.getYear(e)+"");
            calendar.setCalendarMonth((DateUtil.getMonth(e)+1)+"");
            calendar.setCalendarDay(DateUtil.getDay(e)+"");
            calendar.setCalendarDate(DateUtil.dateToStr(e,DateUtil.YYYY_MM_DD_FORMAT));
            calendar.setCalendarId(UUIDUtil.getUUID());
            calendar.setCalendarType(Const.calendarType.CALENDAR_TYPE_DATE.toString());
            calendar.setStatus("1");
            calendarList.add(calendar);
        });
        int insert = calendarMapper.insertBatch(calendarList);
        if(insert>0){
            return ServerResponse.createBySuccess("新增日历成功");
        }
        return ServerResponse.createByError("新增日历异常");
    }

    @Override
    public ServerResponse update(Calendar calendar) {
        try {
            //修改
            int i = calendarMapper.updateByPrimaryKeySelective(calendar);
            if(i>0){
                return ServerResponse.createBySuccess("修改日历成功");
            }
            return ServerResponse.createByError("修改日历异常");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("修改日历异常"+e);
        }
        return ServerResponse.createByError("修改日历异常");
    }

    @Override
    public ServerResponse delete(Calendar calendar) {
        log.info("删除MapPoint参数:"+calendar.getCalendarId());
        int i = calendarMapper.deleteByPrimaryKey(calendar.getCalendarId());
        if(i>=1){
            return ServerResponse.createBySuccess("删除成功！");
        }
        return ServerResponse.createByError("删除异常！");
    }

    /**
     * 添加描述校历信息
     *
     * @param calendar
     * @return
     */
    @Override
    public ServerResponse addDesc(Calendar calendar) {
        logger.info("后台新增日历描述参数："+calendar);
        calendar.setCalendarType(Const.calendarType.CALENDAR_TYPE_INFO.toString());
        calendar.setCalendarId(UUIDUtil.getUUID());
        calendar.setCalendarDate(calendar.getCalendarDate().substring(0,10));
        int insert = calendarMapper.insert(calendar);
        if(insert>0){
            return ServerResponse.createBySuccess("新增日历描述成功");
        }
        return ServerResponse.createByError("新增日历描述异常");
    }

    private void buildResponseList(List<Calendar> calendarList, List<CalendarResponse> calendarResponseList) {
        for(Calendar calendar:calendarList){
            CalendarResponse vo = new CalendarResponse();
            vo.setCalendarDate(calendar.getCalendarDate());
            vo.setCalendarDay(calendar.getCalendarDay());
            vo.setCalendarId(calendar.getCalendarId());
            vo.setCalendarInfo(calendar.getCalendarInfo());
            vo.setCalendarMonth(calendar.getCalendarMonth());
            vo.setCalendarTitle(calendar.getCalendarTitle());
            vo.setCalendarType(calendar.getCalendarType());
            vo.setCalendarTypeDesc(calendar.getCalendarType().equals(Const.calendarType.CALENDAR_TYPE_DATE.toString())?
                    Const.calendarType.CALENDAR_TYPE_DATE_DESC: Const.calendarType.CALENDAR_TYPE_INFO_DESC);
            vo.setCalendarYear(calendar.getCalendarYear());
            vo.setCreateTime(DateUtil.dateToStr(calendar.getCreateTime()));
            vo.setIsCurrentYear(calendar.getIsCurrentYear());
            /*vo.setIsCurrentYearDesc(calendar.getIsCurrentYear().equals(Const.IsCurrentYear.IsCurrentYear_YES.toString())?
                    Const.IsCurrentYear.IsCurrentYear_YES_DESC: Const.IsCurrentYear.IsCurrentYear_NO_DESC);
            */
            vo.setStatusDesc(calendar.getStatus().equals(Const.Status.YES.toString())?
                    Const.Status.YES_DESC:Const.Status.NO_DESC);
            vo.setModifiedTime(DateUtil.dateToStr(calendar.getModifiedTime()));
            calendarResponseList.add(vo);
        }
    }

    /**
     * 获取两个日期间的日期列表
     * @param start
     * @param end
     * @return
     */
    private List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        java.util.Calendar tempStart = java.util.Calendar.getInstance();
        tempStart.setTime(start);
        //tempStart.add(java.util.Calendar.DAY_OF_YEAR, 1);

        java.util.Calendar tempEnd = java.util.Calendar.getInstance();
        tempEnd.setTime(end);
        //先判断两个日期是否相等
        if(tempStart.compareTo(tempEnd)==0){
            result.add(tempStart.getTime());
            return result;
        }
        //result.add(tempStart.getTime());
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(java.util.Calendar.DAY_OF_YEAR, 1);
        }
        result.add(tempEnd.getTime());
        return result;
    }
}