package com.lib.network.deliver;


import android.os.Handler;
import android.os.Looper;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/24
 * 描述： 处理回调的结果，开启异步线程解析，结果发送到主线程执行
 **/
public class AndroidDeliver {
    private static AndroidDeliver mDeliver = new AndroidDeliver();
    private Handler mMainHander;

    private AndroidDeliver() {
        mMainHander = new Handler(Looper.getMainLooper());
    }

    public static AndroidDeliver get() {
        return mDeliver;
    }

    public void executor(Runnable runnable) {
        if (runnable != null) {
            mMainHander.post(runnable);
        }
    }
}
