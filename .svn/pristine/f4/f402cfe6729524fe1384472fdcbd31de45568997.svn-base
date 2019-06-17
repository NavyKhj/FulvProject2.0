package com.tcps.common_module.commonUI.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tcps.common_module.R;
import com.tcps.common_module.R2;
import com.tcps.common_module.baseMvp.BaseMvpFragment;
import com.tcps.common_module.commonUI.mvp.contract.LoginContract;
import com.tcps.common_module.commonUI.mvp.presenter.LoginPresenter;
import com.tcps.common_module.widget.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PhoneLoginFragment extends BaseMvpFragment<LoginPresenter> implements LoginContract.View {


    Unbinder unbinder;
    @BindView(R2.id.edPhone)
    ClearEditText edPhone;
    @BindView(R2.id.edCode)
    ClearEditText edCode;
    @BindView(R2.id.btnCode)
    Button btnCode;
    @BindView(R2.id.btnLogin)
    Button btnLogin;

    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void beforeInitView(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_phone_login;
    }

    @Override
    public void initView(Bundle savedInstanceState, View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
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

}
