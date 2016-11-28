package com.example.administrator.school.mvp.account.resetphone.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.mvp.home.MainFragment;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.example.administrator.school.view.TimeCountUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/9/3.
 * 修改手机(第二步)
 */

public class ResetPhone2Fragment extends BaseFragment {

    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.et_new_phone_num_fragment_reset_phone2)
    EditText etNewPhoneNumFragmentResetPhone2;
    @BindView(R.id.et_msg_code_fragment_reset_phone2)
    EditText etMsgCodeFragmentResetPhone2;
    @BindView(R.id.bt_msg_code_fragment_reset_phone2)
    Button btMsgCodeFragmentResetPhone2;
    @BindView(R.id.bt_sure_fragment_reset_phone2)
    Button btSureFragmentResetPhone2;
    private TimeCountUtil countUtil;

    public static ResetPhone2Fragment newInstance() {
        ResetPhone2Fragment fragment=new ResetPhone2Fragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset_phone2, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

        tvMiddleHeader.setText("修改手机");
        ivBackHeader.setOnClickListener(noDoubleClick);
        btMsgCodeFragmentResetPhone2.setOnClickListener(noDoubleClick);
        btSureFragmentResetPhone2.setOnClickListener(noDoubleClick);
        countUtil = new TimeCountUtil(_mActivity,1000,btMsgCodeFragmentResetPhone2);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    pop();
                    break;
                case R.id.bt_msg_code_fragment_reset_phone2:

                    break;
                case R.id.bt_sure_fragment_reset_phone2:
                    //确定
                    start(MainFragment.newInstance(2));
                    break;

            }
        }
    };


}
