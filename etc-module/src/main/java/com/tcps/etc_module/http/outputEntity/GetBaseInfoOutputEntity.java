package com.tcps.etc_module.http.outputEntity;


import com.tcps.common_module.http.HttpResponse;

/**
 * Created by khj on 2018-3-20.
 */

public class GetBaseInfoOutputEntity extends HttpResponse {
    private String RETMSG;
    private String TELEPHONE;
    private String ADTIME;
    private String RESSEQ;

    public String getRETMSG() {
        return RETMSG;
    }

    public void setRETMSG(String RETMSG) {
        this.RETMSG = RETMSG;
    }

    public String getTELEPHONE() {
        return TELEPHONE;
    }

    public void setTELEPHONE(String TELEPHONE) {
        this.TELEPHONE = TELEPHONE;
    }

    public String getADTIME() {
        return ADTIME;
    }

    public void setADTIME(String ADTIME) {
        this.ADTIME = ADTIME;
    }

    public String getRESSEQ() {
        return RESSEQ;
    }

    public void setRESSEQ(String RESSEQ) {
        this.RESSEQ = RESSEQ;
    }
}
