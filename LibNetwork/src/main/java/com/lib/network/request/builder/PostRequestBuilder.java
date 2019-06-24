package com.lib.network.request.builder;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/24
 * 描述： post请求
 **/
public class PostRequestBuilder extends BaseRequestBuilder {
    @Override
    public Request build() {
        RequestBody requestBody = appendParam()
                .build();
        Request request = new Request.Builder()
                .tag(tag)
                .url(url)
                .headers(appendHeaders())
                .post(requestBody)
                .build();
        return request;
    }

    private FormBody.Builder appendParam() {
        FormBody.Builder formBuilder = new FormBody.Builder();
        if (params != null || !params.isEmpty()) {
            for (String key : heads.keySet()) {
                formBuilder.add(key, heads.get(key));
            }
        }
        return formBuilder;
    }
}
