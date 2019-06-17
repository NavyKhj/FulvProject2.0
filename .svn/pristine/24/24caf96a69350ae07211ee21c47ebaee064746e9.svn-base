package com.tcps.common_module.wechat.base;

import com.tcps.common_module.http.ApiService;
import com.tcps.common_module.http.NormalObserver;
import com.tcps.common_module.http.RetrofitClient;
import com.tcps.common_module.http.RxSchedulers;
import com.tcps.common_module.utils.LogUtil;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import io.reactivex.Observable;

/**
 * 基于微信activity封装的微信登录BaseActivity
 */
public abstract class BaseWXEntryActivity extends BaseWXActivity {

    //用户登录成功后的回调
    @SuppressWarnings("SameParameterValue")
    protected abstract void onSignInSuccess(String userInfo);

    //微信发送请求到三方应用后的回调（不会用到）
    @Override
    public void onReq(BaseReq baseReq) {

    }

    //第三方应用发送请求到微信后的回调
    @Override
    public void onResp(BaseResp baseResp) {
        final String code = ((SendAuth.Resp) baseResp).code;
        //请求后台返回用户信息
        LogUtil.i("code>>>>>" + code);
        ApiService apiService = RetrofitClient.getInstance().creat(ApiService.class);
        Observable<String> observable = apiService.getUserInfo("");
        observable.compose(RxSchedulers.<String>compose())
                .as(AutoDispose.<String>autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(new NormalObserver<String>(this) {
                    @Override
                    protected void onHandleSuccess(String s) {
                        onSignInSuccess(s);
                    }
                });
    }
}
