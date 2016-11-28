package com.example.administrator.school.utils;

import android.view.View;

import java.util.Calendar;

/**
 * Created by admin on 2015/12/19.
 * 两种点击模式  默认两秒 (空参)
 * 带参  自己设置
 */
public abstract class NoDoubleClickListener implements View.OnClickListener {
    public   int MIN_CLICK_DELAY_TIME = 2000;
    private long lastClickTime = 0;


    public NoDoubleClickListener(int clickDelayTime) {
        this.MIN_CLICK_DELAY_TIME = clickDelayTime;
    }
    public NoDoubleClickListener() {
        //默认就设置间隔时间两秒 因为以前都是空参构造  不好改
        MIN_CLICK_DELAY_TIME = 2000;
    }

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {

            lastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }
    public abstract void onNoDoubleClick(View v);

}
