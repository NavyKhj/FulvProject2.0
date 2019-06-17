package com.tcps.common_module.baseMvp;

import android.os.Bundle;
import android.view.View;

import com.tcps.common_module.baseMvp.baseService.IBaseView;

/**
 * Class description
 * Mvp的baseFragment基础类
 *
 * @author WJ
 * @version 1.0, 2018-3-8
 */

@SuppressWarnings({"RedundantCast", "unchecked"})
public abstract class BaseMvpFragment<Presenter extends BasePresenter> extends BaseFragmentMore
        implements IBaseView {

    /**
     * presenter 具体的presenter由子类确定
     */
    protected Presenter mPresenter;

    /**
     * 初始化Presenter
     *
     * @return
     */
    public abstract Presenter initPresenter();

    /**
     * 初始化数据
     * <p>
     * 子类可以复写此方法初始化子类数据
     */
    public void initData(Bundle savedInstanceState, View rootView) {
        mPresenter = (Presenter) initPresenter();
        if (mPresenter != null) {
            mPresenter.attachViewM(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachViewM();
        }
    }
}
