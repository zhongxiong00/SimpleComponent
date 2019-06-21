package com.lib.common.viewutils;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

/**
 * 作者： 钟雄辉
 * 时间： 2018/9/26
 * 描述： View操作相关
 **/
public class ViewUtils {
    public static void setTextViewDrawable(TextView tv, Drawable drawableLeft, Drawable drawableRight) {
        if (tv != null) {
            if (drawableLeft != null) {
                drawableLeft.setBounds(0, 0, drawableLeft.getMinimumWidth(), drawableLeft.getMinimumHeight());
            }
            tv.setCompoundDrawables(drawableLeft, null, null, null);
            if (drawableRight != null) {
                drawableRight.setBounds(0, 0, drawableRight.getMinimumWidth(), drawableRight.getMinimumHeight());
            }
            tv.setCompoundDrawables(null, null, drawableRight, null);
        }
    }

}
