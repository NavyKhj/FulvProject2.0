package com.tcps.common_module.commonUI.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tcps.common_module.R;
import com.tcps.common_module.R2;
import com.tcps.common_module.baseMvp.BaseMvpFragment;
import com.tcps.common_module.commonUI.mvp.contract.LoginContract;
import com.tcps.common_module.commonUI.mvp.presenter.LoginPresenter;
import com.tcps.common_module.qq.QQUtils;
import com.tcps.common_module.widget.ClearEditText;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.Tencent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AccountLoginFragment extends BaseMvpFragment<LoginPresenter> implements LoginContract.View {
    Unbinder unbinder;
    @BindView(R2.id.edPhone)
    ClearEditText edPhone;
    @BindView(R2.id.edPsw)
    ClearEditText edPsw;
    @BindView(R2.id.check_visible)
    CheckBox checkVisible;
    @BindView(R2.id.ivWechat)
    ImageView ivWechat;
    @BindView(R2.id.ivWeiBo)
    ImageView ivWeiBo;
    @BindView(R2.id.ivQq)
    ImageView ivQq;
    @BindView(R2.id.btnLogin)
    Button btnLogin;

    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter(this);
    }

//    @OnClick({R2.id.tv, R2.id.login})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R2.id.tv:
//                ToastUtils.show(getActivity(), "点击");
//                Intent intent = new Intent();
//                intent.setAction("com.tcps.fulvproject.login");
//                intent.putExtra("flag", "AccountLoginFragment");
//                Objects.requireNonNull(getActivity()).sendBroadcast(intent);
//                break;
//            case R2.id.login:
//                mPresenter.toLogin(AccountLoginFragment.this, "13132232731", "1qazxsw2", "1");
    /*WeChatUtils.getInstance(*//*getActivity()*//*).onSignSuccess(new IWeChatSignInCallback() {
                    @Override
                    public void onSignInSuccess(String userInfo) {

                    }
                }).signIn();*/
                /*QQUtils.getInstance(getActivity()).signIn(new QQUtils.IQQSignInCallback() {
                    @Override
                    public void onSignInSuccess() {
                        LogUtil.i("qq登录成功");
                    }
                });*/
//                ARouter.getInstance().build("/etc/EtcActivity").navigation();
//                onClick();
//                break;
//        }
//    }

    @Override
    public void beforeInitView(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_account_login;
    }

    @Override
    public void initView(Bundle savedInstanceState, View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Objects.requireNonNull(getActivity()).getWindow().getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }*/
    }

    @Override
    public void loadDataSuccess(String Data, String requestTag) {

    }

    @Override
    public void loadDataError(Throwable e, int requestTag) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN) {
            Tencent.onActivityResultData(requestCode, resultCode, data, QQUtils.baseUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R2.id.btnLogin)
    public void onViewClicked() {
        ARouter.getInstance().build("/etc/EtcActivity").navigation();
    }
}
