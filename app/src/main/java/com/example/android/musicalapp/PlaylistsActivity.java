package com.example.android.musicalapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaylistsActivity extends AppCompatActivity {

    public static final String EXTRA_SONG_NAME = "com.example.android.musicalapp.EXTRA_SONG_NAME";
    public static final String EXTRA_ARTIST_NAME = "com.example.android.musicalapp.EXTRA_ARTIST_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        ArrayList<Media> playlists = new ArrayList<Media>();
        playlists.add(new Media("Relax", "1 h 20 min"));
        playlists.add(new Media("City commute", "58 min"));
        playlists.add(new Media("Dinner with friends", "2 h 10 min"));
        playlists.add(new Media("Study", "2 h 34 min"));

        MediaAdapter adapter = new MediaAdapter(this, playlists);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Media currentMedia = (Media) adapter.getItemAtPosition(position);
                Toast.makeText(PlaylistsActivity.this, "Now Playing: " + currentMedia.getSongName(), Toast.LENGTH_SHORT).show();
                Intent playIntent = new Intent(PlaylistsActivity.this, NowPlayingActivity.class);
                playIntent.putExtra(EXTRA_SONG_NAME, currentMedia.getSongName());
                playIntent.putExtra(EXTRA_ARTIST_NAME, currentMedia.getArtistName());
                startActivity(playIntent);
            }
        });
    }
}
