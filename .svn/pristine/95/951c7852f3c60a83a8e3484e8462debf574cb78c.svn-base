package com.tcps.common_module.commonUI.activity;

import android.Manifest;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tcps.common_module.R;
import com.tcps.common_module.baseMvp.BaseMvpActivity;
import com.tcps.common_module.baseMvp.baseService.IPermissionListener;
import com.tcps.common_module.commonUI.mvp.contract.WelcomeContract;
import com.tcps.common_module.commonUI.mvp.presenter.WelcomePresenter;
import com.tcps.common_module.utils.ToastUtils;
import com.tcps.common_module.utils.UUIDS;

public class WelcomeActivity extends BaseMvpActivity<WelcomePresenter> implements WelcomeContract.View, IPermissionListener {
    @Override
    public WelcomePresenter initPresenter() {
        return new WelcomePresenter(this);
    }

    @Override
    public void beforeInitView(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.welcome_activity;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        requestPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, this);
    }

    @Override
    public void loadDataSuccess(String Data, String requestTag) {
        ARouter.getInstance().build("/app/MainActivity").navigation();
        finish();
    }

    @Override
    public void loadDataError(Throwable e, int requestTag) {

    }

    //权限申请成功
    @Override
    public void getPermissionSuccess() {
        UUIDS.buidleID().check();
        mPresenter.certificateDownload(this);
    }

    //权限申请失败
    @Override
    public void getPermissionFailure() {
        ToastUtils.show(this, "申请权限失败");
        requestPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, this);
    }
}
