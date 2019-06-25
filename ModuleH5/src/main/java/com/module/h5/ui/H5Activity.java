package com.module.h5.ui;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lib.common.constant.PageConstant;
import com.lib.common.ui.activity.BaseActivity;
import com.module.h5.R;
import com.module.h5.presenter.H5Presenter;
import com.module.h5.widgets.X5WebView;

@Route(path = PageConstant.ActivityRoute.ROUTE_H5)
public class H5Activity extends BaseActivity<H5Presenter> {
    private X5WebView mWebView;
    @Autowired(name = PageConstant.PageParamKey.KEY_STRING1)
    public String mUrl;

    @Override
    protected H5Presenter createPresenter() {
        return new H5Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_h5_main;
    }

    @Override
    protected void initLayoutView(Bundle savedInstanceState) {
        mWebView = findViewById(R.id.wv_h5_main);
        mWebView.loadUrl("https://www.baidu.com");
    }
}
