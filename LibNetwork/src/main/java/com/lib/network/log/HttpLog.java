package com.lib.network.log;

import android.util.Log;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/24
 * 描述：
 **/
public class HttpLog {
    private static final String TAG = "HttpLog";
    private static boolean isOpenLog;

    public static void openLog(boolean isOpen) {
        isOpenLog = isOpen;
    }

    public static void debug(String msg) {
        if (isOpenLog) {
            Log.e(TAG, msg);
        }
    }
}
