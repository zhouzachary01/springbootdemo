package com.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @description: 与日期有关的工具类;
 * @author: 周海涛
 * @date: 2018/6/13 9:17
 * @comment: 备注
 * @version: V1.0
 */
public class DateUtils {

    private static final SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy年MM月dd日");
    private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    /** 
     * @description : 日期格式转换成字符串"yyyy-MM-dd HH:mm:ss"；;
     * @author : 周海涛
     * @date : 2018/6/13 9:27
     * @param : [date]
     * @return : java.lang.String
     * @throws :可能抛出的异常;
     */
    private static String dateTimeConvertString(Date date){
        String dateStr = "";
        if(date != null){
            dateStr = datetimeFormat.format(date);
        }
        return dateStr;
    }


    /** 
     * @description : 字符串格式转换成日期时间格式；yyyy-MM-dd HH:mm:ss;
     * @author : 周海涛
     * @date : 2018/6/13 9:35
     * @param : [dateStr]
     * @return : java.util.Date
     * @throws :可能抛出的异常;
     */
    public static Date StringConvertDateTime(String dateStr){
        Date date = null;
        try {
            date = datetimeFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /** 
     * @description : 某个日期多少天之后的日期;
     * @author : 周海涛
     * @date : 2018/6/13 9:44
     * @param : [datestr, day]
     * @return : java.util.String
     * @throws :可能抛出的异常;
     */
    public static String afterDate(String datestr,int day){
        try {
            java.sql.Date olddate = null;
            try {
                dateFormat.setLenient(false);
                olddate = new java.sql.Date(dateFormat.parse(datestr).getTime());
            } catch (ParseException e) {
                throw new RuntimeException("日期转换错误");
            }
            Calendar cal = new GregorianCalendar();
            cal.setTime(olddate);
            int Year = cal.get(Calendar.YEAR);
            int Month = cal.get(Calendar.MONTH);
            int Day = cal.get(Calendar.DAY_OF_MONTH);
            int NewDay = Day + day;
            cal.set(Calendar.YEAR, Year);
            cal.set(Calendar.MONTH, Month);
            cal.set(Calendar.DAY_OF_MONTH, NewDay);
            Date d = new Date(cal.getTimeInMillis());
            return dateFormat.format(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datestr;
    }

    /** 
     * @description : 日期转换成"yyyy年MM月dd日 星期几";
     * @author : 周海涛
     * @date : 2018/6/13 9:58
     * @param : [date]
     * @return : java.lang.String
     * @throws :可能抛出的异常;
     */
    public static String getDateWeek(Date date){
        try {
            String[] week = new String[]{"日","一","二","三","四","五","六"};
            String dateString = ymdFormat.format(date);
            Calendar calendar = Calendar.getInstance();
            int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
            System.out.println(weekDay);
            return dateString +" 星期"+week[weekDay-1];
        } catch (Exception e) {
            e.printStackTrace();
            return ymdFormat.format(date);
        }
    }

}
