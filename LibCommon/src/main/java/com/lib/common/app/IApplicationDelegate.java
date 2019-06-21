package com.lib.common.app;

import android.app.Application;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/20
 * 描述： 所有module不单独运行时所用的application
 **/
public interface IApplicationDelegate {
    void onCreate(Application application);

    void onLowMemory();
}
