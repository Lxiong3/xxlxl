package com.newthread.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateFormatUtils {

    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat t = new SimpleDateFormat("HH:mm:ss");


    public static String Now2String(){
        Date date = Calendar.getInstance().getTime();
        return f.format(date);
    }

    public static String dateTime2String(Date d){
        return d == null ? null : f.format(d);
    }

    public static String date2String(Date dd){
        return dd == null ? null : d.format(dd);
    }

    public static String time2String(Date d){
        return d == null ? null : t.format(d);
    }

}
