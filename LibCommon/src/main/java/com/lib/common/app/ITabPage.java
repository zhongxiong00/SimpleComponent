package com.lib.common.app;


import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/21
 * 描述： 对主界面Tab的规约
 **/
public interface ITabPage {
    String getTabName();

    @DrawableRes
    int iconRes();

    Fragment getFragment();
}
