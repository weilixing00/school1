package com.example.administrator.school.mvp.account.resetpsw.presenter;

import com.example.administrator.school.mvp.account.resetpsw.ResetPswContract;
import com.example.administrator.school.mvp.account.resetpsw.model.ResetPswModel;

/**
 * Created by Administrator on 2016/9/1.
 */

public class ResetPswPresenter implements ResetPswContract.Presenter {

    private final ResetPswContract.View view;
    private final ResetPswModel model;

    public ResetPswPresenter(ResetPswContract.View  view) {
        this.view =view;
        model = new ResetPswModel(this);
    }

    @Override
    public void fetchMsgCode(String phoneNum) {
        model.fetchMsgCode(phoneNum);
    }

    @Override
    public void login(String phoneNum, String msg, String psw) {
        model.login(phoneNum,msg,psw);
    }

    @Override
    public void showErrMsg(String errMsg) {
        view.showError(errMsg);
    }
}
