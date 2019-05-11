package com.xq.serviceadmin.entity.dto;

/**
 * @description:
 * @create: 2019-05-10 15:15
 **/

public class AddMusicDTO {
    private Integer musicId;
    private Integer musicListId;

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public Integer getMusicListId() {
        return musicListId;
    }

    public void setMusicListId(Integer musicListId) {
        this.musicListId = musicListId;
    }
}