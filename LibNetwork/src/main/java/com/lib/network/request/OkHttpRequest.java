package com.lib.network.request;


import com.lib.network.deliver.AndroidDeliver;
import com.lib.network.request.builder.BaseRequestBuilder;
import com.lib.network.response.IResponse;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/24
 * 描述： http请求封装
 **/
public class OkHttpRequest<T extends BaseRequestBuilder> {

    private T requestBuilder;
    private OkHttpClient okHttpClient;

    public OkHttpRequest(T requestBuilder, OkHttpClient okHttpClient) {
        this.requestBuilder = requestBuilder;
        this.okHttpClient = okHttpClient;
    }

    //设置请求url
    public OkHttpRequest url(String url) {
        if (requestBuilder != null) {
            requestBuilder.url(url);
        }
        return this;
    }

    //设置请求头
    public OkHttpRequest head(Map<String, String> heads) {
        if (requestBuilder != null) {
            requestBuilder.header(heads);
        }
        return this;
    }

    //设置请求参数
    public OkHttpRequest params(Map<String, String> params) {
        if (requestBuilder != null) {
            requestBuilder.params(params);
        }
        return this;
    }

    //同步方式请求
    public Response requestSync() {
        if (requestBuilder != null && okHttpClient != null) {
            Call call = okHttpClient.newCall(requestBuilder.build());
            try {
                Response response = call.execute();
                return response;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //异步方式请求
    public void request(final IResponse response) {
        if (requestBuilder != null && okHttpClient != null) {
            Call call = okHttpClient.newCall(requestBuilder.build());
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    if (response != null) {
                        response.onFail(call, e);
                    }
                }

                @Override
                public void onResponse(final Call call, final Response okhttpResponse) {
                    if (response != null) {
                        if (okhttpResponse != null) {
                            try {
                                final Object o = response.parseResult(okhttpResponse); //异步线程解析数据
                                if (o != null) {
                                    AndroidDeliver.get().executor(new Runnable() {//结果送到主线程
                                        @Override
                                        public void run() {
                                            response.onSuccess(call, o);
                                        }
                                    });
                                } else {

                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                    }
                }
            });
        }
    }
}
