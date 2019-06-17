package com.tcps.common_module.wechat.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tcps.common_module.wechat.weChatUtils.WeChatUtils;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;


/**
 * 基础的微信activity
 */
public abstract class BaseWXActivity extends AppCompatActivity implements IWXAPIEventHandler {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeChatUtils.getInstance().getWXAPI().handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        WeChatUtils.getInstance().getWXAPI().handleIntent(getIntent(), this);
    }
}
