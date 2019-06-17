package com.tcps.fulvproject.ui.activity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tcps.common_module.baseMvp.BaseAppCompatActivity;
import com.tcps.fulvproject.R;

@Route(path = "/app/TestActivity")
public class TestActivity extends BaseAppCompatActivity {
    @Override
    public void beforeInitView(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setToolBarTitle("test", GravityType.CENTER);
    }

    @Override
    public void initMvp() {
//        ARouter.getInstance().build("/etc/EtcActivity").navigation();
        /*AliPay.getInstance(this)
                .onPaySuccess(new IAliPayCallback() {

                    @Override
                    public void onPaySuccess() {

                    }
                }).pay("");

        WeChatUtils.getInstance(*//*this*//*)
                .onPaySuccess(new IWeChatPayCallback() {
                    @Override
                    public void onPaySuccess() {

                    }
                }).pay(new WXPayUrlBean());*/
    }

    @Override
    public void initData(Bundle bundle) {

    }
}
