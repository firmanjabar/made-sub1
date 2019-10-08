package com.firmanjabar.submission1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra("Move");
        String title = movie.getTitle();
        String desc = movie.getDescription();

        getSupportActionBar().setTitle(title);

        ImageView imgPoster = findViewById(R.id.img_poster);

        Glide.with(this)
                .load(movie.getPoster())
                .into(imgPoster);

        TextView nTitle = findViewById(R.id.txt_title);
        nTitle.setText(title);

        TextView tvDesc = findViewById(R.id.txt_description);
        tvDesc.setText(desc);

    }
}
