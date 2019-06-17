package com.tcps.fulvproject.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.tcps.common_module.baseMvp.BaseAppCompatActivity;
import com.tcps.fulvproject.R;
import com.tcps.fulvproject.ui.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/app/MainActivity")
public class MainActivity extends BaseAppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    @BindView(R.id.navigation_content)
    FrameLayout navigationContent;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    private HomeFragment homeFragment;

    @Override
    public void beforeInitView(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.setBarBackgroundColor(R.color.navigation_bg);
        //滚动隐藏
        bottomNavigationBar.setAutoHideEnabled(false);
        //默认item背景
        bottomNavigationBar.setInActiveColor(R.color.navigation_item_bg);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.home, getString(R.string.home)))
                .addItem(new BottomNavigationItem(R.mipmap.vehicle_service, getString(R.string.vehicle_service)))
                .addItem(new BottomNavigationItem(R.mipmap.mine, getString(R.string.mine)))
                .addItem(new BottomNavigationItem(R.mipmap.forum, getString(R.string.forum)))
                .setFirstSelectedPosition(0)
                .initialise();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    @Override
    public void initMvp() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.replace(R.id.navigation_content, homeFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                transaction.replace(R.id.navigation_content, homeFragment);
                transaction.commitAllowingStateLoss();
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
