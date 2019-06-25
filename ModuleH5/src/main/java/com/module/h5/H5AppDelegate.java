package com.module.h5;

import android.app.Application;

import com.lib.common.app.IApplicationDelegate;
import com.lib.common.log.LogUtils;
import com.tencent.smtt.sdk.QbSdk;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/25
 * 描述： H5组件的Application
 **/
public class H5AppDelegate implements IApplicationDelegate {
    @Override
    public void initModuleApp(Application application) {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                LogUtils.e("X5WebView  onViewInitFinished: " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                LogUtils.e("X5WebView  onCoreInitFinished");
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(application, cb);
    }

    @Override
    public void onModuleAppLowMemory() {

    }
}
