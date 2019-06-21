package com.lib.common.app;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/21
 * 描述： Tab构建工厂
 **/
public class TabFactory {
    private ITabPage mTabHomePage;

    private TabFactory() {

    }

    public static class TabFactoryInner {
        public static TabFactory FACTORY = new TabFactory();
    }

    public static TabFactory getInstance() {
        return TabFactoryInner.FACTORY;
    }

    public void setTabHomePage(ITabPage homeTabPage) {
        mTabHomePage = homeTabPage;
    }

    public ITabPage getTabHomePage() {
        return mTabHomePage;
    }
}
