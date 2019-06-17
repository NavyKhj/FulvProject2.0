package com.tcps.fulvproject.app;

import android.app.Application;

import com.tcps.common_module.baseApplication.app;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        app.init(this)
                .withApiHost("https://ic.tcps.com.cn:9407/flonline/web/")
                .InitARouter(this)
                .withIsDebug(true)
                .withQQAppId("1233131313")
                .withWXAppId("wxd590746e842ab5cf")
                .withWXSecret("")
                .Configure();
    }
}
