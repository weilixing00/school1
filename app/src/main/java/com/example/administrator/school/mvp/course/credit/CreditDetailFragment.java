package com.example.administrator.school.mvp.course.credit;

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
import com.example.administrator.school.bean.CreditDetailBean;
import com.example.administrator.school.mvp.course.credit.applyforrecord.CreditDetailAdapter;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/9/4.
 * 学分明细
 */

public class CreditDetailFragment extends BaseFragment  implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.tv_credit_score_fragment_credit_detail)
    TextView tvCreditScoreFragmentCreditDetail;
    @BindView(R.id.erv_fragment_credit_detail)
    EasyRecyclerView erv;
    @BindView(R.id.iv_to_top_fragment_credit_detail)
    ImageView ivToTopFragmentCreditDetail;
    private CreditDetailAdapter adapter;

    public static CreditDetailFragment newInstance() {
        CreditDetailFragment fragment=new CreditDetailFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_credit_detail, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;

    }

    private void initView() {
        tvMiddleHeader.setText("学分明细");
        ivBackHeader.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                pop();
            }
        });
        ivToTopFragmentCreditDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                erv.scrollToPosition(0);
            }
        });
        initRecycleView();

    }

    private void initRecycleView() {
        erv.setLayoutManager(new LinearLayoutManager(getContext()));
        erv.setAdapterWithProgress(adapter=new CreditDetailAdapter(getContext()));
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
        adapter.add(new CreditDetailBean());
        adapter.add(new CreditDetailBean());
    }
}
