package com.example.wanandroid.base;

import android.app.Application;

/**
 * @author :created by ${ WYW }
 * 时间：2019/3/20 14
 */
public class MyApp extends Application {
    private static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public static synchronized MyApp getInstance(){
        return instance;
    }

}
