package com.tcps.common_module.http;

import android.content.Context;
import android.util.Log;

import com.tcps.common_module.service.IProgressCancelListener;
import com.tcps.common_module.utils.SimpleLoadDialog;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class NormalObserver<T> implements Observer<T>, IProgressCancelListener {
    private static final String TAG = "Observer";
    protected SimpleLoadDialog simpleLoadDialog;

    public NormalObserver() {
    }

    public NormalObserver(Context context) {
        simpleLoadDialog = new SimpleLoadDialog(context, this, true);
        simpleLoadDialog.show();
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
        if (simpleLoadDialog != null)
            simpleLoadDialog.dismiss();
    }

    @Override
    public void onNext(T t) {
        if (simpleLoadDialog != null)
            simpleLoadDialog.dismiss();
        if (t != null) {
            onHandleSuccess(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (simpleLoadDialog != null)
            simpleLoadDialog.dismiss();
        Log.e(TAG, "error:" + e.toString());
    }

    protected abstract void onHandleSuccess(T t);

    protected void onHandleError(String state, String msg) {
        simpleLoadDialog.dismiss();
        Log.i(TAG, "state>>>>>" + state + ":msg>>>>>" + msg);
    }

    @Override
    public void onCancelProgress() {
        onComplete();
    }
}
