package com.android.sawagi;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Vatsal on 2/2/2017.
 */

public class sUtils {

    //Common Constants
    static final private String IS_APP_OPENED = "isAppOpened";
    static final String COMMON_PREF = "common_pref";

    private static final String LOG_TAG = "swagi";
    private static final String OTP = "otp";
    private static final String MOBILE_NUMBER = "mobile_number";

    static SharedPreferences common_pref;

    public static boolean isFirstOpen(Context context) {
        common_pref = context.getSharedPreferences(COMMON_PREF, context.MODE_PRIVATE);
        boolean isAppOpened = common_pref.getBoolean(IS_APP_OPENED, false);

        if (!isAppOpened)
            setAppOpened(context);

        return !isAppOpened;
    }

    public  static void saveOtp(Context context, String otp){
        if (common_pref != null)
            common_pref = context.getSharedPreferences(COMMON_PREF, context.MODE_PRIVATE);

        common_pref.edit().putString(OTP, otp).apply();
    }

    public static boolean matchOtp(Context context, String otp){
        if (common_pref != null)
            common_pref = context.getSharedPreferences(COMMON_PREF, context.MODE_PRIVATE);

        String storedOtp = common_pref.getString(OTP, "NA");
        if (storedOtp.equals("NA") || storedOtp == null)
            return false;
        else
            return  storedOtp.equals(otp);
    }

    private static void setAppOpened(Context context) {
        if (common_pref != null)
            common_pref = context.getSharedPreferences(COMMON_PREF, context.MODE_PRIVATE);

        common_pref.edit().putBoolean(IS_APP_OPENED, true).apply();
    }

    public static void log(Object object) {
        Log.d(LOG_TAG, object.toString());
    }

    public static void showToast(Context context,String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void saveMobileNumber(Context context, String mobileNumber) {
        if (common_pref != null)
            common_pref = context.getSharedPreferences(COMMON_PREF, context.MODE_PRIVATE);

        common_pref.edit().putString(MOBILE_NUMBER, mobileNumber).apply();
    }

    public static String getMobileNumber(Context context){
        if (common_pref != null)
            common_pref = context.getSharedPreferences(COMMON_PREF, context.MODE_PRIVATE);

        return common_pref.getString(MOBILE_NUMBER, "NA");
    }
}
