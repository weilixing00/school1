package com.example.administrator.school.mvp.course.nationallevelcontest.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.bean.NationalLevelBean;
import com.example.administrator.school.mvp.course.contestdetail.ContestDetailFragment;
import com.example.administrator.school.mvp.course.nationallevelcontest.NationalLevelContestFragment;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by server on 2016/9/10.
 */
public class NationalLevelViewHolder extends BaseViewHolder<NationalLevelBean> {
    private final NationalLevelContestFragment nationalLevelContestFragment;
    TextView tvProjectNameItemErvFragmentNationalContest;
    TextView tvContentItemErvFragmentNationalContest;
    TextView tvGradeItemErvFragmentNationalContest;
    ImageView ivApplyforItemErvFragmentNationalContest;

    public NationalLevelViewHolder(ViewGroup parent, NationalLevelContestFragment nationalLevelContestFragment) {
        super(parent, R.layout.item_erv_fragment_national_contest);
        tvProjectNameItemErvFragmentNationalContest=$(R.id.tv_project_name_item_erv_fragment_national_contest);
        tvContentItemErvFragmentNationalContest=$(R.id.tv_content_item_erv_fragment_national_contest);
        tvGradeItemErvFragmentNationalContest=$(R.id.tv_grade_item_erv_fragment_national_contest);
        ivApplyforItemErvFragmentNationalContest=$(R.id.iv_applyfor_item_erv_fragment_national_contest);
        this.nationalLevelContestFragment=nationalLevelContestFragment;
    }

    @Override
    public void setData(NationalLevelBean data) {
        super.setData(data);
        //申请按钮
        ivApplyforItemErvFragmentNationalContest.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
//                EventBus.getDefault().post(new StartBrotherEvent(ContestDetailFragment.newInstance()));
                nationalLevelContestFragment.start(ContestDetailFragment.newInstance());
            }
        });
    }
}
