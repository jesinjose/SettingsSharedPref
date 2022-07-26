package com.qdes.sharedpref;

import android.content.Context;

public class Utils {

    public static boolean SALES_ONLINE(Context context) {
        return SharedPref.getPrefsBoolean(context, Constants.SALES);
    }


}
