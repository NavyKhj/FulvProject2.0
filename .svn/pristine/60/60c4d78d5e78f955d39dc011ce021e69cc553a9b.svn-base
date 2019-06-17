package com.tcps.common_module.baseMvp.baseService;

import android.arch.lifecycle.LifecycleOwner;

/**
 * Class description
 * 视图（View层）基础回调接口
 *
 * @author WJ
 * @version 1.0, 2018-1-15
 */

public interface IBaseView extends LifecycleOwner {
    /**
     * 基础的请求的返回
     *
     * @param requestTag 请求标识
     */
    void loadDataSuccess(String Data, String requestTag);

    /**
     * 基础请求的错误
     *
     * @param e
     * @param requestTag 请求标识
     */
    void loadDataError(Throwable e, int requestTag);
}
