package com.tcps.etc_module.http.inputEntity;

/**
 * Created by khj on 2018-3-20.
 */

public class GetAppVersionInputEntity {
    private String FUNCODE;
    private String REQSEQ;
    private String IMEI;
    private String APKVERSION;
    private String APKTYPE;
    private String CALLTIME;
    private String SIGN;

    public String getSIGN() {
        return SIGN;
    }

    public void setSIGN(String SIGN) {
        this.SIGN = SIGN;
    }

    public String getFUNCODE() {
        return FUNCODE;
    }

    public void setFUNCODE(String FUNCODE) {
        this.FUNCODE = FUNCODE;
    }

    public String getREQSEQ() {
        return REQSEQ;
    }

    public void setREQSEQ(String REQSEQ) {
        this.REQSEQ = REQSEQ;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getAPKVERSION() {
        return APKVERSION;
    }

    public void setAPKVERSION(String APKVERSION) {
        this.APKVERSION = APKVERSION;
    }

    public String getAPKTYPE() {
        return APKTYPE;
    }

    public void setAPKTYPE(String APKTYPE) {
        this.APKTYPE = APKTYPE;
    }

    public String getCALLTIME() {
        return CALLTIME;
    }

    public void setCALLTIME(String CALLTIME) {
        this.CALLTIME = CALLTIME;
    }
}
