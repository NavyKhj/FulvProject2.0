package com.tcps.etc_module.http.inputEntity;

/**
 * Created by khj on 2018-3-13.
 */

public class GetPublicKeyInputEntity {
    private String FUNCODE;
    private String REQSEQ;
    private String PRIPARAM;
    private String IMEI;
    private String CALLTIME;

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

    public String getPRIPARAM() {
        return PRIPARAM;
    }

    public void setPRIPARAM(String PRIPARAM) {
        this.PRIPARAM = PRIPARAM;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getCALLTIME() {
        return CALLTIME;
    }

    public void setCALLTIME(String CALLTIME) {
        this.CALLTIME = CALLTIME;
    }
}
