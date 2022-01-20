package com.example.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.pojo.Search;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Search> mMovieList;
    private LayoutInflater mInflater;
    private Context mContext;

    public MovieAdapter(Context mContext) {
        this.mMovieList = mMovieList;
        this.mInflater = mInflater;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_movie, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Search movie = mMovieList.get(position);
        holder.nameDt.setText(movie.getTitle());
        holder.yearDt.setText(movie.getYear());
        Picasso.with(mContext)
                .load(movie.getPoster())
                .placeholder(R.color.colorAccent)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

            public ImageView imageView;
            public TextView nameDt, yearDt;
            public MovieViewHolder(View itemView)
            {
                super(itemView);
                nameDt = itemView.findViewById(R.id.namedt);
                yearDt = itemView.findViewById(R.id.yeardt);
                imageView = (ImageView) itemView.findViewById(R.id.imageView);
            }
        }
}
