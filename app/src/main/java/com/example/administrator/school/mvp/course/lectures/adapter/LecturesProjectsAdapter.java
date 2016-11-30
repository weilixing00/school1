package com.example.administrator.school.mvp.course.lectures.adapter;

import android.content.Context;
import android.view.View;
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
    private ButtonInterface buttonInterface;

    public LecturesProjectsAdapter(Context context, LecturesProjectsFragment lecturesProjectsFragment) {
        super(context);
        this.lecturesProjectsFragment=lecturesProjectsFragment;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new LecturesProjectsViewHolder(parent,lecturesProjectsFragment,buttonInterface);
    }

    /**
     * 按钮点击事件对应的接口
     */
    public interface ButtonInterface{
        public void onclick(View view, int position);
    }

    /**
     *按钮点击事件需要的方法
     */
    public void buttonSetOnclick(ButtonInterface buttonInterface){
        this.buttonInterface=buttonInterface;
    }
}
