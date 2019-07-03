package com.lib.common.app;

import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lib.imageloader.ImageLoader;
import com.lib.libcommon.BuildConfig;
import com.squareup.leakcanary.LeakCanary;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/20
 * 描述： 所有module单独运行的时候，所用的Application必须继承此Application
 * module获取application通过AppConfig
 **/
public class BaseApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initCommonApp();
        initAllComponent();
    }

    private void initCommonApp() {//所有组件单独运行时都需要做的初始化工作
        if (BuildConfig.DEBUG) {
            if (!LeakCanary.isInAnalyzerProcess(this)) {
                LeakCanary.install(this);
            }
            ARouter.openLog();
            ARouter.openDebug();
        }
        ImageLoader.getInstance().getLoadStrategy().init();
        ARouter.init(this);
        AppConfig.getInstance().cacheApplication(this);
    }

    private void initAllComponent() {//初始化所有注册的组件
        AppConfig.getInstance().registerAllComponent(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        ImageLoader.getInstance().getLoadStrategy().clearMemoryCache(this);
        AppConfig.getInstance().onLowMemory();
    }
}
