package com.module.home;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lib.common.app.IApplicationDelegate;
import com.lib.common.app.ITabPage;
import com.lib.common.app.TabFactory;
import com.lib.common.constant.PageConstant;
import com.lib.common.log.LogUtils;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/21
 * 描述： 作为一个单独的组件时，框架自动初始化
 **/
public class HomeApplicationDelegate implements IApplicationDelegate {
    @Override
    public void initModuleApp(Application application) {
        LogUtils.e("初始化首页组件");
        TabFactory.getInstance().setTabHomePage(new ITabPage() {
            @Override
            public String getTabName() {
                return "首页";
            }

            @Override
            public int iconRes() {
                return R.drawable.selector_tab_homepage;
            }

            @Override
            public Fragment getFragment() {
                return (Fragment) ARouter.getInstance().build(PageConstant.FragmentRoute.ROUTE_HOMEPAGE).navigation();
            }
        });
    }

    @Override
    public void onModuleAppLowMemory() {

    }
}
