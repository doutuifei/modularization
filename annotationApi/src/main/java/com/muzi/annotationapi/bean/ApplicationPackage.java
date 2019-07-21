package com.muzi.annotationapi.bean;

import com.muzi.annotation.RegisterApplicationPackage;
import com.muzi.annotation.enums.ThreadMode;
import com.muzi.annotationapi.interfaces.IApplication;

/**
 * Author: lipeng
 * Date: 2019/7/14
 * Email: lipeng@moyi365.com
 * Content:
 */
public class ApplicationPackage extends RegisterApplicationPackage {

    private IApplication application;

    public IApplication getApplication() {
        return application;
    }

    public void setApplication(IApplication application) {
        this.application = application;
    }

    public ApplicationPackage() {
    }

    public ApplicationPackage(RegisterApplicationPackage registerSDKPack) {
        this(registerSDKPack, null);
    }

    public ApplicationPackage(RegisterApplicationPackage registerSDKPack, IApplication application) {
        super(registerSDKPack.getClazz(), registerSDKPack.getPriority(), registerSDKPack.getDelay(), registerSDKPack.getMode());
        this.application = application;
    }

    public ApplicationPackage(String clazz, int priority, int delay, ThreadMode mode, IApplication application) {
        super(clazz, priority, delay, mode);
        this.application = application;
    }

}
