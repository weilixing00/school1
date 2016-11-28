package com.example.administrator.school.mvp.course.lectures.adapter;

import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.bean.MyBookingBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by server on 2016/9/9.
 */
public class MyBookingViewHolder extends BaseViewHolder<MyBookingBean> {
    @BindView(R.id.tv_title_item_erv_item_fragment_mybooking)
    TextView tvTitleItemErvItemFragmentMybooking;
    @BindView(R.id.tv_name_item_erv_item_fragment_mybooking)
    TextView tvNameItemErvItemFragmentMybooking;
    @BindView(R.id.tv_time_item_erv_item_fragment_mybooking)
    TextView tvTimeItemErvItemFragmentMybooking;
    @BindView(R.id.tv_school_area_item_erv_item_fragment_mybooking)
    TextView tvSchoolAreaItemErvItemFragmentMybooking;
    @BindView(R.id.tv_school_major_item_erv_item_fragment_mybooking)
    TextView tvSchoolMajorItemErvItemFragmentMybooking;
    @BindView(R.id.tv_count_item_erv_item_fragment_mybooking)
    TextView tvCountItemErvItemFragmentMybooking;

    public MyBookingViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_erv_item_fragment_mybooking);

        tvTitleItemErvItemFragmentMybooking=$(R.id.tv_title_item_erv_item_fragment_mybooking);
        tvNameItemErvItemFragmentMybooking=$(R.id.tv_name_item_erv_item_fragment_mybooking);
        tvTimeItemErvItemFragmentMybooking=$(R.id.tv_time_item_erv_item_fragment_mybooking);
        tvSchoolAreaItemErvItemFragmentMybooking=$(R.id.tv_school_area_item_erv_item_fragment_mybooking);
        tvSchoolMajorItemErvItemFragmentMybooking=$(R.id.tv_school_major_item_erv_item_fragment_mybooking);
        tvCountItemErvItemFragmentMybooking=$(R.id.tv_count_item_erv_item_fragment_mybooking);

    }

    @Override
    public void setData(MyBookingBean data) {
        super.setData(data);

    }
}
