package com.example.administrator.school.net.retrofit;

/**
 * Created by server on 2016/6/21.
 * 所有网络请求返回类的基类
 */

public class BaseResponse {
    public int code;
    public String error;

    public BaseResponse() {
    }

    public BaseResponse(int code) {
        this.code = code;
    }


}
