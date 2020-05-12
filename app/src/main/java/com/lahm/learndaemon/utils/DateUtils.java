package com.lahm.learndaemon.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by zsd on 2018/1/11 17:36
 * desc:日期相关类
 */

public class DateUtils {

    //年月日格式
    public static final String DATEFORMAT_YMD = "yyyy-MM-dd";

    public static long getCurrentTime() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis;
    }


    public static int[] getYmdHms(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(time);
            return new int[]{
                    date.getYear(),
                    date.getMonth()
            };
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new int[0];
    }


    /**
     * 获取精确到秒的时间戳
     *
     * @param date
     * @return
     */
    public static String getSecondTimestamp(Date date) {
        if (null == date) {
            return null;
        }
        String timestamp = String.valueOf(date.getTime() / 1000);
        return timestamp;
    }

    /**
     * 格式转换日期
     */
    public static String formatDate(String before, String forMat) {
        String after;
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .parse(before);
            after = new SimpleDateFormat(forMat, Locale.getDefault()).format(date);
        } catch (ParseException e) {
            return before;
        }
        return after;
    }

    public static String convertMillToHms(long millis) {
        return String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
    }

    public static String convertMillToDHms(long millis) {
        return String.format("%02d:%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toDays(millis),
                TimeUnit.MILLISECONDS.toHours(millis) - TimeUnit.HOURS.toHours(TimeUnit.MILLISECONDS.toDays(millis)),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
    }


    public static String formatNum(int time) {
        return time < 10 ? "0" + time : String.valueOf(time);
    }

    public static String formatMillisecond(int millisecond) {
        String retMillisecondStr;

        if (millisecond > 99) {
            retMillisecondStr = String.valueOf(millisecond / 10);
        } else if (millisecond <= 9) {
            retMillisecondStr = "0" + millisecond;
        } else {
            retMillisecondStr = String.valueOf(millisecond);
        }

        return retMillisecondStr;
    }

    public static String dateToWeek(String datetime) {
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

    public static String getAllTime(long time){
        long oneHour = 3600000;//1小时的时间
        SimpleDateFormat formatter;
        if (time>oneHour){
           formatter = new SimpleDateFormat("HH:mm:ss");
        }else {
            formatter = new SimpleDateFormat("mm:ss");
        }
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String hms = formatter.format(time);
        if (time ==0){
            return "00:00";
        }else {
            return hms;
        }
    }
}
