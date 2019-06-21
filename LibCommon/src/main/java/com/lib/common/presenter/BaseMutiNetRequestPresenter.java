package com.lib.common.presenter;


import com.lib.common.ui.iview.ILoadingView;

import java.util.Arrays;

/**
 * 作者： 钟雄辉
 * 时间： 2018/10/17
 * 描述： 一个界面多接口请求
 **/
public abstract class BaseMutiNetRequestPresenter<V extends ILoadingView> extends BaseLoadingPresenter<V> {
    private int mNetCount;
    private boolean[] mSuccessTag;//表示网络请求是否成功
    private int mIndex = 0;

    public BaseMutiNetRequestPresenter(int netNum) {
        mNetCount = netNum;
        mSuccessTag = new boolean[netNum];
    }

    protected void start() { //开始工作
        mIndex = 0;
        Arrays.fill(mSuccessTag, false);
    }

    protected void onOneNetReturn(boolean isSuccess) { //每个接口请求回来之后都需要调用此方法
        if (mIndex < mSuccessTag.length) {
            mSuccessTag[mIndex++] = isSuccess;
        }
        if (mIndex == mNetCount) {
            for (int i = 0; i < mSuccessTag.length; i++) {
                if (!mSuccessTag[i]) {
                    onHasNetFail();
                    return;
                }
            }
            onAllNetSuccess();
        }
    }

    protected abstract void onAllNetSuccess(); //所有接口都请求成功

    protected abstract void onHasNetFail();//有某个接口请求失败
}
