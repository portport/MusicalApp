package com.example.android.musicalapp;

public class Media {

    private String mSongName;
    private String mArtistName;

    public Media(String songName, String artistName) {
        mSongName = songName;
        mArtistName = artistName;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }
}
