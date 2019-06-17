package com.tcps.etc_module.http.outputEntity;


import com.tcps.common_module.http.HttpResponse;

/**
 * Created by khj on 2018-4-3.
 */

public class BindPlateOutputEntity extends HttpResponse {
    private String RETMSG;
    private String USERID;
    private String RESSEQ;

    public String getRETMSG() {
        return RETMSG;
    }

    public void setRETMSG(String RETMSG) {
        this.RETMSG = RETMSG;
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
