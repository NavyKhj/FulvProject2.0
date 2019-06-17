package com.tcps.common_module.wechat;


import com.tcps.common_module.wechat.base.BaseWXEntryActivity;
import com.tcps.common_module.wechat.weChatUtils.WeChatUtils;

/**
 * 微信登录
 */
public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onSignInSuccess(String userInfo) {
        WeChatUtils.getInstance().getSignInCallback().onSignInSuccess(userInfo);
        finish();
    }
}
