package com.tcps.common_module.wechat;

import com.google.gson.annotations.SerializedName;

public class WXPayUrlBean {
    /**
     * prepayid : wx25104237706543e2748ed3470708582063
     * package : Sign=WXPay
     * appid : wxd590746e842ab5cf
     * sign : 7C939E996607BCDB237C6EAC4AAF77B1
     * timestamp : 1527216157
     * noncestr : vm5dyBWQWhdyY0GR
     * partnerid : 1504415031
     * RCODE : 9000
     */

    private String prepayid;
    @SerializedName("package")
    private String packageX;
    private String appid;
    private String sign;
    private int timestamp;
    private String noncestr;
    private String partnerid;
    private String RCODE;

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getPackageX() {
        return packageX;
    }

    public void setPackageX(String packageX) {
        this.packageX = packageX;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getRCODE() {
        return RCODE;
    }

    public void setRCODE(String RCODE) {
        this.RCODE = RCODE;
    }
}
