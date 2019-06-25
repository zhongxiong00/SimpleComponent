package com.module.h5.widgets;


import com.module.h5.bridge.InjectedChromeClient;

public class H5ChromeClient extends InjectedChromeClient {
    public H5ChromeClient(String injectedName, Class injectedCls) {
        super(injectedName, injectedCls);
    }
}
