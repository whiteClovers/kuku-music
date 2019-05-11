package com.xq.serviceadmin.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "music")
public class Music implements Serializable {
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
    @GeneratedValue(generator = "JDBC")
    private Integer musicId;

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

    /**
     * 歌单id
     */
    @Column(name = "music_list_id")
    private Integer musicListId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取网易云音乐id
     *
     * @return music_id - 网易云音乐id
     */
    public Integer getMusicId() {
        return musicId;
    }

    /**
     * 设置网易云音乐id
     *
     * @param musicId 网易云音乐id
     */
    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    /**
     * 获取歌曲名称
     *
     * @return name - 歌曲名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置歌曲名称
     *
     * @param name 歌曲名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取歌手名称
     *
     * @return artist - 歌手名称
     */
    public String getArtist() {
        return artist;
    }

    /**
     * 设置歌手名称
     *
     * @param artist 歌手名称
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * 获取歌曲图片链接
     *
     * @return cover - 歌曲图片链接
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置歌曲图片链接
     *
     * @param cover 歌曲图片链接
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * 获取歌曲播放链接
     *
     * @return url - 歌曲播放链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置歌曲播放链接
     *
     * @param url 歌曲播放链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取歌曲评论id
     *
     * @return comment_id - 歌曲评论id
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     * 设置歌曲评论id
     *
     * @param commentId 歌曲评论id
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取歌词
     *
     * @return lrc - 歌词
     */
    public String getLrc() {
        return lrc;
    }

    /**
     * 设置歌词
     *
     * @param lrc 歌词
     */
    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取歌单id
     *
     * @return music_list_id - 歌单id
     */
    public Integer getMusicListId() {
        return musicListId;
    }

    /**
     * 设置歌单id
     *
     * @param musicListId 歌单id
     */
    public void setMusicListId(Integer musicListId) {
        this.musicListId = musicListId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", musicId=").append(musicId);
        sb.append(", name=").append(name);
        sb.append(", artist=").append(artist);
        sb.append(", cover=").append(cover);
        sb.append(", url=").append(url);
        sb.append(", commentId=").append(commentId);
        sb.append(", lrc=").append(lrc);
        sb.append(", userId=").append(userId);
        sb.append(", musicListId=").append(musicListId);
        sb.append("]");
        return sb.toString();
    }
}