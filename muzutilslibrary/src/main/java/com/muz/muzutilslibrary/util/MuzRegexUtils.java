package com.muz.muzutilslibrary.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Muz
 * @description RegexUtils
 * @date 2018/11/13 13:23
 */

public class MuzRegexUtils {
    public MuzRegexUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isMobile(@NonNull String mobile) {
        String regex = "^1((3|5|8)[0-9]|4[5,7]|66|7[3,5-8]|9[8,9])\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobile);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
