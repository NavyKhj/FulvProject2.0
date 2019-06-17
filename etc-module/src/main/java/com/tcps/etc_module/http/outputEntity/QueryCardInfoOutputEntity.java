package com.tcps.etc_module.http.outputEntity;


import com.tcps.common_module.http.HttpResponse;

/**
 * Created by khj on 2018-3-14.
 */

public class QueryCardInfoOutputEntity extends HttpResponse {
    private String RETMSG;
    private String MONEY;
    private String CARDNO;
    private String STATE;
    private String USERID;
    private String RESSEQ;

    public String getRETMSG() {
        return RETMSG;
    }

    public void setRETMSG(String RETMSG) {
        this.RETMSG = RETMSG;
    }

    public String getMONEY() {
        return MONEY;
    }

    public void setCARDMONEY(String CARDMONEY) {
        this.MONEY = CARDMONEY;
    }

    public String getCARDNO() {
        return CARDNO;
    }

    public void setCARDNO(String CARDNO) {
        this.CARDNO = CARDNO;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getRESSEQ() {
        return RESSEQ;
    }

    public void setRESSEQ(String RESSEQ) {
        this.RESSEQ = RESSEQ;
    }
}
