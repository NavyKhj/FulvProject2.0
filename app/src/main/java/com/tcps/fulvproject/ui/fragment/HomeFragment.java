package com.tcps.fulvproject.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.tcps.common_module.baseAdapter.BaseRecycleAdapter;
import com.tcps.common_module.baseAdapter.LinearDividerItemDecoration;
import com.tcps.common_module.baseMvp.BaseFragmentMore;
import com.tcps.common_module.utils.LogUtil;
import com.tcps.common_module.utils.ToastUtils;
import com.tcps.fulvproject.R;
import com.tcps.fulvproject.entity.HomeHorRecycleEntity;
import com.tcps.fulvproject.ui.adapter.HomeHorRecycleAdapter;
import com.tcps.fulvproject.ui.adapter.HomeVerRecycleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGALocalImageSize;

/**
 * Create by khj on 2019-1-7
 **/
public class HomeFragment extends BaseFragmentMore {
    @BindView(R.id.backdrop)
    BGABanner backdrop;
    @BindView(R.id.home_toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    Unbinder unbinder;
    @BindView(R.id.horizontal_recycle)
    RecyclerView horizontalRecycle;
    @BindView(R.id.vertical_recycle)
    RecyclerView verticalRecycle;
    @BindView(R.id.nest_scroll)
    NestedScrollView nestScroll;

    @Override
    public void beforeInitView(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(Bundle savedInstanceState, View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
        settingToolbar();
        settingRecycle();
    }

    private void settingRecycle() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecycle.setLayoutManager(linearLayoutManager);
        horizontalRecycle.addItemDecoration(
                new LinearDividerItemDecoration(Objects.requireNonNull(getActivity()),
                        R.drawable.custom_divider_green,
                        LinearLayoutManager.HORIZONTAL));
        final List<HomeHorRecycleEntity> list_hor = addListEntity("Hor");
        HomeHorRecycleAdapter adapter = new HomeHorRecycleAdapter(list_hor, 1);
        horizontalRecycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
//                ToastUtils.show(getActivity(), Objects.requireNonNull(list_hor).get(position).getText());
                LogUtil.i(Objects.requireNonNull(list_hor).get(position).getText());
            }
        });
        verticalRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        verticalRecycle.addItemDecoration(new LinearDividerItemDecoration(getActivity(),
                R.drawable.custom_divider_white,
                LinearLayoutManager.VERTICAL));
        final List<HomeHorRecycleEntity> list_ver = addListEntity("Ver");
        HomeVerRecycleAdapter homeVerRecycleAdapter = new HomeVerRecycleAdapter(list_ver, 1);
        verticalRecycle.setAdapter(homeVerRecycleAdapter);
        homeVerRecycleAdapter.setOnItemClickListener(new BaseRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                ToastUtils.show(getActivity(), Objects.requireNonNull(list_ver).get(position).getText());
            }
        });
    }

    private void settingToolbar() {
        View mAppBarChildAt = appbar.getChildAt(0);
        AppBarLayout.LayoutParams mAppBarParams = (AppBarLayout.LayoutParams) mAppBarChildAt.getLayoutParams();
        mAppBarParams.setScrollFlags(0);
        //设置fragment中菜单显示
        setHasOptionsMenu(true);
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.back_selector);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show(getActivity(), "搜索");
            }
        });
    }

    @Override
    public void initData(Bundle bundle, View rootView) {
        BGALocalImageSize localImageSize = new BGALocalImageSize(720, 1280, 320, 640);
        // 设置数据源
        backdrop.setData(localImageSize, ImageView.ScaleType.CENTER_CROP,
                R.mipmap.banner,
                R.mipmap.banner,
                R.mipmap.banner);
        backdrop.setAutoPlayAble(true);
    }

    private List<HomeHorRecycleEntity> addListEntity(String type) {
        switch (type) {
            case "Hor":
                List<HomeHorRecycleEntity> list_hor = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    HomeHorRecycleEntity entity = new HomeHorRecycleEntity();
                    switch (i) {
                        case 0:
                            entity.setImgRes(R.drawable.sel_scenic_spot_icon);
                            entity.setText(getString(R.string.scenic_spot));
                            list_hor.add(entity);
                            break;
                        case 1:
                            entity.setImgRes(R.drawable.sel_parking_icon);
                            entity.setText(getString(R.string.parking));
                            list_hor.add(entity);
                            break;
                        case 2:
                            entity.setImgRes(R.drawable.sel_high_speed_icon);
                            entity.setText(getString(R.string.high_speed));
                            list_hor.add(entity);
                            break;
                        case 3:
                            entity.setImgRes(R.drawable.sel_user_regist_icon);
                            entity.setText(getString(R.string.user_register));
                            list_hor.add(entity);
                            break;
                        case 4:
                            entity.setImgRes(R.drawable.sel_bind_etc_icon);
                            entity.setText(getString(R.string.bind_etc));
                            list_hor.add(entity);
                            break;
                    }
                }
                return list_hor;
            case "Ver":
                List<HomeHorRecycleEntity> list_ver = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    HomeHorRecycleEntity entity = new HomeHorRecycleEntity();
                    switch (i) {
                        case 0:
                            entity.setImgRes(R.mipmap.self_driving_icon);
                            entity.setText(getString(R.string.self_driving));
                            list_ver.add(entity);
                            break;
                        case 1:
                            entity.setImgRes(R.mipmap.camp_icon);
                            entity.setText(getString(R.string.camp));
                            list_ver.add(entity);
                            break;
                        case 2:
                            entity.setImgRes(R.mipmap.hotel_icon);
                            entity.setText(getString(R.string.hotel));
                            list_ver.add(entity);
                            break;
                        case 3:
                            entity.setImgRes(R.mipmap.high_quality_line_icon);
                            entity.setText(getString(R.string.high_quality_line));
                            list_ver.add(entity);
                            break;
                    }
                }
                return list_ver;
            default:
                return null;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_home, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.item_msg) {
            ToastUtils.show(getActivity(), "菜单");
        }
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
