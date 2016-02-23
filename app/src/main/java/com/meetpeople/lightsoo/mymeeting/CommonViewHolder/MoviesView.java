package com.meetpeople.lightsoo.mymeeting.CommonViewHolder;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.meetpeople.lightsoo.mymeeting.Data.Movies;
import com.meetpeople.lightsoo.mymeeting.Data.MoviesItems;
import com.meetpeople.lightsoo.mymeeting.R;

/**
 * Created by LG on 2016-02-22.
 */
public class MoviesView extends FrameLayout{

    private TextView title, director, symopsis, year;
    /*MoviesItems movies;*/
    Movies movies;

    public MoviesView(Context context) {
        super(context);
        init();
    }

    public void init(){
        inflate(getContext(), R.layout.view_movie,this);
        title = (TextView)findViewById(R.id.movie_title);
        director = (TextView)findViewById(R.id.movie_director);
        symopsis= (TextView)findViewById(R.id.movie_synopsis);
        year = (TextView)findViewById(R.id.movie_year);
    }

    public void setMovies(Movies movies){
        this.movies = movies;

        title.setText(movies.getTitle());
        director.setText(movies.getDirector());
        year.setText(""+movies.getYear());
        symopsis.setText(movies.getSynopsis());

    }

/*
    public void setMovies(MoviesItems movies){
        this.movies = movies;

        title.setText(movies.getTitle());
        director.setText(movies.getDirector());
        year.setText(movies.getYear());
        symopsis.setText(movies.getSynopsis());

    }
    */
}
