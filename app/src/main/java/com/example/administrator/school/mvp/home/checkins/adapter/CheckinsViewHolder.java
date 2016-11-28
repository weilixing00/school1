package com.example.administrator.school.mvp.home.checkins.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.bean.CheckinsBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by server on 2016/9/8.
 */

public class CheckinsViewHolder extends BaseViewHolder<CheckinsBean> {


    private TextView techer;
    private TextView date;
    private TextView time;
    private TextView school;
    private TextView address;
    private ImageView ivSignin;
    private ImageView ivSignout;


    public CheckinsViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_erv_fragment_checkins);

        techer = $(R.id.tv_host_tecther_item_erv_fragment_checkins);
        date = $(R.id.tv_date_item_erv_fragment_checkins);
        time = $(R.id.tv_time_item_erv_fragment_checkins);
        school = $(R.id.tv_school_item_erv_fragment_checkins);
        address = $(R.id.tv_address_item_erv_fragment_checkins);
        ivSignin = $(R.id.iv_signin_item_erv_fragment_checkins);
        ivSignout = $(R.id.iv_signout_item_erv_fragment_checkins);
    }

    @Override
    public void setData(final CheckinsBean checkinsBean) {


//        mTv_name.setText(person.getName());
////        mTv_sign.setText(person.getSign());
//        Glide.with(getContext())
//                .load(person.getFace())
//                .placeholder(R.drawable.default_image)
//                .bitmapTransform(new CropCircleTransformation(getContext()))
//                .into(mImg_face);
    }
}