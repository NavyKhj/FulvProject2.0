package com.tcps.etc_module.http.inputEntity;

/**
 * Created by khj on 2018-3-20.
 */

public class GetBannerPicInputEntity {
    private String FUNCODE;
    private String REQSEQ;
    private String IMEI;
    private String CITYCODE;
    private String CALLTIME;
    private String SIGN;

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

    public String getCITYCODE() {
        return CITYCODE;
    }

    public void setCITYCODE(String CITYCODE) {
        this.CITYCODE = CITYCODE;
    }

    public String getCALLTIME() {
        return CALLTIME;
    }

    public void setCALLTIME(String CALLTIME) {
        this.CALLTIME = CALLTIME;
    }

    public String getSIGN() {
        return SIGN;
    }

    public void setSIGN(String SIGN) {
        this.SIGN = SIGN;
    }
}
