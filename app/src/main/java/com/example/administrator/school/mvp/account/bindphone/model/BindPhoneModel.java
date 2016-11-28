package com.example.administrator.school.mvp.account.bindphone.model;

import android.text.TextUtils;

import com.example.administrator.school.mvp.account.bindphone.presenter.BindPhonePresenter;
import com.example.administrator.school.utils.RegularUtils;

/**
 * Created by Administrator on 2016/9/3.
 */
public class BindPhoneModel {
    private final BindPhonePresenter bindPhonePresenter;

    public BindPhoneModel(BindPhonePresenter bindPhonePresenter) {
            this.bindPhonePresenter=bindPhonePresenter;
    }


    public void senMsgCode(String phoneNum){
        if (TextUtils.isDigitsOnly(phoneNum)){
            bindPhonePresenter.onError("手机号不能为空");
            return;
        }
        if (!RegularUtils.isMobileExact(phoneNum)){
            bindPhonePresenter.onError("请输入正确的手机号");
            return;
        }



    }

    public void bindPhone(String phoneNum, String msgCode) {
        if (TextUtils.isDigitsOnly(phoneNum)){
            bindPhonePresenter.onError("手机号不能为空");
            return;
        }
        if (TextUtils.isDigitsOnly(msgCode)){
            bindPhonePresenter.onError("验证码不能为空");
            return;
        }
        if (!RegularUtils.isMobileExact(phoneNum)){
            bindPhonePresenter.onError("请输入正确的手机号");
            return;
        }


    }
}
