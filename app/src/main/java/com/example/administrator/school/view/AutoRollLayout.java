package com.example.administrator.school.view;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.school.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by server on 2016/7/14.
 * 自定义轮播图 自动滚动 自动生成点
 */

public class AutoRollLayout extends RelativeLayout {
    private LinearLayout dotContainer;
    private ViewPager viewPager;
    private GestureDetector gestureDetector;

    public AutoRollLayout(Context context) {
        this(context, null);
    }

    public AutoRollLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoRollLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.arl_layout_arl, this);
        dotContainer = (LinearLayout) findViewById(R.id.arl_arl_dot_container);
        viewPager = (ViewPager) findViewById(R.id.arl_arl_vp);
//        ① 创建 GestureDetector 对象
        gestureDetector = new GestureDetector(getContext(), gestureListener);

//
//        viewPager.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AutoRollLayout.this.performClick();
//            }
//        });

        // 对view设置了触摸监听，在view的分发触摸事件的方法中，会：
        // 1 先调用触摸监听的onTouch方法
        // 2 如果onTouch返回true了，就不会调用自己的onTouchEvent方法了
        // 3 如果onTouch返回false了，才会调用自己的onTouchEvent方法

        // 如果没有对view设置触摸监听，
        // 在分发中会调用自己的onTouchEvent方法

        viewPager.setOnTouchListener(touchListener);
    }


    // 如果手指按上去，就不滚动     ！= 手指松开就滚动

    boolean isTouching;
    boolean isAutoRollWhenDown;
    private OnTouchListener touchListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
//            ② 把触摸事件交给它去分析
            gestureDetector.onTouchEvent(event);

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    isTouching = true;
                    break;
                case MotionEvent.ACTION_UP:
                    isTouching = false;

                    break;
            }
            return false;
        }
    };


    static Handler handler = new Handler();
    boolean autoRoll = false;

    public void setAutoRoll(boolean autoRoll) {
        this.autoRoll = autoRoll;
        if (autoRoll) {
            handler.postDelayed(showNextPageRunnable, 1000);
        } else {
            handler.removeCallbacks(showNextPageRunnable);
        }
    }
    Runnable showNextPageRunnable = new Runnable() {
        @Override
        public void run() {
            // 只保证有一个任务在执行，防止重复执行，
//            removeCallbacks 只能取消掉未执行的任务， 可以取消掉所有 == 参数 的任务
            handler.removeCallbacks(this);
            if (!isTouching) {
                showNextPage();
            }
            //设置滚动时间 3秒
            handler.postDelayed(this, 3000);
        }
    };

    //设置滑动方向
    boolean toRight = true;
    private void showNextPage() {
        // 只有一张页面的时候，setCurrentItem 设置了错误的值，但Viewpager已经处理了，我们要知道
        if (pagerAdapter.getCount() == 1) {
            return;
        }

        int currentIndex = viewPager.getCurrentItem();
        if (currentIndex == 0) {
            toRight = true;
        } else if (currentIndex == pagerAdapter.getCount() - 1) {
            toRight = false;
        }

        int targetIndex;
        if (toRight) {
            targetIndex = currentIndex + 1;
        } else {
            targetIndex = currentIndex - 1;
        }

        viewPager.setCurrentItem(targetIndex);
    }



    List<RollItem> items;

    public void setItems(List<RollItem> items) {
        this.items = items;
        if (viewPager==null){
            return;
        }
        // 让ViewPager展示图片
        viewPager.setAdapter(pagerAdapter);
        // 让textview去显示标题
//        titleTv.setText(null);
        viewPager.setOnPageChangeListener(pagerListener);
        // 让点去展示当前显示。。。
        dotContainer.removeAllViews();
        addDots();
        // 初始值
        pagerListener.onPageSelected(0);
    }

    private void addDots() {
        if (items == null || items.isEmpty()) {
            return;
        }
        int pxFor10dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        for (RollItem item : items) {
            View dot = new View(getContext());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(pxFor10dp, pxFor10dp);
            lp.setMargins(0, 0, pxFor10dp, 0);
            dot.setLayoutParams(lp);

            dot.setBackgroundResource(R.drawable.arl_dot_selector);
            dot.setOnClickListener(chooseItemOcl);
            dotContainer.addView(dot);
        }

    }


    private OnClickListener chooseItemOcl = new OnClickListener() {
        @Override
        public void onClick(View v) {
            int index = dotContainer.indexOfChild(v);
            Log.d("onClick", "" + index);
            viewPager.setCurrentItem(index);
        }
    };


    private GestureDetector.OnGestureListener gestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        //        ③ 享用分析的结果
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.e("GestureDetector", "onSingleTapUp");
            AutoRollLayout.this.performClick();
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    };

//    private BreakIterator titleTv;
    private ViewPager.OnPageChangeListener pagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (items == null || items.isEmpty()) {
                return;
            }

            for (int i = 0; i < pagerAdapter.getCount(); i++) {
//                if(i == position){
//                    dotContainer.getChildAt(i).setEnabled(false);
//                }else{
//                    dotContainer.getChildAt(i).setEnabled(true);
//                }
                dotContainer.getChildAt(i).setEnabled(i != position);
            }
//            dotContainer.getChildAt(position).setEnabled(false);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public static class RollItem {
       private String urlPath;
        private  int resId;

        public RollItem(String urlPath,int resId) {
            this.urlPath = urlPath;
            this.resId=resId;
        }

//        public RollItem(int resId){
//            this.resId=resId;
//        }

        public int getResId() {
            return resId;
        }

        public String getUrlPath() {
            return urlPath;
        }


    }

    private PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return items == null ? 0 : items.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        List<ImageView> cache = new ArrayList<>();


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (cache.isEmpty()) {
                ImageView iv = new ImageView(container.getContext());
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
                cache.add(iv);
            }
            ImageView imageView=cache.remove(0);
            String picPath = items.get(position).getUrlPath();
            int resId = items.get(position).getResId();
            //通过构造参数判断加载图片来源网络还是本地
            //本地加载
            if (TextUtils.isEmpty(picPath)){
                imageView.setImageResource(resId);
            }
            //网络加载
            else {

                Picasso.with(container.getContext()).load(picPath).into(imageView);
            }
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ImageView imageView = (ImageView) object;
            cache.add(imageView);
            container.removeView(imageView);
        }
    };

}
