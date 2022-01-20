package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.movieapp.pojo.Movieapp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressBar mProgressBar;

    private RecyclerView mRecyclerView;
    private MovieAdapter mAdapter;
    private static final String TAG = "tag";
    private final static String API_KEY = "77c8f531";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = findViewById(R.id.indeterminateBar);
        mProgressBar.setVisibility(View.INVISIBLE);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from ondbapi", Toast.LENGTH_LONG).show();
            return;
        }

        APIInterface apiService =
                ApiClient.getClient().create(APIInterface.class);

        Call<Movieapp> call = apiService.getTopMovies(API_KEY);
        call.enqueue(new Callback<Movieapp>() {
            @Override
            public void onResponse(Call<Movieapp>call, Response<Movieapp> response) {
                String movies = response.body().getTotalResults();
                mRecyclerView.setAdapter(new MovieAdapter(getApplicationContext()));
                Log.d(TAG, "Number of movies received: " + movies);
            }

            @Override
            public void onFailure(Call<Movieapp> call, Throwable t) {
                Log.e(TAG, t.toString());
            }


        });
    }


}