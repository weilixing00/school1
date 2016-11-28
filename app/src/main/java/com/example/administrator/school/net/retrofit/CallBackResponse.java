package com.example.administrator.school.net.retrofit;

/**
 * Created by server on 2016/6/21.
 * code 返回码
 * error 出现错误时候的错误表示
 */

public class CallBackResponse<T> {
    /**
     * 执行成功的回调
     *
     * @param t
     */
    public void onSuccess(T t) {
    }

    /**
     * 出现错误的回调
     *
     * @param t
     */
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    /**
     * 连接失败的回调
     *
     * @param message
     */
    public void onFail(String message) {
    }

}