package com.tcps.common_module.baseMvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcps.common_module.baseMvp.baseService.BaseMvpInterface;

/**
 * Class description
 * 带有快速点击的基础的BaseFragment抽象类
 *
 * @author WJ
 * @version 1.0, 2018-3-8
 */

@SuppressWarnings("unused")
public abstract class BaseFragmentMore extends BaseFragment implements BaseMvpInterface {

    private View rootView;

    /**
     * 上次点击时间
     */
    private long lastClick = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        beforeInitView(savedInstanceState);
        if (rootView != null) {
            ViewGroup viewGroup = (ViewGroup) rootView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(getLayoutId(), container, false);
            initView(savedInstanceState, rootView);
            initData(savedInstanceState, rootView);
        }
        return rootView;
    }

    /**
     * 判断是否快速点击
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public boolean isFastClick() {
        long now = System.currentTimeMillis();
        if (now - lastClick >= 500) {
            lastClick = now;
            return false;
        }
        return true;
    }
}
