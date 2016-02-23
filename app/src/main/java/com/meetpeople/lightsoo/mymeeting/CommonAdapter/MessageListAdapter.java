package com.meetpeople.lightsoo.mymeeting.CommonAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.meetpeople.lightsoo.mymeeting.CommonViewHolder.ChattingView;
import com.meetpeople.lightsoo.mymeeting.CommonViewHolder.MessageListView;
import com.meetpeople.lightsoo.mymeeting.Data.MessageList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LG on 2016-02-18.
 */
public class MessageListAdapter extends BaseAdapter{

    List<MessageList> items = new ArrayList<MessageList>();

//    public MessageList(){
//
//    }

    public void add(MessageList m){
        items.add(m);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public MessageList getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MessageListView view;
        if (convertView == null) {
            view = new MessageListView(parent.getContext());
//            view.setOnImageClickListener(this);
        } else {
            view = (MessageListView)convertView;
        }
        view.setMessageList(items.get(position));
        return view;
    }

}
