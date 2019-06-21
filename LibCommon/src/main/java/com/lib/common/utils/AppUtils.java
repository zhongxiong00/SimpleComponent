package com.lib.common.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;

import com.lib.common.viewutils.ToastUtil;

import java.util.List;


/**
 * 作者： 钟雄辉
 * 时间： 2018/9/26
 * 描述： App相关
 **/
public class AppUtils {
    private static long currentSystemTime;
    private static Application mApplication;


    public static void cacheContext(Application application) {
        mApplication = application;
    }

    public static Application getApplication() {
        if (mApplication == null) {
            throw new RuntimeException("must invoke cacheContext");
        }
        return mApplication;
    }

    public static void exitAfterPress(Activity activity, long delayTime) {
        if (System.currentTimeMillis() - currentSystemTime > delayTime && activity != null) { //连续按两次间隔小于两秒
            ToastUtil.showToastShort(activity, "再按一次退出程序");
            currentSystemTime = System.currentTimeMillis();
        } else {
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static boolean isMyAppProcess(Context c) { //是否是在自己app的进程
        if (c == null) {
            return false;
        }
        return c.getPackageName().equals(getCurrentProcessName(c));
    }

    public static String getCurrentProcessName(Context c) { //获取当前进程名
        int pid = android.os.Process.myPid();
        ActivityManager manager = (ActivityManager) c.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = manager.getRunningAppProcesses();
        if (runningApps == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
            if (procInfo.pid == pid) {
                return procInfo.processName;
            }
        }
        return "";
    }

    public static boolean isActivityForeground(Context context, String className) {//判断Activity是否在前台展示
        if (context == null || TextUtils.isEmpty(className)) { //需要权限<uses-permission android:name="android.permission.GET_TASKS"/>
            return false;
        }
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(1);
        if (list != null && list.size() > 0) {
            ComponentName cpn = list.get(0).topActivity;
            if (className.equals(cpn.getClassName())) {
                return true;
            }
        }

        return false;
    }

    public static boolean isAppRunning(Context context, String pkgName) { //判断app是否在运行
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                    .getRunningAppProcesses();
            if (appProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
                    if (appProcess.processName.equals(pkgName)) {
                        if (appProcess.importance != ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void openSystemSetting(Context c) {//打开系统设置页面
        if (c != null) {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
            c.startActivity(intent);
        }
    }

    public static void launchApp(Context context, String pkgName) {
        Intent launchIntent = context.getPackageManager().
                getLaunchIntentForPackage(pkgName);
        launchIntent.setFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        context.startActivity(launchIntent);
    }

    public static boolean isIntentAvailable(Context context, Intent intent) { //判断intent是否可用
        return context.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null;
    }
}
