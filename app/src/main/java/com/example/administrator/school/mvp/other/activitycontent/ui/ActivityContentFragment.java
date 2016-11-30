package com.example.administrator.school.mvp.other.activitycontent.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by server on 2016/9/3.
 * 活动内容
 */

public class ActivityContentFragment extends BaseFragment {


    @BindView(R.id.iv_back_header_noshodow)
    ImageView ivBackHeaderNoshodow;
    @BindView(R.id.tv_middle_header_noshodow)
    TextView tvMiddleHeaderNoshodow;
    @BindView(R.id.tv_right_header_noshodow)
    TextView tvRightHeaderNoshodow;
    @BindView(R.id.iv_picturefragment_campagion_content)
    ImageView ivPicturefragmentCampagionContent;
    @BindView(R.id.tv_title_fragment_campagion_content)
    TextView tvTitleFragmentCampagionContent;
    @BindView(R.id.tv_date_fragment_campagion_content)
    TextView tvDateFragmentCampagionContent;
    @BindView(R.id.tv_time_fragment_campagion_content)
    TextView tvTimeFragmentCampagionContent;
    @BindView(R.id.tv_address_fragment_campagion_content)
    TextView tvAddressFragmentCampagionContent;
    @BindView(R.id.tv_host_name_fragment_campagion_content)
    TextView tvHostNameFragmentCampagionContent;
    @BindView(R.id.tv_campagion_info_fragment_campagion_content)
    TextView tvCampagionInfoFragmentCampagionContent;
    @BindView(R.id.iv_collect_fragment_campagion_content)
    ImageView ivCollectFragmentCampagionContent;
    @BindView(R.id.iv_share_fragment_campagion_content)
    ImageView ivShareFragmentCampagionContent;
    @BindView(R.id.iv_to_top_fragment_activity_content)
    ImageView ivToTopFragmentActivityContent;
    @BindView(R.id.sv_fragment_campagion_content)
    ScrollView svFragmentCampagionContent;


    public static ActivityContentFragment newInstance() {
        ActivityContentFragment fragment = new ActivityContentFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_content, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeaderNoshodow.setText("活动内容");
        ivBackHeaderNoshodow.setOnClickListener(noDoubleClick);
        ivShareFragmentCampagionContent.setOnClickListener(noDoubleClick);
        ivToTopFragmentActivityContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                svFragmentCampagionContent.scrollTo(0,0);
            }
        });
        //演示暂时用没有时间间隔的点击事件 正式时候换回来不能重复点击
//        ivCollectFragmentCampagionContent.setOnClickListener(noDoubleClick);
        ivCollectFragmentCampagionContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                collect();
            }
        });

    }


    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header_noshodow:
                    pop();
                    break;

                //收藏
                case R.id.iv_collect_fragment_campagion_content:
//                    Toast.makeText(_mActivity, "收藏", Toast.LENGTH_SHORT).show();
                    collect();
                    break;
                //分享
                case R.id.iv_share_fragment_campagion_content:
//                    Toast.makeText(_mActivity, "分享", Toast.LENGTH_SHORT).show();
                    showShare();
                    break;

            }
        }
    };


    private boolean isCollected = false;

    //收藏
    private void collect() {
        KLog.e();
        ivCollectFragmentCampagionContent.setImageResource(isCollected ? R.mipmap.activity_like_normal2x : R.mipmap.activity_like_click2x);
        isCollected = !isCollected;
    }

    private void showShare() {
        ShareSDK.initSDK(getContext());
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(getContext());
    }

}
