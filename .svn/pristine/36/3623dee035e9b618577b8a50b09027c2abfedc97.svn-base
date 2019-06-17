// (c)2016 Flipboard Inc, All Rights Reserved.

package com.tcps.etc_module.http;


import com.tcps.etc_module.http.outputEntity.ApplyCardOutputEntity;
import com.tcps.etc_module.http.outputEntity.BindPlateOutputEntity;
import com.tcps.etc_module.http.outputEntity.CardInitOutputEntity;
import com.tcps.etc_module.http.outputEntity.ForgetPswOutputEntity;
import com.tcps.etc_module.http.outputEntity.GetAppVersionOutputEntity;
import com.tcps.etc_module.http.outputEntity.GetBannerPicOutputEntity;
import com.tcps.etc_module.http.outputEntity.GetBaseInfoOutputEntity;
import com.tcps.etc_module.http.outputEntity.GetCardListOutputEntity;
import com.tcps.etc_module.http.outputEntity.GetCityListOutputEntity;
import com.tcps.etc_module.http.outputEntity.GetDefaultPayTypeOutputEntity;
import com.tcps.etc_module.http.outputEntity.GetEtcListOutputEntity;
import com.tcps.etc_module.http.outputEntity.GetPublicKeyOutputEntity;
import com.tcps.etc_module.http.outputEntity.GetTransferkeyOutputEntity;
import com.tcps.etc_module.http.outputEntity.GetverifyOutputEntity;
import com.tcps.etc_module.http.outputEntity.LoginOutpuEntity;
import com.tcps.etc_module.http.outputEntity.QueryCardInfoOutputEntity;
import com.tcps.etc_module.http.outputEntity.RechageOutputEntity;
import com.tcps.etc_module.http.outputEntity.RechargeQueryOutputEntity;
import com.tcps.etc_module.http.outputEntity.RegisterOutputEntity;
import com.tcps.etc_module.http.outputEntity.RemoveEtcOutputEntity;
import com.tcps.etc_module.http.outputEntity.ServiceTimeOutputEntityNew;
import com.tcps.etc_module.http.outputEntity.SetDefaultPayTypeOutputEntity;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Describe:girls Api接口
 * Created by liying on 2018/2/7.
 */
public interface ApiService {
    final String url = "appIService";
    /**
     * 获取服务器时间
     */
    @POST(url)
    Observable<ServiceTimeOutputEntityNew> getServerTime(@Body() Object body);

    /**
     * 获取验证码
     */
    @POST(url)
    Observable<GetverifyOutputEntity> getVerify(@Body() Object body);

    /**
     * 获取公钥
     */
    @POST(url)
    Observable<GetPublicKeyOutputEntity> getPublicKey(@Body() Object body);

    /**
     * 获取传输秘钥
     */
    @POST(url)
    Observable<GetTransferkeyOutputEntity> getTransferKey(@Body() Object body);

    /**
     * 注册
     */
    @POST(url)
    Observable<RegisterOutputEntity> register(@Body() Object body);

    /**
     * 登录
     */
    @POST(url)
    Observable<LoginOutpuEntity> login(@Body() Object body);

    /**
     * 卡申请
     */
    @POST(url)
    Observable<ApplyCardOutputEntity> applyCard(@Body() Object body);

    /**
     * 获取充值订单
     */
    @POST(url)
    Observable<RechageOutputEntity> rechargeOrder(@Body() Object body);

    /**
     * 卡充值
     */
    @POST(url)
    Observable<RechargeQueryOutputEntity> queryRecharge(@Body() Object body);

    /**
     * 获取卡信息 ps：查询余额
     */
    @POST(url)
    Observable<QueryCardInfoOutputEntity> queryCardInfo(@Body() Object body);

    /**
     * 获取卡列表
     */
    @POST(url)
    Observable<GetCardListOutputEntity> getCardList(@Body() Object body);

    /**
     * 忘记密码
     */
    @POST(url)
    Observable<ForgetPswOutputEntity> forgetPsw(@Body() Object body);

    /**
     * 获取城市列表
     */
    @POST(url)
    Observable<GetCityListOutputEntity> getCityList(@Body() Object body);

    /**
     * 获取app版本
     */
    @POST(url)
    Observable<GetAppVersionOutputEntity> getAppVersion(@Body() Object body);

    /**
     * 获取广告图片
     */
    @POST(url)
    Observable<GetBannerPicOutputEntity> getBannerPic(@Body() Object body);

    /**
     * 获取广告图片
     */
    @POST(url)
    Observable<GetBaseInfoOutputEntity> getBaseInfo(@Body() Object body);

    /**
     * 虚拟卡初始化
     */
    @POST(url)
    Observable<CardInitOutputEntity> cardInit(@Body() Object body);

    /**
     * 绑定ETC
     */
    @POST(url)
    Observable<BindPlateOutputEntity> bindPlate(@Body() Object body);

    /**
     * 获取ETClist
     */
    @POST(url)
    Observable<GetEtcListOutputEntity> getEtcList(@Body() Object body);

    /**
     * 解绑ETC
     */
    @POST(url)
    Observable<RemoveEtcOutputEntity> removeETC(@Body() Object body);

    /**
     * 查询默认支付顺序
     */
    @POST(url)
    Observable<GetDefaultPayTypeOutputEntity> GetDefaultPayType(@Body() Object body);

    /**
     * 查询默认支付顺序
     */
    @POST(url)
    Observable<SetDefaultPayTypeOutputEntity> SetDefaultPayType(@Body() Object body);
}
