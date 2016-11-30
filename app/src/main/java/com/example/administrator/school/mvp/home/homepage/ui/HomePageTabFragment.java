package com.example.administrator.school.mvp.home.homepage.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.bean.SchoolActivityBean;
import com.example.administrator.school.event.StartBrotherEvent;
import com.example.administrator.school.mvp.course.credit.CreditFragment;
import com.example.administrator.school.mvp.course.lectures.LecturesFragment;
import com.example.administrator.school.mvp.other.activitycontent.ui.ActivityContentFragment;
import com.example.administrator.school.mvp.other.message.ui.MessageFragment;
import com.example.administrator.school.mvp.other.schoolactivity.SchoolActivityFragment;
import com.example.administrator.school.utils.CommonAdapter;
import com.example.administrator.school.utils.JUtils;
import com.example.administrator.school.utils.LvViewHolder;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.example.administrator.school.view.AutoRollLayout;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/28.
 * 首页
 */
public class HomePageTabFragment extends BaseFragment {

    @BindView(R.id.arl_fragment_homepage)
    AutoRollLayout arlFragmentHomepage;
    @BindView(R.id.tv_more_fragment_homepage)
    TextView tvMoreFragmentHomepage;
    @BindView(R.id.lv_fragment_homepage)
    ListView lvFragmentHomepage;
    @BindView(R.id.tv_message_count_fragment_homepage)
    TextView tvMessageCountFragmentHomepage;
    @BindView(R.id.fl_message_fragment_homepage)
    FrameLayout flMessageFragmentHomepage;
    @BindView(R.id.ll_lectures_fragment_homepage)
    LinearLayout llLecturesFragmentHomepage;//学术讲座
    @BindView(R.id.ll_score_fragment_homepage)
    LinearLayout llScoreFragmentHomepage;//创新学分
    private List<SchoolActivityBean> items;

    public static HomePageTabFragment newInstance() {
        HomePageTabFragment homePageTabFragment = new HomePageTabFragment();
        return homePageTabFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//       statusBarTranspare();
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        ButterKnife.bind(this, view);
//        StatusBarUtil.setTranslucentForImageViewInFragment(getActivity(),0, arlFragmentHomepage);
        initView();
        return view;
    }

    private void initView() {


        initScrollowBar();
        initLv();
        tvMoreFragmentHomepage.setOnClickListener(noDoubleClick);
        flMessageFragmentHomepage.setOnClickListener(noDoubleClick);
        llLecturesFragmentHomepage.setOnClickListener(noDoubleClick);
        llScoreFragmentHomepage.setOnClickListener(noDoubleClick);


    }

    private void initLv() {
        //设置lv默认没有焦点 防止默认滑到lv的首条而不是scrollView的首条
//        lvFragmentHomepage.setFocusable(false);  重写scrollview之后 就不用这样了

        items = new ArrayList<>();
        items.add(new SchoolActivityBean());
        items.add(new SchoolActivityBean());
        CommonAdapter<SchoolActivityBean> adapter = new CommonAdapter<SchoolActivityBean>(getContext(), items, R.layout.item_erv_fragment_school_activity) {
            @Override
            public void convert(LvViewHolder holder, SchoolActivityBean schoolActivityBean) {

            }
        };
        lvFragmentHomepage.setAdapter(adapter);
        JUtils.setListViewHeight(lvFragmentHomepage, adapter, items.size());
        lvFragmentHomepage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //跳转到活动内容
                EventBus.getDefault().post(new StartBrotherEvent(ActivityContentFragment.newInstance()));
            }
        });
    }

    private void initScrollowBar() {
        List<AutoRollLayout.RollItem> arlList = new ArrayList<>();
        arlList.add(new AutoRollLayout.RollItem(null, R.mipmap.lunbotu));
        arlList.add(new AutoRollLayout.RollItem(null, R.mipmap.lunbotu2));
        arlFragmentHomepage.setItems(arlList);
        arlFragmentHomepage.setAutoRoll(true);
    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                //跳转到校园活动
                case R.id.tv_more_fragment_homepage:
                    EventBus.getDefault().post(new StartBrotherEvent(SchoolActivityFragment.newInstance()));
                    break;
                //跳转到消息
                case R.id.fl_message_fragment_homepage:
                    EventBus.getDefault().post(new StartBrotherEvent(MessageFragment.newInstance()));
                    break;
                //学术讲座
                case R.id.ll_lectures_fragment_homepage:
                   EventBus.getDefault().post(new StartBrotherEvent(LecturesFragment.newInstance()));
                    KLog.e("学术讲座  点击");
                    break;
                //创新学分
                case R.id.ll_score_fragment_homepage:
                    //// TODO: 2016/9/9 跳转到学分
                   EventBus.getDefault().post(new StartBrotherEvent(CreditFragment.newInstance()));

                    break;
            }
        }
    };

}
