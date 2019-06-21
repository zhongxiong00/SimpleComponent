package com.module.main.widgets;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.module.main.R;


/**
 * 作者： 钟雄辉
 * 时间： 2018/7/11
 * 描述： 主界面底部单个tab
 **/
public class MainTabItemView extends RelativeLayout {
    private TextView mTvTitle;
    private ImageView mIcon;

    public MainTabItemView(Context context) {
        this(context, null);
    }

    public MainTabItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MainTabItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public MainTabItemView setText(String txt) {
        mTvTitle.setText(txt);
        return this;
    }

    public MainTabItemView setIconRecource(@DrawableRes int selectorId) {
        mIcon.setImageResource(selectorId);
        return this;
    }


    private void init() {
        inflate(getContext(), R.layout.item_main_bottomtab, this);
        mTvTitle = findViewById(R.id.tv_tabname);
        mIcon = findViewById(R.id.iv_tabicon);
    }
}
