package com.lib.common.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.lib.common.mvp.MvpBaseActivity;
import com.lib.common.presenter.BasePresenter;
import com.lib.common.ui.iview.IBaseView;
import com.lib.common.viewutils.ToastUtil;
import com.lib.network.EasyOkHttp;

import java.util.List;


/**
 * 作者： 钟雄辉
 * 时间： 2018/6/27
 * 描述： 放置公共业务的Activity
 **/
public abstract class BaseActivity<P extends BasePresenter> extends MvpBaseActivity<P> implements IBaseView {

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initLayoutView(savedInstanceState);
    }

    protected void switchFragment(int resId, Fragment targetFragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm
                .beginTransaction();

        if (targetFragment != null) {
            List<Fragment> frgmentList = fm.getFragments();
            if (frgmentList != null) { //先把其他的隐藏
                for (Fragment f : frgmentList) {
                    if (f.isVisible() && f == targetFragment) {
                        return;
                    }
                    transaction.hide(f);
                }
            }
            if (!targetFragment.isAdded()) {
                transaction
                        .add(resId, targetFragment)
                        .commit();
            } else {
                transaction
                        .show(targetFragment)
                        .commit();
            }
        }
    }

    @Override
    public void showToastMsg(String msg) {
        ToastUtil.showToastShort(this, msg);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EasyOkHttp.getInstance().cancelTag(this);
    }

    protected abstract int layoutId();

    protected abstract void initLayoutView(Bundle savedInstanceState);
}
