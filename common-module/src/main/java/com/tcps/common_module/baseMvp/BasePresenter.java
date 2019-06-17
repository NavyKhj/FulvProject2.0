package com.tcps.common_module.baseMvp;

import com.tcps.common_module.baseMvp.baseService.IBaseView;

/**
 * Class description
 * 基础业务处理层
 *
 * @author WJ
 * @version 1.0, 2018-1-10
 */

@SuppressWarnings("unused")
public abstract class BasePresenter<V extends IBaseView> {

    /**
     * 绑定的view
     */
    private V mMvpView;

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    public void attachViewM(V mMvpView) {
        this.mMvpView = mMvpView;
    }

    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachViewM() {
        this.mMvpView = null;
    }

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached() {
        return mMvpView != null;
    }

    /**
     * 获取连接的view
     */
    public V getView() {
        return mMvpView;
    }
}
