package com.example.administrator.school.mvp.other.message.ui;

import android.os.Bundle;
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
import com.example.administrator.school.bean.MessageBean;
import com.example.administrator.school.mvp.other.message.MessageAdapter;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by server on 2016/9/3.
 */

public class MessageFragment extends BaseFragment  implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.erv_fragment_message)
    EasyRecyclerView erv;
    private MessageAdapter adapter;

    public static SupportFragment newInstance() {
        MessageFragment fragment=new MessageFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        initRecycleView();
        tvMiddleHeader.setText("消息");
        ivBackHeader.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                pop();
            }
        });

    }

    private void initRecycleView() {
        erv.setLayoutManager(new LinearLayoutManager(getContext()));
        erv.setAdapterWithProgress(adapter = new MessageAdapter(getContext()));
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
                start(MessageContentFragment.newInstance());
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
        adapter.add(new MessageBean());
        adapter.add(new MessageBean());
    }
}
