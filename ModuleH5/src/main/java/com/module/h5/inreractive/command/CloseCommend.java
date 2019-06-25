package com.module.h5.inreractive.command;

import com.module.h5.ui.H5Activity;
import com.module.h5.widgets.X5WebView;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/25
 * 描述： 关闭页面命令
 **/
public class CloseCommend extends BaseCommond {
    public CloseCommend(X5WebView x5WebView) {
        super(x5WebView);
    }

    @Override
    public void execute() {
        ((H5Activity) getX5WebView().getContext()).finish();
    }
}
