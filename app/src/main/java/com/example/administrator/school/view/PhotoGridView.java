package com.example.administrator.school.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2016/9/13.
 */

public class PhotoGridView extends GridView {
    public PhotoGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public PhotoGridView(Context context) {
        super(context);
    }
    public PhotoGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}