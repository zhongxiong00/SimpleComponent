package com.lib.common.http.parser;


import com.lib.common.http.ResultBean;
import com.lib.common.log.LogUtils;
import com.lib.network.log.HttpLog;
import com.lib.network.response.OkHttpResponse;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;


/**
 * 作者： 钟雄辉
 * 时间： 2018/7/24
 * 描述：
 **/
public abstract class GsonHttpCallback<T> extends OkHttpResponse<ResultBean<T>> {

    private Type mType;


    public GsonHttpCallback() {
        mType = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public GsonHttpCallback(Type type) {
        this.mType = type;
    }


    @Override
    public ResultBean<T> parseResult(Response response) throws IOException {
        String json;
        json = response.body().string();
        HttpLog.debug("网络请求url: " + response.request().url());
        HttpLog.debug("网络接口返回： " + json);
        ResultBean<T> t = null;

        Type type = new ParameterizedTypeImpl(ResultBean.class, new Type[]{mType});
        try {
            t = GsonUtil.getGson().fromJson(json, type);
        } catch (Exception e) {
            LogUtils.e("网络数据gson解析异常：" + e.toString());
        }
        return t;
    }

    @Override
    public void onFail(Call call, Exception e) {

    }

    @Override
    public void onSuccess(Call call, ResultBean<T> result) {

    }


    protected abstract void error(String msg);

    protected abstract void response(ResultBean<T> t);
}
