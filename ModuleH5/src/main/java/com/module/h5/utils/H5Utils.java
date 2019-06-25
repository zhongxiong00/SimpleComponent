package com.module.h5.utils;

import android.os.Build;

import com.lib.common.log.LogUtils;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;


public class H5Utils {
    public static void invokeJs(WebView webView, String js) {
        LogUtils.e("调用js: " + js);
        if (webView != null) {
            if (Build.VERSION.SDK_INT < 19) {
                webView.loadUrl(js);
            } else {
                webView.evaluateJavascript(js, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String s) {

                    }
                });
            }
        }
    }
}
