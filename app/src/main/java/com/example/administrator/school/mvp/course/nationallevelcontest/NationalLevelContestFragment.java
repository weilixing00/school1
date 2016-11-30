package com.example.administrator.school.mvp.course.nationallevelcontest;

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
import com.example.administrator.school.bean.NationalLevelBean;
import com.example.administrator.school.mvp.course.nationallevelcontest.adapter.NationalLevelAdapter;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/9/10.
 * 国家级竞赛
 */

public class NationalLevelContestFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.erv_fragment_national_level_content)
    EasyRecyclerView erv;
    @BindView(R.id.iv_to_top_fragment_national_level_content)
    ImageView ivToTopFragmentNationalLevelContent;
    private NationalLevelAdapter adapter;

    public static NationalLevelContestFragment newInstance() {
        NationalLevelContestFragment fragment = new NationalLevelContestFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_national_level_contest, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeader.setText("国家级竞赛");
        ivBackHeader.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                pop();
            }
        });
        initRecycleView();
    }

    private void initRecycleView() {
        erv.setLayoutManager(new LinearLayoutManager(getContext()));
//        DividerDecoration itemDecoration = new DividerDecoration(Color.TRANSPARENT, JUtils.dip2px(10),0,0);
//        itemDecoration.setDrawLastItem(false);
//        erv.addItemDecoration(itemDecoration);


        erv.setAdapterWithProgress(adapter = new NationalLevelAdapter(getContext(), this));
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);

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
        adapter.add(new NationalLevelBean());
        adapter.add(new NationalLevelBean());
    }
}
