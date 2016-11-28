package com.example.administrator.school.mvp.account.resetloginpsw;

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

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.utils.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/9/10.
 * 修改登录密码
 */

public class ResetLoginPswFragment extends BaseFragment {

    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.et_org_psw_fragment_reset_login_psw)
    EditText etOrgPswFragmentResetLoginPsw;
    @BindView(R.id.et_new_psw_fragment_reset_login_psw)
    EditText etNewPswFragmentResetLoginPsw;
    @BindView(R.id.iv_psw_show_fragment_reset_login_psw)
    ImageView ivPswShowFragmentResetLoginPsw;
    @BindView(R.id.bt_sure_fragment_reset_login_psw)
    Button btSureFragmentResetLoginPsw;

    public static ResetLoginPswFragment newInstance() {
        ResetLoginPswFragment fragment = new ResetLoginPswFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset_login_psw, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeader.setText("修改登录密码");
        ivBackHeader.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                pop();
            }
        });
        ivPswShowFragmentResetLoginPsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPsw();
            }
        });
        btSureFragmentResetLoginPsw.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                //确定
            }
        });
    }


    private boolean isShowPsw;

    private void showPsw() {
        if (isShowPsw) {
            //设置密码隐藏
            ivPswShowFragmentResetLoginPsw.setImageResource(R.mipmap.resetpassword_notshow2x);
            etNewPswFragmentResetLoginPsw.setTransformationMethod(PasswordTransformationMethod.getInstance());  //密码隐藏
        } else {
            //设置密码可见
            ivPswShowFragmentResetLoginPsw.setImageResource(R.mipmap.resetpassword_show);
            etNewPswFragmentResetLoginPsw.setTransformationMethod(HideReturnsTransformationMethod.getInstance()); //密码显示
        }
        //让光标始终在最后
        etNewPswFragmentResetLoginPsw.setSelection(etNewPswFragmentResetLoginPsw.getText().length());
        isShowPsw = !isShowPsw;
    }
}
