package com.module.main.widgets;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.lib.common.app.ITabPage;
import com.lib.common.app.TabFactory;
import com.lib.common.widgets.TabSelectAdapter;

import java.util.ArrayList;

public class MainTabView extends TabLayout {
    private ViewPager mViewPage;
    private ArrayList<Fragment> mFragments;

    public MainTabView(Context context) {
        super(context);
    }

    public MainTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mFragments = new ArrayList<>();
        if (TabFactory.getInstance().getTabHomePage() != null) { //添加首页
            ITabPage homeTab = TabFactory.getInstance().getTabHomePage();
            mFragments.add(homeTab.getFragment());
            addTab(newTab().setCustomView(new MainTabItemView(getContext()).setIconRecource(homeTab.iconRes()).setText(homeTab.getTabName())));
        }
    }

    public void bindViewPage(ViewPager viewPager, FragmentManager manager) {
        mViewPage = viewPager;

        if (mViewPage != null) {
            addOnTabSelectedListener(new TabSelectAdapter() {

                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    mViewPage.setCurrentItem(tab.getPosition(), false);
                }
            });
            mViewPage.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    getTabAt(position).select();
                }
            });
            mViewPage.setAdapter(new FragmentStatePagerAdapter(manager) {
                @Override
                public Fragment getItem(int i) {
                    return mFragments.get(i);
                }

                @Override
                public int getCount() {
                    return mFragments.size();
                }
            });
        }

    }
}
