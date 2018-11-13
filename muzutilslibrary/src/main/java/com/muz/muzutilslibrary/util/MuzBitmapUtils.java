package com.muz.muzutilslibrary.util;

import android.graphics.Bitmap;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * @description  BitmapUtils
 * @author  Muz
 * @date  2018/11/13 9:40
 */
public class MuzBitmapUtils {

    /**
     * Convert Bitmap to Base64 String via Base32
     *
     * @param bit Bitmap
     * @return Base64 string
     */
    public static String bitmap2StrByBase64(Bitmap bit) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG, 100, bos);//Parameter 100 means no compression
        byte[] bytes = bos.toByteArray();
        return "data:image/jpg;base64,"+Base64.encodeToString(bytes, Base64.DEFAULT);
    }
}
