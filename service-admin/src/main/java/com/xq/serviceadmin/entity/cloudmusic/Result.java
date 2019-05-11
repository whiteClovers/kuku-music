package com.xq.serviceadmin.entity.cloudmusic;



import java.util.List;


public class Result {

    private List<Songs> songs;
    private int songCount;

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }
}