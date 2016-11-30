package com.example.administrator.school.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.utils.JUtils;
import com.socks.library.KLog;

import static com.example.administrator.school.base.BaseApplication.context;

/**
 * Created by Administrator on 2016/9/11.
 * 简单封装的pop 仅适用于目前特定的情景
 */

public class LikeIosPopupWindow extends PopupWindow {


    public TextView t2;
    public  TextView t1;
    public Button cancel;
    private PopupWindow popupWindow;

    public LikeIosPopupWindow(Context context) {
        super(context);
    }

    public LikeIosPopupWindow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LikeIosPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);



    }

    public LikeIosPopupWindow(final View rootView, String text1, String text2) {
        super(rootView);
        View popView = LayoutInflater.from(context).inflate(
                R.layout.popupwindow_likeios, null);
        popupWindow = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        JUtils.setBackgroundGray(rootView);//设置屏幕透明度
        KLog.e("view="+rootView);

        t1 = (TextView) popView.findViewById(R.id.tv1_pop_likeios);
        t2 = (TextView) popView.findViewById(R.id.tv2_pop_likeios);
        cancel = (Button) popView.findViewById(R.id.bt_cancel_pop_likeios);
        t1.setText(text1);
        t2.setText(text2);


        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(true);// 点击空白处时，隐藏掉pop窗口
        popupWindow.setAnimationStyle(R.style.popwin_anim_style);
        // 顯示在根佈局的底部
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM | Gravity.LEFT, 0,
                0);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                KLog.e("dismiss");
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                JUtils.setBackgroundWhite(rootView);
                KLog.e("LikeIOS弹框消失");

            }
        });
    }

    @Override
    public void dismiss() {
        super.dismiss();
        popupWindow.dismiss();
    }




}
