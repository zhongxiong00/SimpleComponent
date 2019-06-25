package com.module.h5.debug;

import com.lib.common.app.BaseApplication;
import com.lib.common.log.LogUtils;
import com.tencent.smtt.sdk.QbSdk;

public class H5TestApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
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
        QbSdk.initX5Environment(this, cb);
    }
}
