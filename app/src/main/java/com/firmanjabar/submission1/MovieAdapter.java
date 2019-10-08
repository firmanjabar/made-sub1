package com.firmanjabar.submission1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    private ArrayList<Movie> movies;

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    private Context context;


    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        ImageView imgPoster = view.findViewById(R.id.img_poster);
        viewHolder.bind(movie);
        Glide
                .with(view)
                .load(movie.getPoster())
                .into(imgPoster);
        return view;
    }

    private class ViewHolder {
        private TextView txtTitle;
        private TextView txtDescription;
        private ImageView imgPoster;
        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.txt_title);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPoster = view.findViewById(R.id.img_poster);
        }
        void bind(Movie movie) {
            txtTitle.setText(movie.getTitle());;
            txtDescription.setText(movie.getDescription());
            imgPoster.setImageResource(movie.getPoster());
        }
    }
}
