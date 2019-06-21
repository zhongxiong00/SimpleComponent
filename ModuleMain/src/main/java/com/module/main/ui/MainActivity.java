package com.module.main.ui;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lib.common.constant.PageConstant;
import com.lib.common.ui.activity.BaseActivity;
import com.lib.common.widgets.FixedViewPage;
import com.module.main.R;
import com.module.main.presenter.MainPresenter;
import com.module.main.ui.iview.IMainView;
import com.module.main.widgets.MainTabView;

@Route(path = PageConstant.ActivityRoute.ROUTE_MAIN)
public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {
    private MainTabView mTabView;
    private FixedViewPage mVpContent;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initLayoutView(Bundle savedInstanceState) {
        mTabView = findViewById(R.id.tab_main_layout);
        mVpContent = findViewById(R.id.vp_content);
        mTabView.bindViewPage(mVpContent, getSupportFragmentManager());
    }
}
