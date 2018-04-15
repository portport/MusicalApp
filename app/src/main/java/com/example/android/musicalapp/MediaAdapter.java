package com.example.android.musicalapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MediaAdapter extends ArrayAdapter<Media> {

    public MediaAdapter(Activity context, ArrayList<Media> media) {
        super(context, 0, media);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Media currentMedia = getItem(position);

        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        artistTextView.setText(currentMedia.getArtistName());

        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_text_view);
        songTextView.setText(currentMedia.getSongName());

        return listItemView;
    }
}
