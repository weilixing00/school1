package com.example.administrator.school.mvp.account.login.presenter;

import com.example.administrator.school.mvp.account.login.ILoginContract;
import com.example.administrator.school.mvp.account.login.model.LoginModel;

/**
 * Created by server on 2016/8/30.
 */

public class LoginPresenter implements ILoginContract.Presenter {
    ILoginContract.View view;
    private final LoginModel model;

    public LoginPresenter(ILoginContract.View view) {
        this.view = view;
        model = new LoginModel(this);
    }

    @Override
    public void login(String username, String psw) {
        if (model.filtrateInput(username, psw)){

        }
        else {

        }

    }

    @Override
    public void forgetPsw() {

    }

    @Override
    public void showInputError(String error) {
    }
}
