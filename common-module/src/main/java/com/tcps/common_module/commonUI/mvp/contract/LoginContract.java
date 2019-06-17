package com.tcps.common_module.commonUI.mvp.contract;

import com.tcps.common_module.baseMvp.BaseMvpFragment;
import com.tcps.common_module.baseMvp.baseService.IBaseView;

public interface LoginContract {

    interface View extends IBaseView {
    }

    interface Presenter {
        void toLogin(BaseMvpFragment fragment, String name, String psw, String loginType);

        void toRegister(BaseMvpFragment fragment, String name, String psw, String verify);

        void toVerify(BaseMvpFragment fragment, String name, String verifyType);
    }
}
