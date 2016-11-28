package com.example.administrator.school.mvp.course.checkinsdetail;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.bean.CheckinsRecordsBean;
import com.example.administrator.school.mvp.course.checkinsdetail.adapter.CheckoutRecordsAdapter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/9/6.
 * 签退
 */
public class CheckoutRecordsFragment extends BaseFragment  implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.erv)
    EasyRecyclerView erv;
    private CheckoutRecordsAdapter adapter;

    public static CheckoutRecordsFragment newInstance() {
        CheckoutRecordsFragment checkoutRecordsFragment = new CheckoutRecordsFragment();

        return checkoutRecordsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_recycleview, container, false);
        ButterKnife.bind(this, view);
        initRecycleView();
        return view;
    }

    private void initRecycleView() {
        erv.setLayoutManager(new LinearLayoutManager(getContext()));
//        DividerDecoration itemDecoration = new DividerDecoration(Color.TRANSPARENT, JUtils.dip2px(10),0,0);
//        itemDecoration.setDrawLastItem(false);
//        erv.addItemDecoration(itemDecoration);


        erv.setAdapterWithProgress(adapter = new CheckoutRecordsAdapter(getContext()));
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
        adapter.add(new CheckinsRecordsBean());
        adapter.add(new CheckinsRecordsBean());

    }
}
