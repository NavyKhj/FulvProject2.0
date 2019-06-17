package com.tcps.common_module.service;

/**
 * 证书下载回调
 * Created by khj on 2018-3-20.
 */

public interface ICertificateDownloadListener {
    void downloadSuccess();

    void downloadFail();
}
