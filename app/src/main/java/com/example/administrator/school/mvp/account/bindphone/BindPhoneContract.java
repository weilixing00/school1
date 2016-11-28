package com.example.administrator.school.mvp.account.bindphone;

/**
 * Created by Administrator on 2016/9/3.
 */

public interface BindPhoneContract {
    interface View{
        void onMsgCodeSuc();
        void onError(String error);

    }
    interface Presenter{
        void sendMsgCode(String phoneNum);

        void bindPhone(String phoneNum,String msgCode);

        void onError(String msgCode);
    }
}
