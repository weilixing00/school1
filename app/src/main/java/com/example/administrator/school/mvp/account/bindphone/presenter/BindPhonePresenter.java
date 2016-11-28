package com.example.administrator.school.mvp.account.bindphone.presenter;

import com.example.administrator.school.mvp.account.bindphone.BindPhoneContract;
import com.example.administrator.school.mvp.account.bindphone.model.BindPhoneModel;

/**
 * Created by Administrator on 2016/9/3.
 */

public class BindPhonePresenter implements BindPhoneContract.Presenter {
    private BindPhoneContract.View view ;
    private final BindPhoneModel model;

    public BindPhonePresenter(BindPhoneContract.View view) {
        this.view = view;
        model = new BindPhoneModel(this);
    }

    @Override
    public void sendMsgCode(String phoneNum) {
        model.senMsgCode(phoneNum);
    }

    @Override
    public void bindPhone(String phoneNum, String msgCode) {
        model.bindPhone(phoneNum,msgCode);
    }

    @Override
    public void onError(String msgCode) {
            view.onError(msgCode);
    }
}
