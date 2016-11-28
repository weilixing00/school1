package com.example.administrator.school.mvp.course.lectures.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.school.bean.LecturesProjectsBean;
import com.example.administrator.school.mvp.course.lectures.LecturesProjectsFragment;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by server on 2016/9/9.
 */
public class LecturesProjectsAdapter extends RecyclerArrayAdapter<LecturesProjectsBean> {
    private final LecturesProjectsFragment lecturesProjectsFragment;

    public LecturesProjectsAdapter(Context context, LecturesProjectsFragment lecturesProjectsFragment) {
        super(context);
        this.lecturesProjectsFragment=lecturesProjectsFragment;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new LecturesProjectsViewHolder(parent,lecturesProjectsFragment);
    }
}
