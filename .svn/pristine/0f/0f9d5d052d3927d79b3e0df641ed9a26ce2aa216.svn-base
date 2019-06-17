package com.tcps.common_module.baseApplication;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tcps.common_module.utils.LogUtil;

import java.util.HashMap;

/**
 * application初始化全局常量
 */
public class Configurator {
    private static final HashMap<String, Object> APP_CONFIGS = new HashMap<>();

    Configurator() {
        APP_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public final HashMap<String, Object> getAppConfigs() {
        return APP_CONFIGS;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void Configure() {
        APP_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) APP_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")
    public final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) APP_CONFIGS.get(key.name());
    }

    public final Configurator withApiHost(String host) {
        APP_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    public final Configurator withIsDebug(Boolean isDebug) {
        LogUtil.isDebug = isDebug;
        if (isDebug) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        return this;
    }

    public final Configurator withQQAppId(String QQAppId) {
        APP_CONFIGS.put(ConfigType.QQ_APP_ID.name(), QQAppId);
        return this;
    }
    public final Configurator withWXAppId(String wxAppId) {
        APP_CONFIGS.put(ConfigType.WX_APP_ID.name(), wxAppId);
        return this;
    }

    public final Configurator withWXSecret(String secret) {
        APP_CONFIGS.put(ConfigType.WX_SECRET.name(), secret);
        return this;
    }

    public final Configurator InitARouter(Application application) {
        ARouter.init(application);
        return this;
    }

}
