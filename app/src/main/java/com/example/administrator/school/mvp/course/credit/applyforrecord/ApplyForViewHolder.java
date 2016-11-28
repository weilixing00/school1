package com.example.administrator.school.mvp.course.credit.applyforrecord;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.school.R;
import com.example.administrator.school.bean.ApplyForBean;
import com.example.administrator.school.mvp.course.contestdetail.ContestDetailFragment;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by server on 2016/9/9.
 */
public class ApplyForViewHolder extends BaseViewHolder<ApplyForBean> {


    private final ApplyForRecordFragment applyForRecordFragment;
    TextView tvNumberItemErvFragmentApplyforRecord;
    TextView tvApplyforTimeItemErvFragmentApplyforRecord;
    TextView tvNameItemErvFragmentApplyforRecord;
    TextView tvSchoolTypeItemErvFragmentApplyforRecord;
    TextView tvLevelItemErvFragmentApplyforRecord;
    TextView tvYearItemErvFragmentApplyforRecord;
    TextView tvGetTimeItemErvFragmentApplyforRecord;
    TextView tvStatusItemErvFragmentApplyforRecord;
    TextView tvAffirmStatusItemErvFragmentApplyforRecord;
    ImageView ivEditItemErvFragmentApplyforRecord;

    public ApplyForViewHolder(ViewGroup parent, ApplyForRecordFragment applyForRecordFragment) {
        super(parent, R.layout.item_erv_fragment_applyfor_record);
        this.applyForRecordFragment=applyForRecordFragment;

        tvNumberItemErvFragmentApplyforRecord=$(R.id.tv_number_item_erv_fragment_applyfor_record);
        tvApplyforTimeItemErvFragmentApplyforRecord=$(R.id.tv_applyfor_time_item_erv_fragment_applyfor_record);
        tvNameItemErvFragmentApplyforRecord=$(R.id.tv_name_item_erv_fragment_applyfor_record);
        tvSchoolTypeItemErvFragmentApplyforRecord=$(R.id.tv_school_type_item_erv_fragment_applyfor_record);
        tvLevelItemErvFragmentApplyforRecord=$(R.id.tv_year_item_erv_fragment_applyfor_record);
        tvYearItemErvFragmentApplyforRecord=$(R.id.tv_get_time_item_erv_fragment_applyfor_record);
        tvGetTimeItemErvFragmentApplyforRecord=$(R.id.tv_status_item_erv_fragment_applyfor_record);
        tvStatusItemErvFragmentApplyforRecord=$(R.id.tv_affirm_status_item_erv_fragment_applyfor_record);
        tvAffirmStatusItemErvFragmentApplyforRecord=$(R.id.tv_number_item_erv_fragment_applyfor_record);
        ivEditItemErvFragmentApplyforRecord=$(R.id.iv_edit_item_erv_fragment_applyfor_record);
    }

    @Override
    public void setData(ApplyForBean data) {
        super.setData(data);
        if (ivEditItemErvFragmentApplyforRecord==null){
            Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();
        }
        ivEditItemErvFragmentApplyforRecord.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                //跳转到国家级大学生竞赛科目

//                EventBus.getDefault().post(new StartBrotherEvent(ContestDetailFragment.newInstance()));
                applyForRecordFragment.start(ContestDetailFragment.newInstance());
            }
        });
    }
}
