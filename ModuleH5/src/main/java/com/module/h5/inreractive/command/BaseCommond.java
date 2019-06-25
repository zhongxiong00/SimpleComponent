package com.module.h5.inreractive.command;

import com.module.h5.widgets.X5WebView;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/25
 * 描述： 命令模式解耦交互
 * 优点:某个交互不需要了，直接删除对应的命令即可
 **/
public abstract class BaseCommond {
    private X5WebView x5WebView;

    public BaseCommond(X5WebView x5WebView) {
        this.x5WebView = x5WebView;
    }

    public X5WebView getX5WebView() {
        return x5WebView;
    }

    public abstract void execute();
}
