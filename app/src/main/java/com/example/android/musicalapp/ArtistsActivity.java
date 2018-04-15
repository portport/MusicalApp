package com.example.android.musicalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ArtistsActivity extends AppCompatActivity {

    public static final String EXTRA_SONG_NAME = "com.example.android.musicalapp.EXTRA_SONG_NAME";
    public static final String EXTRA_ARTIST_NAME = "com.example.android.musicalapp.EXTRA_ARTIST_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        ArrayList<Media> artists = new ArrayList<Media>();
        artists.add(new Media("Lana Del Rey", "3 songs, 14 min"));
        artists.add(new Media("The Killers", "14 songs, 58 min"));
        artists.add(new Media("Rolling Stones", "36 songs, 2 h 10 min"));
        artists.add(new Media("U2", "11 songs, 54 min"));
        artists.add(new Media("Ed Sheeran", "5 songs, 23 min"));
        artists.add(new Media("M.I.A.", "7 songs, 32 min"));

        MediaAdapter adapter = new MediaAdapter(this, artists);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Media currentMedia = (Media) adapter.getItemAtPosition(position);
                Toast.makeText(ArtistsActivity.this, "Now Playing " + currentMedia.getSongName(), Toast.LENGTH_SHORT).show();
                Intent playIntent = new Intent(ArtistsActivity.this, NowPlayingActivity.class);
                playIntent.putExtra(EXTRA_SONG_NAME, currentMedia.getSongName());
                playIntent.putExtra(EXTRA_ARTIST_NAME, currentMedia.getArtistName());
                startActivity(playIntent);
            }
        });
    }
}
