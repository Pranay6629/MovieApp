package com.example.movieapp;

import com.example.movieapp.pojo.Movieapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("movie/search")

    Call<Movieapp> getTopMovies(@Query("api_key") String apiKey);

}
