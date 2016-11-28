package com.example.administrator.school.mvp.course.lectures.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.school.mvp.course.lectures.LecturesProjectsFragment;
import com.example.administrator.school.mvp.course.lectures.MyBookingFragment;

/**
 * Created by Administrator on 2016/9/4.
 */

public class LecturesVPAdapter extends FragmentPagerAdapter {

    private String[] titles=  {"讲座项目","我的预定"};

    public LecturesVPAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return LecturesProjectsFragment.newInstance();
            case 1:
                return MyBookingFragment.newInstance();
            default:
                throw new IllegalArgumentException("讲座Fragment只能显示2个条目");
        }
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
