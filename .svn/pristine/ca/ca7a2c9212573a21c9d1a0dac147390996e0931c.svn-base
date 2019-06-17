package com.tcps.common_module.wechat.base;

import com.tcps.common_module.R;
import com.tcps.common_module.baseApplication.app;
import com.tcps.common_module.utils.ToastUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

/**
 * 基于BaseWXActivity封装的微信支付BaseActivity
 */
public abstract class BaseWXPayActivity extends BaseWXActivity {
    //用户登录成功后的回调
    protected abstract void onPaySuccess();

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        switch (baseResp.getType()) {
            case ConstantsAPI.COMMAND_PAY_BY_WX:
                if (baseResp.errCode == 0) {
                    onPaySuccess();
                } else {
                    ToastUtils.show(app.getApplication(), app.getApplication().getString(R.string.pay_failure));
                    finish();
                }
                break;
        }
    }
}
