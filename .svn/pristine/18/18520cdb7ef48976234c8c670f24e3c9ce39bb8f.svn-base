package com.tcps.common_module.http;


import com.tcps.common_module.baseApplication.app;
import com.tcps.common_module.utils.DiskCacheManager;
import com.tcps.common_module.utils.NetUtil;
import com.tcps.common_module.utils.ToastUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by khj on 2017-12-25.
 */

public class RxSchedulers {
    public static <T> ObservableTransformer<T, T> compose() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) {
                                if (!NetUtil.isConnected(app.getApplication())) {
                                    ToastUtils.show(app.getApplication(), "请先连接网络");
                                }
                            }
                        });
            }
        };
    }

    public static <T> ObservableTransformer<T, T> composeCache() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(new Consumer<T>() {
                            @Override
                            public void accept(T t) {
                                new DiskCacheManager<T>(app.getApplication()).put("1", t);
                            }
                        });
            }
        };
    }
}
