package com.ele.system.utils;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 
 * @author wangping-ds5
 *
 */
public class DateUtil {

	public static final int REAR = 1;
	public static final int MONTH = 2;
	public static final int DAY = 3;
	public static final int HOUR = 4;
	public static final int MINUTE = 5;
	public static final int SECOUND = 6;
	
	private static SimpleDateFormat getDateFormatter() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
	}

	private static SimpleDateFormat getyyyyMMddFormatter() {
		return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
	}

	private static SimpleDateFormat getyyyyMMddHHmmssFormatter() {
		return new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
	}

	public static final String[] getyyyyMMddHHmmssFormatCurrentTime() {
		String[] str = new String[2];
		Date date = new java.util.Date();
		// 1 2005-02-03 10:02:22
		str[0] = getDateFormatter().format(date);
		// 2 20050203100222
		str[1] = getyyyyMMddHHmmssFormatter().format(date);
		return str;
	}

	public static final String getyyyyMMddHHmmssFormatTime(String date) {
		Date dateStr = null;
		try {
			dateStr = getDateFormatter().parse(date);
		} catch (Exception e) {
			return getyyyyMMddHHmmssFormatter().format(new Date());
		}
		return getyyyyMMddHHmmssFormatter().format(dateStr);
	}

	public static final String getFormatCurrentTime() {
		return getDateFormatter().format(new java.util.Date());
	}

	public static final String getFormatTime(long time) {
		return getDateFormatter().format(new java.util.Date(time));
	}

	public static final String getFormatTime(java.util.Date date) {
		if (date == null) {
			return "";
		}
		return getDateFormatter().format(date);
	}

	public static final String getyyyyMMddFormatCurrentTime() {
		return getyyyyMMddFormatter().format(new java.util.Date());
	}

	public static final String getyyyyMMddFormatCurrentTime(java.util.Date date) {
		if (date == null) {
			return null;
		}
		return getyyyyMMddFormatter().format(date);
	}

	// today is 2005-11-4 return 2005-10-04
	public static String getTodayDateString() {
		return getyyyyMMddFormatter().format(new java.util.Date());
	}

	// today is 2005-11-4, if beforeDay=-30 return 2005-10-04
	public static String getFromDateString(int beforeDay) {
		GregorianCalendar gregorianCalendar = new GregorianCalendar(Locale.CHINA);// 一定要new,否则在原来的时间基础上增加
		gregorianCalendar.add(GregorianCalendar.DATE, beforeDay);
		Date beforeday = gregorianCalendar.getTime();
		return getyyyyMMddFormatter().format(beforeday);
	}

	public static int getDayCountBetweenTwoDay(String fromDay, String toDay) {
		if (fromDay == null || toDay == null) {
			return 0;
		}
		Date dDate1 = null;
		Date dDate2 = null;
		try {
			dDate1 = getyyyyMMddFormatter().parse(fromDay);
			dDate2 = getyyyyMMddFormatter().parse(toDay);
		} catch (ParseException e) {
		}
		if (dDate1 == null || dDate2 == null) {
			return 0;
		}
		float a = 1000 * 60 * 60 * 24;
		float m = dDate2.getTime() - dDate1.getTime();
		return (int) (m / a);
	}

	public static int getMonthCountBetweenTwoDay(String fromDay, String toDay) {
		if (fromDay == null || toDay == null) {
			return 0;
		}
		Date dDate1 = null;
		Date dDate2 = null;
		try {
			dDate1 = getyyyyMMddFormatter().parse(fromDay);
			dDate2 = getyyyyMMddFormatter().parse(toDay);
		} catch (ParseException e) {
		}
		if (dDate1 == null || dDate2 == null) {
			return 0;
		}
		float a = 1000 * 60 * 60 * 24;
		float m = dDate2.getTime() - dDate1.getTime();
		return (int) (m / a) / 30;
	}

	public static long getCountBetweenTwoDay(int countType, String fromDay, String toDay) {
		if (fromDay == null || toDay == null) {
			return 0;
		}
		if (fromDay.length() <= 10) {
			fromDay += " 00:00:00";
		}
		if (toDay.length() <= 10) {
			toDay += " 00:00:00";
		}
		Date dDate1 = null;
		Date dDate2 = null;
		try {
			dDate1 = getDateFormatter().parse(fromDay);
			dDate2 = getDateFormatter().parse(toDay);
		} catch (Exception e) {
			return 0;
		}
		if (dDate1 == null || dDate2 == null) {
			return 0;
		}
		float a = 1;
		switch (countType) {
		case REAR:
			a = 1000 * 60 * 60 * 24 * 365;
			break;
		case MONTH:
			a = 1000 * 60 * 60 * 24 * 30;
			break;
		case DAY:
			a = 1000 * 60 * 60 * 24;
			break;
		case HOUR:
			a = 1000 * 60 * 60;
			break;
		case MINUTE:
			a = 1000 * 60;
			break;
		case SECOUND:
			a = 1000;
			break;
		}
		float m = dDate2.getTime() - dDate1.getTime();
		return (long) (m / a);
	}

	// 返回 4分25秒
	public static String getMinuteAndSecondBetweenTwoDay(String fromDay, String toDay) {
		long resSecond = 0;
		try {
			resSecond = (long) getCountBetweenTwoDay(SECOUND, fromDay, toDay);
		} catch (Exception e) {
			;
		}
		long minute = resSecond / 60;
		long second = resSecond % 60;
		String res = minute + "分" + second + "秒";
		return res;
	}

	public static boolean isDateBigToday(String aDate) {
		String currentTime = DateUtil.getFormatCurrentTime();
		int day = DateUtil.getDayCountBetweenTwoDay(aDate, currentTime);
		if (day <= -1)
			return true;
		else
			return false;
	}

	// 返回基于aDate的前后beforeOrAfterCount天，beforeOrAfterCount为负就返回前beforeOrAfterCount天
	public static String getDateValue(String aDate, int beforeOrAfterCount) {
		Date dDate1 = null;
		try {
			dDate1 = getDateFormatter().parse(aDate);
		} catch (Exception e) {
			try {
				dDate1 = getyyyyMMddFormatter().parse(aDate);
			} catch (Exception e1) {
				;
			}
		}
		GregorianCalendar gregorianCalendar = new GregorianCalendar(Locale.CHINA);// 一定要new,否则在原来的时间基础上增加
		if (dDate1 != null) {
			gregorianCalendar.setTimeInMillis(dDate1.getTime());
		}
		gregorianCalendar.add(GregorianCalendar.DATE, beforeOrAfterCount);
		Date beforeday = gregorianCalendar.getTime();
		return getyyyyMMddFormatter().format(beforeday);
	}

	public static Date parseToDate(String fullDateString) {
		if (fullDateString == null || fullDateString.length() == 0) {
			return null;
		}
		Date date = null;
		try {
			date = getDateFormatter().parse(fullDateString);
		} catch (ParseException e) {
		}
		return date;
	}

	/**
	 * t3在t1-t2的时间段前[-1]，内[0]，后[1]。 -1:即将使用； 0：正在使用； 1：已经过期
	 * 
	 * @param t1
	 * @param t2
	 * @param t3
	 * @return [-1]t1[0]t2[1]
	 */
	public static int timePosition(String t1, String t2, String t3) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dT1 = sdf.parse(t1);
			Date dT2 = sdf.parse(t2);
			Date dT3 = sdf.parse(t3);
			if ((dT3.getTime() >= dT1.getTime()) && dT2.getTime() >= dT3.getTime()) {
				return 0;
			} else if (dT1.getTime() > dT3.getTime()) {
				return -1;
			} else {
				return 1;
			}

		} catch (ParseException e) {
			return -1;
		}
	}

	/**
	 * 将2012-04-12 12:12:12.0格式化成2012-04-12
	 * 
	 * @param t1
	 * @return
	 */
	public static String format2Date(String t1) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return DateFormatUtils.format(sdf.parse(t1), "yyyy-MM-dd");
		} catch (ParseException e) {
			return "";
		}
	}
}
