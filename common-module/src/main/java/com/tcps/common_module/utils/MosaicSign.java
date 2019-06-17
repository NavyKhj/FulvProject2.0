package com.tcps.common_module.utils;

import android.util.Log;

import com.tcps.common_module.baseApplication.app;

import org.json.JSONException;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.WeakHashMap;

/**
 * Created by khj on 2018-3-13.
 */

@SuppressWarnings("ALL")
public class MosaicSign {
    /**
     * 获取SIGN
     *
     * @param args a
     * @return a
     * @throws JSONException e
     */

    public static String getSignParm(WeakHashMap tmp, String[] args)
            throws JSONException {
        Arrays.sort(args);
        StringBuffer strb = new StringBuffer();
        int length = args.length;
        for (int i = 0; i < length; i++) {
            String value = tmp.get(args[i]).toString();
            if (value == null || "".equals(value.trim()))
                continue;
            if (i == length - 1) {
                strb.append(args[i]).append("=").append(value);
            } else
                strb.append(args[i]).append("=").append(value).append("&");
        }
        int strb_len = strb.length();
        if (strb_len > 0) {
            if (strb.substring(strb_len - 1).equals("&")) {
                strb = strb.delete(strb_len - 1, strb_len);
            }
        }
        strb.append(PreferencesUtils.getString(app.getApplication(), Const.TKEY));
        Log.d("0000", "SIGN 明文===" + strb.toString().replaceAll("\n", ""));
        Log.d("1111", "SIGN 明文===" + strb.toString());
        return strb.toString().replaceAll("\n", "");
    }

    public static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] btInput = s.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
