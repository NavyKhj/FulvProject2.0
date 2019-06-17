package com.tcps.common_module.wechat.weChatUtils;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import com.tcps.common_module.baseApplication.ConfigType;
import com.tcps.common_module.baseApplication.app;
import com.tcps.common_module.wechat.WXPayUrlBean;
import com.tcps.common_module.wechat.callbacks.IWeChatPayCallback;
import com.tcps.common_module.wechat.callbacks.IWeChatSignInCallback;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by khj on 2018/9/10
 */
@SuppressWarnings("unused")
@SuppressLint("StaticFieldLeak")
public final class WeChatUtils {
    private static final String APP_ID = app.init().getConfiguration(ConfigType.WX_APP_ID);
    private final IWXAPI WXAPI;

    private IWeChatSignInCallback mSignInCallback = null;
    private IWeChatPayCallback mPayCallback = null;

    private static final class Holder {
        private static final WeChatUtils INSTANCE = new WeChatUtils();
    }

    public static WeChatUtils getInstance() {
        return Holder.INSTANCE;
    }

    private WeChatUtils() {
        WXAPI = WXAPIFactory.createWXAPI(app.getApplication(), APP_ID, true);
        WXAPI.registerApp(APP_ID);
    }

    public final IWXAPI getWXAPI() {
        return WXAPI;
    }

    public WeChatUtils onSignSuccess(IWeChatSignInCallback callback) {
        this.mSignInCallback = callback;
        return this;
    }

    public IWeChatSignInCallback getSignInCallback() {
        return mSignInCallback;
    }

    public WeChatUtils onPaySuccess(IWeChatPayCallback callback) {
        this.mPayCallback = callback;
        return this;
    }

    public IWeChatPayCallback getPayCallback() {
        return mPayCallback;
    }

    public final void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }

    public final void pay(@NonNull WXPayUrlBean payUrlBean) {
        PayReq request = new PayReq();
        request.appId = payUrlBean.getAppid();
        // 微信支付分配的商户号
        request.partnerId = payUrlBean.getPartnerid();
        // 微信返回的支付交易会话id
        request.prepayId = payUrlBean.getPrepayid();
        // 随机字符串，不长于32位，推荐随机数生成算法
        request.nonceStr = payUrlBean.getNoncestr();
        // 时间戳
        request.timeStamp = String.valueOf(payUrlBean.getTimestamp());
        // 扩展字段（暂写Sign = WXPay）
        request.packageValue = payUrlBean.getPackageX();
        // 签名
        request.sign = payUrlBean.getSign();
        final IWXAPI msgApi = WXAPIFactory.createWXAPI(app.getApplication(), null);
        msgApi.registerApp(payUrlBean.getAppid());
        msgApi.sendReq(request);
    }
}
