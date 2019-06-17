package com.tcps.common_module.wechat;

import com.tcps.common_module.wechat.base.BaseWXPayActivity;
import com.tcps.common_module.wechat.weChatUtils.WeChatUtils;

/**
 * 微信支付
 */
public class WXPayEntryTemplate extends BaseWXPayActivity {

    @Override
    protected void onPaySuccess() {
        WeChatUtils.getInstance().getPayCallback().onPaySuccess();
        finish();
    }
}
