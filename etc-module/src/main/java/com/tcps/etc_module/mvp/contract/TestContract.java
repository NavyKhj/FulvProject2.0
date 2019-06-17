package com.tcps.etc_module.mvp.contract;

import com.tcps.common_module.baseMvp.BaseAppCompatActivity;
import com.tcps.common_module.baseMvp.baseService.IBaseView;

public interface TestContract {
        interface View extends IBaseView {
    }

    interface Presenter {
        void getServiceTime(BaseAppCompatActivity appCompatActivity);
    }
}
