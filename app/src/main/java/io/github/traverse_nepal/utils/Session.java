package io.github.traverse_nepal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    private SharedPreferences prefs;

    public Session(Context cntx) {
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setUsername(String username) {
        prefs.edit().putString("username", username).commit();
    }

    public String getUsername() {
        String username = prefs.getString("username","");
        return username;
    }

    public void setPassword(String password) {
        prefs.edit().putString("password", password).commit();
    }

    public String getPassword() {
        String password = prefs.getString("password","");
        return password;
    }

    public void setApiKey(String key) {
        prefs.edit().putString("key", key).commit();
    }

    public String getApiKey() {
        String key = prefs.getString("key","");
        return key;
    }

    public void setUserId(int id) {
        prefs.edit().putInt("userId", id).commit();
    }

    public int getUserId() {
        int id = prefs.getInt("userId",-1);
        return id;
    }
}
