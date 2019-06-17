package com.tcps.etc_module.http.inputEntity;


/**
 * Created by khj on 2018-4-8.
 */

public class SetDefaultPayTypeInputEntity {
    private String FUNCODE;
    private String REQSEQ;
    private String IMEI;
    private String USERID;
    private String PAYSEQ;
    private String USEFLAG;
    private String MOBILE;
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

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getPAYSEQ() {
        return PAYSEQ;
    }

    public void setPAYSEQ(String PAYSEQ) {
        this.PAYSEQ = PAYSEQ;
    }

    public String getUSEFLAG() {
        return USEFLAG;
    }

    public void setUSEFLAG(String USEFLAG) {
        this.USEFLAG = USEFLAG;
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
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
