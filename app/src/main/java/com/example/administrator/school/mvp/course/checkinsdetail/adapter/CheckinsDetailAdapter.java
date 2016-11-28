package com.example.administrator.school.mvp.course.checkinsdetail.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.school.mvp.course.checkinsdetail.CheckinsRecordsFragment;
import com.example.administrator.school.mvp.course.checkinsdetail.CheckoutRecordsFragment;

/**
 * Created by server on 2016/9/6.
 */
public class CheckinsDetailAdapter extends FragmentPagerAdapter {

    private String[] titles = {"签到记录", "签退记录"};

    public CheckinsDetailAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titles[position];
    }



    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CheckinsRecordsFragment.newInstance();
            case 1:
                    return CheckoutRecordsFragment.newInstance();
            default:
                throw new IllegalArgumentException("CheckinsDetailAdapter 只包含签到和签退记录");
        }
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
