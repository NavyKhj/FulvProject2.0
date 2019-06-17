package com.tcps.common_module.qq;

import android.annotation.SuppressLint;
import android.app.Activity;

import com.tcps.common_module.R;
import com.tcps.common_module.baseApplication.ConfigType;
import com.tcps.common_module.baseApplication.app;
import com.tcps.common_module.utils.LogUtil;
import com.tcps.common_module.utils.ToastUtils;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

public class QQUtils {
    private static final String APP_ID = app.init().getConfiguration(ConfigType.QQ_APP_ID);
    private Tencent mTencent;
    @SuppressLint("StaticFieldLeak")
    private static Activity activity;
    private static final String TAG = "QQUtils";
    private IQQSignInCallback callback;
    public static BaseUiListener baseUiListener;

    private static final class Holder {
        @SuppressLint("StaticFieldLeak")
        private static final QQUtils QQ_UTILS = new QQUtils();
    }

    public static QQUtils getInstance(Activity activity) {
        QQUtils.activity = activity;
        return Holder.QQ_UTILS;
    }

    public QQUtils() {
        mTencent = Tencent.createInstance(APP_ID, app.getApplication());
    }

    public final void signIn(IQQSignInCallback callback) {
        this.callback = callback;
        baseUiListener = new BaseUiListener();
        mTencent.login(activity, "all", baseUiListener);
    }

    private class BaseUiListener implements IUiListener {
        /**
         * 登录成功
         *
         * @param response 返回信息
         */
        @Override
        public void onComplete(Object response) {
            ToastUtils.show(app.getApplication(), app.getApplication().getString(R.string.empowerment_success));
            LogUtil.i(TAG, "response:" + response.toString());
            try {
                JSONObject obj = (JSONObject) response;
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken, expires);
                QQToken qqToken = mTencent.getQQToken();
                UserInfo mUserInfo = new UserInfo(app.getApplication(), qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object o) {
                        LogUtil.i("oooooo" + o.toString());
                        callback.onSignInSuccess();
                    }

                    @Override
                    public void onError(UiError uiError) {
                        LogUtil.e(TAG, "登录失败" + uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        LogUtil.e(TAG, "登录取消");
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            LogUtil.e(TAG, "登录失败" + uiError.toString());
        }

        @Override
        public void onCancel() {
            LogUtil.e(TAG, "登录取消");
        }
    }

    public interface IQQSignInCallback {
        void onSignInSuccess();
    }
}
