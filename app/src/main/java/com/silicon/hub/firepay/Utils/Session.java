package com.silicon.hub.firepay.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    public static final String LOGGED_IN = "LOGGED_IN";
    public static final String FIRST_TIME = "FIRST_TIME";
    public static final String USER_NAME = "USER_NAME";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public Session(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setusername(String username) {
        editor =prefs.edit();
        editor.putString(USER_NAME, username).apply();
    }

    public String getusername() {
        return prefs.getString(USER_NAME,"");
    }

    public void clearUser(){
        editor = prefs.edit();
        editor.putString("email", "");
        editor.putBoolean(LOGGED_IN, false);
        // editor.putString(USER_NAME, "").apply();
        editor.apply();
    }

    public void setUserEmail(String email){
        editor =prefs.edit();
        editor.putString("email", email).apply();
    }

    public boolean isLoggedIn(){
        return prefs.getBoolean(LOGGED_IN, false);
    }

    public void setLoggedInStatus(boolean status){
        editor =prefs.edit();
        editor.putBoolean(LOGGED_IN, status);
        editor.apply();
    }

    public boolean isFirstTimeStatus(){
        return prefs.getBoolean(FIRST_TIME, true);
    }

    // would generally be set to be false, so it could as well be hard-coded
    public void setFirstTimeStatus(boolean status){
        editor =prefs.edit();
        editor.putBoolean(FIRST_TIME, status);
        editor.apply();
    }
}
