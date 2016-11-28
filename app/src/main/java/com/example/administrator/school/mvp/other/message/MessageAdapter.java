package com.example.administrator.school.mvp.other.message;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.school.bean.MessageBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by server on 2016/9/9.
 */
public class MessageAdapter extends RecyclerArrayAdapter<MessageBean>{
    public MessageAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageViewHodler(parent);
    }
}
