package com.muz.muzutilslibrary.util;

import android.content.Context;
import android.renderscript.Double2;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import java.nio.DoubleBuffer;
import java.text.DecimalFormat;

/**
 * @author Muz
 * @description GeneralUtils
 * @date 2018/2/8 11:35
 */

public class MuzGeneralUtils {
    /**
     * Get the view focus
     *
     * @param view The view to get the focus.
     */
    public static void getFocus(View view) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.requestFocusFromTouch();

    }

    /**
     * Open soft keyboard
     *
     * @param view view
     * @see #getFocusAndOpenSoftKeyboard(View)
     */
    public static void openSoftKeyboard(View view) {
        InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(view, 0);
    }

    /**
     * Close soft keyboard
     *
     * @param view view
     * @see #closeFocusAndCloseSoftKeyboard(View)
     */
    public static void closeSoftKeyboard(View view) {
        InputMethodManager m = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        m.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * Get the focus and open the soft keyboard.
     *
     * @param view view
     * @see #openSoftKeyboard(View)
     */
    public static void getFocusAndOpenSoftKeyboard(View view) {
        getFocus(view);
        InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(view, 0);
    }

    /**
     * Lose focus and close the soft keyboard.
     *
     * @param view view
     * @see #closeSoftKeyboard(View)
     */
    public static void closeFocusAndCloseSoftKeyboard(View view) {
        view.setFocusable(false);
        view.setFocusableInTouchMode(false);
        InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * Select a view, and other views uncheck the state (if the selected view is selected, change to unchecked)
     *
     * @param view                Selected view
     * @param checkedBackground   Background color when checked.
     * @param uncheckedBackground Background color when unchecked.
     * @param checked             The index of the corresponding state array.
     * @param views               view array
     * @param booleans            state array
     * @return Return the data
     */
    public static boolean[] checkedMoney(View view, @DrawableRes int checkedBackground, @DrawableRes int uncheckedBackground, int checked, View[] views, boolean[] booleans) {
        if (!booleans[checked]) {
            booleans = MuzGeneralUtils.initViewChecked(view, uncheckedBackground, views, booleans, booleans[checked]);
            booleans[checked] = true;
            view.setBackgroundResource(checkedBackground);
        } else {
            booleans[checked] = false;
            view.setBackgroundResource(uncheckedBackground);
        }
        return booleans;
    }

    /**
     * Select a textView, and other textView uncheck the state (if the selected textView is selected, change to unchecked)  Apply to textView and button.
     *
     * @param view                Selected view
     * @param checkedBackground   Background color when checked.
     * @param uncheckedBackground Background color when unchecked.
     * @param checked             The index of the corresponding state array.
     * @param views               view array
     * @param booleans            state array
     * @param checkedColor        textColor color when checked.
     * @param uncheckedColor      textColor color when unchecked.
     * @return Return the data
     */
    public static boolean[] checkedMoney(TextView view, @DrawableRes int checkedBackground, @DrawableRes int uncheckedBackground, int checked, TextView[] views, boolean[] booleans, @ColorRes int checkedColor,@ColorRes int uncheckedColor) {
        if (!booleans[checked]) {
            booleans = MuzGeneralUtils.initViewChecked(view, uncheckedBackground, views, booleans, booleans[checked], uncheckedColor);
            booleans[checked] = true;
            view.setTextColor(view.getResources().getColor(checkedColor));
            view.setBackgroundResource(checkedBackground);
        } else {
            booleans[checked] = false;
            view.setBackgroundResource(uncheckedBackground);
            view.setTextColor(view.getResources().getColor(uncheckedColor));
        }
        return booleans;
    }

    /**
     * Changes the background and state of a set of views.
     *
     * @param background background
     * @param views      view array
     * @param booleans   state array
     * @param checked    state
     * @return Returns the state of change.
     */
    public static boolean[] initViewChecked(@DrawableRes int background, View[] views, boolean[] booleans, boolean checked) {
        for (int i = 0; i < views.length; i++) {
            views[i].setBackgroundResource(background);
            booleans[i] = checked;
        }
        return booleans;
    }

    /**
     * Changes the background, state, and text color of a set of views.
     *
     * @param background background
     * @param textViews  TextView array
     * @param booleans   state array
     * @param checked    state
     * @param color      text color
     * @return Returns the state of change.
     */
    public static boolean[] initViewChecked(@DrawableRes int background, TextView[] textViews, boolean[] booleans, boolean checked, @ColorRes int color) {
        for (int i = 0; i < textViews.length; i++) {
            textViews[i].setBackgroundResource(background);
            textViews[i].setTextColor(textViews[i].getResources().getColor(color));
            booleans[i] = checked;
        }
        return booleans;
    }

    /**
     * Changes the background and state of all views, except for the selected view.
     *
     * @param view       Selected view
     * @param background background
     * @param views      view array
     * @param booleans   state array
     * @param checked    state
     * @return Returns the state of change
     */
    public static boolean[] initViewChecked(View view, @DrawableRes int background, View[] views, boolean[] booleans, boolean checked) {
        for (int i = 0; i < views.length; i++) {
            if (view != views[i]) {
                views[i].setBackgroundResource(background);
                booleans[i] = checked;
            }
        }
        return booleans;
    }

    /**
     * Changes the background, state, and text color of a set of views, except for the selected view.
     *
     * @param view       Selected view
     * @param background background
     * @param views      view array
     * @param booleans   state array
     * @param checked    state
     * @param color      text color
     * @return Returns the state of change
     */
    public static boolean[] initViewChecked(TextView view,@DrawableRes int background, TextView[] views, boolean[] booleans, boolean checked, @ColorRes int color) {
        for (int i = 0; i < views.length; i++) {
            if (view != views[i]) {
                views[i].setBackgroundResource(background);
                views[i].setTextColor(views[i].getResources().getColor(color));
                booleans[i] = checked;
            }
        }
        return booleans;
    }

    /**
     * Display content
     * @see #setText(String, TextView)
     */
    public static void setText(String data, TextView view) {
        setText(data,view,"");
    }
    /**
     * Display content
     */
    public static void setText(String data, TextView view, @NonNull String defaultData) {
        view.setText(TextUtils.isEmpty(data) ? defaultData : data);
    }
    /**
     * Display content
     * Do not set default
     */
    public static void setTextNotDefault(String data, TextView view) {
        if (!TextUtils.isEmpty(data)) {
            view.setText(data);
        }
    }

    /**
     * Set data and show or hide
     * @return   Whether the data is set successfully
     */
    public static boolean setTextOrVisibility(String data, TextView view) {
        boolean empty=TextUtils.isEmpty(data);
        view.setText(empty?"":data);
        view.setVisibility(empty?View.GONE:View.VISIBLE);
        return !empty;
    }

    /**
     * Set data and show or hide  （Keep raw data when data is wrong）
     * @return   Whether the data is set successfully
     */
    public static boolean setTextOrVisibilityNotDefault(String data, TextView view) {
        if (!TextUtils.isEmpty(data)) {
            view.setText(data);
            view.setVisibility(View.VISIBLE);
            return true;
        }else {
            view.setVisibility(View.GONE);
            return false;
        }
    }

    /**
     * Set the title and content and set the corresponding color
     */
    public static void setText(String details, TextView view, String title, String titleColor, String detailsColor) {
        if (!TextUtils.isEmpty(details)&&!TextUtils.isEmpty(title)) {
            String str = "<font color=\"" + titleColor + "\">" + title + "</font><font color=\"" + detailsColor + "\">" + details + "</font>";
            view.setText(Html.fromHtml(str));
        }
    }
    /**
     * String to Double
     */
    public static Double stringToDouble(String data) {
       return TextUtils.isEmpty(data)?0.00: TextUtils.isDigitsOnly(data)?Double.valueOf(data):0.00;
    }

    /**
     *  Compares this string to the specified string.
     *
     *  Prevent error reporting when the data is empty
     */
    public static boolean equals(String data,String otherData){
        return !TextUtils.isEmpty(data)&&!TextUtils.isEmpty(otherData)&&data.equals(otherData);
    }
}
