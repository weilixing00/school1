package com.example.administrator.school.net.retrofit;

import android.text.TextUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by server on 2016/6/21.
 */
public class BaseCallBack<T extends BaseResponse> implements Callback<T> {
    private final CallBackResponse<T> mResponse;

    public BaseCallBack(CallBackResponse<T> mResponse) {
        this.mResponse = mResponse;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            T t = response.body();
            if (t == null || t.code != 0|| !TextUtils.isEmpty(t.error)) {
                mResponse.onFail(t == null ? "请求错误" : t.error+"");
            } else {
                mResponse.onSuccess(t);
            }
        } else {
            mResponse.onFail("连接失败");
        }
    }


    @Override
    public void onFailure(Call<T> call, Throwable t) {
        mResponse.onError(t);
    }
}