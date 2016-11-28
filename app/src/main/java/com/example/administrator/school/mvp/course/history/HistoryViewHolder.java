package com.example.administrator.school.mvp.course.history;

import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.bean.HistoryBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by server on 2016/9/9.
 */
public class HistoryViewHolder extends BaseViewHolder<HistoryBean> {
    TextView tvTitleItemErvFragmentHistory;//标题
    TextView tvNameItemErvFragmentHistory; //姓名
    TextView tvSchoolAreaItemErvFragmentHistory;//校区
    TextView tvSchoolMajorItemErvFragmentHistory;//专业

    public HistoryViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_erv_fragment_history);
        tvTitleItemErvFragmentHistory=$(R.id.tv_title_item_erv_fragment_history);
        tvNameItemErvFragmentHistory=$(R.id.tv_name_item_erv_fragment_history);
        tvSchoolAreaItemErvFragmentHistory=$(R.id.tv_school_area_item_erv_fragment_history);
        tvSchoolMajorItemErvFragmentHistory=$(R.id.tv_school_major_item_erv_fragment_history);
    }

    @Override
    public void setData(HistoryBean data) {
        super.setData(data);

    }
}
