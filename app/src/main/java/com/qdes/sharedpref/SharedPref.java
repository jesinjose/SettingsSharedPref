package com.qdes.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private static SharedPreferences preferences = null;
    private static final String PREF_NAME = "settings";

    private static SharedPreferences getInstance(Context context) {
        if (preferences != null)
            return preferences;
        else {
            return preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        return getInstance(context).edit();
    }

    public static void setPrefs(Context context, String prefsName, boolean prefValue) {
        getEditor(context).putBoolean(prefsName, prefValue).apply();
    }

    public static boolean getPrefsBoolean(Context context, String prefsName) {
        return getInstance(context).getBoolean(prefsName, false);
    }
}
