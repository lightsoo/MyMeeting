package com.meetpeople.lightsoo.mymeeting.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.meetpeople.lightsoo.mymeeting.CommonAdapter.MovieAdapter;
import com.meetpeople.lightsoo.mymeeting.Data.Movies;
import com.meetpeople.lightsoo.mymeeting.Data.MoviesItems;
import com.meetpeople.lightsoo.mymeeting.Manager.NetworkManager;
import com.meetpeople.lightsoo.mymeeting.R;
import com.meetpeople.lightsoo.mymeeting.RestAPI.MoviesAPI;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MovieActivity extends AppCompatActivity {

    private EditText title, director, synopsis,year;
    Movies movies;
    private TextView tx_title, tx_director, tx_symopsis, tx_year;
    ListView lv_movie;

    private MovieAdapter movieAdapter;
    List<MoviesItems> moviesItemses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();

        Button btn_post = (Button)findViewById(R.id.btn_post);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!preInspection()){
                    Toast.makeText(MovieActivity.this, "빈칸있다!", Toast.LENGTH_SHORT).show();
                }else{
                    Call call = NetworkManager.getInstance()
                            .getAPI(MoviesAPI.class)
//                            .post_movies(title.getText().toString(),
//                            director.getText().toString(),
//                            Integer.parseInt(year.getText().toString()),
//                            synopsis.getText().toString());
                                .post_movies(movies);
                   call.enqueue(new Callback() {
                       @Override
                       public void onResponse(Response response, Retrofit retrofit) {
                           if(response.isSuccess()){
                               Toast.makeText(MovieActivity.this, "영화 입력 성공인경우code(200~300)",
                                       Toast.LENGTH_SHORT).show();
                           }else {
                               Toast.makeText(MovieActivity.this, "영화 입력 실패는 아니도 다른 코드..",
                                       Toast.LENGTH_SHORT).show();
                           }
                       }
                       @Override
                       public void onFailure(Throwable t) {
                           Log.d("network",t.toString());
                           Toast.makeText(MovieActivity.this, t.toString(),
                                   Toast.LENGTH_SHORT).show();
                       }
                   });
                }
            }
        });

        Button btn_get = (Button)findViewById(R.id.btn_get);
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMovies();
            }
        });

    }

    public void init(){
        title = (EditText)findViewById(R.id.movie_title);
        director = (EditText)findViewById(R.id.movie_director);
        synopsis = (EditText)findViewById(R.id.movie_synopsis);
        year = (EditText)findViewById(R.id.movie_year);
        //한개의 객체일경우
        tx_title = (TextView)findViewById(R.id.tx_title);
        tx_director = (TextView)findViewById(R.id.tx_director);
        tx_symopsis= (TextView)findViewById(R.id.tx_synopsis);
        tx_year = (TextView)findViewById(R.id.tx_year);

        lv_movie = (ListView)findViewById(R.id.lv_movies);

    }

    //입력이 되었는지 확인
    public boolean preInspection(){
        if(TextUtils.isEmpty(title.getText().toString())
                || TextUtils.isEmpty(director.getText().toString())
                || TextUtils.isEmpty(synopsis.getText().toString())
                || TextUtils.isEmpty(year.getText().toString())) {
            return false;
        } else {
            //movies객체를 만들어서 restAPI에서 BODY로 받아주려고하는거야
            movies = new Movies(title.getText().toString(), director.getText().toString(),
                    Integer.parseInt(year.getText().toString()),
                    synopsis.getText().toString() );
            return true;
        }
    }


    public void getMovies(){

//        moviesItemses = new ArrayList<MoviesItems>();
        Call<List<Movies>> call = NetworkManager.getInstance()
                .getAPI(MoviesAPI.class)
                .get_movies();
        call.enqueue(new Callback<List<Movies>>() {
            @Override
            public void onResponse(Response<List<Movies>> response, Retrofit retrofit) {
                if(response.isSuccess()){

                    List<Movies> result = response.body();

//                    Movies result = response.body();
                    Log.d("please", "response = " + new Gson().toJson(result));
//                    result.;

                    movieAdapter = new MovieAdapter();
                    movieAdapter.addAll(result);
//                    movieAdapter = result.getItems();

//                    movieemses = result.getItems();
//                    Log.d("please", "items = " + moviesItemses.size());

                    lv_movie.setAdapter(movieAdapter);

//                    Movies movies = (Movies)response.body();
//                        movieAdapter.addAll(response.body().items);
//                    for(MoviesItems item : response.body().items){
//
//                        movieAdapter.add(item);
//                    }

//                    for(MoviesItems item : response.body().items){
//                        Log.d("items : ", item.toString());
//                        movieAdapter.add(item);
//                    }


                    //한개의 객체일경우
//                    tx_title.setText(movies.title.toString());
//                    tx_director.setText(movies.director.toString());
//                    tx_year.setText(movies.year+"");
//                    tx_symopsis.setText(movies.synopsis.toString());
                }else{

                }
            }
            @Override
            public void onFailure(Throwable t) {
                Log.d("network : ", t.toString());
                Toast.makeText(MovieActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
