package com.shenawynkov.data.sharedPref;

import android.content.SharedPreferences;

public class PrefManger {
    private final SharedPreferences prefs;

    private final String API_KEY = "Api_key";
    private final String USER_ID = "User_id";

    public PrefManger(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public void saveApiKey(String key) {

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(API_KEY, key);
        editor.apply();

    }

    public String getApiKey() {
        return prefs.getString(API_KEY, "");
    }

    public void saveUserId(String id) {

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_ID, id);
        editor.apply();

    }

    public String getUserId() {
        return prefs.getString(USER_ID, "");
    }

    public Boolean isUserLoggedIn() {
        return getUserId() != null && getApiKey() != null;

    }

}
