package com.lib.common.app;

import android.app.Application;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/20
 * 描述： module作为组件运行时需要针对该module定制的Application
 **/
public interface IApplicationDelegate {
    void initModuleApp(Application application);

    void onModuleAppLowMemory();
}
