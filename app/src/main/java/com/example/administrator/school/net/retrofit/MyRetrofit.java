package com.example.administrator.school.net.retrofit;

import com.example.administrator.school.base.BaseApplication;
import com.example.administrator.school.constant.HttpConstant;
import com.example.administrator.school.net.service.RequestService;
import com.example.administrator.school.utils.JUtils;
import com.facebook.stetho.okhttp3.BuildConfig;
import com.socks.library.KLog;

import java.io.File;
import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2016/6/15.
 * 网络层的二次封装
 */
public class MyRetrofit {
    public static Retrofit retrofit = null;

    public static RequestService createService() {
        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            //设置缓存
            setCache(builder);

           // Log信息拦截器，代码略

            ConfigRetrofitLog(builder);
            //设置cookie，代码略
            setCookie(builder);

            //     设置超时和重连，代码略
            setReConnect(builder);


            //以上设置结束，才能build(),不然设置白搭
            OkHttpClient okHttpClient = builder.build();

            retrofit = new Retrofit.Builder()
                    // TODO: 2016/6/15
                    .baseUrl(HttpConstant.HOST)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

//        RequestService requestService = retrofit.create(RequestService.class);

        return retrofit.create(RequestService.class);
    }

    private static void setReConnect(OkHttpClient.Builder builder) {
        //设置超时
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
    }

    private static void setCookie(OkHttpClient.Builder builder) {
        final CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        builder.cookieJar(new CookieManger(BaseApplication.context));


    }

    private static void ConfigRetrofitLog(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            // Log信息拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //设置 Debug Log 模式
            builder.addInterceptor(loggingInterceptor);
        }
    }

    private static void setCache(OkHttpClient.Builder builder) {
        if (BaseApplication.context==null){
            KLog.e("context空");
            return;
        }

        if (BaseApplication.context.getExternalCacheDir()==null){
            KLog.e("获取路径为空");
            return;
        }
        File cacheFile = new File(BaseApplication.context.getExternalCacheDir(), "InsureCache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);

        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!JUtils.isNetWorkAvilable()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (JUtils.isNetWorkAvilable()) {
                    int maxAge = 0;
                    // 有网络时 设置缓存超时时间0个小时
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("WuXiaolong")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("nyn")
                            .build();
                }
                return response;
            }
        };
        builder.cache(cache).addInterceptor(cacheInterceptor);
    }
}
