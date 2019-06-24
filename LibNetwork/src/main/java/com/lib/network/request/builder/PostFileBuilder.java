package com.lib.network.request.builder;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * 作者： 钟雄辉
 * 时间： 2019/6/24
 * 描述： 上传文件
 **/
public class PostFileBuilder extends BaseRequestBuilder {
    private List<File> files;

    public PostFileBuilder(List<File> files) {
        this.files = files;
    }

    @Override
    public Request build() {
        MediaType MutilPart_Form_Data = MediaType.parse("multipart/form-data; charset=utf-8");
        MultipartBody.Builder requestBodyBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        //添加参数
        if (params != null) {
            for (String key : params.keySet()) {
                requestBodyBuilder.addFormDataPart(key, params.get(key));
            }
        }
        //循环添加文件
        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            requestBodyBuilder.addFormDataPart("imgs", file.getName(), RequestBody.create(MutilPart_Form_Data, file));
        }
        RequestBody requestBody = requestBodyBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return request;
    }
}
