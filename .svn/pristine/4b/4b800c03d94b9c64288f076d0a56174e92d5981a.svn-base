package com.tcps.common_module.baseMvp;

import android.os.Bundle;

import com.tcps.common_module.baseMvp.baseService.IBaseView;

/**
 * Created by khj on 2018-3-7.
 */

public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseAppCompatActivity
        implements IBaseView {
    /**
     * presenter 具体的presenter由子类确定
     */
    protected P mPresenter;

    /**
     * 初始化Presenter
     */
    public abstract P initPresenter();

    /**
     * MVP初始化
     */
    @SuppressWarnings({"unchecked", "RedundantCast"})
    @Override
    public void initMvp() {
        mPresenter = (P) initPresenter();
        if (mPresenter != null) {
            mPresenter.attachViewM(this);
        }
    }

    /**
     * 初始化数据
     * <p>
     * 子类可以复写此方法初始化子类数据
     */
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachViewM();
        }
    }
}
