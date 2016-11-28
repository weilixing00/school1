package com.example.administrator.school.mvp.other.message.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.utils.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by server on 2016/9/3.
 * 消息正文
 */

public class MessageContentFragment extends BaseFragment {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.tv_date_fragment_message_content)
    TextView tvDateFragmentMessageContent;
    @BindView(R.id.tv_time_fragment_message_content)
    TextView tvTimeFragmentMessageContent;
    @BindView(R.id.tv_content_fragment_message_content)
    TextView tvContentFragmentMessageContent;


    public static SupportFragment newInstance() {
        MessageContentFragment fragment=new MessageContentFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_content, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeader.setText("消息正文");
        ivBackHeader.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                pop();
            }
        });
// TODO: 2016/9/3  tvContentFragmentMessageContent 用settext(\t\t  ) 转义字符保证首行的两个字的间距


    }


}
