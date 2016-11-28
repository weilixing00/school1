package com.example.administrator.school.mvp.home.checkins;

import android.graphics.Color;
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
import com.example.administrator.school.bean.CheckinsBean;
import com.example.administrator.school.event.StartBrotherEvent;
import com.example.administrator.school.mvp.course.history.HistoryFragment;
import com.example.administrator.school.mvp.home.checkins.adapter.CheckinsAdapter;
import com.example.administrator.school.utils.JUtils;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/28.
 */
public class CheckinsTabFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeader;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.erv_fragment_checkins)
    EasyRecyclerView ervFragmentCheckins;
    private CheckinsAdapter adapter;

    public static CheckinsTabFragment newInstance() {
        CheckinsTabFragment checkinsTabFragment = new CheckinsTabFragment();
        return checkinsTabFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chekins, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeader.setText("签到");
        tvRightHeader.setText("历史记录");
        ivBackHeader.setVisibility(View.INVISIBLE);
        tvRightHeader.setOnClickListener(new NoDoubleClickListener() {

            @Override
            public void onNoDoubleClick(View v) {
                //页面的逻辑跳转 MainFragment才和HistoryFragment平级 应该从MainFragment跳转
                EventBus.getDefault().post(new StartBrotherEvent(HistoryFragment.newInstance()));
//                start(HistoryFragment.newInstance());
            }
        });
        initRecycleView();
    }

        private void initRecycleView() {
            ervFragmentCheckins.setLayoutManager(new LinearLayoutManager(getContext()));
            DividerDecoration itemDecoration = new DividerDecoration(Color.TRANSPARENT, JUtils.dip2px(10),0,0);
            itemDecoration.setDrawLastItem(false);
            ervFragmentCheckins.addItemDecoration(itemDecoration);


        ervFragmentCheckins.setAdapterWithProgress(adapter = new CheckinsAdapter(getContext()));
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


        ervFragmentCheckins.setRefreshListener(this);
            onRefresh();
        }


        @Override
        public void onLoadMore() {

        }

        @Override
        public void onRefresh() {
            adapter.clear();
            List<CheckinsBean> items=new ArrayList<>();
            items.add(new CheckinsBean());
            items.add(new CheckinsBean());
            adapter.addAll(items);
        }

    }


