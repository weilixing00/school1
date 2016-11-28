package com.example.administrator.school.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;

import com.example.administrator.school.R;


/**
 * Created by admin on 2015/12/28.
 * 倒计时按钮
 */
public class TimeCountUtil extends CountDownTimer {
    private Activity mActivity;
    private Button btn;//按钮

    // 在这个构造方法里需要传入三个参数，一个是Activity，一个是总的时间millisInFuture，一个是countDownInterval，然后就是你在哪个按钮上做这个是，就把这个按钮传过来就可以了
    //默认间隔60s
    public TimeCountUtil( Activity mActivity, long countDownInterval,Button btn) {
        super(60000, countDownInterval);
        this.mActivity = mActivity;
        this.btn =btn;
    }


    @SuppressLint("NewApi")
    @Override
    public void onTick(long millisUntilFinished) {
        btn.setClickable(false);//设置不能点击
        btn.setText(millisUntilFinished / 1000 + "秒后可重发");//设置倒计时时间
//        btn.setTextSize();
        //设置按钮为灰色，这时是不能点击的
        btn.setBackgroundColor(mActivity.getResources().getColor(R.color.deepGray));
        Spannable span = new SpannableString(btn.getText().toString());//获取按钮的文字
        span.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//将倒计时时间显示为红色
        btn.setText(span);

    }


    @SuppressLint("NewApi")
    @Override
    public void onFinish() {
        btn.setText("重新获取验证码");
        btn.setClickable(true);//重新获得点击
        btn.setBackgroundColor(Color.parseColor("#fff"));//还原背景色
        btn.setBackground(mActivity.getDrawable(R.drawable.bg_bt_verification_code));
    }


}
