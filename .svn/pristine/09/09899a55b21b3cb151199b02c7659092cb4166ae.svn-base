package com.tcps.etc_module.app;

import android.app.Application;

import com.tcps.common_module.baseApplication.app;

public class EtcApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        app.init(this)
                .InitARouter(this)
                .withApiHost("https://ic.tcps.com.cn:9407/flonline/web/")
                .withIsDebug(true)
                .Configure();
    }
}
