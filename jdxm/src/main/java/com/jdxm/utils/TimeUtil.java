package com.jdxm.utils;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by swk on 2017/10/14.
 * jd.wang@renrunkeji.com
 */
public class TimeUtil {

    private static Logger logger = LoggerFactory.getLogger(TimeUtil.class);

    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_2 = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final int DATE_FORWARD = 1;
    public static final int DATE_BACK = 2;

    public static String nowTime() {
        return format(TIME_FORMAT);
    }

    public static String nowTime2() {
        return format(TIME_FORMAT_2);
    }

    public static String nowDate() {
        return format(DATE_FORMAT);
    }

    public static Long nowTs() {
        return System.currentTimeMillis()/1000;
    }

    public static String format() {
        return format(TIME_FORMAT);
    }

    public static String format(String format) {
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormater.format(date);
    }

    public static String format(String dateStr, String format) {
        // 默认原始格式是 yyyy-MM-dd
        return turnFormat(dateStr, DATE_FORMAT, format);
    }

    /**
     * 转换日期格式
     * turnFormat("2017-11-21", "yyyy-MM-dd", "yyyy年MM月dd日");
     * 2017-11-21 => 2017年11月21日
     *
     * @param dateStr
     * @param formatFrom
     * @param formatTo
     * @return
     */
    public static String turnFormat(String dateStr, String formatFrom, String formatTo) {
        SimpleDateFormat df1 = new SimpleDateFormat(formatFrom);
        SimpleDateFormat df2 = new SimpleDateFormat(formatTo);
        try {
            Date dateFrom = df1.parse(dateStr);
            return df2.format(dateFrom);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("解析日期失败");
        }
    }

    /**
     * 比较哪个日期早， 1 date1比较早   -1 date2比较早  0相同
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compareDateTime(String date1, String date2) {
        DateTime dateTime1 = new DateTime(date1);
        DateTime dateTime2 = new DateTime(date2);

        if (dateTime1.isBefore(dateTime2)) {
            return 1;
        } else if (dateTime1.isAfter(dateTime2)) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * 根据月份计算指定日期
     *
     * @param fixedDate 指定日期字符串
     * @param month     提前或者退出的月数
     * @param type      向前还是向后 1向前 2向后
     * @return
     */
    public static String calDateByMonth(String fixedDate, int month, int type) {
        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);
        DateTime dateTime = DateTime.parse(fixedDate, format);

        if (type == 1) {
            dateTime = dateTime.plusMonths(month);
        } else {
            dateTime = dateTime.minusMonths(month);
        }

        return dateTime.toString(DATE_FORMAT);
    }

    /**
     * 根据周计算指定日期
     *
     * @param fixedDate 指定日期字符串
     * @param week     提前或者退出的周数数
     * @param type      向前还是向后 1向前 2向后
     * @return
     */
    public static String calDateByWeek(String fixedDate, int week, int type) {
        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);
        DateTime dateTime = DateTime.parse(fixedDate, format);

        if (type == 1) {
            dateTime = dateTime.plusWeeks(week);
        } else {
            dateTime = dateTime.plusWeeks(week);
        }

        return dateTime.toString(DATE_FORMAT);
    }

    /**
     * 根据天数计算指定日期
     *
     * @param fixedDate 指定日期字符串
     * @param days      提前或者退出的天数
     * @param type      向前还是向后 1向前 2向后
     * @return
     */
    public static String calDateByDay(String fixedDate, int days, int type) {
        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);
        DateTime dateTime = DateTime.parse(fixedDate, format);

        if (type == 1) {
            dateTime = dateTime.plusDays(days);
        } else {
            dateTime = dateTime.minusDays(days);
        }

        return dateTime.toString(DATE_FORMAT);
    }

    /**
     * 根据小时数计算指定
     *
     * @param fixedTime 指定日期字符串
     * @param days      提前或者退出的小时数
     * @param type      向前还是向后 1向前 2向后
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String calTimeByHour(String fixedTime, int days, int type) {
        DateTimeFormatter format = DateTimeFormat.forPattern(TIME_FORMAT);
        DateTime dateTime = DateTime.parse(fixedTime, format);

        if (type == 1) {
            dateTime = dateTime.plusHours(days);
        } else {
            dateTime = dateTime.minusHours(days);
        }

        return dateTime.toString(TIME_FORMAT);
    }

    /**
     * 计算两个日期之间的天数(保留头尾)
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 天数
     */
    public static int daysBetweenDate(String start, String end) {
        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);
        DateTime startDateTime = DateTime.parse(start, format);
        DateTime endDateTime = DateTime.parse(end, format);

        int days = Days.daysBetween(startDateTime, endDateTime).getDays();
        days = days + 1;

        return days;
    }

    /**
     * 根据日期字符串获取天
     *
     * @param date
     * @return
     */
    public static int getDay(String date) {
        DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);
        DateTime dateTime = DateTime.parse(date, format);
        String dayStr = dateTime.toString("dd");
        int day = Integer.parseInt(dayStr);

        return day;
    }

    /**
     * 获取该月的最后一天的日期
     *
     * @param date
     * @return
     */
    public static String getEndDayOfMonth(String date) {
        DateTime dt = new DateTime(date);
        DateTime lastday = dt.dayOfMonth().withMaximumValue();
        return lastday.toString("yyyy-MM-dd");
    }

    /**
     * 转换时间为时间戳
     *
     * @param time
     * @param format
     * @param dft
     * @return
     */
    public static long Str2Timestamp(String time, String format, long dft) {
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
        try {
            Date date = dateFormater.parse(time);
            return date.getTime() / 1000;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return dft;
    }

    /**
     * 转换时间戳为时间
     *
     * @param time
     * @param format
     * @return
     */
    public static String Timestamp2Str(long time, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = new Date(time * 1000);
        return simpleDateFormat.format(date);
    }

    /**
     * 比较哪个时间早， 1 date1比较早   -1 date2比较早  0相同
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compareTimestamp(String date1, String date2) {
        Long dateTime1 = TimeUtil.Str2Timestamp(date1,TIME_FORMAT,0L);
        Long dateTime2 = TimeUtil.Str2Timestamp(date2,TIME_FORMAT,0L);

        if (dateTime1 < dateTime2) {
            return 1;
        } else if (dateTime1 > dateTime2) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * 校验指定日期格式
     *
     * @param str
     * @return
     */
    public static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat(TIME_FORMAT);
        try {
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * 计算两个日期的时差
     *
     * @param start
     * @param end
     * @return
     */
    public static int calBetweenHour(String start, String end) {
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date begin=dfs.parse(start);
            Date last = dfs.parse(end);
            long between=(last.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
            int hour1= (int)between%(24*3600)/3600;
            return hour1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
