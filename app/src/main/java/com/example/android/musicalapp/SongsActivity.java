package com.example.android.musicalapp;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    public static final String EXTRA_SONG_NAME = "com.example.android.musicalapp.EXTRA_SONG_NAME";
    public static final String EXTRA_ARTIST_NAME = "com.example.android.musicalapp.EXTRA_ARTIST_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        ArrayList<Media> songs = new ArrayList<Media>();
        songs.add(new Media("Every Other Freckle", "alt-J"));
        songs.add(new Media("Beautiful Hell", "Adna"));
        songs.add(new Media("Yellow Flicker Beat", "Lorde"));
        songs.add(new Media("Young And Beautiful", "Lana Del Rey"));
        songs.add(new Media("Take Me To Church", "Hozier"));
        songs.add(new Media("I Of The Storm", "Of Monsters ans Men"));
        songs.add(new Media("Run", "Wyvern Lingo"));
        songs.add(new Media("Volcano", "Damien Rice"));
        songs.add(new Media("What Kind Of Man", "Florence + The Machine"));
        songs.add(new Media("Sleep Baby Sleep", "Broods"));

        MediaAdapter adapter = new MediaAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Media currentMedia = (Media) adapter.getItemAtPosition(position);
                Toast.makeText(SongsActivity.this, "Now Playing " + currentMedia.getSongName() + " by " + currentMedia.getArtistName(), Toast.LENGTH_SHORT).show();
                Intent playIntent = new Intent(SongsActivity.this, NowPlayingActivity.class);
                playIntent.putExtra(EXTRA_SONG_NAME, currentMedia.getSongName());
                playIntent.putExtra(EXTRA_ARTIST_NAME, currentMedia.getArtistName());
                startActivity(playIntent);
            }
        });
    }
}



