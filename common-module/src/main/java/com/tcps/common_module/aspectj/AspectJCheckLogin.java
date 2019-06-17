package com.tcps.common_module.aspectj;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tcps.common_module.R;
import com.tcps.common_module.utils.Const;
import com.tcps.common_module.utils.LogUtil;
import com.tcps.common_module.utils.PreferencesUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 切面编程解析类
 */
@SuppressWarnings("ALL")
@Aspect
public class AspectJCheckLogin {
    private static final String TAG = "tag00";

    @Pointcut("execution(@com.tcps.common_module.aspectj.CheckLogin  * *(..))")
    public void executionCheckLogin() {

    }

    @Around("executionCheckLogin()")
    public Object aroundAspectJ(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        LogUtil.i(TAG, "aroundAspectJ(ProceedingJoinPoint joinPoint)");
        CheckLogin checkLogin = methodSignature.getMethod().getAnnotation(CheckLogin.class);
        Object o = null;
        if (checkLogin != null) {
            Object object = joinPoint.getThis();
            Context context;
            if (object instanceof Fragment) {
                context = ((Fragment) object).getActivity();
            } else {
                context = (Context) object;
            }
            if (PreferencesUtils.getBoolean(context, Const.LOGIN)) {
                o = joinPoint.proceed();
            } else {
                Toast.makeText(context, context.getString(R.string.please_login_first), Toast.LENGTH_SHORT).show();
                ARouter.getInstance().build("/base/RegisterLoginActivity").navigation(context);
            }
        }
        return o;
    }
}
