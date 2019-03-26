package com.jdxm.utils;


import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 * @author dyf
 */
public class DateUtils {

    public static String TIME_FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

	public static String DATE_FORMAT = "yyyy-MM-dd";

    public static final int DATE_FORWARD = 1;

    public static final int DATE_BACK = 2;

    /**
     * 根据月份计算指定日期
     * @param fixedDate 指定日期字符串
     * @param month 提前或者退出的月数
     * @param type 向前还是向后 1向前 2向后
     * @return
     */
    public static String calDateByMonth(String fixedDate,int month,int type){

        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);

        DateTime dateTime = DateTime.parse(fixedDate, format);

        if(type == 1){
            dateTime = dateTime.plusMonths(month);
        }
        else {
            dateTime = dateTime.minusMonths(month);
        }

        return dateTime.toString(DATE_FORMAT);
    }



    /**
     * 根据天数计算指定日期
     * @param fixedDate 指定日期字符串
     * @param days 提前或者退出的月数
     * @param type 向前还是向后 1向前 2向后
     * @return
     */
    public static String calDateByDay(String fixedDate,int days,int type){

        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);

        DateTime dateTime = DateTime.parse(fixedDate, format);

        if(type == 1){
            dateTime = dateTime.plusDays(days);
        }
        else {
            dateTime = dateTime.minusDays(days);
        }

        return dateTime.toString(DATE_FORMAT);
    }


    /**
     * 计算两个日期之间的天数(去头)
     * start        end           返回
     * 2017-03-01   2017-03-01    0
     * 2017-03-01   2017-03-05    4
     * 2017-03-05   2017-03-01    -4
     * @param start 开始日期
     * @param end 结束日期
     * @return 天数
     */
    public static int daysBetweenDateNoHead(String start,String end){
        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);

        DateTime startDateTime = DateTime.parse(start, format);

        DateTime endDateTime = DateTime.parse(end,format);


        int days = Days.daysBetween(startDateTime, endDateTime).getDays();

        return days;
    }



    /**
     * 计算两个日期之间的天数(保留头尾)
     * @param start 开始日期
     * @param end 结束日期
     * @return 天数
     */
    public static int daysBetweenDate(String start,String end){
        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);
        DateTime startDateTime = DateTime.parse(start, format);
        DateTime endDateTime = DateTime.parse(end,format);

        int days = Days.daysBetween(startDateTime, endDateTime).getDays();
        days = days + 1;

        return days;
    }


    /**
     * 计算两个日期之间的天数(去头去尾)
     * @param start 开始日期
     * @param end 结束日期
     * @return 天数
     */
    public static int daysBetweenDateNoBoth(String start,String end){
        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);
        DateTime startDateTime = DateTime.parse(start, format);
        DateTime endDateTime = DateTime.parse(end,format);

        int days = Days.daysBetween(startDateTime, endDateTime).getDays();
        days = days - 1;
        return days;
    }


    /**
     * 根据时间字符串获取日期
     * @param date 时间 eg. 2017-09-21
     * @return int 日期
     */
    public static int getDay(String date){
        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);

        DateTime dateTime = DateTime.parse(date, format);

        String dayStr = dateTime.toString("dd");

        return Integer.parseInt(dayStr);
    }


    /**
     * 获取该月的最后一天的日期
     * @param date
     * @return
     */
    public static String getEndDayOfMonth(String date){
        DateTime dt = new DateTime(date);

        DateTime lastday = dt.dayOfMonth().withMaximumValue();

        return lastday.toString("yyyy-MM-dd");
    }

    /**
     * 获取该月一共有几天
     * @param date 日期 eg. 2017-01-04
     */
    public static int getDayOfMonth(String date){
        DateTime dt = new DateTime(date);

        return dt.dayOfMonth().getMaximumValue();
    }

    /**
     * 计算去年最后一天
     * @return
     */
    public static String getlastYear(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Calendar c = Calendar.getInstance();
        //过去一年
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date y = c.getTime();
        String year = format.format(y);
        return year+"-12-31";
    }

    /**
     * 计算去年
     * @return
     */
    public static String getlastYearDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去一年
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date y = c.getTime();
        String year = format.format(y);
        return year;
    }

    /**
     * 计算下一个月
     * @return
     */
    public static String getnextMonthDate(String date){
        try {
            Date d1 = new SimpleDateFormat("yyyy-MM").parse(date);
            Calendar c = Calendar.getInstance();

            c.setTime(d1);
            c.add(Calendar.MONTH, 1);
            Date y = c.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            String s = sdf.format(y.getTime());
            return s;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算上一个月
     * @return
     */
    public static String getlastMonthDate(String date){
        try {
            Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Calendar c = Calendar.getInstance();

            c.setTime(d1);
            c.add(Calendar.MONTH, -1);
            Date y = c.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String s = sdf.format(y.getTime());
            return s;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算昨天
     * @return
     */
    public static String getlastDayDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //昨天
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_YEAR, -1);
        Date y = c.getTime();
        String year = format.format(y);
        return year;
    }
    /**
     * 计算明天
     * @return
     */
    public static String getnextDayDate(String date){
        try {
            Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Calendar c = Calendar.getInstance();

            c.setTime(d1);
            c.add(Calendar.DAY_OF_WEEK, -1);
            Date y = c.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String s = sdf.format(y.getTime());
            return s;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 计算
     * @return
     */
    public static String getOtherDayDate(Integer day){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();

        c.setTime(new Date());
        c.add(Calendar.DAY_OF_YEAR, day);
        Date y = c.getTime();
        String year = format.format(y);
        return year;
    }
    /**
     * 比较哪个日期早， 1 date1比较早   -1 date2比较早  0相同
     * @param date1
     * @param date2
     * @return
     */
    public static int compareDateTime(String date1,String date2){
        DateTime dateTime1 = new DateTime(date1);
        DateTime dateTime2 = new DateTime(date2);

        if(dateTime1.isBefore(dateTime2)){
            return 1;
        }else if (dateTime2.isAfter(dateTime2)) {
            return -1;
        }else {
            return 0;
        }
    }

    public static int monthBetween(String start, String end) {
        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);
        DateTime startDateTime = DateTime.parse(start, format);
        DateTime endDateTime = DateTime.parse(end,format);

        return Months.monthsBetween(startDateTime, endDateTime).getMonths();
    }


    /**
     * 计算一年有多少天
     * @param year
     * @return
     */
    private static int getMaxDaysOfYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    public static int getMonth(String date) {
        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);
        DateTime dt = DateTime.parse(date, format);
        return dt.getMonthOfYear();
    }

    public static String getYearAndMonth(String date) {
        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);
        DateTime dt = DateTime.parse(date, format);
        return dt.getYear()+"-"+dt.getMonthOfYear();
    }


    public static List<String> getDateList(String startDate,String endDate){
        List<String> list = new ArrayList<>();
        try {
            Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
            Calendar dd = Calendar.getInstance();
            dd.setTime(d1);
            while (dd.getTime().before(d2)){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String s = sdf.format(dd.getTime());
                list.add(s);
                dd.add(Calendar.DAY_OF_YEAR, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }


    //最近一周
    public static List<String> dateToWeek(String date) {
        try {
            Date mdate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            int b = mdate.getDay();
            Date fdate;
            List<String> list = new ArrayList<String>();
            Long fTime = mdate.getTime() - b * 24 * 3600000;
            for (int a = 1; a <= 7; a++) {
                fdate = new Date();
                fdate.setTime(fTime - (a * 24 * 3600000));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String s = sdf.format(fdate.getTime());
                list.add(a-1, s);
            }
            return list;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期转星期
     *
     * @param datetime
     * @return
     */
    public static String dateWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
}

