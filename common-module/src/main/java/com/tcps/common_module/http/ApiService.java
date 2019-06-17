package com.tcps.common_module.http;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    /**
     * 微信登录
     */
    @POST("")
    Observable<String> getUserInfo(@Body() Object body);
}
