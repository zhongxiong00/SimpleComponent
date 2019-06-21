package com.lib.common.app;


import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;

public interface ITabPage {
    String getTabName();

    @DrawableRes
    int iconRes();

    Fragment getFragment();
}
