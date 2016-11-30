package com.example.administrator.school.mvp.account.login.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.mvp.account.login.ILoginContract;
import com.example.administrator.school.mvp.account.login.presenter.LoginPresenter;
import com.example.administrator.school.mvp.account.resetpsw.ui.ResetPswFragment;
import com.example.administrator.school.mvp.home.MainFragment;
import com.example.administrator.school.utils.JUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/28.
 * 登录
 */

public class LoginFragment extends BaseFragment implements ILoginContract.View {


    @BindView(R.id.et_username_fragment_login)
    EditText etUsernameFragmentLogin;
    @BindView(R.id.et_psw_fragment_login)
    EditText etPswFragmentLogin;
    @BindView(R.id.bt_login_fragment_login)
    Button btLoginFragmentLogin;
    @BindView(R.id.tv_forget_psw_fragment_login)
    TextView tvForgetPswFragmentLogin;
    private ILoginContract.Presenter presenter;




    public static  LoginFragment newInstance(){
        LoginFragment fragment=new LoginFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        statusBarTranspare();
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        presenter = new LoginPresenter(this);
        initView();
        return view;
    }

    private void initView() {
        btLoginFragmentLogin.setOnClickListener(clickListener);
        tvForgetPswFragmentLogin.setOnClickListener(clickListener);
    }

    @Override
    public void showInputError(String error) {
        JUtils.Toast(error);
    }

    @Override
    public void startMainActivity() {
        start(MainFragment.newInstance(0));
    }

    @Override
    public void login(String username, String psw) {

    }



    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                //登录
                case R.id.bt_login_fragment_login:
                    //正常版本之后解除注释
//                    String username = etUsernameFragmentLogin.getText().toString().trim();
//                    String psw = etPswFragmentLogin.getText().toString().trim();
//                    presenter.login(username, psw);

                    //测试的逻辑  正常版本之后删掉
                    start(MainFragment.newInstance(0));
                    break;
                //忘记密码
                case R.id.tv_forget_psw_fragment_login:
                    start(ResetPswFragment.newInstance());
                    break;
            }
        }
    };

}
