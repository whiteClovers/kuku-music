package com.xq.serviceadmin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`comment`")
public class Comment implements Serializable {
    /**
     * 评论id
     */
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(generator = "JDBC")
    private Integer commentId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "music_id")
    private Integer musicId;

    /**
     * 评论描述
     */
    @Column(name = "commnet_desc")
    private String commnetDesc;

    /**
     * 评论时间
     */
    @Column(name = "comment_time")
    private Date commentTime;

    /**
     * 评论点赞数
     */
    @Column(name = "comment_agree_num")
    private String commentAgreeNum;

    private static final long serialVersionUID = 1L;

    /**
     * 获取评论id
     *
     * @return comment_id - 评论id
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * 设置评论id
     *
     * @param commentId 评论id
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return music_id
     */
    public Integer getMusicId() {
        return musicId;
    }

    /**
     * @param musicId
     */
    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    /**
     * 获取评论描述
     *
     * @return commnet_desc - 评论描述
     */
    public String getCommnetDesc() {
        return commnetDesc;
    }

    /**
     * 设置评论描述
     *
     * @param commnetDesc 评论描述
     */
    public void setCommnetDesc(String commnetDesc) {
        this.commnetDesc = commnetDesc;
    }

    /**
     * 获取评论时间
     *
     * @return comment_time - 评论时间
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * 设置评论时间
     *
     * @param commentTime 评论时间
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * 获取评论点赞数
     *
     * @return comment_agree_num - 评论点赞数
     */
    public String getCommentAgreeNum() {
        return commentAgreeNum;
    }

    /**
     * 设置评论点赞数
     *
     * @param commentAgreeNum 评论点赞数
     */
    public void setCommentAgreeNum(String commentAgreeNum) {
        this.commentAgreeNum = commentAgreeNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commentId=").append(commentId);
        sb.append(", userId=").append(userId);
        sb.append(", musicId=").append(musicId);
        sb.append(", commnetDesc=").append(commnetDesc);
        sb.append(", commentTime=").append(commentTime);
        sb.append(", commentAgreeNum=").append(commentAgreeNum);
        sb.append("]");
        return sb.toString();
    }
}