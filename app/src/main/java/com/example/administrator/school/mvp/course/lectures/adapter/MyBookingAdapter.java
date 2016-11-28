package com.example.administrator.school.mvp.course.lectures.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.school.bean.MyBookingBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by server on 2016/9/9.
 */
public class MyBookingAdapter extends RecyclerArrayAdapter<MyBookingBean> {
    public MyBookingAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyBookingViewHolder(parent);
    }
}
