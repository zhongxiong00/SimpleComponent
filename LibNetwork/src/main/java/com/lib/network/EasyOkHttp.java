package com.lib.network;

import com.lib.network.request.builder.GetRequestBuilder;
import com.lib.network.request.OkHttpRequest;
import com.lib.network.request.builder.PostFileBuilder;
import com.lib.network.request.builder.PostRequestBuilder;

import java.io.File;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/24
 * 描述： 请求客户端
 **/
public class EasyOkHttp {
    private OkHttpClient mOkhttpClient;

    private EasyOkHttp() {
        mOkhttpClient = new OkHttpClient();
    }

    private static class EasyOkHttpInner {
        public static EasyOkHttp INSTANCE = new EasyOkHttp();
    }

    public static EasyOkHttp getInstance() {
        return EasyOkHttpInner.INSTANCE;
    }

    //get请求
    public OkHttpRequest<GetRequestBuilder> get() {
        return new OkHttpRequest<>(new GetRequestBuilder(), mOkhttpClient);
    }

    //post请求
    public OkHttpRequest<PostRequestBuilder> post() {
        return new OkHttpRequest<>(new PostRequestBuilder(), mOkhttpClient);
    }

    //下载文件
    public OkHttpRequest<GetRequestBuilder> download() {
        return new OkHttpRequest<>(new GetRequestBuilder(), mOkhttpClient);
    }

    //上传文件
    public OkHttpRequest<PostFileBuilder> postFile(List<File> files) {
        return new OkHttpRequest<>(new PostFileBuilder(files), mOkhttpClient);
    }

    //根据tag取消网络任务
    public void cancelTag(Object tag) {
        for (okhttp3.Call call : mOkhttpClient.dispatcher().queuedCalls()) {
            if (tag.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (okhttp3.Call call : mOkhttpClient.dispatcher().runningCalls()) {
            if (tag.equals(call.request().tag())) {
                call.cancel();
            }
        }
    }
}
