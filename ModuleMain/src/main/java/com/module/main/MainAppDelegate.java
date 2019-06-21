package com.module.main;

import android.app.Application;

import com.lib.common.app.IApplicationDelegate;
import com.lib.common.log.LogUtils;

public class MainAppDelegate implements IApplicationDelegate {
    @Override
    public void initModuleApp(Application application) {
        LogUtils.e("Main组件初始化");
    }

    @Override
    public void onModuleAppLowMemory() {

    }
}
