package com.example.administrator.school.mvp.other.schoolactivity.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.school.bean.SchoolActivityBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.socks.library.KLog;

/**
 * Created by server on 2016/9/9.
 */
public class SchoolActivityAdapter extends RecyclerArrayAdapter<SchoolActivityBean> {
    public SchoolActivityAdapter(Context context) {
        super(context);
        KLog.e();
    }


    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
            KLog.e();
        return new SchoolActivityViewHolder(parent);
    }
}
