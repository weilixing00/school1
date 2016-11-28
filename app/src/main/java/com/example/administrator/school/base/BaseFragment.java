package com.example.administrator.school.base;

import android.graphics.Color;
import android.os.Build;
import android.view.View;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Administrator on 2016/8/28.
 */
public class BaseFragment extends SupportFragment{

    /**
     * 透明状态栏
     */
    public void statusBarTranspare(){
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getActivity().getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }



}
