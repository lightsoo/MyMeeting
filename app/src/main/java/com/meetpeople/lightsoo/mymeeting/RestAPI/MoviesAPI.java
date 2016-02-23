package com.meetpeople.lightsoo.mymeeting.RestAPI;

import com.meetpeople.lightsoo.mymeeting.Data.Movies;
import com.meetpeople.lightsoo.mymeeting.Data.MoviesItems;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Multipart;
import retrofit.http.POST;

public interface MoviesAPI {

    @POST("movies")
    Call<Movies> post_movies(@Body Movies movies);

//    @FormUrlEncoded
//    @POST("movies")
//    Call<Movies> post_movies(@Field("title") String title,
//                        @Field("director") String director,
//                        @Field("year")int year,
//                        @Field("synopsis")String synopsis);

//    @GET("movies")
//    Call<MoviesItems> get_movies();

//    @GET("movies")
//    Call<Movies> get_movies();

    @GET("movies")
    Call<List<Movies>> get_movies();


}
