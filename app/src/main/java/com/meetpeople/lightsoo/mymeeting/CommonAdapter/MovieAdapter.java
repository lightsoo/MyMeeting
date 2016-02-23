package com.meetpeople.lightsoo.mymeeting.CommonAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.meetpeople.lightsoo.mymeeting.CommonViewHolder.MoviesView;

import com.meetpeople.lightsoo.mymeeting.Data.Movies;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends BaseAdapter {

    List<Movies> items = new ArrayList<Movies>();

    public void add(Movies m) {
        items.add(m);
        notifyDataSetChanged();
    }

    public void addAll(List<Movies> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }


//    List<MoviesItems> items = new ArrayList<MoviesItems>();
//
//    public void add(MoviesItems item){
//        items.add(item);
//        notifyDataSetChanged();
//    }
//
//    public void addAll(List<MoviesItems> items) {
//        this.items.addAll(items);
//        notifyDataSetChanged();
//    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Movies getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MoviesView view;
        if(convertView ==null){
            view = new MoviesView(parent.getContext());
        }else{
            view = (MoviesView)convertView;
        }
        view.setMovies(items.get(position));
        return view;
    }
}
