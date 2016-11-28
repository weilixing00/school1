package com.example.administrator.school.mvp.course.checkinsdetail;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.mvp.course.checkinsdetail.adapter.CheckinsDetailAdapter;
import com.example.administrator.school.utils.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/9/6.
 * 签到详情
 */

public class CheckinsDetailFragment extends BaseFragment {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.tv_class_type_fragment_checkins_detail)
    TextView tvClassTypeFragmentCheckinsDetail;
    @BindView(R.id.tv_class_name_fragment_checkins_detail)
    TextView tvClassNameFragmentCheckinsDetail;
    @BindView(R.id.tv_host_name_fragment_checkins_detail)
    TextView tvHostNameFragmentCheckinsDetail;
    @BindView(R.id.tv_time_fragment_checkins_detail)
    TextView tvTimeFragmentCheckinsDetail;
    @BindView(R.id.tv_school_fragment_checkins_detail)
    TextView tvSchoolFragmentCheckinsDetail;
    @BindView(R.id.tv_address_fragment_checkins_detail)
    TextView tvAddressFragmentCheckinsDetail;
    @BindView(R.id.tab_fragment_checkins_detail)
    TabLayout tabFragmentCheckinsDetail;
    @BindView(R.id.vp_fragment_checkins_detail)
    ViewPager vpFragmentCheckinsDetail;

    public static CheckinsDetailFragment newInstance() {
        CheckinsDetailFragment checkinsDetailFragment=new CheckinsDetailFragment();
        return checkinsDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chekins_detail, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeader.setText("签到详情");
        ivBackHeader.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                pop();
            }
        });
        vpFragmentCheckinsDetail.setAdapter(new CheckinsDetailAdapter(getChildFragmentManager()));
        tabFragmentCheckinsDetail.setupWithViewPager(vpFragmentCheckinsDetail);

    }


}
