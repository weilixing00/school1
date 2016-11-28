package com.example.administrator.school.mvp.account.login;

/**
 * Created by Administrator on 2016/8/28.
 */

public class ILoginContract {

    public interface View{
        void showInputError(String error);

        void startMainActivity();

        void login(String username,String psw);


    }
    public interface Presenter{

        void login(String username,String psw);

        void forgetPsw();

        void showInputError(String error);
    }

}
