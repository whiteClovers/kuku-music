package com.xq.serviceadmin.entity;

/**
 * @program: kukuMusic
 * @description:
 * @author: Mr.Fu
 * @create: 2019-05-06 15:46
 **/
import java.io.Serializable;
import javax.persistence.*;

@Table(name = "music")
public class MusicVO implements Serializable {
    /**
     * 自增id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 网易云音乐id
     */
    @Column(name = "music_id")
    private String musicId;

    /**
     * 歌曲名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 歌手名称
     */
    @Column(name = "artist")
    private String artist;

    /**
     * 歌曲图片链接
     */
    @Column(name = "cover")
    private String cover;

    /**
     * 歌曲播放链接
     */
    @Column(name = "url")
    private String url;

    /**
     * 歌曲评论id
     */
    @Column(name = "comment_id")
    private String commentId;

    /**
     * 歌词
     */
    @Column(name = "lrc")
    private String lrc;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

