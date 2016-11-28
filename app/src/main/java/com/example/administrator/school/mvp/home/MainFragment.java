package com.example.administrator.school.mvp.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.constant.KeyConstant;
import com.example.administrator.school.event.StartBrotherEvent;
import com.example.administrator.school.event.TabSelectedEvent;
import com.example.administrator.school.mvp.home.checkins.CheckinsTabFragment;
import com.example.administrator.school.mvp.home.homepage.ui.HomePageTabFragment;
import com.example.administrator.school.mvp.home.me.ui.MeTabFragment;
import com.example.administrator.school.view.BottomBar;
import com.example.administrator.school.view.BottomBarTab;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import me.yokeyword.fragmentation.SupportFragment;


/**
 * Created by YoKeyword on 16/6/30.
 * 首页
 */
public class MainFragment extends BaseFragment {
    private static final int REQ_MSG = 10;

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;

    private SupportFragment[] mFragments = new SupportFragment[3];

    private BottomBar mBottomBar;


    public static MainFragment newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt(KeyConstant.BundleKeyConstant.INDEX,index);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        if (savedInstanceState == null) {
            mFragments[FIRST] = HomePageTabFragment.newInstance();
            mFragments[SECOND] = CheckinsTabFragment.newInstance();
            mFragments[THIRD] = MeTabFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用,也可以通过getChildFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findChildFragment(HomePageTabFragment.class);
            mFragments[SECOND] = findChildFragment(CheckinsTabFragment.class);
            mFragments[THIRD] = findChildFragment(MeTabFragment.class);
        }

        initView(view);
        return view;
    }

    private void initView(View view) {
        EventBus.getDefault().register(this);
        mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);

        mBottomBar
                .addItem(new BottomBarTab(_mActivity, R.mipmap.index_index_nor2x, "首页"))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.index_massage_click2x, "签到"))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.index_accountr_normal2x, "我"));

        int index = getArguments().getInt(KeyConstant.BundleKeyConstant.INDEX);
        mBottomBar.setCurrentItem(index);

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                        KLog.e("onTabReselected");
                      statusBarTranspare();
                // 这里推荐使用EventBus来实现 -> 解耦
                // 在FirstPagerFragment,FirstHomeFragment中接收, 因为是嵌套的Fragment
                // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
//                EventBus.getDefault().post(new TabSelectedEvent(position));
            }
        });
    }



    @Override
    protected void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        if (requestCode == REQ_MSG && resultCode == RESULT_OK) {

        }
    }



    /**
     * start other BrotherFragment
     */
    @Subscribe
    public void startBrother(StartBrotherEvent event) {
        start(event.targetFragment);
        KLog.e("触发了Eventbus的startBus事件");
//        startWithPop(event.targetFragment)
//        pop();
    }

    @Subscribe
    public void tabSelect(TabSelectedEvent event) {
        mBottomBar.setCurrentItem(event.position);
        KLog.e("触发了Eventbus的底部选项卡按钮");
//        startWithPop(event.targetFragment);
//        pop();
    }



    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }
}
