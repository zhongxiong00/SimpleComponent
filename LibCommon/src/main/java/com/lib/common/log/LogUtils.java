package com.lib.common.log;

import android.text.TextUtils;
import android.util.Log;

import com.lib.libcommon.BuildConfig;


/**
 * 作者： 钟雄辉
 * 时间： 2018/6/28
 * 描述： 统一日志管理类
 **/

public class LogUtils {

    /**
     * 日志输出时的TAG
     */
    private static String mTag = "MyLog";

    /**
     * 以级别为 d 的形式输出LOG
     */
    public static void v(String msg) {
        if (BuildConfig.DEBUG) {
            Log.v(mTag, msg);
        }
    }

    /**
     * 以级别为 d 的形式输出LOG
     */
    public static void d(String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(mTag, msg);
        }
    }

    /**
     * 以级别为 i 的形式输出LOG
     */
    public static void i(String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(mTag, msg);
        }
    }

    /**
     * 以级别为 w 的形式输出LOG
     */
    public static void w(String msg) {
        if (BuildConfig.DEBUG) {
            Log.w(mTag, msg);
        }
    }

    /**
     * 以级别为 w 的形式输出Throwable
     */
    public static void w(Throwable tr) {
        if (BuildConfig.DEBUG) {
            Log.w(mTag, "", tr);
        }
    }

    /**
     * 以级别为 w 的形式输出LOG信息和Throwable
     */
    public static void w(String msg, Throwable tr) {
        if (BuildConfig.DEBUG && null != msg) {
            Log.w(mTag, msg, tr);
        }
    }

    /**
     * 以级别为 e 的形式输出LOG
     */
    public static void e(String msg) {
        if (BuildConfig.DEBUG) {
            if (!TextUtils.isEmpty(msg) && msg.length() > 2000) {
                for (int i = 0; i < msg.length(); i += 2000) {
                    if (i + 2000 < msg.length())
                        Log.e(mTag, msg.substring(i, i + 2000));
                    else
                        Log.e(mTag, msg.substring(i, msg.length()));
                }
            } else {
                Log.e(mTag, msg);
            }
        }
    }


    /**
     * 以级别为 e 的形式输出Throwable
     */
    public static void e(Throwable tr) {
        if (BuildConfig.DEBUG) {
            Log.e(mTag, "", tr);
        }
    }

    /**
     * 以级别为 e 的形式输出LOG信息和Throwable
     */
    public static void e(String msg, Throwable tr) {
        if (BuildConfig.DEBUG && null != msg) {
            Log.e(mTag, msg, tr);
        }
    }
}
