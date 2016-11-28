package com.example.administrator.school.mvp.other.message;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.bean.MessageBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by server on 2016/9/9.
 */
public class MessageViewHodler extends BaseViewHolder<MessageBean> {
    ImageView ivItemErvFragmentMessage;
    TextView tvTitleItemErvFragmentMessage;
    TextView tvDateItemErvFragmentMessage;

    public MessageViewHodler(ViewGroup parent) {
        super(parent, R.layout.item_erv_fragment_message);
        ivItemErvFragmentMessage=  $(R.id.iv_item_erv_fragment_message);
        tvTitleItemErvFragmentMessage=  $(R.id.tv_title_item_erv_fragment_message);
        tvDateItemErvFragmentMessage= $(R.id.tv_date_item_erv_fragment_message);
    }

    @Override
    public void setData(MessageBean messageBean) {
        super.setData(messageBean);

    }
}
