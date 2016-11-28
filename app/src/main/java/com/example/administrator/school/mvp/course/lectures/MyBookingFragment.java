package com.example.administrator.school.mvp.course.lectures;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.bean.MyBookingBean;
import com.example.administrator.school.mvp.course.lectures.adapter.MyBookingAdapter;
import com.example.administrator.school.utils.JUtils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/4.
 * 讲座中的VP我的预定子Fragment
 */
public class MyBookingFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{


    @BindView(R.id.erv)
    EasyRecyclerView erv;
    private MyBookingAdapter adapter;

    public static MyBookingFragment newInstance() {
        MyBookingFragment fragment = new MyBookingFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_recycleview, container, false);
        ButterKnife.bind(this, view);
        initRecycleView();
        return view;
    }

    private void initRecycleView() {
        erv.setPadding(0, JUtils.dip2px(10),0,0);
        erv.setLayoutManager(new LinearLayoutManager(getContext()));


        //我的预定和历史记录使用同样类型的条目 所以一样的适配器 只是数据不一样
        erv.setAdapterWithProgress(adapter = new MyBookingAdapter(getContext()));
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
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
        List<MyBookingBean> items=new ArrayList<>();
        items.add(new MyBookingBean());
        items.add(new MyBookingBean());
        adapter.addAll(items);
    }

}

