package com.muzi.annotationapi.interfaces;

import android.app.Application;

/**
 * Author: lipeng
 * Date: 2019/7/14
 * Email: lipeng@moyi365.com
 * Content:
 */
public interface IApplication {

    void onCreate(Application application);

    void onLowMemory();

    void onTrimMemory(int level);

}
