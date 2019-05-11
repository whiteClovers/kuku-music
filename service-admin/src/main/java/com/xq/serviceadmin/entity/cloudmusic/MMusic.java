package com.xq.serviceadmin.entity.cloudmusic;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class MMusic {
    private String name;
    private long id;
    private long size;
    private String extension;
    private int sr;
    private long dfsId;
    private long bitrate;
    private long playTime;
    @JsonIgnore
    private String volumeDelta;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSr() {
        return sr;
    }

    public void setSr(int sr) {
        this.sr = sr;
    }

    public long getDfsId() {
        return dfsId;
    }

    public void setDfsId(long dfsId) {
        this.dfsId = dfsId;
    }

    public long getBitrate() {
        return bitrate;
    }

    public void setBitrate(long bitrate) {
        this.bitrate = bitrate;
    }

    public long getPlayTime() {
        return playTime;
    }

    public void setPlayTime(long playTime) {
        this.playTime = playTime;
    }

    public String getVolumeDelta() {
        return volumeDelta;
    }

    public void setVolumeDelta(String volumeDelta) {
        this.volumeDelta = volumeDelta;
    }
}