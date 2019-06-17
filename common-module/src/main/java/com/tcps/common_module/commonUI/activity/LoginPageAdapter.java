package com.tcps.common_module.commonUI.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Class description
 * 登陆页适配器
 *
 * @author WJ
 * @version 1.0, 2018-3-6
 */

public class LoginPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;

    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    LoginPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {

        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }


}