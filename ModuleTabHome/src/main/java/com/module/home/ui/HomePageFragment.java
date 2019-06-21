package com.module.home.ui;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lib.common.constant.PageConstant;
import com.lib.common.ui.fragment.BaseFragment;
import com.module.home.R;
import com.module.home.presenter.HomePagePresenter;
import com.module.home.ui.iview.IHomePageView;

@Route(path = PageConstant.FragmentRoute.ROUTE_HOMEPAGE)
public class HomePageFragment extends BaseFragment<HomePagePresenter> implements IHomePageView {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected HomePagePresenter createPresenter() {
        return new HomePagePresenter();
    }
}
