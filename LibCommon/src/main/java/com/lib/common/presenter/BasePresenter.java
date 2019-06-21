package com.lib.common.presenter;


import com.lib.common.mvp.MvpBasePresenter;
import com.lib.common.ui.iview.IBaseView;

public abstract class BasePresenter<V extends IBaseView> extends MvpBasePresenter<V> {
    public abstract void createModel();//创建对应的model
}
