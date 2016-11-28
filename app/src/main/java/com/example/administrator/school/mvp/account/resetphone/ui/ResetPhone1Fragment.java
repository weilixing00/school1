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
import com.example.administrator.school.utils.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by server on 2016/9/3.
 * 修改手机(第一步)
*/
public class ResetPhone1Fragment extends BaseFragment {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.et_name_fragment_reset_phone)
    EditText etNameFragmentResetPhone;
    @BindView(R.id.et_new_phone_num_fragment_reset_phone)
    EditText etNewPhoneNumFragmentResetPhone;
    @BindView(R.id.et_msg_code_fragment_reset_phone)
    EditText etMsgCodeFragmentResetPhone;
    @BindView(R.id.bt_msg_code_fragment_reset_phone)
    Button btMsgCodeFragmentResetPhone;
    @BindView(R.id.bt_next_step_fragment_reset_phone)
    Button btNextStepFragmentResetPhone;

    public static SupportFragment newInstance() {
        ResetPhone1Fragment fragment=new ResetPhone1Fragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset_phone1, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeader.setText("修改手机");
        ivBackHeader.setOnClickListener(noDoubleClick);
        btMsgCodeFragmentResetPhone.setOnClickListener(noDoubleClick);
        btNextStepFragmentResetPhone.setOnClickListener(noDoubleClick);
    }
    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:
                    pop();
                    break;
                case R.id.bt_msg_code_fragment_reset_phone:

                    break;
                case R.id.bt_next_step_fragment_reset_phone:
                    start(ResetPhone2Fragment.newInstance());
                    break;

            }
        }
    };


}
