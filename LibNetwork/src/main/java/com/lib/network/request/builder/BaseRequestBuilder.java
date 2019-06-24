package com.lib.network.request.builder;

import java.util.Map;

import okhttp3.Headers;
import okhttp3.Request;

public abstract class BaseRequestBuilder {
    protected String url;
    protected Object tag;
    protected Map<String, String> heads;
    protected Map<String, String> params;

    public BaseRequestBuilder tag(Object tag) {
        this.tag = tag;
        return this;
    }

    public BaseRequestBuilder url(String url) {
        this.url = url;
        return this;
    }

    public BaseRequestBuilder header(Map<String, String> heads) {
        this.heads = heads;
        return this;
    }

    public BaseRequestBuilder params(Map<String, String> params) {
        this.params = params;
        return this;
    }

    protected Headers appendHeaders() {
        Headers.Builder headerBuilder = new Headers.Builder();
        if (heads != null || !heads.isEmpty()) {
            for (String key : heads.keySet()) {
                headerBuilder.add(key, heads.get(key));
            }
        }
        return headerBuilder.build();
    }

    public abstract Request build();
}
