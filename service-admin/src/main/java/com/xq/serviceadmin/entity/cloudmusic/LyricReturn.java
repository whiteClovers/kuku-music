package com.xq.serviceadmin.entity.cloudmusic;



/**
 * @description: 歌词返回类
 * @author: mirrorming
 * @create: 2019-04-27 11:46
 **/

public class LyricReturn {
    private int songStatus;
    private int lyricVersion;
    private String lyric;
    private int code;

    public int getSongStatus() {
        return songStatus;
    }

    public void setSongStatus(int songStatus) {
        this.songStatus = songStatus;
    }

    public int getLyricVersion() {
        return lyricVersion;
    }

    public void setLyricVersion(int lyricVersion) {
        this.lyricVersion = lyricVersion;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}