package com.tcps.common_module.commonUI.mvp.presenter;

import android.annotation.SuppressLint;
import android.util.Log;

import com.tcps.common_module.baseApplication.app;
import com.tcps.common_module.baseMvp.BaseAppCompatActivity;
import com.tcps.common_module.baseMvp.BasePresenter;
import com.tcps.common_module.commonUI.http.ApiService;
import com.tcps.common_module.commonUI.http.FunCodeCommon;
import com.tcps.common_module.commonUI.http.entity.GetPublicKeyOutputEntity;
import com.tcps.common_module.commonUI.http.entity.GetTransferKeyOutputEntity;
import com.tcps.common_module.commonUI.http.entity.ServiceTimeOutputEntityNew;
import com.tcps.common_module.commonUI.mvp.contract.WelcomeContract;
import com.tcps.common_module.http.BaseObserver;
import com.tcps.common_module.http.CertificateHttpUtil;
import com.tcps.common_module.http.RetrofitClient;
import com.tcps.common_module.http.RxSchedulers;
import com.tcps.common_module.service.ICertificateDownloadListener;
import com.tcps.common_module.utils.AppDes;
import com.tcps.common_module.utils.Const;
import com.tcps.common_module.utils.LogUtil;
import com.tcps.common_module.utils.PreferencesUtils;
import com.tcps.common_module.utils.RsaUtil;
import com.tcps.common_module.utils.ToastUtils;
import com.tcps.common_module.utils.UUIDS;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.security.interfaces.RSAPublicKey;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.WeakHashMap;

import io.reactivex.Observable;

public class WelcomePresenter extends BasePresenter<WelcomeContract.View> implements WelcomeContract.Presenter {
    private ApiService apiService;
    private RSAPublicKey publicKey;

    public WelcomePresenter(WelcomeContract.View view) {
        attachViewM(view);
    }

    @Override
    public void certificateDownload(final BaseAppCompatActivity baseAppCompatActivity) {
        CertificateHttpUtil.getInstance().setListener(new ICertificateDownloadListener() {
            @Override
            public void downloadSuccess() {
                apiService = RetrofitClient.getInstance().creat(ApiService.class);
                getServerTime(baseAppCompatActivity);
            }

            @Override
            public void downloadFail() {
                Log.i("Welcome>>>>", "证书下载失败");
            }
        }).getCertificate(baseAppCompatActivity);
    }

    private void getServerTime(final BaseAppCompatActivity baseAppCompatActivity) {
        String Time = String.valueOf(System.currentTimeMillis());
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd:HHmmSS");
        LogUtil.i("time:::::::" + simpleDateFormat.format(System.currentTimeMillis()));
        // 传入网络请求参数
        WeakHashMap<String, String> inputBody = new WeakHashMap<>();
        inputBody.put("FUNCODE", FunCodeCommon.getServerTime);
        inputBody.put("IMEI", UUIDS.getUUID());
        inputBody.put("REQSEQ", Time);
        inputBody.put("CALLTIME", Time);
        Observable<ServiceTimeOutputEntityNew> objectObservable = apiService.getServerTime(inputBody);
        objectObservable
                .compose(RxSchedulers.<ServiceTimeOutputEntityNew>compose())
                .as(AutoDispose.<ServiceTimeOutputEntityNew>autoDisposable(AndroidLifecycleScopeProvider.from(baseAppCompatActivity)))
                .subscribe(new BaseObserver<ServiceTimeOutputEntityNew>(baseAppCompatActivity) {
                    @Override
                    protected void onHandleSuccess(ServiceTimeOutputEntityNew serviceTimeOutputEntityNew) {
                        if (serviceTimeOutputEntityNew.getRETCODE().equals("9000")) {
                            getPublicKey(baseAppCompatActivity, serviceTimeOutputEntityNew.getSERVERTIME(), WelcomePresenter.this);
                        } else {
                            ToastUtils.show(app.getApplication(), serviceTimeOutputEntityNew.getRETMSG());
                        }
                    }
                });
    }

    private void getPublicKey(final BaseAppCompatActivity baseAppCompatActivity, String serverTime, final WelcomePresenter presenter) {
        String Time = String.valueOf(System.currentTimeMillis());
        WeakHashMap<String, String> inputBody = new WeakHashMap<>();
        inputBody.put("FUNCODE", FunCodeCommon.getPublicKey);
        inputBody.put("REQSEQ", Time);
        inputBody.put("IMEI", UUIDS.getUUID());
        inputBody.put("CALLTIME", Time);
        String priParam;
        String tripPriParam = null;
        priParam = "DA" + "|" + UUIDS.getUUID() + "|" + serverTime + "|" + "1000"
                + "|" + "00000000000" + "|" + "CE";
        if (!"".equals(priParam))
            tripPriParam = AppDes.TripDESencrypt1("9911DD22FF33EE4004AA55BB66CC7788", priParam);
        inputBody.put("PRIPARAM", tripPriParam);
        Observable<GetPublicKeyOutputEntity> ob = apiService.getPublicKey(inputBody);
        ob.compose(RxSchedulers.<GetPublicKeyOutputEntity>compose())
                .as(AutoDispose.<GetPublicKeyOutputEntity>autoDisposable(AndroidLifecycleScopeProvider.from(baseAppCompatActivity)))
                .subscribe(new BaseObserver<GetPublicKeyOutputEntity>(baseAppCompatActivity) {
                    @Override
                    protected void onHandleSuccess(GetPublicKeyOutputEntity getPublicKeyOutputEntity) {
                        if (getPublicKeyOutputEntity.getRETCODE().equals("9000")) {
                            PreferencesUtils.putString(app.getApplication(), Const.PUBKEY, getPublicKeyOutputEntity.getPUBKEY());
                            getTransFerKey(baseAppCompatActivity, getPublicKeyOutputEntity.getPUBKEY(), presenter);
                        } else {
                            ToastUtils.show(app.getApplication(), getPublicKeyOutputEntity.getRETMSG());
                        }
                    }
                });
    }

    private void getTransFerKey(final BaseAppCompatActivity baseAppCompatActivity, String pubkey, final WelcomePresenter presenter) {
        String Time = String.valueOf(System.currentTimeMillis());
        WeakHashMap<String, String> inputBody = new WeakHashMap<>();
        inputBody.put("FUNCODE", FunCodeCommon.getTransferKey);
        inputBody.put("REQSEQ", Time);
        inputBody.put("IMEI", UUIDS.getUUID());
        inputBody.put("CALLTIME", Time);
        String priParam;
        if (Const.transKey.equals("9911DD22FF33EE4004AA55BB66CC7788")) {
            priParam = "!!" + "02" + Const.transKey + "@@";
        } else {
            priParam = "!!" + "04" + Const.transKey + "@@";
        }
        String jiami = null;
        try {
            publicKey = RsaUtil.getPublicKey(pubkey);
            jiami = RsaUtil.encrypt(publicKey, priParam);
            Log.i("priParam", priParam);
            Log.i("jiami", jiami);
        } catch (Exception e) {
            e.printStackTrace();
        }
        jiami = Objects.requireNonNull(jiami).replaceAll("\n", "");
        inputBody.put("PRIPARAM", jiami);
        Observable<GetTransferKeyOutputEntity> objectObservable = apiService.getTransferKey(inputBody);
        objectObservable
                .compose(RxSchedulers.<GetTransferKeyOutputEntity>compose())
                .as(AutoDispose.<GetTransferKeyOutputEntity>autoDisposable(AndroidLifecycleScopeProvider.from(baseAppCompatActivity)))
                .subscribe(new BaseObserver<GetTransferKeyOutputEntity>(baseAppCompatActivity) {
                    @Override
                    protected void onHandleSuccess(GetTransferKeyOutputEntity getTransferkeyOutputEntity) {
                        if (getTransferkeyOutputEntity.getRETCODE().equals("9000")) {
                            String tKey = getTransferkeyOutputEntity.getTKEY();
                            // 对TKey解密
                            String jiemi;
                            try {
                                jiemi = RsaUtil.decryptByPublic(publicKey, tKey);
                                Const.transKey = jiemi.substring(2, jiemi.length() - 2);
                                PreferencesUtils.putString(app.getApplication(), Const.TKEY, Const.transKey);
                                presenter.getView().loadDataSuccess(getTransferkeyOutputEntity.getRETCODE(), "");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            ToastUtils.show(app.getApplication(), getTransferkeyOutputEntity.getRETMSG());
                        }
                    }
                });
    }
}
