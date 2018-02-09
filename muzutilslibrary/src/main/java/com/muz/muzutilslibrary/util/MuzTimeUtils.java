package com.muz.muzutilslibrary.util;


import android.app.TimePickerDialog;
import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @description  TimeUtils
 * @author  Muz
 * @date  2018/2/8 14:28
 */

public class MuzTimeUtils {
    /**
     * The default format
     */
    public static final String TIME_DEFAULT_FORMAT="yyyy-MM-dd hh:mm:ss";
    /**
     * Year month day    The default format
     */
    public static final String TIME_DEFAULT_YMD_FORMAT="yyyy-MM-dd";
    /**
     * Year month day    There is no horizontal line format.
     */
    public static final String TIME_NO_LINE_YMD_FORMAT="yyyyMMdd";
    /**
     * Year month day    Chinese format.
     */
    public static final String TIME_CHINESE_YMD_FORMAT="yyyy年MM月dd日";
    /**
     * Year month day    Slash format
     */
    public static final String TIME_SLASH_YMD_FORMAT="yyyy/MM/dd";
    /**
     * Year month day    The colon format
     */
    public static final String TIME_COLON_YMD_FORMAT="yyyy:MM:dd";
    /**
     * month day    Chinese format.
     */
    public static final String TIME_CHINESE_MD_FORMAT="MM月dd日";
    /**
     * month day     The default format
     */
    public static final String TIME_DEFAULT_MD_FORMAT="MM-dd";
    /**
     * hour minute     The colon format
     */
    public static final String TIME_COLON_HS_FORMAT="hh:mm";
    /**
     * month     Chinese format.
     */
    public static final String TIME_ONLY_CHINESE_M_FORMAT="MM月";
    /**
     * Get nearby dates.       default
     * @param i         The number of days off the current date.      -1:yesterday   0:today      1:Tomorrow
     * @return          Return date
     */
    public static String getRecentTime(int i){
        return getRecentTime( i,TIME_DEFAULT_YMD_FORMAT);
    }
    /**
     * Get nearby dates.
     * @param i         The number of days off the current date.      -1:yesterday   0:today      1:Tomorrow
     * @param format    The date format
     * @return          Return date
     */
    public static String getRecentTime(int i,String format){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        String dateString="";
        try {
            calendar.add(calendar.DATE,i);
            date=calendar.getTime();
            dateString = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateString;
    }
    /************************First day of the year*********************************************************************************
     /**
     * First day of the year  dou
     * @return    Return date
     */
    public static String getYearFirstDay(){
        return getYearFirstDay(TIME_DEFAULT_YMD_FORMAT);
    }

    /**
     * First day of the year
     * @param format The date format
     * @return     Return date
     */
    public static String getYearFirstDay(String format){
        return getDate(format,Calendar.DAY_OF_YEAR,1);
    }
    /**
     * First day of the year     default
     * @param view  Displays a view of the date.Apply to textView and button
     */
    public static void getYearFirstDay(TextView view){
        getYearFirstDay( view, TIME_DEFAULT_YMD_FORMAT);
    }
    /**
     * First day of the year
     * @param view  Displays a view of the date.Apply to textView and button
     * @param format The date format
     */
    public static void getYearFirstDay(TextView view,String format){
        view.setText(getDate(format,Calendar.DAY_OF_YEAR,1));
    }
    /************************The last day of the year.*********************************************************************************
     /**
     * The last day of the year.
     * @return    Return date
     */
    public static String getYearLastDay(){
        return getYearLastDay(TIME_DEFAULT_YMD_FORMAT);
    }
    /**
     * The last day of the year.
     * @param format The date format
     * @return    Return date
     */
    public static String getYearLastDay(String format){
        return getDate(format,Calendar.DAY_OF_YEAR,Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR));
    }
    /**
     * The last day of the year.
     * @param view  Displays a view of the date.Apply to textView and button
     */
    public static void getYearLastDay(TextView view){
        getYearLastDay( view,TIME_DEFAULT_YMD_FORMAT);
    }
    /**
     * The last day of the year.
     * @param view  Displays a view of the date.Apply to textView and button
     * @param format The date format
     */
    public static void getYearLastDay(TextView view,String format){
        view.setText(getDate(format,Calendar.DAY_OF_YEAR,Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR)));
    }
    /************************First day of the month*********************************************************************************
     /**
     * First day of the month  default
     * @return    Return date
     */
    public static String getMonthFirstDay(){
        return getMonthFirstDay(TIME_DEFAULT_YMD_FORMAT);
    }

    /**
     * * First day of the month
     * @param format The date format
     * @return     Return date
     */
    public static String getMonthFirstDay(String format){
        return getDate(format,Calendar.DAY_OF_MONTH,1);
    }
    /**
     * First day of the month     default
     * @param view  Displays a view of the date.Apply to textView and button
     */
    public static void getMonthFirstDay(TextView view){
        getMonthFirstDay( view, TIME_DEFAULT_YMD_FORMAT);
    }
    /**
     * First day of the month
     * @param view  Displays a view of the date.Apply to textView and button
     * @param format The date format
     */
    public static void getMonthFirstDay(TextView view,String format){
        view.setText(getDate(format,Calendar.DAY_OF_MONTH,1));
    }
    /************************The last day of the month*********************************************************************************
     /**
     * The last day of the month
     * @return    Return date
     */
    public static String getMonthLastDay(){
        return getMonthLastDay(TIME_DEFAULT_YMD_FORMAT);
    }
    /**
     * The last day of the month
     * @param format The format
     * @return    Return date
     */
    public static String getMonthLastDay(String format){
        return getDate(format,Calendar.DAY_OF_MONTH,Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
    }
    /**
     * The last day of the month
     * @param view  Displays a view of the date.Apply to textView and button
     */
    public static void getMonthLastDay(TextView view){
        getMonthLastDay( view,TIME_DEFAULT_YMD_FORMAT);
    }
    /**
     * The last day of the month
     * @param view  Displays a view of the date.Apply to textView and button
     * @param format Return date
     */
    public static void getMonthLastDay(TextView view,String format){
        view.setText(getDate(format,Calendar.DAY_OF_MONTH,Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)));
    }
    /************************First day of the week*********************************************************************************
     /**
     * First day of the week  default
     * @return    Return date
     */
    public static String getWeekFirstDay(){
        return getMonthFirstDay(TIME_DEFAULT_YMD_FORMAT);
    }

    /**
     * * First day of the week
     * @param format The format
     * @return     Return date
     */
    public static String getWeekFirstDay(String format){
        return getDate(format,Calendar.DAY_OF_WEEK,1);
    }
    /**
     * First day of the week     default
     * @param view  Displays a view of the date.Apply to textView and button
     */
    public static void getWeekFirstDay(TextView view){
        getMonthFirstDay( view, TIME_DEFAULT_YMD_FORMAT);
    }
    /**
     * First day of the week
     * @param view  Displays a view of the date.Apply to textView and button
     * @param format The date format
     */
    public static void getWeekFirstDay(TextView view,String format){
        view.setText(getDate(format,Calendar.DAY_OF_WEEK,1));
    }
    /************************The last day of the week*********************************************************************************
     /**
     * The last day of the week
     * @return    Return date
     */
    public static String getWeekLastDay(){
        return getMonthLastDay(TIME_DEFAULT_YMD_FORMAT);
    }
    /**
     * The last day of the week
     * @param format The format
     * @return    Return date
     */
    public static String getWeekLastDay(String format){
        return getDate(format,Calendar.DAY_OF_WEEK,Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_WEEK));
    }
    /**
     * The last day of the week
     * @param view  Displays a view of the date.Apply to textView and button
     */
    public static void getWeekLastDay(TextView view){
        getMonthLastDay( view,TIME_DEFAULT_YMD_FORMAT);
    }
    /**
     * The last day of the week
     * @param view  Displays a view of the date.Apply to textView and button
     * @param format The format
     */
    public static void getWeekLastDay(TextView view,String format){
        view.setText(getDate(format,Calendar.DAY_OF_WEEK,Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_WEEK)));
    }

    /************************today*********************************************************************************
     * get today        default
     * @return     today
     */
    public static String getToday(){
        return getToday(TIME_DEFAULT_YMD_FORMAT);
    }
    /**
     * Fetch current time
     * @param format The date format
     * @return     today
     */
    public static String getToday(String format){
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        return dateFormater.format(cal.getTime());
    }
    /**
     * get today
     * @return     today
     */
    public static void getToday(TextView view){
        getToday(view,TIME_DEFAULT_YMD_FORMAT);
    }
    /**
     * Fetch current time
     * @param view Displays a view of the date.
     * @param format The date format
     *
     */
    public static void getToday(TextView view,String format){
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        view.setText(dateFormater.format(cal.getTime()));
    }

    /**
     * Get the specified date
     * @param format                 The date format
     * @param calendar               calendar
     * @param day                    How many days
     * @return                       Return date
     */
    public static String  getDate(String format,int calendar,int day){
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.set(calendar,day);
        return dateFormater.format(cal.getTime());
    }
    /**
     * Get the specified date
     * @param view                   Displays a view of the date.
     * @param format                 The date format
     * @param calendar               calendar
     * @param day                    How many days
     * @return                       Return date
     */
    public static void   getDate(TextView view,String format,int calendar,int day){
        view.setText(getDate(format,calendar,day));
    }
/***********************************Time format conversion*********************************************************************/
    /**
     * Time format conversion  Enter date output String.
     * @param date  date
     * @return    Return date
     */
    public static String  timeFormatAlter(Date date,String format){
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return dateFormater.format(date);
    }

    /**
     * Time format conversion Enter String output Calendar.
     * @param time    Enter time
     * @return  Return Calender
     */
    public static Calendar timeFormatAlter(String  time)  {
        SimpleDateFormat fmt =new SimpleDateFormat(TIME_DEFAULT_YMD_FORMAT);
        Calendar cal = Calendar.getInstance();
        try {
            Date date = fmt.parse(time);
            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal;
    }
/**********************************The time stamp**************************************************************/
    /**
     * Call this method to enter the timestamp input that you want to convert.
     *
     * @param time  The time stamp
     * @return Return date
     */
    public static String timestampShiftTime(long time,String format) {
        SimpleDateFormat sdr = new SimpleDateFormat(format);
//        @SuppressWarnings("unused")
//        long lcc = Long.valueOf(time);
//        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(time * 1000L));
        return times;

    }


    /**
     * Display current time
     *@param context   context
     * @param textView Displays a view of the date.Apply to textView and button
     */
    public static void setTime(Context context, final TextView textView) {


        final Calendar mCalendar=Calendar.getInstance();
        int mHour=mCalendar.get(Calendar.HOUR);
        int mMinuts=mCalendar.get(Calendar.MINUTE);

        String tvTime = (String) textView.getText();
        int hour;
        int minuts;
        if (TextUtils.isEmpty(tvTime)){
            hour = mCalendar.get(Calendar.HOUR);
            minuts = mCalendar.get(Calendar.MINUTE);
        }else {
            String[] split = tvTime.split(":");
            hour = Integer.parseInt(split[0]);
            minuts = Integer.parseInt(split[split.length - 1]);
        }

        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mCalendar.set(hourOfDay, minute);//get time
                textView.setText(DateFormat.format("hh:ss", mCalendar));//show time
            }
        },hour,minuts,true);
        timePickerDialog.show();

    }



}
