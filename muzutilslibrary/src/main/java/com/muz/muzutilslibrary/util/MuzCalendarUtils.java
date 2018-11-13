package com.muz.muzutilslibrary.util;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


/**
 * @description  CalendarUtils
 * @author  Muz
 * @date  2018/11/13 9:40
 */
public class MuzCalendarUtils {
    /**
     * Call system date selector
     *
     * @param textView The textView to display the time
     */
    public static void getTime(Context context,final TextView textView) {
        final Calendar c = Calendar.getInstance();//Get the default calendar
        DatePickerDialog dialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                c.set(year, monthOfYear, dayOfMonth);//Get Time
                textView.setText(DateFormat.format(MuzTimeUtils.TIME_DEFAULT_YMD_FORMAT, c));//display time
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        dialog.show();//Display time selector
    }

    /**
     * Show current time
     *
     * @param textView The textView to display the time
     */
    public static void setTime(Context context,final TextView textView) {
        final Calendar c = Calendar.getInstance();//Get the default calendar
        String s = textView.getText().toString();
        String[] split = s.split("-");
        DatePickerDialog dialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                c.set(year, monthOfYear, dayOfMonth);//Get Time
                textView.setText(DateFormat.format(MuzTimeUtils.TIME_DEFAULT_YMD_FORMAT, c));//display time
            }
        }, Integer.parseInt(split[0]), (Integer.parseInt(split[1]) - 1), Integer.parseInt(split[split.length - 1]));
        dialog.show();//Display time selector
    }

    /**
     * Display current time
     * @param context     context
     * @param textView    Displays a view of the date.Apply to textView and button
     * @param regex       regex
     * @param format     time format
     */
    public static void setTime(Context context, final TextView textView, String regex, final String format) {


        final Calendar mCalendar=Calendar.getInstance();


        String tvTime = (String) textView.getText();
        int hour;
        int minute;
        if (TextUtils.isEmpty(tvTime)){
            hour = mCalendar.get(Calendar.HOUR);
            minute = mCalendar.get(Calendar.MINUTE);
        }else {
            String[] split = tvTime.split(regex);
            hour = Integer.parseInt(split[0]);
            minute = Integer.parseInt(split[split.length - 1]);
        }

        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mCalendar.set(hourOfDay, minute);//get time
                textView.setText(DateFormat.format(format, mCalendar));//show time
            }
        },hour,minute,true);
        timePickerDialog.show();

    }
}
