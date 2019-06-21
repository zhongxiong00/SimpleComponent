package com.component.simplecomponent;

import android.os.Handler;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lib.common.constant.PageConstant;
import com.lib.common.presenter.BasePresenter;


public class WelcomePresenter extends BasePresenter<IWelcomeView> {

    public void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ARouter.getInstance().build(PageConstant.ActivityRoute.ROUTE_MAIN).navigation();
            }
        }, 1500);
    }

    @Override
    public void createModel() {

    }
}
