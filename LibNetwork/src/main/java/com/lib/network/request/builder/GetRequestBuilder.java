package com.lib.network.request.builder;


import android.net.Uri;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.Request;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/24
 * 描述： get请求
 **/
public class GetRequestBuilder extends BaseRequestBuilder {


    @Override
    public Request build() {
        Request request = new Request.Builder()
                .url(appendParams(url, params))
                .headers(appendHeaders())
                .get()
                .build();
        return request;
    }

    protected String appendParams(String url, Map<String, String> params) {
        if (url == null || params == null || params.isEmpty()) {
            return url;
        }
        Uri.Builder builder = Uri.parse(url).buildUpon();
        Set<String> keys = params.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            builder.appendQueryParameter(key, params.get(key));
        }
        return builder.build().toString();
    }
}
