package com.example.administrator.school.mvp.other.aboutus;

import android.content.Intent;
import android.net.Uri;
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
import com.example.administrator.school.utils.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Administrator on 2016/9/4.
 * 关于我们
 */

public class AboutUsFragment extends BaseFragment {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.tv_version_name_fragment_about_us)
    TextView tvVersionNameFragmentAboutUs;
    @BindView(R.id.ll_customer_server_fragment_about_us)
    LinearLayout llCustomerServerFragmentAboutUs;
    @BindView(R.id.tv_company_info_fragment_about_us)
    TextView tvCompanyInfoFragmentAboutUs;
    @BindView(R.id.tv_phone_fragment_about_us)
    TextView tvPhoneFragmentAboutUs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public static SupportFragment newInstance() {
        AboutUsFragment fragment = new AboutUsFragment();
        return fragment;
    }

    private void initView() {
        tvMiddleHeader.setText("关于我们");
        ivBackHeader.setOnClickListener(noDoubleClick);
        llCustomerServerFragmentAboutUs.setOnClickListener(noDoubleClick);
    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header:
                    pop();
                    break;
                //客服热线
                case R.id.ll_customer_server_fragment_about_us:
                    //测试  跳转到拨号页面
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tvPhoneFragmentAboutUs.getText().toString().trim()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    break;
            }
        }
    };


}
