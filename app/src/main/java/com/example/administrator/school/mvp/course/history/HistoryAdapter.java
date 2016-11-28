package com.example.administrator.school.mvp.course.history;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.school.bean.HistoryBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by server on 2016/9/9.
 */
public class HistoryAdapter extends RecyclerArrayAdapter<HistoryBean>{
    public HistoryAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new HistoryViewHolder(parent);
    }
}
