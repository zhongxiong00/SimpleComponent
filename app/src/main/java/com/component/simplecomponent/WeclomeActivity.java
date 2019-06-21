package com.component.simplecomponent;

import android.os.Bundle;

import com.lib.common.ui.activity.BaseActivity;

public class WeclomeActivity extends BaseActivity<WelcomePresenter> implements IWelcomeView {


    @Override
    protected WelcomePresenter createPresenter() {
        return new WelcomePresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_weclome;
    }

    @Override
    protected void initLayoutView(Bundle savedInstanceState) {
        presenter.init();
    }
}
