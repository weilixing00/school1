package com.example.administrator.school.mvp.course.lectures.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.bean.LecturesProjectsBean;
import com.example.administrator.school.event.StartBrotherEvent;
import com.example.administrator.school.mvp.course.coursedetail.CourseDetailFragment;
import com.example.administrator.school.mvp.course.courseedit.CourseEditFragment;
import com.example.administrator.school.mvp.course.lectures.LecturesProjectsFragment;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by server on 2016/9/9.
 */
public class LecturesProjectsViewHolder extends BaseViewHolder<LecturesProjectsBean> {
    private  LecturesProjectsFragment lecturesProjectsFragment;
    private   TextView tvTitleItemErvItemFragmentLectureProjects;
    private  TextView tvNameItemErvItemFragmentLectureProjects;
    private  TextView tvTimeItemErvItemFragmentLectureProjects;
    private TextView tvSchoolAreaItemErvItemFragmentLectureProjects;
    private  TextView tvSchoolMajorItemErvItemFragmentLectureProjects;
    private  TextView tvCountItemErvItemFragmentLectureProjects;
    private  ImageView ivBookItemErvItemFragmentLectureProjects;
    private ImageView ivEditItemErvItemFragmentLectureProjects;

    public LecturesProjectsViewHolder(ViewGroup parent, LecturesProjectsFragment lecturesProjectsFragment) {
        super(parent, R.layout.item_erv_item_fragment_lecture_projects);
        this.lecturesProjectsFragment=lecturesProjectsFragment;
        tvTitleItemErvItemFragmentLectureProjects=$(R.id.tv_title_item_erv_item_fragment_lecture_projects);
        tvNameItemErvItemFragmentLectureProjects=$(R.id.tv_name_item_erv_item_fragment_lecture_projects);
        tvTimeItemErvItemFragmentLectureProjects=$(R.id.tv_time_item_erv_item_fragment_lecture_projects);
        tvSchoolAreaItemErvItemFragmentLectureProjects=$(R.id.tv_school_area_item_erv_item_fragment_lecture_projects);
        tvTitleItemErvItemFragmentLectureProjects=$(R.id.tv_school_major_item_erv_item_fragment_lecture_projects);
        tvCountItemErvItemFragmentLectureProjects=$(R.id.tv_count_item_erv_item_fragment_lecture_projects);
        ivBookItemErvItemFragmentLectureProjects=$(R.id.iv_book_item_erv_item_fragment_lecture_projects);
        ivEditItemErvItemFragmentLectureProjects=$(R.id.iv_edit_item_erv_item_fragment_lecture_projects);
    }


    @Override
    public void setData(LecturesProjectsBean data) {
        super.setData(data);

        ivBookItemErvItemFragmentLectureProjects.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                //预定
//                lecturesProjectsFragment.start(CreditDetailFragment);
                EventBus.getDefault().post(new StartBrotherEvent(CourseDetailFragment.newInstance()));
            }
        });
        ivEditItemErvItemFragmentLectureProjects.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
//                lecturesProjectsFragment.start(CourseEditFragment.newInstance());
                //编辑
                EventBus.getDefault().post(new StartBrotherEvent(CourseEditFragment.newInstance()));
            }
        });

    }
}
