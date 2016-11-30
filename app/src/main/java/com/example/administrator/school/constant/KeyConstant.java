package com.example.administrator.school.constant;

/**
 * Created by admin on 2016/6/7.
 * 传递数据的一些 key 常量
 */
public interface KeyConstant {

    /**
     * intent传递数据的key常量
     */
    interface IntentKey {

        String MAINACTIIVTY_INDEX = "index";
        String ACCOUNT_SHOW_PAGE = "account_page";

        String SOURCE =         "source";
    }

    /**
     * bundle传递数据的key常量
     */
    interface BundleKey {

        String FANINCING_LIST_INDEX = "index";
        String SOURCE = "source_fragment_show";
        String TITLE = "title";
        String INVEST_MONEY = "invest_money";
        String REPAY_TYPE = "repay_type";
        String ITEM_ID = "item_id";
        String CONTENT = "content";
        String INDEX = "index";
    }

    /**
     * 网络请求参数的key常量
     */
    interface Params {

    }

    /**
     * SP中的key常量
     */
    interface SP {

        String USER_TEL_NUM = "user_tel_num";
        String LOGIN_STATUS = "login_status";
    }
}
