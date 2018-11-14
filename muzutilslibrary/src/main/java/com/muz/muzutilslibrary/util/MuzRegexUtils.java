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

    /**
     * mobile regex
     * Mobile: 134,135,136,137,138,139,147,150,151,152,157,158,159,178,182,183,184,187,188,198
     * Unicom: 130,131,132,145,155,156,166,175,176,185,186
     * Telecom:133,153,180,173,177,180,181,189,199
     * Satellite:1349
     */
    public static final String MOBILE_REGEX = "^1((3|5|8)[0-9]|4[57]|66|7[35-8]|9[89])\\d{8}$";
    /**
     * email regex
     */
    public static final String EMAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    /**
     * Judging the mobile number
     * @param mobile  China mobile number to be judged
     * @return    result
     */
    public static boolean isMobile(@NonNull String mobile) {
        return regex(mobile,MOBILE_REGEX);
    }

    /**
     * Judging email
     * @param email   email to be judged
     * @return
     */
    public static boolean isEmail(@NonNull String email){
        return regex(email,EMAIL_REGEX);
    }

    /**
     * regex judgment
     * @param data       Data to be judged
     * @param regex      regex
     * @return           result
     */
    public static boolean regex(@NonNull String data,@NonNull String regex){
        if (TextUtils.isEmpty(data)){
            return false;
        }
        if (TextUtils.isEmpty(regex)){
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
