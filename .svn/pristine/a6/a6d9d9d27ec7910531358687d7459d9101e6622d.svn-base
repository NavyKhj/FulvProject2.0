package com.tcps.common_module.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.tcps.common_module.R;

/**
 * smartRefresh下拉刷新
 */
@SuppressWarnings("RedundantCast")
public class RefreshHeader extends LinearLayout implements com.scwang.smartrefresh.layout.api.RefreshHeader {
    private ImageView mImage;
    private AnimationDrawable refreshingAnim;
    private View view;

    public RefreshHeader(Context context) {
        super(context);
        view = View.inflate(context, R.layout.widget_custom_refresh_header, this);
        mImage = (ImageView) view.findViewById(R.id.iv_refresh_header);
    }

    public RefreshHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = View.inflate(context, R.layout.widget_custom_refresh_header, this);
        mImage = (ImageView) view.findViewById(R.id.iv_refresh_header);
    }

    public RefreshHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        view = View.inflate(context, R.layout.widget_custom_refresh_header, this);
        mImage = (ImageView) view.findViewById(R.id.iv_refresh_header);
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int extendHeight) {

    }

    /**
     * 下拉过程中不断调用
     */
    @Override
    public void onPulling(float percent, int offset, int height, int extendHeight) {
        if (percent < 1)
            mImage.setImageResource(R.mipmap.refreshing_01);
    }

    @Override
    public void onReleasing(float percent, int offset, int height, int extendHeight) {

    }

    @Override
    public void onReleased(RefreshLayout refreshLayout, int height, int extendHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int extendHeight) {

    }

    /**
     * 动画结束后调用
     */
    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        if (refreshingAnim != null && refreshingAnim.isRunning()) {
            refreshingAnim.stop();
        }
        return 0;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    /**
     * 状态改变时调用。
     *
     * @param refreshLayout .
     * @param oldState      .
     * @param newState      .
     */
    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        switch (newState) {
            case PullDownToRefresh:
                mImage.setImageResource(R.mipmap.refreshing_01);
                break;
            case Refreshing:
                mImage.setImageResource(R.drawable.refresh_refreshing);
                refreshingAnim = (AnimationDrawable) mImage.getDrawable();
                refreshingAnim.start();
                break;
            case ReleaseToRefresh:

                break;
        }
    }
}
