package com.chenyou.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class DateUtil {

    static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
    public static String format(Date date){
        SimpleDateFormat dateFormat = (SimpleDateFormat)threadLocal.get();
        if(null == dateFormat){
            dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
            threadLocal.set(dateFormat);
        }
        return dateFormat.format(date);
    }

    public static String format(Date date,String format){
        if(null == format)
            format = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static Date parse(String date) throws ParseException {
        SimpleDateFormat dateFormat = (SimpleDateFormat)threadLocal.get();
        if(null == dateFormat){
            dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
            threadLocal.set(dateFormat);
        }
        if(date !=null){
            return dateFormat.parse(date);
        }else{
            return null;
        }
    }

    public  static Date parse(Date date) throws ParseException{
        return parse(format(date));
    }

    public static Date today() throws ParseException {
        SimpleDateFormat dateFormat = (SimpleDateFormat)threadLocal.get();
        if(null == dateFormat){
            dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
            threadLocal.set(dateFormat);
        }
        return dateFormat.parse(dateFormat.format(new Date()));
    }

    public static Date addYearsAndToYearBegin(Date date,Integer yearSpan){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR,yearSpan);
        cal.set(Calendar.MONTH,0);
        cal.set(Calendar.DAY_OF_MONTH,1);
        return cal.getTime();
    }

    /**
     * 获取某一年的年底时间
     */
    public static Date addYearsAndToYearEnd(Date date,Integer yearSpan){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR,yearSpan);
        cal.set(Calendar.MONTH,11);
        cal.set(Calendar.DAY_OF_MONTH,31);
        return cal.getTime();
    }

    public static Date addDays(Date date,Integer daySpan){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR,daySpan);
        return cal.getTime();
    }

    public static Date addMonths(Date date,Integer monthSpan){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH,monthSpan);
        return cal.getTime();
    }

    public static Date addYears(Date date,Integer yearSpan){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR,yearSpan);
        return cal.getTime();
    }

    public static Date addHours(Date date, Integer hours){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY,hours);
        return cal.getTime();
    }

    public static Date addSeconds(Date date,Integer secondSpan){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND,secondSpan);
        return cal.getTime();
    }

    public static Integer day(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static Integer month(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    public static Integer year(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static Integer dayspan(Date date1, Date date2) {
        String s_date1 = format(date1);
        String s_date2 =  format(date2);
        try {
            Date round_date1   = parse(s_date1);
            Date round_date2   = parse(s_date2);
            Long timespan = round_date2.getTime() - round_date1.getTime();
            return (int)(timespan/ (24 * 60 * 60 * 1000));
//            return (int) Math.abs( (round_date2.getTime() - round_date1.getTime()) / (24 * 60 * 60 * 1000) );
        } catch (ParseException e) {

        }
        return 0;
    }

    public static Integer dayspanCeil(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        Long timespan = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        return (int) Math.ceil(timespan.doubleValue()/(24 * 60 * 60 * 1000));
    }

    public static boolean isLastYear(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        Calendar curCal = Calendar.getInstance();
        curCal.setTime(new Date());
        int curYear = curCal.get(Calendar.YEAR);
        return (year < curYear);
    }

    public static Map<String,Object> gettime(String parse) throws ParseException {
        Map <String, Object> resultMap = new HashMap<>();
        String ymd = parse.substring(0, 10);
        String hms = parse.substring(11);
        resultMap.put("ymd", ymd);
        resultMap.put("hms", hms);
        return resultMap;
    }

    /**
     * 判断前面时间是否大于后面时间
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public  static boolean equalTime(String start,String end) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        boolean is = sdf.parse(start).after(sdf.parse(end));
        return  is;
    }

    public  static String  format1(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
    }






}
