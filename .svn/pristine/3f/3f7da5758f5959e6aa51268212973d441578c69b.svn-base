package com.tcps.common_module.commonUI.mvp.presenter;

import com.tcps.common_module.baseApplication.app;
import com.tcps.common_module.baseMvp.BaseMvpFragment;
import com.tcps.common_module.baseMvp.BasePresenter;
import com.tcps.common_module.commonUI.http.ApiService;
import com.tcps.common_module.commonUI.http.FunCodeCommon;
import com.tcps.common_module.commonUI.http.entity.LoginOutputEntity;
import com.tcps.common_module.commonUI.mvp.contract.LoginContract;
import com.tcps.common_module.http.BaseObserver;
import com.tcps.common_module.http.RetrofitClient;
import com.tcps.common_module.http.RxSchedulers;
import com.tcps.common_module.utils.AppDes;
import com.tcps.common_module.utils.Const;
import com.tcps.common_module.utils.MosaicSign;
import com.tcps.common_module.utils.PreferencesUtils;
import com.tcps.common_module.utils.RsaUtil;
import com.tcps.common_module.utils.ToastUtils;
import com.tcps.common_module.utils.UUIDS;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import org.json.JSONException;

import java.security.interfaces.RSAPublicKey;
import java.util.WeakHashMap;

import io.reactivex.Observable;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    private ApiService apiService = RetrofitClient.getInstance().creat(ApiService.class);

    public LoginPresenter(LoginContract.View view) {
        attachViewM(view);
    }

    @Override
    public void toLogin(BaseMvpFragment fragment, String name, String psw, String loginType) {
        String Time = String.valueOf(System.currentTimeMillis());
        WeakHashMap<String, String> inputBody = new WeakHashMap<>();
        inputBody.put("FUNCODE", FunCodeCommon.login);
        inputBody.put("REQSEQ", Time);
        inputBody.put("IMEI", UUIDS.getUUID());
        inputBody.put("MOBILE", name);
        inputBody.put("TYPE", loginType);
        inputBody.put("CALLTIME", Time);
        RSAPublicKey publicKey;
        String jmPsw = null;
        try {
            publicKey = RsaUtil.getPublicKey(PreferencesUtils.getString(app.getApplication(), Const.PUBKEY));
            String jm = RsaUtil.encrypt(publicKey, psw);
            jm = jm.replaceAll("\r\n", "");
            jmPsw = jm.replaceAll("\n", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        inputBody.put("PASSWORD", jmPsw);
        String params[] = {"FUNCODE", "REQSEQ", "IMEI", "MOBILE", "CALLTIME", "PASSWORD", "TYPE"};
        String sign = null;
        try {
            sign = AppDes.MD5(MosaicSign.getSignParm(inputBody, params));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        inputBody.put("SIGN", sign);
        Observable<LoginOutputEntity> objectObservable = apiService.login(inputBody);
        objectObservable
                .compose(RxSchedulers.<LoginOutputEntity>compose())
                .as(AutoDispose.<LoginOutputEntity>autoDisposable(AndroidLifecycleScopeProvider.from(fragment)))
                .subscribe(new BaseObserver<LoginOutputEntity>(fragment.getContext()) {
                    @Override
                    protected void onHandleSuccess(LoginOutputEntity loginOutputEntity) {
                        ToastUtils.show(app.getApplication(), loginOutputEntity.getRETMSG());
                    }
                });
    }

    @Override
    public void toRegister(BaseMvpFragment fragment, String name, String psw, String verify) {
    }

    @Override
    public void toVerify(BaseMvpFragment fragment, String name, String verifyType) {
    }
}
