package com.example.administrator.school.base;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import com.example.administrator.school.utils.JUtils;
import com.facebook.stetho.Stetho;
import com.socks.library.KLog;


/**
 * Created by admin on 2016/5/23.
 * 参考库
 * 网络请求  retrofit+ok
 * 事件传递 eventbus
 *
 */
public class BaseApplication extends Application {
    private DisplayMetrics displayMetrics = null;
    public static BaseApplication baseApplication;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化听诊器 调试用 后期可以删掉
        Stetho.initializeWithDefaults(this);
        if (baseApplication==null) {
            baseApplication = new BaseApplication();
        }
        context=getApplicationContext();
        JUtils.initialize(this);

        KLog.init(true,"weilixing");

//        PhotoPicker.init(ImageLoader, null);
    }


}
