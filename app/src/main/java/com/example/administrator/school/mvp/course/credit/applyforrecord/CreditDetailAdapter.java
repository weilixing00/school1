package com.example.administrator.school.mvp.course.credit.applyforrecord;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.school.bean.CreditDetailBean;
import com.example.administrator.school.mvp.course.credit.adapter.CreditDetailViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by server on 2016/9/9.
 */
public class CreditDetailAdapter extends RecyclerArrayAdapter<CreditDetailBean> {
    public CreditDetailAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new CreditDetailViewHolder(parent);
    }
}
