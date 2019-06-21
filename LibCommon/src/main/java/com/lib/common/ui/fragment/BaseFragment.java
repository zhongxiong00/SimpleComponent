package com.lib.common.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lib.common.mvp.MvpBaseFragment;
import com.lib.common.presenter.BasePresenter;
import com.lib.common.ui.iview.IBaseView;
import com.lib.common.viewutils.ToastUtil;


/**
 * 作者： 钟雄辉
 * 时间： 2018/9/20
 * 描述： 放置公共业务Fragment
 **/
public abstract class BaseFragment<P extends BasePresenter> extends MvpBaseFragment<P> implements IBaseView {
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public final View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    @Override
    public void showToastMsg(String msg) {
        ToastUtil.showToastShort(getContext(), msg);
    }

    public abstract int getLayoutId();

    protected abstract void initView(View view);

    protected abstract void initData();
}
