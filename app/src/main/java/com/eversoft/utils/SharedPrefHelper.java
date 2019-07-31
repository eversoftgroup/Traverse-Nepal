package com.eversoft.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPrefHelper {

    public static void SetSharedFloatData(String key, Float value, Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor =sharedPref.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public static float GetSharedFloatData(String key, Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        float value = sharedPref.getFloat(key, 0f);
        return value;
    }

    public static void SetSharedStringData(String key, String value, Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor =sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String GetSharedStringData(String key, Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String value = sharedPref.getString(key, "");
        return value;
    }
}
