package com.lib.network.response;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public interface IResponse<T> {
    T parseResult(Response response) throws IOException;

    void onFail(Call call, Exception e);

    void onSuccess(Call call, T result);
}
