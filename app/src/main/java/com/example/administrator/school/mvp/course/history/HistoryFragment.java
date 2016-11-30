package com.example.administrator.school.mvp.course.history;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.bean.HistoryBean;
import com.example.administrator.school.mvp.course.checkinsdetail.CheckinsDetailFragment;
import com.example.administrator.school.utils.JUtils;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/3.
 * 历史记录
 */
public class HistoryFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.iv_back_header_noshodow)
    ImageView ivBackHeaderNoshodow;
    @BindView(R.id.tv_middle_header_noshodow)
    TextView tvMiddleHeaderNoshodow;
    @BindView(R.id.tv_right_header_noshodow)
    TextView tvRightHeaderNoshodow;
    @BindView(R.id.et_fragment_history)
    EditText etFragmentHistory;
    @BindView(R.id.iv_fragment_history)
    ImageView ivFragmentHistory;
    @BindView(R.id.erv_fragment_history)
    EasyRecyclerView erv;
    private HistoryAdapter adapter;
    private static HistoryFragment fragment;

    public static HistoryFragment newInstance() {
        if (fragment == null)
            fragment = new HistoryFragment();
        KLog.d("历史记录  newInstance  fragment=" + fragment);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeaderNoshodow.setText("历史记录");
        ivBackHeaderNoshodow.setOnClickListener(noDoubleClick);
        ivFragmentHistory.setOnClickListener(noDoubleClick);
        initRecycleView();
        KLog.d("历史记录  onCreateView ");
    }


    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header_noshodow:
                    JUtils.hideKeyboard(getActivity());
                    pop();
                    break;
                case R.id.iv_fragment_history:

                    break;
            }
        }
    };

    @Override
    public boolean onBackPressedSupport() {
        JUtils.hideKeyboard(getActivity());
        return super.onBackPressedSupport();
    }

    private void initRecycleView() {
        erv.setLayoutManager(new LinearLayoutManager(getContext()));
        erv.setAdapterWithProgress(adapter = new HistoryAdapter(getContext()));
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
                //跳转到签到详情
                start(CheckinsDetailFragment.newInstance());
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
        adapter.add(new HistoryBean());
        adapter.add(new HistoryBean());
    }
}
