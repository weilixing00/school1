package com.example.administrator.school.mvp.course.coursedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.mvp.course.courseedit.CourseEditFragment;
import com.example.administrator.school.utils.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/9/4.
 * 课程详情
 * 包含听课和预定
 * 和预定详情一个页面预定详情
 */

public class CourseDetailFragment extends BaseFragment {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.tv_lecture_type_fragment_course_detail)
    TextView tvLectureTypeFragmentCourseDetail;
    @BindView(R.id.tv_askfor_unit_fragment_course_detail)
    TextView tvAskforUnitFragmentCourseDetail;
    @BindView(R.id.tv_host_person_fragment_course_detail)
    TextView tvHostPersonFragmentCourseDetail;
    @BindView(R.id.tv_introduce_fragment_course_detail)
    TextView tvIntroduceFragmentCourseDetail;
    @BindView(R.id.tv_school_area_fragment_course_detail)
    TextView tvSchoolAreaFragmentCourseDetail;
    @BindView(R.id.tv_address_fragment_course_detail)
    TextView tvAddressFragmentCourseDetail;
    @BindView(R.id.tv_time_fragment_course_detail)
    TextView tvTimeFragmentCourseDetail;
    @BindView(R.id.tv_content_fragment_course_detail)
    TextView tvContentFragmentCourseDetail;
    @BindView(R.id.bt_detail_plain_fragment_course_detail)
    Button btDetailPlainFragmentCourseDetail;
    @BindView(R.id.tv_rated_count_fragment_course_detail)
    TextView tvRatedCountFragmentCourseDetail;
    @BindView(R.id.tv_setted_count_fragment_course_detail)
    TextView tvSettedCountFragmentCourseDetail;
    @BindView(R.id.bt_booking_fragment_course_detail)
    Button btBookingFragmentCourseDetail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_detail, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        //未预定显示 编辑 已经预定 编辑 隐藏
        tvRightHeaderShadow.setText("编辑");
        tvRightHeaderShadow.setOnClickListener(noDoubleClick);
        ivBackHeader.setOnClickListener(noDoubleClick);
        btBookingFragmentCourseDetail.setOnClickListener(noDoubleClick);
        btDetailPlainFragmentCourseDetail.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    pop();
                    break;
                //编辑  进入编辑界面
                case R.id.tv_right_header_shadow:
                    start(CourseEditFragment.newInstance());
                    break;
                //查看
                case R.id.bt_detail_plain_fragment_course_detail:

                    break;
                //听课预定 或者 取消预定  考虑将预定状态保存在本地sp里面
                case R.id.bt_booking_fragment_course_detail:

                    break;
            }
        }
    };

    public static CourseDetailFragment newInstance() {
        CourseDetailFragment fragment=new CourseDetailFragment();
        return fragment;
    }
}
