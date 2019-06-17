package com.tcps.common_module.commonUI.http;

import com.tcps.common_module.commonUI.http.entity.GetPublicKeyOutputEntity;
import com.tcps.common_module.commonUI.http.entity.GetTransferKeyOutputEntity;
import com.tcps.common_module.commonUI.http.entity.LoginOutputEntity;
import com.tcps.common_module.commonUI.http.entity.ServiceTimeOutputEntityNew;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    final String url = "appIService";
    /**
     * 获取服务器时间
     */
    @POST(url)
    Observable<ServiceTimeOutputEntityNew> getServerTime(@Body() Object body);

    /**
     * 获取公钥
     */
    @POST(url)
    Observable<GetPublicKeyOutputEntity> getPublicKey(@Body() Object body);

    /**
     * 获取传输秘钥
     */
    @POST(url)
    Observable<GetTransferKeyOutputEntity> getTransferKey(@Body() Object body);

    /**
     * 登录
     */
    @POST(url)
    Observable<LoginOutputEntity> login(@Body() Object body);
}
