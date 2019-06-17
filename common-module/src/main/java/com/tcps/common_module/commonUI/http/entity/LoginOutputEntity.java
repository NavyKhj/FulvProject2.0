package com.tcps.common_module.commonUI.http.entity;


import com.tcps.common_module.http.HttpResponse;

/**
 * Created by khj on 2018-3-13.
 */

public class LoginOutputEntity extends HttpResponse {
    private String USERID;
    private String INTEGRAL;
    private String STATE;
    private String RESSEQ;
    private String TEMINALID;
    private String XNCARDNO;

    public String getXNCARDNO() {
        return XNCARDNO;
    }

    public void setXNCARDNO(String XNCARDNO) {
        this.XNCARDNO = XNCARDNO;
    }

    public String getTEMINALID() {
        return TEMINALID;
    }

    public void setTEMINALID(String TEMINALID) {
        this.TEMINALID = TEMINALID;
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getINTEGRAL() {
        return INTEGRAL;
    }

    public void setINTEGRAL(String INTEGRAL) {
        this.INTEGRAL = INTEGRAL;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getRESSEQ() {
        return RESSEQ;
    }

    public void setRESSEQ(String RESSEQ) {
        this.RESSEQ = RESSEQ;
    }
}
