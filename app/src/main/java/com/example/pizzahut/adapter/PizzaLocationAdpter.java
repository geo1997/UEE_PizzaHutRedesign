package com.example.pizzahut.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzahut.R;
import com.example.pizzahut.model.PizzaModel;

import java.util.ArrayList;
import java.util.List;

public class PizzaLocationAdpter extends RecyclerView.Adapter<PizzaLocationAdpter.MyViewHolder>{
    private List<String> moviesList;
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, year, genre;
        MyViewHolder(View view) {
            super(view);
//            title = view.findViewById(R.id.title);
//            genre = view.findViewById(R.id.genre);
//            year = view.findViewById(R.id.year);
        }
    }
    public PizzaLocationAdpter(List<String> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_single_widget_layout, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String movie = moviesList.get(position);
//        holder.title.setText(movie.getTitle());
//        holder.genre.setText(movie.getGenre());
//        holder.year.setText(movie.getYear());
    }
    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
