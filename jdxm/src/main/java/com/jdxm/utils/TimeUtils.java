package com.jdxm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间换算工具类
 */
public class TimeUtils {

    // 长日期格式
    public static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 获得当前UNIX时间戳（自1970-01-01 到现在的秒数）
	 * @return
	 */
	public static long time()
	{
		long t =  System.currentTimeMillis()/1000; //当前UNIX时间戳
		return t;
	}

	/**
	 * 获得当前时间，格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String date()
	{
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date =new Date();
		return dateFormater.format(date);
	}

	/**
	 * 格式化当前时间，格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String date(String format)
	{
		if (format=="")
			format="yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat dateFormater = new SimpleDateFormat(format);
		Date date =new Date();
		return dateFormater.format(date);
	}

	/**
	 * 格式化时间，格式：yyyy-MM-dd HH:mm:ss
	 * @param format 格式化字符串
	 * @param unix_time 数字化的UNIX时间戳
	 * @return
	 */
	public static String date(String format,long unix_time)
	{
		SimpleDateFormat dateFormater = new SimpleDateFormat(format);
		Date date =new Date(unix_time*1000); //转化成微秒
		return dateFormater.format(date);
	}

	/**
	 * 获得当前时间，格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String dateIng()
	{
		SimpleDateFormat dateFormater =new SimpleDateFormat("yyyyMMddHHmmss");
		Date date =new Date();
		return dateFormater.format(date);
	}


	public static String dateIngs()
	{
		SimpleDateFormat dateFormater =new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date date =new Date();
		return dateFormater.format(date);
	}
	/**
	 * 获得时间字符串，格式：yyyyMMddHHmmss
	 * @return
	 */
	public static String date(String format,String strtime)
	{
		if (format == null || strtime == null || format.equals("") || strtime.equals("")) {
			return "";
		}

		SimpleDateFormat dateFormater = new SimpleDateFormat(format);
		Date date =new Date(TimeUtils.strtotime(strtime));
		return dateFormater.format(date);
	}

	public static String timedate(String time){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormater.format(date);
	}
	/**
	 * 转化时间
	 * @param strtime
	 * @return
	 */
	public static long strtotime(String strtime)
	{
        try {
            SimpleDateFormat format = new SimpleDateFormat(TIME_FORMAT);
            return format.parse(strtime).getTime();
        }catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
	}
	public static String longdatetostr(long big,long small){
		if (big-small<0)
			return "00:00:00";
		long shijiancha=big-small;//时间差
		String hour;
		String min;
		String second;

		if (shijiancha/1000/60/60<10){hour="0"+shijiancha/1000/60/60;}else{hour=new Long(shijiancha/1000/60/60).toString();}
		if (shijiancha/1000/60%60<10){min="0"+shijiancha/1000/60%60;}else{min=new Long(shijiancha/1000/60%60).toString();}
		if (shijiancha/1000%60<10){second="0"+shijiancha/1000%60;}else{second=new Long(shijiancha/1000%60).toString();}

		return hour+":"+min+":"+second;
	}
	public static String shortDate(){
		SimpleDateFormat dateFormater =new SimpleDateFormat("yyyy-MM-dd");
		Date date =new Date();
		return dateFormater.format(date);
	}

	public static String sudate(int day ){
		SimpleDateFormat dateFormater =new SimpleDateFormat("yyyy-MM-dd");
		Date dt =new Date();
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		rightNow.add(Calendar.DAY_OF_YEAR,-day);
		Date dt1=rightNow.getTime();
		return dateFormater.format(dt1);
	}

	public static String adddate(int time ){
		SimpleDateFormat dateFormater =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt =new Date();
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		rightNow.add(Calendar.MINUTE,time);
		Date dt1=rightNow.getTime();
		return dateFormater.format(dt1);
	}

	public static List<String> dateSplit(String a, String b)
			throws Exception {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		Date startDate= sdf.parse(a);
		Date endDate= sdf.parse(b);
		if (!startDate.before(endDate))
			throw new Exception("开始时间应该在结束时间之后");
		Long spi = endDate.getTime() - startDate.getTime();
		Long step = spi / (24 * 60 * 60 * 1000);// 相隔天数

		List<String> dateList = new ArrayList<String>();
		dateList.add(b);
		for (int i = 1; i <= step; i++) {
			dateList.add(sdf.format(new Date(sdf.parse(dateList.get(i - 1)).getTime()
					- (24 * 60 * 60 * 1000))));// 比上一天减一
		}
		return dateList;
	}

}

