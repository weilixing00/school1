package com.example.administrator.school.mvp.course.lectures;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.bean.LecturesProjectsBean;
import com.example.administrator.school.constant.KeyConstant;
import com.example.administrator.school.event.StartBrotherEvent;
import com.example.administrator.school.mvp.course.coursedetail.CourseDetailFragment;
import com.example.administrator.school.mvp.course.courseedit.CourseEditFragment;
import com.example.administrator.school.mvp.course.lectures.adapter.LecturesProjectsAdapter;
import com.example.administrator.school.utils.JUtils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/4.
 * 讲座项目
 */
public class LecturesProjectsFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{


    @BindView(R.id.erv)
    EasyRecyclerView erv;
    private LecturesProjectsAdapter adapter;

    public static LecturesProjectsFragment newInstance() {
        LecturesProjectsFragment fragment = new LecturesProjectsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_lectures_project, container, false);
        View view = inflater.inflate(R.layout.layout_recycleview, container, false);
        ButterKnife.bind(this, view);
        initReycleView();
        // TODO: 2016/9/4 带不同显示类型的lv?
        return view;
    }

    private void initReycleView() {
        erv.setPadding(0, JUtils.dip2px(45),0,0);
        erv.setLayoutManager(new LinearLayoutManager(getContext()));
//        DividerDecoration itemDecoration = new DividerDecoration(Color.TRANSPARENT, JUtils.dip2px(10),0,0);
//        itemDecoration.setDrawLastItem(false);
//        erv.addItemDecoration(itemDecoration);

        //讲座项目和
        erv.setAdapterWithProgress(adapter = new LecturesProjectsAdapter(getContext(),this));
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        adapter.buttonSetOnclick(new LecturesProjectsAdapter.ButtonInterface() {
            @Override
            public void onclick(View view, int position) {
                if (view.getId()==R.id.iv_edit_item_erv_item_fragment_lecture_projects){
                    Toast.makeText(_mActivity, "编辑", Toast.LENGTH_SHORT).show();

                                    EventBus.getDefault().post(new StartBrotherEvent(CourseEditFragment.newInstance()));
                }
                if (view.getId()==R.id.iv_book_item_erv_item_fragment_lecture_projects){
                    Toast.makeText(_mActivity, "预定", Toast.LENGTH_SHORT).show();
                    Bundle bundle=new Bundle();
                    bundle.putString(KeyConstant.BundleKey.SOURCE,"LecturesProjectsFragment");
                    EventBus.getDefault().post(new StartBrotherEvent(CourseDetailFragment.newInstance(bundle)));
                }
            }
        });
//        adapter.setOnItemLongClickListener(new RecyclerArrayAdapter.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(int position) {
//                adapter.remove(position);
//                return true;
//            }
//        });
        adapter.setError(R.layout.view_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.resumeMore();

            }
        });


        erv.setRefreshListener(this);
        onRefresh();
    }


    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {
        adapter.clear();
        List<LecturesProjectsBean> items=new ArrayList<>();
        items.add(new LecturesProjectsBean());
//        items.add(new LecturesProjectsBean());
        adapter.addAll(items);
    }

}

