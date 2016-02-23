package com.meetpeople.lightsoo.mymeeting.CommonAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.meetpeople.lightsoo.mymeeting.CommonViewHolder.ChattingView;
import com.meetpeople.lightsoo.mymeeting.Data.Chatting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by LG on 2016-02-15.
 */

public class ChattingAdapter extends BaseAdapter implements ChattingView.OnImageClickListener{

    List<Chatting> items = new ArrayList<Chatting>();

    public ChattingAdapter() {
    }

    public void add(Chatting c) {
        items.add(c);
        notifyDataSetChanged();
    }

    public void addAll(List<Chatting> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void remove(Chatting c) {
        items.remove(c);
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void sort(Comparator<Chatting> comparator) {
        Collections.sort(items, comparator);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Chatting getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChattingView view;
        if (convertView == null) {
            view = new ChattingView(parent.getContext());
            view.setOnImageClickListener(this);
        } else {
            view = (ChattingView)convertView;
        }
        view.setChatting(items.get(position));
        return view;
    }

    public interface OnAdapterItemClickListener {
        public void onAdapterItemImageClick(ChattingAdapter adapter, ChattingView view, Chatting chatting, int position);
    }
    OnAdapterItemClickListener mAdapterListener;
    public void setOnAdapterItemClickListener(OnAdapterItemClickListener listener) {
        mAdapterListener = listener;
    }


    @Override
    public void onImageClick(ChattingView view, Chatting chatting) {
        if (mAdapterListener != null) {
            int index = items.indexOf(chatting);
            mAdapterListener.onAdapterItemImageClick(this, view, chatting, index);
        }
    }
}
