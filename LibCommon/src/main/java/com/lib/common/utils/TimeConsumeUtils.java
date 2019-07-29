package com.lib.common.utils;

/**
 * 作者： 钟雄辉
 * 时间： 2019/7/29
 * 描述： 耗时统计工具
 **/
public class TimeConsumeUtils {
    private static final ThreadLocal<Long> mTimeCurrent = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static void begin() {
        mTimeCurrent.set(System.currentTimeMillis());
    }

    public static long end() {
        return System.currentTimeMillis() - mTimeCurrent.get();
    }
}
