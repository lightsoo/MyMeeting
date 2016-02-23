package com.meetpeople.lightsoo.mymeeting.Data;

import java.io.Serializable;

/**
 * Created by LG on 2016-02-22.
 */
public class MoviesItems implements Serializable {

     String title;
     String director;
     int year;
     String synopsis;

    @Override
    public String toString() {
        return(title);
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
