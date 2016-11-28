package com.example.administrator.school.mvp.other.aboutsoftware;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.mvp.other.aboutus.AboutUsFragment;
import com.example.administrator.school.mvp.other.useritem.UserItemAndPrivacyPolicyFragment;
import com.example.administrator.school.utils.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/9/2.
 * 关于软件
 */

public class AboutSoftWareFragment extends BaseFragment {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.ll_help_feedback_fragment_about_software)
    LinearLayout llHelpFeedbackFragmentAboutSoftware;
    @BindView(R.id.ll_use_item_fragment_about_software)
    LinearLayout llUseItemFragmentAboutSoftware;
    @BindView(R.id.ll_about_us_fragment_about_software)
    LinearLayout llAboutUsFragmentAboutSoftware;

    public static AboutSoftWareFragment newInstance() {
        AboutSoftWareFragment aboutSoftWareFragment = new AboutSoftWareFragment();

        return aboutSoftWareFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_software, container, false);
        ButterKnife.bind(this, view);

        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeader.setText("关于软件");
        ivBackHeader.setOnClickListener(noDoubleClick);
        llAboutUsFragmentAboutSoftware.setOnClickListener(noDoubleClick);
        llHelpFeedbackFragmentAboutSoftware.setOnClickListener(noDoubleClick);
        llUseItemFragmentAboutSoftware.setOnClickListener(noDoubleClick);

    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                //返回
                case R.id.iv_back_header:
                    pop();
                    break;
                //帮助与反馈
                case R.id.ll_help_feedback_fragment_about_software:

                    break;

                //使用条款与隐私政策
                case R.id.ll_use_item_fragment_about_software:
                    start(UserItemAndPrivacyPolicyFragment.newInstance());
                    break;
                //关于我们
                case R.id.ll_about_us_fragment_about_software:
                    start(AboutUsFragment.newInstance());

                    break;


            }
        }
    };


}
