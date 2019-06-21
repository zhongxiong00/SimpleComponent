package com.module.home.ui;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lib.common.constant.PageConstant;
import com.lib.common.mvp.MvpBasePresenter;
import com.lib.common.ui.activity.BaseActivity;
import com.module.home.R;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/21
 * 描述： 主界面单独运行的时候，用来承载fragment
 **/
public class TestActivity extends BaseActivity {


    @Override
    protected MvpBasePresenter createPresenter() {
        return new MvpBasePresenter() {
            @Override
            public void createModel() {

            }
        };
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initLayoutView(Bundle savedInstanceState) {
        switchFragment(R.id.fl_home_content, (Fragment) ARouter.getInstance().build(PageConstant.FragmentRoute.ROUTE_HOMEPAGE).navigation());
    }
}
