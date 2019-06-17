package com.tcps.common_module.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.tcps.common_module.baseApplication.app;

import java.util.Objects;

/**
 * 适屏工具
 *
 * @author Zhq
 */
public class DisplayTool {
    public static Context mContext;

    private static final class Holder {
        @SuppressLint("StaticFieldLeak")
        private static final DisplayTool DISPLAY_TOOL = new DisplayTool();
    }

    public static DisplayTool getInstance() {
        return Holder.DISPLAY_TOOL;
    }

    /**
     * 根据手机的分辨率�?dp 的单�?转成�?px(像素)
     */
    public int convertDP2PX(float dpValue) {
        float scale = app.getApplication().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率�?px(像素) 的单�?转成�?dp
     */
    public int convertPX2DP(float pxValue) {
        float scale = app.getApplication().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取屏幕宽度 dp
     */
    public int getDisplayWidthDPSize() {
        WindowManager mWindowManager = (WindowManager) app.getApplication()
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metric = new DisplayMetrics();
        mWindowManager.getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels; // 屏幕宽度（像素）
        return convertPX2DP(width);
    }

    /**
     * 获取屏幕高度 dp
     */
    public int getDisplayHeightDPSize() {
        WindowManager mWindowManager = (WindowManager) app.getApplication()
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metric = new DisplayMetrics();
        Objects.requireNonNull(mWindowManager).getDefaultDisplay().getMetrics(metric);
        int height = metric.heightPixels; // 屏幕高度（像素）
        return convertPX2DP(height);
    }

    /**
     * 获取屏幕密度
     *
     * @return
     */
    public int getDensityDPI() {
        DisplayMetrics dm = new DisplayMetrics();
        dm = app.getApplication().getResources().getDisplayMetrics();
        // float density = dm.density; // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        return dm.densityDpi;
    }

    /**
     * 获取屏幕密度
     *
     * @return
     */
    public float getDensity() {
        DisplayMetrics dm = new DisplayMetrics();
        dm = app.getApplication().getResources().getDisplayMetrics();
        // int densityDPI = dm.densityDpi; // 屏幕密度（每寸像素：120/160/240/320）
        return dm.density;
    }

    /**
     * 获得屏幕尺寸
     *
     * @param context
     * @return
     */
    public static Point getScreenSize(Context context) {
        Point point = new Point();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Objects.requireNonNull(wm).getDefaultDisplay().getSize(point);
        return point;
    }
}
