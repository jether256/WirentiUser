package com.jether.wirentiuserapp.Sessions;

import android.content.Context;
import android.content.SharedPreferences;



import java.util.HashMap;

public class SharedPrefManager {

    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    private Context mCtx;
    int PRIVATE_MODE = 0;

    private static final String SHARED_PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String NAME = " NAME ";
    public static final String EMAIL = "EMAIL";
    public static final String USERTYPE = "USERTYPE";
    public static final String MOBILE = "MOBILE";
    public static final String PASSWORD = "PASSWORD";
    public static final String ABOUTME = "ABOUTME";
    public static final String ID = "ID";


    public SharedPrefManager(Context mCtx) {
        this.mCtx = mCtx;
        sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();

    }

//    public static synchronized  SharedPrefManager getInstance(Context mCtx){
//        if(mInstance==null){
//            mInstance= new SharedPrefManager(mCtx);
//        }
//        return mInstance;
//    }


    public void createSession(String user_id,String user_namee,String user_emaill,String user_typp,String user_moo,String user_passs,String user_aboutsss ) {
        editor.putBoolean(LOGIN, true);
        editor.putString(ID, user_id);
       editor.putString(NAME, user_namee);
        editor.putString(EMAIL, user_emaill);
        editor.putString(USERTYPE, user_typp);
       editor.putString(MOBILE, user_moo);
        editor.putString(PASSWORD, user_passs);
        editor.putString(ABOUTME, user_aboutsss);
        editor.apply();
    }

    public  boolean isLogin() {
        return sharedPreferences.getBoolean(LOGIN, false);
    }


    public HashMap<String, String> getUserDetail() {

    HashMap<String, String> user = new HashMap<>();
    user.put(ID,sharedPreferences.getString(ID,null));
    user.put(NAME,sharedPreferences.getString(NAME,null));
    user.put(EMAIL,sharedPreferences.getString(EMAIL,null));
    user.put(USERTYPE,sharedPreferences.getString(USERTYPE,null));
    user.put(MOBILE,sharedPreferences.getString(MOBILE,null));
    user.put(PASSWORD,sharedPreferences.getString(PASSWORD,null));
    user.put(ABOUTME,sharedPreferences.getString(ABOUTME,null));

    return user;
    }





}
