package com.module.h5.debug;

import com.lib.common.app.AppConfig;
import com.lib.common.app.BaseApplication;

public class H5TestApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        AppConfig.getInstance().registerComponent(this, AppConfig.getInstance().HOME_MUDLE_H5);
    }
}
