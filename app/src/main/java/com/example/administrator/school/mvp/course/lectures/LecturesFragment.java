package com.example.administrator.school.mvp.course.lectures;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.event.TabSelectedEvent;
import com.example.administrator.school.mvp.course.lectures.adapter.LecturesVPAdapter;
import com.example.administrator.school.mvp.home.MainFragment;
import com.example.administrator.school.utils.NoDoubleClickListener;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Administrator on 2016/9/4.
 * 讲座
 */

public class LecturesFragment extends BaseFragment {


    @BindView(R.id.iv_back_header_noshodow)
    ImageView ivBackHeaderNoshodow;
    @BindView(R.id.tv_middle_header_noshodow)
    TextView tvMiddleHeaderNoshodow;
    @BindView(R.id.tv_right_header_noshodow)
    TextView tvRightHeaderNoshodow;
    @BindView(R.id.tab_fragment_lectures)
    TabLayout tabFragmentLectures;
    @BindView(R.id.vp_fragment_lectures)
    ViewPager vpFragmentLectures;


    public static SupportFragment newInstance() {
        LecturesFragment fragment=new LecturesFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lectures, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeaderNoshodow.setText("讲座");
        tvRightHeaderNoshodow.setText("签到");
        ivBackHeaderNoshodow.setOnClickListener(noDoubleClick);
        tvRightHeaderNoshodow.setOnClickListener(noDoubleClick);
        vpFragmentLectures.setAdapter(new LecturesVPAdapter(getChildFragmentManager()));
//        vpFragmentLectures.setAdapter(new CheckinsDetailAdapter(getChildFragmentManager()));
        tabFragmentLectures.setupWithViewPager(vpFragmentLectures);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header_noshodow:
                    pop();
                    break;
                //签到
                case R.id.tv_right_header_noshodow:
                    EventBus.getDefault().post(new TabSelectedEvent(MainFragment.SECOND));
                    pop();
//                    startWithPop(MainFragment.newInstance(1));
//                    popTo(MainFragment.class,false);
//                    start(MainFragment.newInstance(1));
//                    pop();
                    break;
            }
        }
    };


}
