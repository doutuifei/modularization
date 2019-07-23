package com.muzi.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.muzi.annotationapi.RegisterApplicationManager;

/**
 * 作者: lipeng
 * 时间: 2019/7/12
 * 邮箱: lipeng@moyi365.com
 * 功能:
 */
public class GlobalApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
        RegisterApplicationManager.getInstance().register(this);
        RegisterApplicationManager.getInstance().onCreate(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        RegisterApplicationManager.getInstance().onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        RegisterApplicationManager.getInstance().onTrimMemory(level);
    }

    private void initARouter() {
//        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }

}
