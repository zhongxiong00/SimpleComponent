package com.lib.common.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.lib.network.EasyOkHttp;


/**
 * 作者： 钟雄辉
 * 时间： 2018/6/28
 * 描述： Mvp设计模式基类fragment
 **/
@SuppressWarnings("rawtypes")
public abstract class MvpBaseFragment<P extends MvpBasePresenter>
        extends Fragment implements IMvpBaseView {
    protected P presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }


    protected <T extends View> T getView(View view, int resId) {
        return view.findViewById(resId);
    }

    protected abstract P createPresenter();


}