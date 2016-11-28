package com.example.administrator.school.mvp.account.resetpsw.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.mvp.account.resetpsw.ResetPswContract;
import com.example.administrator.school.mvp.account.resetpsw.presenter.ResetPswPresenter;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.example.administrator.school.view.TimeCountUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/9/1.
 * 重置密码
 */

public class ResetPswFragment extends BaseFragment implements ResetPswContract.View {

    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.et_phone_num_fragment_reset_psw)
    EditText etPhoneNumFragmentResetPsw;
    @BindView(R.id.et_msg_code_fragment_reset_psw)
    EditText etMsgCodeFragmentResetPsw;
    @BindView(R.id.bt_fetch_msg_code_fragment_reset_psw)
    Button btFetchMsgCodeFragmentResetPsw;
    @BindView(R.id.et_psw_fragment_reset_psw)
    EditText etPswFragmentResetPsw;
    @BindView(R.id.iv_psw_show_fragment_reset_psw)
    ImageView ivPswShowFragmentResetPsw;
    @BindView(R.id.bt_ok_fragment_reset_psw)
    Button btOkFragmentResetPsw;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeader;
    private ResetPswPresenter presenter;
    private TimeCountUtil countUtil;

    public static ResetPswFragment newInstance() {
        ResetPswFragment fragment=new ResetPswFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset_psw, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        presenter = new ResetPswPresenter(this);
        countUtil = new TimeCountUtil(_mActivity, 1000, btFetchMsgCodeFragmentResetPsw);
        tvMiddleHeader.setText("重置密码");
        ivBackHeader.setOnClickListener(clickListener);
        ivPswShowFragmentResetPsw.setOnClickListener(clickListener);
        btOkFragmentResetPsw.setOnClickListener(noDoubleClick);
        btFetchMsgCodeFragmentResetPsw.setOnClickListener(noDoubleClick);
    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
                    String phoneNum= etPhoneNumFragmentResetPsw.getText().toString().trim() ;
            switch (v.getId()) {
                case R.id.bt_fetch_msg_code_fragment_reset_psw:
                    //获取短信验证码
                    presenter.fetchMsgCode(phoneNum);
                    break;
                case R.id.bt_ok_fragment_reset_psw:
                    String psw = etPswFragmentResetPsw.getText().toString().trim();
                    String msgCode = etMsgCodeFragmentResetPsw.getText().toString().trim();
                    presenter.login(phoneNum,msgCode,psw);
                    break;
            }
        }
    };


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.iv_back_header:
                    //返回

                    break;
                case R.id.iv_psw_show_fragment_reset_psw:
                    //密码显示隐藏
                    showPsw();
                    break;

            }
        }
    };


    private boolean isShowPsw;

    private void showPsw() {
        if (isShowPsw) {
            //设置密码隐藏
            ivPswShowFragmentResetPsw.setImageResource(R.mipmap.resetpassword_notshow2x);
            etPswFragmentResetPsw.setTransformationMethod(PasswordTransformationMethod.getInstance());  //密码隐藏
        } else {
            //设置密码可见
            ivPswShowFragmentResetPsw.setImageResource(R.mipmap.resetpassword_show);
            etPswFragmentResetPsw.setTransformationMethod(HideReturnsTransformationMethod.getInstance()); //密码显示
        }
        //让光标始终在最后
        etPswFragmentResetPsw.setSelection(etPswFragmentResetPsw.getText().length());
        isShowPsw = !isShowPsw;
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(_mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMsgCodeSuc() {
        countUtil.start();

    }


}
