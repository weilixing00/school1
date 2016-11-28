package com.example.administrator.school.mvp.account.resetpsw.model;

import android.text.TextUtils;

import com.example.administrator.school.mvp.account.resetpsw.presenter.ResetPswPresenter;
import com.example.administrator.school.utils.RegularUtils;

/**
 * Created by Administrator on 2016/9/1.
 */

public class ResetPswModel {
    ResetPswPresenter presenter;

    public ResetPswModel(ResetPswPresenter presenter) {
        this.presenter = presenter;
    }

    public void fetchMsgCode(String phoneNum) {
        if (TextUtils.isEmpty(phoneNum)) {
            presenter.showErrMsg("手机号不能为空");
            return;
        }
        if (!RegularUtils.isMobileExact(phoneNum)){
            presenter.showErrMsg("请输入正确的手机号");
            return;
        }
        //发送短信验证码


    }

    public void login(String phoneNum, String msg, String psw) {

        if (TextUtils.isEmpty(phoneNum)) {
            presenter.showErrMsg("手机号不能为空");
            return;
        }
        if (TextUtils.isEmpty(msg)) {
            presenter.showErrMsg("验证码不能为空");
            return;
        }
        if (TextUtils.isEmpty(psw)) {
            presenter.showErrMsg("密码不能为空");
            return;
        }
        if (!RegularUtils.isMobileExact(phoneNum)){
            presenter.showErrMsg("请输入正确的手机号");
            return;
        }


    }
}
