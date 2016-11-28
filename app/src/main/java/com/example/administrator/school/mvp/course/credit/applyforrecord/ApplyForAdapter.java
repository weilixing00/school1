package com.example.administrator.school.mvp.course.credit.applyforrecord;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.school.bean.ApplyForBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by server on 2016/9/9.
 */
public class ApplyForAdapter extends RecyclerArrayAdapter<ApplyForBean> {
    private final ApplyForRecordFragment applyForRecordFragment;

    public ApplyForAdapter(Context context, ApplyForRecordFragment applyForRecordFragment) {
        super(context);
        this.applyForRecordFragment=applyForRecordFragment;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ApplyForViewHolder(parent,applyForRecordFragment);
    }
}
