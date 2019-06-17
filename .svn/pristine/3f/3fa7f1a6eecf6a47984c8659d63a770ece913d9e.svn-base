package com.tcps.etc_module.http.cache;


import com.tcps.etc_module.http.outputEntity.ServiceTimeOutputEntityNew;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.LifeCache;

/**
 * Created by khj on 2018-6-4.
 */

public interface ServiceTimeCacheProviders {
    @LifeCache(duration = 10, timeUnit = TimeUnit.SECONDS)
    Observable<ServiceTimeOutputEntityNew> getServiceTime(Observable<ServiceTimeOutputEntityNew> user,
                                                          DynamicKey userName,
                                                          EvictDynamicKey evictDynamicKey);
}
