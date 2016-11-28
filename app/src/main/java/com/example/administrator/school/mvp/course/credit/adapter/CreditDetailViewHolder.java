package com.example.administrator.school.mvp.course.credit.adapter;

import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.bean.CreditDetailBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by server on 2016/9/9.
 */
public class CreditDetailViewHolder extends BaseViewHolder<CreditDetailBean> {
    @BindView(R.id.tv_number_item_erv_fragment_credit_detail)
    TextView tvNumberItemErvFragmentCreditDetail;
    @BindView(R.id.tv_time_item_erv_fragment_credit_detail)
    TextView tvTimeItemErvFragmentCreditDetail;
    @BindView(R.id.tv_project_name_item_erv_fragment_credit_detail)
    TextView tvProjectNameItemErvFragmentCreditDetail;
    @BindView(R.id.tv_credit_type_item_erv_fragment_credit_detail)
    TextView tvCreditTypeItemErvFragmentCreditDetail;
    @BindView(R.id.tv_project_level_type_item_erv_fragment_credit_detail)
    TextView tvProjectLevelTypeItemErvFragmentCreditDetail;
    @BindView(R.id.tv_project_year_type_item_erv_fragment_credit_detail)
    TextView tvProjectYearTypeItemErvFragmentCreditDetail;
    @BindView(R.id.tv_score_item_erv_fragment_credit_detail)
    TextView tvScoreItemErvFragmentCreditDetail;

    public CreditDetailViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_erv_fragment_credit_detail);
        tvNumberItemErvFragmentCreditDetail=$(R.id.tv_number_item_erv_fragment_credit_detail);
        tvTimeItemErvFragmentCreditDetail=$(R.id.tv_time_item_erv_fragment_credit_detail);
        tvProjectNameItemErvFragmentCreditDetail=$(R.id.tv_project_name_item_erv_fragment_credit_detail);
        tvCreditTypeItemErvFragmentCreditDetail=$(R.id.tv_credit_type_item_erv_fragment_credit_detail);
        tvProjectLevelTypeItemErvFragmentCreditDetail=$(R.id.tv_project_level_type_item_erv_fragment_credit_detail);
        tvProjectYearTypeItemErvFragmentCreditDetail=$(R.id.tv_project_year_type_item_erv_fragment_credit_detail);
        tvScoreItemErvFragmentCreditDetail=$(R.id.tv_score_item_erv_fragment_credit_detail);
    }

    @Override
    public void setData(CreditDetailBean data) {
        super.setData(data);

    }
}
