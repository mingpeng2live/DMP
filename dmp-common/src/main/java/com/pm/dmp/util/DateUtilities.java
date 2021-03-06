package com.pm.dmp.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 
 * @author dolf.zhang@hunteron.com
 * @Description 时间帮助类 
 * @Date  2015年3月18日 上午9:48:36
 */
public class DateUtilities {
	
	public static String defaultFormatDate(Date date) {
		return formatDate(date, ConstantUtilities.DATE_TIME_FORMAT);
	}

	public static String formatDate(Date date, String format) {
		return formatDate(date.getTime(), format);
	}

	public static String defaultFormatDate(long date) {
		return formatDate(date, ConstantUtilities.DATE_TIME_FORMAT);
	}

	public static String formatDate(long date, String format) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
		return formatter.print(date);
	}

	public static Date defaultParseDate(String date) throws ParseException {
		return parseDate(date, ConstantUtilities.DATE_TIME_FORMAT);
	}

	public static Date parseDate(String date, String format) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
		return new Date(formatter.parseMillis(date));
	}

	public static Date getCurrentDateWithoutTime() {
		try {
			return parseDate(formatDate(new Date(), "yyyy/MM/dd"), "yyyy/MM/dd");
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date getCurrentDate() {
		return new Date();
	}

	
	public static Date createDate(Long time) {
		if (time == null) {
			return null;
		}
		return new Date(time);
	}

	
	/**
	 * 获取本周的开始时间
	 * @return
	 */
	public static Date getThisWeekStartTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return getStartTimeOfDay(calendar);
	}
	
	/**
	 * 获取本周的结束时间 
	 * @return
	 */
	public static Date getThisWeekEndTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return getEndTimeOfDay(calendar);
	}
	
	/**
	 * 获取当月的开始时间 
	 * @return
	 */
	public static Date getThisMonthStartTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return getStartTimeOfDay(calendar);
	}
	
	/**
	 * 获取当月的结束时间
	 * @return
	 */
	public static Date getThisMonthEndTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		return getEndTimeOfDay(calendar);
	}
	
	
	/**
	 * 获取一天的开始时间
	 * @return
	 */
	public static Date getStartTimeOfDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
		return calendar.getTime();
	}
	
	/**
	 * 获取一天的开始时间
	 * @return
	 */
	public static Date getStartTimeOfDay(Calendar calendar){
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
		return calendar.getTime();
	}
	
	/**
	 * 获取一天的结束时间
	 * @return
	 */
	public static Date getEndTimeOfDay(Calendar calendar){
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 23, 59, 59);
		return calendar.getTime();
	}
	
	/**
	 * 获取一天的结束时间
	 * @return
	 */
	public static Date getEndTimeOfDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 23, 59, 59);
		return calendar.getTime();
	}
	
	 /**
     * 当前季度的开始时间，即2012-01-1 00:00:00
     *
     * @return
     */
    public static Date getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 4);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = DateUtils.truncate(c, Calendar.DATE).getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

}
