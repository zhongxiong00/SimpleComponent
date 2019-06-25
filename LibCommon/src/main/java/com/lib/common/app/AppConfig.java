package com.lib.common.app;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/21
 * 描述： 各个组件统一管理类
 **/
public class AppConfig {
    private final String MODULE_MAIN = "com.module.main.MainAppDelegate";
    private final String HOME_MUDLE_APP = "com.module.home.HomeApplicationDelegate";
    private final String HOME_MUDLE_H5 = "com.module.h5.H5AppDelegate";
    private static AppConfig INSTANCE = new AppConfig();
    private Application mApplication;

    private List<IApplicationDelegate> mAppComponentList;
    public String[] mModuleApp = new String[]{
            MODULE_MAIN, HOME_MUDLE_APP, HOME_MUDLE_H5
    };

    private AppConfig() {
        mAppComponentList = new ArrayList<>();
    }

    public void cacheApplication(Application application) {
        this.mApplication = application;
    }

    public Application getApplication() {
        return mApplication;
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    //初始化各个组件
    public void registerAllComponent(Application application) {
        for (String moduleApp : mModuleApp) {
            try {
                Class clazz = Class.forName(moduleApp);
                IApplicationDelegate app = (IApplicationDelegate) clazz.newInstance();
                mAppComponentList.add(app);
                app.initModuleApp(application);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public void onLowMemory() {
        if (mAppComponentList != null) {
            for (IApplicationDelegate appDelegate : mAppComponentList) {
                appDelegate.onModuleAppLowMemory();
            }
        }
    }

}
