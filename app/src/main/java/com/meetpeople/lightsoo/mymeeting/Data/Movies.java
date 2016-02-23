package com.meetpeople.lightsoo.mymeeting.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LG on 2016-02-19.
 */
public class Movies implements Serializable {

    String title,director, synopsis;
    int year;

    public Movies(){

    }


//    public List<MoviesItems> items;
//
//    public List<MoviesItems> getItems(){
//        return items;
//    }


//    public String title;
//    public String director;
//    public int year;
//    public String synopsis;
//

    public Movies(String title, String director, int year){
        this.title = title;
        this.director = director;
        this.year = year;
    }
    public Movies(String title, String director, int year, String synopsis ){
        this.title = title;
        this.director = director;
        this.year = year;
        this.synopsis = synopsis;
    }



    //setter
    public void setTitle(String title){
        this.title = title;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }
    //getter
    public String getTitle(){
        return title;
    }
    public String getDirector(){
        return director;
    }
    public int getYear(){
        return year;
    }

    public String getSynopsis(){
        return synopsis;
    }


}
