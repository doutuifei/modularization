package com.muzi.annotationapi;

import android.app.Application;
import android.support.annotation.CallSuper;

import com.muzi.annotationapi.interfaces.IApplication;

/**
 * Author: lipeng
 * Date: 2019/7/14
 * Email: lipeng@moyi365.com
 * Content:
 */
public abstract class AbsApplication implements IApplication {

    private Application application;

    public Application getApplication() {
        return application;
    }

    @Override
    @CallSuper
    public void onCreate(Application application) {
        this.application = application;
    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }

}
