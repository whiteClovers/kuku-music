package com.xq.serviceadmin.entity.cloudmusic;




public class BMusic {
    private String name;
    private Long id;
    private Long size;
    private String extension;
    private int sr;
    private Long dfsId;
    private Long bitrate;
    private Long playTime;
    private Double volumeDelta;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
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

    public Long getDfsId() {
        return dfsId;
    }

    public void setDfsId(Long dfsId) {
        this.dfsId = dfsId;
    }

    public Long getBitrate() {
        return bitrate;
    }

    public void setBitrate(Long bitrate) {
        this.bitrate = bitrate;
    }

    public Long getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Long playTime) {
        this.playTime = playTime;
    }

    public Double getVolumeDelta() {
        return volumeDelta;
    }

    public void setVolumeDelta(Double volumeDelta) {
        this.volumeDelta = volumeDelta;
    }
}