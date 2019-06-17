package com.tcps.common_module.Alipay;

import android.annotation.SuppressLint;
import android.app.Activity;

import com.alipay.sdk.app.PayTask;
import com.tcps.common_module.R;
import com.tcps.common_module.baseApplication.app;
import com.tcps.common_module.http.NormalObserver;
import com.tcps.common_module.http.RxSchedulers;
import com.tcps.common_module.utils.ToastUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;


public class AliPay {
    @SuppressLint("StaticFieldLeak")
    private static Activity activity;

    private static final class Holder {
        @SuppressLint("StaticFieldLeak")
        static final AliPay ALI_PAY = new AliPay();
    }

    public static AliPay getInstance(Activity activity) {
        AliPay.activity = activity;
        return Holder.ALI_PAY;
    }

    private IAliPayCallback payOkDo;//支付成功回调
    private IAliPayCallback payFailDo;//支付失败回调

    public AliPay onPaySuccess(IAliPayCallback cb_ok) {
        payOkDo = cb_ok;
        return Holder.ALI_PAY;
    }

    @SuppressWarnings("unused")
    public AliPay setFailCallback(IAliPayCallback cb_ok) {
        payFailDo = cb_ok;
        return Holder.ALI_PAY;
    }

    /**
     * call alipay sdk pay. 调用SDK支付
     */
    public void pay(@NonNull final String orderInfo) {
        Observable.create(new ObservableOnSubscribe<String>() {
            @SuppressWarnings("RedundantThrows")
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(activity);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(orderInfo, true);
                emitter.onNext(result);
            }
        }).compose(RxSchedulers.<String>compose())
                .subscribe(new NormalObserver<String>() {
                    @Override
                    protected void onHandleSuccess(String s) {
                        PayResult payResult = new PayResult(s);
                        switch (payResult.getResultStatus()) {
                            case "9000":
                                if (payOkDo != null) {
                                    payOkDo.onPaySuccess();
                                }
                                break;
                            case "8000":
                                ToastUtils.show(app.getApplication(), app.getApplication().getString(R.string.pay_result_confirmation));
                                if (payFailDo != null) {
                                    payOkDo.onPaySuccess();
                                }
                                break;
                            default:
                                ToastUtils.show(app.getApplication(), app.getApplication().getString(R.string.pay_failure));
                                // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                                if (payFailDo != null) {
                                    payFailDo.onPaySuccess();
                                }
                                break;
                        }
                    }
                });
    }
}
