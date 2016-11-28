package com.example.administrator.school.mvp.course.checkinsdetail.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.school.bean.CheckinsRecordsBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by Administrator on 2016/9/8.
 */
public class CheckoutRecordsAdapter extends RecyclerArrayAdapter<CheckinsRecordsBean> {
    public CheckoutRecordsAdapter(Context context) {
        super(context);
    }


    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new CheckoutViewHolder(parent);
    }
}