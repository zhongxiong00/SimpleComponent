package com.lib.common.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lib.common.presenter.BaseLoadingPresenter;


/**
 * 作者： 钟雄辉
 * 时间： 2019/5/7
 * 描述： 懒加载Fragment
 **/
public abstract class LazyLoadFragment<P extends BaseLoadingPresenter> extends BaseFragment<P> {
    private boolean isInitView = false;
    private boolean isVisible = false;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isInitView = true;
        isCanLoadData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isVisible = true;
            isCanLoadData();
        } else {
            isVisible = false;
        }
    }

    private void isCanLoadData() {
        //所以条件是view初始化完成并且对用户可见
        if (isInitView && isVisible) {
            lazyLoad();
            //防止重复加载数据
            isInitView = false;
            isVisible = false;
        }
    }

    /**
     * 加载要显示的数据
     */
    protected abstract void lazyLoad();
}
