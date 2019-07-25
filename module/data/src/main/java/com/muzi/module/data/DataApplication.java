package com.muzi.module.data;

import android.app.Application;

import com.muzi.annotation.annotation.RegisterApplication;
import com.muzi.annotationapi.AbsApplication;

import org.litepal.LitePal;


/**
 * Author: lipeng
 * Date: 2019/7/22
 * Email: lipeng@moyi365.com
 * Content:
 */
@RegisterApplication
public class DataApplication extends AbsApplication {

    @Override
    public void onCreate(Application application) {
        super.onCreate(application);
//       MMKVUtils.init(application);
        LitePal.initialize(application);
    }

}
