package com.tcps.etc_module.http.outputEntity;

import com.tcps.common_module.http.HttpResponse;

/**
 * Created by khj on 2018-3-13.
 */

public class ServiceTimeOutputEntity extends HttpResponse {
   private String RETMSG;
   private String SERVERTIME;

    public String getRETMSG() {
        return RETMSG;
    }

    public void setRETMSG(String RETMSG) {
        this.RETMSG = RETMSG;
    }

    public String getSERVERTIME() {
        return SERVERTIME;
    }

    public void setSERVERTIME(String SERVERTIME) {
        this.SERVERTIME = SERVERTIME;
    }
}
