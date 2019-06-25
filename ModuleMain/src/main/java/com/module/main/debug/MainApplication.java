package com.module.main.debug;

import com.lib.common.app.AppConfig;
import com.lib.common.app.BaseApplication;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/20
 * 描述： 单独运行时使用
 **/
public class MainApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        AppConfig.getInstance().registerComponent(this, AppConfig.getInstance().MODULE_MAIN);
    }
}
