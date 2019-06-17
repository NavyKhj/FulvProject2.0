package com.tcps.etc_module.http.outputEntity;


import com.tcps.common_module.http.HttpResponse;

/**
 * Created by khj on 2018-3-13.
 */

public class ServiceTimeOutputEntityNew extends HttpResponse {
    private String SERVERTIME;
    private String RESSEQ;

    public String getRESSEQ() {
        return RESSEQ;
    }

    public void setRESSEQ(String RESSEQ) {
        this.RESSEQ = RESSEQ;
    }

    public String getSERVERTIME() {
        return SERVERTIME;
    }

    public void setSERVERTIME(String SERVERTIME) {
        this.SERVERTIME = SERVERTIME;
    }


}
