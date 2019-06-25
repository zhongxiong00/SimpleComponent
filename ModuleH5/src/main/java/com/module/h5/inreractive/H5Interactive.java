package com.module.h5.inreractive;

import com.module.h5.inreractive.command.CloseCommend;
import com.module.h5.widgets.X5WebView;
import com.tencent.smtt.sdk.WebView;

/**
 * 作者： 钟雄辉
 * 时间： 2018/7/12
 * 描述： H5调用Android交互的方法都写在这里
 * 注意： 方法必须是public static 并且第一个参数必须是 WebView
 **/
public class H5Interactive {
    public static void close(X5WebView webView) {
        ((IH5InvokeAndroid) webView).invoke(new CloseCommend(webView));
    }
}
