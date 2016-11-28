package com.example.administrator.school.mvp.account.login.model;

import android.text.TextUtils;

import com.example.administrator.school.mvp.account.login.presenter.LoginPresenter;

/**
 * Created by server on 2016/8/30.
 */

public class LoginModel  {
    LoginPresenter presenter;

    public LoginModel(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    public boolean filtrateInput(String usrname,String psw){
        if (TextUtils.isEmpty(usrname)){
            presenter.showInputError("学号不能为空");
            return false;

        }
        if (TextUtils.isEmpty(psw)){
            presenter.showInputError("密码不能为空");
            return false;
        }
        return true;
    }
}
