package com.tcps.etc_module.mvp.presenter;

import com.tcps.common_module.baseApplication.app;
import com.tcps.common_module.baseMvp.BaseAppCompatActivity;
import com.tcps.common_module.baseMvp.BasePresenter;
import com.tcps.common_module.http.BaseObserver;
import com.tcps.common_module.http.RetrofitClient;
import com.tcps.common_module.http.RxSchedulers;
import com.tcps.common_module.utils.ToastUtils;
import com.tcps.common_module.utils.UUIDS;
import com.tcps.etc_module.http.ApiService;
import com.tcps.etc_module.http.outputEntity.ServiceTimeOutputEntityNew;
import com.tcps.etc_module.mvp.contract.TestContract;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.util.WeakHashMap;

import io.reactivex.Observable;

public class TestPresenter extends BasePresenter<TestContract.View> implements TestContract.Presenter {
    private ApiService apiService = RetrofitClient.getInstance().creat(ApiService.class);

    public TestPresenter(TestContract.View view) {
        attachViewM(view);
    }

    @Override
    public void getServiceTime(BaseAppCompatActivity appCompatActivity) {
        // 传入网络请求参数
        WeakHashMap<String, String> inputBody = new WeakHashMap<>();
        inputBody.put("FUNCODE", "1003");
        inputBody.put("IMEI", UUIDS.getUUID());
        inputBody.put("REQSEQ", String.valueOf(System.currentTimeMillis()));
        inputBody.put("CALLTIME", String.valueOf(System.currentTimeMillis()));
        Observable<ServiceTimeOutputEntityNew> objectObservable = apiService.getServerTime(inputBody);
        objectObservable
                .compose(RxSchedulers.<ServiceTimeOutputEntityNew>compose())
                .as(AutoDispose.<ServiceTimeOutputEntityNew>autoDisposable(AndroidLifecycleScopeProvider.from(appCompatActivity)))
                .subscribe(new BaseObserver<ServiceTimeOutputEntityNew>(appCompatActivity) {
                    @Override
                    protected void onHandleSuccess(ServiceTimeOutputEntityNew serviceTimeOutputEntityNew) {
                        ToastUtils.show(app.getApplication(), serviceTimeOutputEntityNew.RETMSG);
                    }
                });
        //先加载缓存再请求网络的缓存
        /*Observable<ServiceTimeOutputEntityNew> ob = apiService.getServerTime(serviceTimeInputEntity)
                .compose(RxSchedulers.<ServiceTimeOutputEntityNew>composeCache(activity));
        Observable<ServiceTimeOutputEntityNew> obdb = Observable.create(new ObservableOnSubscribe<ServiceTimeOutputEntityNew>() {
            @Override
            public void subscribe(ObservableEmitter<ServiceTimeOutputEntityNew> e) throws Exception {
                ServiceTimeOutputEntityNew serviceTimeOutputEntityNew = new DiskCacheManager<ServiceTimeOutputEntityNew>(
                        activity).getSerializable("1");
                if (serviceTimeOutputEntityNew != null) {
                    LogUtil.i("dis>>>>", serviceTimeOutputEntityNew.getRETCODE());
                    e.onNext(serviceTimeOutputEntityNew);
                }
                e.onComplete();
            }
        }).compose(RxSchedulers.<ServiceTimeOutputEntityNew>compose(activity));
        Observable.concat(obdb, ob).subscribe(new BaseObserver<ServiceTimeOutputEntityNew>(activity) {
            @Override
            protected void onHandleSuccess(ServiceTimeOutputEntityNew serviceTimeOutputEntityNew) {
                LogUtil.i("onNext", serviceTimeOutputEntityNew.getRETMSG());
            }
        });
    }*/
    }
}
//rxcache缓存请求方式
        /*RetrofitClient.getInstance().getCache(ServiceTimeCacheProviders.class)
                .getServiceTime(ob, new DynamicKey("1"), new EvictDynamicKey(false))
                .compose(RxSchedulers.<ServiceTimeOutputEntityNew>compose(this))
                .subscribe(new BaseObserver<ServiceTimeOutputEntityNew>() {
                    @Override
                    protected void onHandleSuccess(ServiceTimeOutputEntityNew serviceTimeOutputEntityNew) {
                        Log.i("cache>>>", serviceTimeOutputEntityNew.getRETMSG());
                    }
                });*/

//不加缓存的请求
        /*ob.compose(RxSchedulers.<ServiceTimeOutputEntityNew>compose(this))
                .subscribe(new BaseObserver<ServiceTimeOutputEntityNew>() {
                    @Override
                    protected void onHandleSuccess(ServiceTimeOutputEntityNew serviceTimeOutputEntityNew) {
                        serverTime = serviceTimeOutputEntityNew.getSERVERTIME();
                    }
                });*/