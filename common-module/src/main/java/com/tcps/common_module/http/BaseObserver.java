package com.tcps.common_module.http;

import android.content.Context;

import com.tcps.common_module.utils.LogUtil;

import io.reactivex.disposables.Disposable;

/**
 * Created by khj on 2017-12-25.
 */

public abstract class BaseObserver<T extends HttpResponse> extends NormalObserver<T> {
    private static final String TAG = "BaseObserver";

    protected BaseObserver(Context context) {
        super(context);
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        LogUtil.i(TAG);
        if (simpleLoadDialog != null) {
            simpleLoadDialog.dismiss();
        }
        if (t.getRETCODE() != null && t.getRETCODE().equals("9000")) {
            onHandleSuccess(t);
        } else {
            onHandleError(t.getRETCODE(), t.getRETMSG());
        }
    }
}
