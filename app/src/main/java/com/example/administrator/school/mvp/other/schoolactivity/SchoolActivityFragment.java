package com.example.administrator.school.mvp.other.schoolactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.bean.SchoolActivityBean;
import com.example.administrator.school.mvp.other.activitycontent.ui.ActivityContentFragment;
import com.example.administrator.school.mvp.other.schoolactivity.adapter.SchoolActivityAdapter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/9.
 * 校园活动
 */

public class SchoolActivityFragment extends BaseFragment  implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.erv_layout_recycle_top)
    EasyRecyclerView erv;
    @BindView(R.id.iv_to_top_layout_recycle_top)
    ImageView ivToTopFragmentSchoolActivity;
    private SchoolActivityAdapter adapter;




    public static SchoolActivityFragment newInstance() {
        SchoolActivityFragment fragment=new SchoolActivityFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_recycleview_top, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeader.setText("校园活动");
        ivBackHeader.setOnClickListener(clickListener);
        ivToTopFragmentSchoolActivity.setOnClickListener(clickListener);
        initRecycleView();



    }

    private void initRecycleView() {
        erv.setLayoutManager(new LinearLayoutManager(getContext()));
        erv.setAdapterWithProgress(adapter = new SchoolActivityAdapter(getContext()));
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);

        adapter.setError(R.layout.view_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.resumeMore();

            }
        });
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //跳转到活动内容
                start(ActivityContentFragment.newInstance());
            }
        });


        erv.setRefreshListener(this);
        onRefresh();
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.iv_back_header:
                    pop();
                    break;
                case R.id.iv_to_top_layout_recycle_top:
                    erv.scrollToPosition(0);
                    break;
            }
        }
    };

    @Override
    public void onRefresh() {
        KLog.e();
        adapter.add(new SchoolActivityBean());
        adapter.add(new SchoolActivityBean());
    }

    @Override
    public void onLoadMore() {

    }


}
