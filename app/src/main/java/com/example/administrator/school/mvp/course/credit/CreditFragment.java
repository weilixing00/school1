package com.example.administrator.school.mvp.course.credit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.mvp.course.credit.applyforrecord.ApplyForRecordFragment;
import com.example.administrator.school.mvp.course.nationallevelcontest.NationalLevelContestFragment;
import com.example.administrator.school.utils.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/9/4.
 * 总学分
 */

public class CreditFragment extends BaseFragment {
    @BindView(R.id.tv_credit_total_fragment_credit)
    TextView tvCreditTotalFragmentCredit;
    @BindView(R.id.ll_credit_askfor_fragment_credit)
    LinearLayout llCreditAskforFragmentCredit;
    @BindView(R.id.ll_askfor_record_fragment_credit)
    LinearLayout llAskforRecordFragmentCredit;
    @BindView(R.id.iv_back_fragment_credit)
    ImageView ivBackFragmentCredit;
    @BindView(R.id.iv_total_fragment_credit)
    ImageView ivTotalFragmentCredit;


    public static CreditFragment newInstance() {
        CreditFragment fragment = new CreditFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_credit, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        ivBackFragmentCredit.setOnClickListener(noDoubleClick);
        llAskforRecordFragmentCredit.setOnClickListener(noDoubleClick);
        llCreditAskforFragmentCredit.setOnClickListener(noDoubleClick);
        ivTotalFragmentCredit.setOnClickListener(noDoubleClick);
    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_fragment_credit:
                    pop();
                    break;
                //学分申请  跳转到创新学分申请
                case R.id.ll_credit_askfor_fragment_credit:
//                    start(InnovateScoreFragment.newInstance());
                    start(NationalLevelContestFragment.newInstance());
                    break;
                //申请记录
                case R.id.ll_askfor_record_fragment_credit:
                    start(ApplyForRecordFragment.newInstance());
                    break;
                //总学分
                case R.id.iv_total_fragment_credit:
                    start(CreditDetailFragment.newInstance());
                    break;
            }
        }
    };


}
