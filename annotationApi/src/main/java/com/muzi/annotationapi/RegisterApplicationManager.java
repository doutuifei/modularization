package com.muzi.annotationapi;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.muzi.annotation.AppConstants;
import com.muzi.annotation.RegisterApplicationPackage;
import com.muzi.annotation.interfaces.IRegisterApplication;
import com.muzi.annotationapi.bean.ApplicationPackage;
import com.muzi.annotationapi.interfaces.IApplication;
import com.muzi.annotationapi.utils.ClassUtils;
import com.muzi.annotationapi.utils.PackageUtils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Author: lipeng
 * Date: 2019/7/14
 * Email: lipeng@moyi365.com
 * Content:
 */
public class RegisterApplicationManager implements IApplication {

    private Handler handler;

    private Application context;

    private List<ApplicationPackage> applicationPackageList;

    private List<RegisterApplicationPackage> registerApplicationPackageList;

    private volatile static RegisterApplicationManager instance;

    private volatile static boolean debuggable = false;

    public static RegisterApplicationManager getInstance() {
        if (instance == null) {
            synchronized (RegisterApplicationManager.class) {
                if (instance == null) {
                    instance = new RegisterApplicationManager();
                }
            }
        }
        return instance;
    }

    private RegisterApplicationManager() {
        registerApplicationPackageList = new ArrayList<>();
    }

    public static synchronized void openDebug() {
        debuggable = true;
    }

    public static boolean debuggable() {
        return debuggable;
    }

    public synchronized void register(Application context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null!!!");
        }
        this.context = context;
        handler = new Handler(Looper.getMainLooper());
        scanCategories();
    }

    private synchronized void scanCategories() {
        Set<String> applicationSet = null;
        if (debuggable() || PackageUtils.isNewVersion(context)) {
            try {
                applicationSet = ClassUtils.getFileNameByPackageName(context, AppConstants.PACKAGE_NAME);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!applicationSet.isEmpty()) {
                context.getSharedPreferences(Constants.APPLICATION_SP_CACHE_KEY, Context.MODE_PRIVATE).edit().putStringSet(Constants.APPLICATION_SP_KEY_MAP, applicationSet).apply();
            }

            PackageUtils.updateVersion(context);
        } else {
            applicationSet = new HashSet<>(context.getSharedPreferences(Constants.APPLICATION_SP_CACHE_KEY, Context.MODE_PRIVATE).getStringSet(Constants.APPLICATION_SP_KEY_MAP, new HashSet<>()));
        }
        if (applicationSet == null || applicationSet.isEmpty()) {
            return;
        }
        for (String s : applicationSet) {
            Object o = null;
            try {
                o = Class.forName(s).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (o == null) {
                continue;
            }
            if (o instanceof IRegisterApplication) {
                IRegisterApplication iRegisterSDK = (IRegisterApplication) o;
                iRegisterSDK.registerApplication(registerApplicationPackageList);
            }
        }
        handleRegisterApplicationPackage();
    }

    private void handleRegisterApplicationPackage() {
        if (registerApplicationPackageList.isEmpty()) {
            return;
        }
        applicationPackageList = new ArrayList<>(registerApplicationPackageList.size());
        Collections.sort(registerApplicationPackageList);
        for (RegisterApplicationPackage registerSDKPack : registerApplicationPackageList) {
            String clazz = registerSDKPack.getClazz();
            Object o = newInstance(clazz);
            if (o != null && o instanceof IApplication) {
                ApplicationPackage sdk = new ApplicationPackage(registerSDKPack, (IApplication) o);
                applicationPackageList.add(sdk);
            }
        }
    }

    private Object newInstance(String clazzName) {
        Object o = null;
        try {
            Class<?> clazz = Class.forName(clazzName);
            Constructor declaredConstructors = clazz.getDeclaredConstructor();
            declaredConstructors.setAccessible(true);
            o = declaredConstructors.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public void onCreate(Application application) {
        List<ApplicationPackage> threadList = null;
        if (applicationPackageList != null && !applicationPackageList.isEmpty()) {
            for (ApplicationPackage applicationPackage : applicationPackageList) {
                long delay = applicationPackage.getDelay();
                switch (applicationPackage.getMode()) {
                    case Main:
                        if (delay > 0) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    applicationPackage.getApplication().onCreate(application);
                                }
                            }, delay);
                        } else {
                            applicationPackage.getApplication().onCreate(application);
                        }
                        break;
                    case Thread:
                        if (threadList == null) {
                            threadList = new ArrayList<>();
                        }
                        threadList.add(applicationPackage);
                        break;
                }
            }
            if (threadList != null && !threadList.isEmpty()) {
                Iterator<ApplicationPackage> iterator = threadList.iterator();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (iterator.hasNext()) {
                            iterator.next().getApplication().onCreate(application);
                        }
                    }
                }).start();
            }
        }
    }

    @Override
    public void onLowMemory() {
        if (applicationPackageList != null && !applicationPackageList.isEmpty()) {
            for (ApplicationPackage applicationPackage : applicationPackageList) {
                applicationPackage.getApplication().onLowMemory();
            }
        }
    }

    @Override
    public void onTrimMemory(int level) {
        if (applicationPackageList != null && !applicationPackageList.isEmpty()) {
            for (ApplicationPackage applicationPackage : applicationPackageList) {
                applicationPackage.getApplication().onTrimMemory(level);
            }
        }
    }

}
