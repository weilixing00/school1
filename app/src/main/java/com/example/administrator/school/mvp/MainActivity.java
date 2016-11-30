package com.example.administrator.school.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.administrator.school.R;
import com.example.administrator.school.mvp.home.MainFragment;
import com.socks.library.KLog;

import cn.sharesdk.framework.ShareSDK;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class MainActivity extends SupportActivity {



    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;
    private InputMethodManager imm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //软键盘自动隐藏
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance(0));
//           loadRootFragment(R.id.fl_container, ContestDetailFragment.newInstance());
        }

        //todo 初始化sharesdk  后面参数为sharesdk的id
        ShareSDK.initSDK(this,"172d56e525e38");
    }

//    @Override
//    public void onBackPressedSupport() {
//        // 对于 4个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
//        super.onBackPressedSupport();
//    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();
    }





    //控制点击EditText其他地方软键盘消失  包含ScrollView的地方会失效  看来这个地方不适用
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
//                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
//                        InputMethodManager.HIDE_NOT_ALWAYS);
//            }
//        }
//        Toast.makeText(this, "执行", Toast.LENGTH_SHORT).show();
//        return super.onTouchEvent(event);
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        KLog.e("requestCode="+requestCode+"  resultCode="+resultCode);
    }

    @Override
    public void onBackPressedSupport() {

        Fragment topFragment = getTopFragment();


        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
                finish();
            } else {
                TOUCH_TIME = System.currentTimeMillis();
                Toast.makeText(this, R.string.press_again_exit,Toast.LENGTH_SHORT).show();
            }
        }
    }


}


