package com.example.administrator.school.mvp.course.lectures.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.bean.LecturesProjectsBean;
import com.example.administrator.school.mvp.course.lectures.LecturesProjectsFragment;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by server on 2016/9/9.
 */
public class LecturesProjectsViewHolder extends BaseViewHolder<LecturesProjectsBean> {
    private final LecturesProjectsAdapter.ButtonInterface buttonInterface;
    private  LecturesProjectsFragment lecturesProjectsFragment;
    private   TextView tvTitleItemErvItemFragmentLectureProjects;
    private  TextView tvNameItemErvItemFragmentLectureProjects;
    private  TextView tvTimeItemErvItemFragmentLectureProjects;
    private TextView tvSchoolAreaItemErvItemFragmentLectureProjects;
    private  TextView tvSchoolMajorItemErvItemFragmentLectureProjects;
    private  TextView tvCountItemErvItemFragmentLectureProjects;
    private  ImageView ivBookItemErvItemFragmentLectureProjects;
    private ImageView ivEditItemErvItemFragmentLectureProjects;

    public LecturesProjectsViewHolder(ViewGroup parent, LecturesProjectsFragment lecturesProjectsFragment, final LecturesProjectsAdapter.ButtonInterface buttonInterface) {
        super(parent, R.layout.item_erv_item_fragment_lecture_projects);
        this.lecturesProjectsFragment=lecturesProjectsFragment;
        this.buttonInterface=buttonInterface;
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_erv_item_fragment_lecture_projects,null);
        tvTitleItemErvItemFragmentLectureProjects=$(R.id.tv_title_item_erv_item_fragment_lecture_projects);
        tvNameItemErvItemFragmentLectureProjects=$(R.id.tv_name_item_erv_item_fragment_lecture_projects);
        tvTimeItemErvItemFragmentLectureProjects=$(R.id.tv_time_item_erv_item_fragment_lecture_projects);
        tvSchoolAreaItemErvItemFragmentLectureProjects=$(R.id.tv_school_area_item_erv_item_fragment_lecture_projects);
        tvTitleItemErvItemFragmentLectureProjects=$(R.id.tv_school_major_item_erv_item_fragment_lecture_projects);
        tvCountItemErvItemFragmentLectureProjects=$(R.id.tv_count_item_erv_item_fragment_lecture_projects);
        ivBookItemErvItemFragmentLectureProjects=$(R.id.iv_book_item_erv_item_fragment_lecture_projects);
//        ivBookItemErvItemFragmentLectureProjects=(ImageView) view.findViewById(R.id.iv_book_item_erv_item_fragment_lecture_projects);
        ivEditItemErvItemFragmentLectureProjects=$(R.id.iv_edit_item_erv_item_fragment_lecture_projects);
//        ivEditItemErvItemFragmentLectureProjects= (ImageView) view.findViewById(R.id.iv_edit_item_erv_item_fragment_lecture_projects);

ivBookItemErvItemFragmentLectureProjects.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(buttonInterface!=null) {
//                  接口实例化后的而对象，调用重写后的方法
            buttonInterface.onclick(view,getOldPosition());
        }
    }
});
        ivEditItemErvItemFragmentLectureProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonInterface!=null) {
//                  接口实例化后的而对象，调用重写后的方法
                    buttonInterface.onclick(view,getOldPosition());
                }
            }
        });

    }


    @Override
    public void setData(LecturesProjectsBean data) {
        super.setData(data);
//        ivBookItemErvItemFragmentLectureProjects.setOnClickListener(new NoDoubleClickListener() {
//            @Override
//            public void onNoDoubleClick(View v) {
//                //预定
//                Bundle bundle=new Bundle();
//                bundle.putString(KeyConstant.BundleKey.SOURCE,"LecturesProjectsFragment");
//                lecturesProjectsFragment.start(CourseDetailFragment.newInstance(bundle));
//                KLog.e("听课预定");
////                EventBus.getDefault().post(new StartBrotherEvent(CourseEditFragment.newInstance()));
//            }
//        });
//        ivEditItemErvItemFragmentLectureProjects.setOnClickListener(new NoDoubleClickListener() {
//            @Override
//            public void onNoDoubleClick(View v) {
//                lecturesProjectsFragment.start(CourseEditFragment.newInstance());
//                KLog.e("编辑");
////                //编辑
////                EventBus.getDefault().post(new StartBrotherEvent(CourseDetailFragment.newInstance()));
//            }
//        });
//
//        ivEditItemErvItemFragmentLectureProjects.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                KLog.e("编辑2");
//                //编辑
//                Bundle bundle=new Bundle();
//                bundle.putString(KeyConstant.BundleKey.SOURCE,"LecturesProjectsFragment");
//                EventBus.getDefault().post(new StartBrotherEvent(CourseDetailFragment.newInstance(bundle)));
//            }
//        });
//        ivBookItemErvItemFragmentLectureProjects.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //编辑
//                KLog.e("预定2");
//                EventBus.getDefault().post(new StartBrotherEvent(CourseEditFragment.newInstance()));
//            }
//        });
//
//        ivEditItemErvItemFragmentLectureProjects.setImageResource(R.mipmap.ic_launcher);
    }




}
