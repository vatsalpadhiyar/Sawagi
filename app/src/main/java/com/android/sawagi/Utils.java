package com.android.sawagi;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Vatsal on 2/2/2017.
 */

public class Utils {

    //Common Constants
    static final private String IS_APP_OPENED = "isAppOpened";
    static final String COMMON_PREF = "common_pref";

    private static final String LOG_TAG = "swagi";

    static SharedPreferences common_pref;

    public static boolean isFirstOpen(Context context) {
        common_pref = context.getSharedPreferences(COMMON_PREF, context.MODE_PRIVATE);
        boolean isAppOpened = common_pref.getBoolean(IS_APP_OPENED, false);

        if (!isAppOpened)
            setAppOpened(context);

        return !isAppOpened;
    }

    private static void setAppOpened(Context context) {
        if (common_pref != null)
            common_pref = context.getSharedPreferences(COMMON_PREF, context.MODE_PRIVATE);

        common_pref.edit().putBoolean(IS_APP_OPENED, true).apply();
    }

    public static void log(Object object) {
        Log.d(LOG_TAG, object.toString());
    }
}
