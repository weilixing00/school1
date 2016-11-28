package com.example.administrator.school.mvp.home.checkins.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.school.bean.CheckinsBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by server on 2016/9/8.
 */

public class CheckinsAdapter extends RecyclerArrayAdapter<CheckinsBean> {
    public CheckinsAdapter(Context context) {
        super(context);
    }


    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new CheckinsViewHolder(parent);
    }
}