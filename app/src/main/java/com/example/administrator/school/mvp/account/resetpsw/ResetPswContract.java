package com.example.administrator.school.mvp.account.resetpsw;

/**
 * Created by Administrator on 2016/9/1.
 */

public interface ResetPswContract {
     interface View{
        void showError(String msg);

         void onMsgCodeSuc();


    }
    interface Presenter{

        void fetchMsgCode(String phoneNum);

        void login(String phoneNum,String msg,String psw);

        void showErrMsg(String errMsg);
    }
}
