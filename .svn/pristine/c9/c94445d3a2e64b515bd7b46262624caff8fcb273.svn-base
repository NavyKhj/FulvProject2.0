package com.tcps.common_module.baseMvp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.tcps.annotations_module.PayEntryGenerator;
import com.tcps.common_module.R;
import com.tcps.common_module.baseMvp.baseService.BaseInterface;
import com.tcps.common_module.wechat.WXPayEntryTemplate;

import java.util.Objects;

/**
 * Class description
 * Activity的通用基础抽象类
 *
 * @author WJ
 * @version 1.0, 2018-1-10
 */
@SuppressWarnings("unused")
@PayEntryGenerator(packageName = "com.tcps.fulvproject", PayentryTemplete = WXPayEntryTemplate.class)
public abstract class BaseAppCompatActivity extends BasePermissionActivity implements BaseInterface {
    @Nullable
    private TextView mToolbarTitle;
    protected boolean isTransAnim;
    /**
     * 上次点击时间
     */
    private long lastClick = 0;

    @SuppressWarnings("RedundantCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(null);
        beforeInitView(savedInstanceState);
        setContentView(getLayoutId());
        isTransAnim = true;
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        if (mToolbarTitle != null) {
            mToolbarTitle.setText(getTitle());
            Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        }
        initMvp();
        initView(savedInstanceState);
        initData(savedInstanceState);
        if (null != getToolbar() && isShowBacking()) {
            showBack();
        }
        if (isTransAnim)
            overridePendingTransition(R.anim.slide_right_in, 0);
    }

    public Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    /**
     * 获取头部标题的TextView
     */
    public TextView getToolbarTitle() {
        return mToolbarTitle;
    }

    public enum GravityType {
        CENTER,
        RIGHT
    }

    @SuppressLint("RtlHardcoded")
    public void setToolBarTitle(@Nullable CharSequence title, @Nullable GravityType gravityType) {
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) mToolbarTitle.getLayoutParams();
        switch (Objects.requireNonNull(gravityType)) {
            case CENTER:
                layoutParams.gravity = Gravity.CENTER;
                setToolBar(title, layoutParams);
                break;
            case RIGHT:
                layoutParams.gravity = Gravity.RIGHT;
                layoutParams.rightMargin = 20;
                setToolBar(title, layoutParams);
                break;
        }

    }

    private void setToolBar(@Nullable CharSequence title, @Nullable Toolbar.LayoutParams layoutParams) {
        if (mToolbarTitle != null) {
            mToolbarTitle.setLayoutParams(layoutParams);
            getToolbar().setVisibility(View.VISIBLE);
            mToolbarTitle.setText(title);
            mToolbarTitle.setCompoundDrawables(null, null, null, null); //设置无图标
        } else {
            getToolbar().setTitle(title);
            setSupportActionBar(getToolbar());
        }
    }

    /**
     * 版本号小于21的后退按钮图片
     */
    protected void showBack() {
        //setNavigationIcon必须在setSupportActionBar(toolbar);方法后面加入
        getToolbar().setNavigationIcon(R.drawable.back_selector);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFastClick()) {
                    finish();
                }
            }
        });
    }

    /**
     * 是否显示后退按钮,默认显示,可在子类重写该方法.
     */
    protected boolean isShowBacking() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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

    @Override
    public void finish() {
        super.finish();
        if (isTransAnim)
            overridePendingTransition(0, R.anim.slide_right_out);
    }

    /**
     * 是否使用overridePendingTransition过度动画
     *
     * @return 是否使用overridePendingTransition过度动画，默认使用
     */
    protected boolean isTransAnim() {
        return isTransAnim;
    }

    /**
     * 设置是否使用overridePendingTransition过度动画
     */
    protected void setIsTransAnim(boolean b) {
        isTransAnim = b;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                if (Objects.requireNonNull(v).getWindowToken() != null) {
                    hiddenKeyboard();
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v     视图
     * @param event 视图事件
     * @return 返回
     */
    public boolean isShouldHideKeyboard(View v, MotionEvent event) {
        try {
            v.getParent().requestDisallowInterceptTouchEvent(true);//通知父控件勿拦截本控件touch事件
            if (v instanceof EditText) {
                int[] l = {0, 0};
                v.getLocationInWindow(l);
                int left = l[0],
                        top = l[1],
                        bottom = top + v.getHeight(),
                        right = left + v.getWidth();
                // 点击EditText的事件，忽略它。
                return event.getX() <= left || event.getX() >= right
                        || event.getY() <= top || event.getY() >= bottom;
            }
        } catch (Exception e) {
            return false;
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上，和用户用轨迹球选择其他的焦点
        return false;
    }

    /**
     * 隐藏键盘
     */
    protected void hiddenKeyboard() {
        //点击空白位置 隐藏软键盘
        InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService
                (INPUT_METHOD_SERVICE);
        if (mInputMethodManager != null) {
            mInputMethodManager.hideSoftInputFromWindow(Objects.requireNonNull(this
                    .getCurrentFocus()).getWindowToken(), 0);
        }
    }
}
