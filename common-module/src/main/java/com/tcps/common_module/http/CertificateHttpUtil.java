package com.tcps.common_module.http;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.tcps.common_module.service.ICertificateDownloadListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 证书下载utils
 */
public class CertificateHttpUtil {
    private static ICertificateDownloadListener listener;
    public static String sdPath;

    private static final class Holder {
        static final CertificateHttpUtil INSTANCE = new CertificateHttpUtil();
    }

    public static CertificateHttpUtil getInstance() {
        return Holder.INSTANCE;
    }

    public CertificateHttpUtil setListener(ICertificateDownloadListener certificateDownlaodListener) {
        listener = certificateDownlaodListener;
        return this;
    }

    /**
     * 证书生成环境
     */
    //测试证书
    private static String URL = "http://ic.tcps.com.cn:9430/jnonline/j_c_fi/gender.cer";
    //正式证书
//	public static String URL = "http://101.201.144.125/fbcapp/fbc.cer";

    public static String fileName = "tcpscard.cer";

    public void getCertificate(final Context context) {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) {
                String str_req; //yes-获取到证书，false-未获取到证书
                try {
                    URL url = new URL(URL);//请求地址
                    //获取存放证书的地址
                    sdPath = getDiskCacheDir(context) + "/download/";
                    File dir = new File(sdPath);
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    File file = new File(dir, fileName);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);// 超时设置
                    conn.connect();
                    url.openStream(); // 请求网络
                    Log.e("0000", "---===>>>" + conn.getResponseCode());
                    if (conn.getResponseCode() != 200)
                        throw new RuntimeException("请求url失败");
                    InputStream is = conn.getInputStream();// 获取返回数据
                    // 使用输出流来输出文件(可选)
                    final OutputStream output = new FileOutputStream(file);
                    byte[] buf = new byte[1024];
                    int len;
                    // 把获取到的文件保存到路径下
                    while ((len = is.read(buf)) != -1) {
                        output.write(buf, 0, len);
                    }
                    output.close();
                    str_req = "yes";
                    Log.i("str_req", str_req);
                    emitter.onNext("success");
                } catch (Exception e) {
                    e.printStackTrace();
                    str_req = "false";
                    Log.i("str_req", str_req);
                    emitter.onNext("fail");
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        if (s.equals("fail"))
                            listener.downloadFail();
                        else if (s.equals("success"))
                            listener.downloadSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    // 获取存文件的路径，如果存在SD卡，获取的路径是 /sdcard/Android/data/<application package>/cache
    // 。如果不存在SD卡，返回的路径是/data/data/<application package>/cache 。
    private static String getDiskCacheDir(Context context) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = Objects.requireNonNull(context.getExternalCacheDir()).getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return cachePath;
    }
}
