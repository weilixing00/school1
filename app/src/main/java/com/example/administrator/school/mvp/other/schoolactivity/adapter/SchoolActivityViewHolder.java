package com.example.administrator.school.mvp.other.schoolactivity.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.bean.SchoolActivityBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.socks.library.KLog;

/**
 * Created by server on 2016/9/9.
 */
public class SchoolActivityViewHolder extends BaseViewHolder<SchoolActivityBean> {
    TextView tvTitleItemErvFragmentSchoolActivity;
    ImageView ivItemErvFragmentSchoolActivity;
    TextView tvDateItemErvFragmentSchoolActivity;
    TextView tvTimeItemErvFragmentSchoolActivity;
    TextView tvAddressItemErvFragmentSchoolActivity;
    TextView tvHostItemErvFragmentSchoolActivity;

    public SchoolActivityViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_erv_fragment_school_activity);
//        super(parent, R.layout.item_erv_item_fragment_checkinsrecords);
        KLog.e();
        tvTitleItemErvFragmentSchoolActivity=  $(R.id.tv_title_item_erv_fragment_school_activity);
        ivItemErvFragmentSchoolActivity=  $(R.id.iv_item_erv_fragment_school_activity);
        tvDateItemErvFragmentSchoolActivity=  $(R.id.tv_date_item_erv_fragment_school_activity);
        tvTimeItemErvFragmentSchoolActivity=  $(R.id.tv_time_item_erv_fragment_school_activity);
        tvAddressItemErvFragmentSchoolActivity=  $(R.id.tv_address_item_erv_fragment_school_activity);
        tvHostItemErvFragmentSchoolActivity=  $(R.id.tv_host_item_erv_fragment_school_activity);
    }

    @Override
    public void setData(SchoolActivityBean data) {
        super.setData(data);
        KLog.e();
    }
}
