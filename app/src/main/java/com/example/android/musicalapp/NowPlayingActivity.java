package com.example.android.musicalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NowPlayingActivity extends SongsActivity {

    TextView artistTextView;
    TextView songTextView;
    TextView nowPlayingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent intent = getIntent();

        songTextView = findViewById(R.id.song_nowPlaying);
        songTextView.setText(intent.getStringExtra(SongsActivity.EXTRA_SONG_NAME));

        artistTextView = findViewById(R.id.artist_nowPlaying);
        artistTextView.setText(intent.getStringExtra(SongsActivity.EXTRA_ARTIST_NAME));

        nowPlayingTextView = findViewById(R.id.nowPlaying_text_view);
        nowPlayingTextView.setText(getString(R.string.category_nowPlaying));
    }
}

