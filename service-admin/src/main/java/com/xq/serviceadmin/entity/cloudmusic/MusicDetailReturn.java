package com.xq.serviceadmin.entity.cloudmusic;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.List;


@JsonIgnoreProperties("equalizers")
public class MusicDetailReturn {
    private List<Songs> songs;
    private int code;

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}