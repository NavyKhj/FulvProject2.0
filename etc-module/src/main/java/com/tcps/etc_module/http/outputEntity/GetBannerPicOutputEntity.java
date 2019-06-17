package com.tcps.etc_module.http.outputEntity;


import com.tcps.common_module.http.HttpResponse;

import org.json.JSONObject;

/**
 * Created by khj on 2018-3-20.
 */

public class GetBannerPicOutputEntity extends HttpResponse {
    private String RETMSG;
    private JSONObject ADVERTISEMENTS;
    private String ADNUM;
    private String RESSEQ;

    public String getRETMSG() {
        return RETMSG;
    }

    public void setRETMSG(String RETMSG) {
        this.RETMSG = RETMSG;
    }

    public JSONObject getADVERTISEMENTS() {
        return ADVERTISEMENTS;
    }

    public void setADVERTISEMENTS(JSONObject ADVERTISEMENTS) {
        this.ADVERTISEMENTS = ADVERTISEMENTS;
    }

    public String getADNUM() {
        return ADNUM;
    }

    public void setADNUM(String ADNUM) {
        this.ADNUM = ADNUM;
    }

    public String getRESSEQ() {
        return RESSEQ;
    }

    public void setRESSEQ(String RESSEQ) {
        this.RESSEQ = RESSEQ;
    }
}
