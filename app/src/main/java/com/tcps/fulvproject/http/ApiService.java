package com.tcps.fulvproject.http;


import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    final String url = "appIService";

    /**
     * 获取传输秘钥
     */
    @POST(url)
    Observable<Object> getTransferKey(@Body() Object body);
}
