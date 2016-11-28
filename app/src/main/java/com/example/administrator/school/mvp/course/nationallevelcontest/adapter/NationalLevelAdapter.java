package com.example.administrator.school.mvp.course.nationallevelcontest.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.school.bean.NationalLevelBean;
import com.example.administrator.school.mvp.course.nationallevelcontest.NationalLevelContestFragment;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by server on 2016/9/10.
 */
public class NationalLevelAdapter extends RecyclerArrayAdapter<NationalLevelBean>{
    private final NationalLevelContestFragment nationalLevelContestFragment;

    public NationalLevelAdapter(Context context, NationalLevelContestFragment nationalLevelContestFragment) {
        super(context);
        this.nationalLevelContestFragment=nationalLevelContestFragment;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new NationalLevelViewHolder(parent,nationalLevelContestFragment);
    }
}
