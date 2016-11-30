package com.example.administrator.school.mvp.course.checkinsdetail.adapter;

import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.bean.CheckinsRecordsBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2016/9/8.
 * 签退
 */
public class CheckoutViewHolder extends BaseViewHolder<CheckinsRecordsBean> {


    TextView tvIndexItemErvFragmentCheckinsrecords;
    TextView tvTimeFragmentCheckinsrecords;
    TextView tvTypeFragmentCheckinsrecords;

    public CheckoutViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_erv_item_fragment_checkinsrecords);

        tvIndexItemErvFragmentCheckinsrecords = $(R.id.tv_index_item_erv_fragment_checkinsrecords);
        tvTimeFragmentCheckinsrecords = $(R.id.tv_time_fragment_checkinsrecords);
        tvTypeFragmentCheckinsrecords = $(R.id.tv_type_fragment_checkinsrecords);
    }

    @Override
    public void setData(final CheckinsRecordsBean checkinsBean) {

        tvTypeFragmentCheckinsrecords.setText("签退");
        tvIndexItemErvFragmentCheckinsrecords.setText((1 + getAdapterPosition()) + "");

    }
}