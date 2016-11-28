package com.example.administrator.school.mvp.course.courseedit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.utils.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/9/4.
 * 编辑
 */

public class CourseEditFragment extends BaseFragment {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.tv_title_fragment_course_edit)
    TextView tvTitleFragmentCourseEdit;
    @BindView(R.id.tv_host_name_fragment_course_edit)
    TextView tvHostNameFragmentCourseEdit;
    @BindView(R.id.school_fragment_course_edit)
    EditText schoolFragmentCourseEdit;
    @BindView(R.id.address_fragment_course_edit)
    EditText addressFragmentCourseEdit;
    @BindView(R.id.time_fragment_course_edit)
    TextView timeFragmentCourseEdit;
    @BindView(R.id.ll_time_select_fragment_course_edit)
    LinearLayout llTimeSelectFragmentCourseEdit;
    @BindView(R.id.bt_save_fragment_course_edit)
    Button btSaveFragmentCourseEdit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_edit, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeader.setText("编辑");
        ivBackHeader.setOnClickListener(noDoubleClick);
        llTimeSelectFragmentCourseEdit.setOnClickListener(noDoubleClick);
        btSaveFragmentCourseEdit.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    pop();
                    break;
                case R.id.ll_time_select_fragment_course_edit:

                    break;
                case R.id.bt_save_fragment_course_edit:

                    break;
            }
        }
    };

    public static CourseEditFragment newInstance() {
        CourseEditFragment fragment=new CourseEditFragment();
        return  fragment;
    }
}
