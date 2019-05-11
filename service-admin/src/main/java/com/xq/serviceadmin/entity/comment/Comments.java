package com.xq.serviceadmin.entity.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;


@JsonIgnoreProperties({"isRemoveHotComment","beReplied","pendantData","showFloorComment","commentLocationType","decoration","repliedMark","expressionUrl"})
public class Comments {
    @JsonProperty("user")
    private CloudMusicUser cloudMusicUser;
    private List<String> beReplied;
    private String pendantData;
    private String showFloorComment;
    private int status;
    private int commentLocationType;
    private int parentCommentId;
    private Decoration decoration;
    private boolean repliedMark;
    private long commentId;
    private String expressionUrl;
    private boolean liked;
    private long time;
    private int likedCount;
    private String content;
    private boolean isRemoveHotComment;

    public CloudMusicUser getCloudMusicUser() {
        return cloudMusicUser;
    }

    public void setCloudMusicUser(CloudMusicUser cloudMusicUser) {
        this.cloudMusicUser = cloudMusicUser;
    }

    public List<String> getBeReplied() {
        return beReplied;
    }

    public void setBeReplied(List<String> beReplied) {
        this.beReplied = beReplied;
    }

    public String getPendantData() {
        return pendantData;
    }

    public void setPendantData(String pendantData) {
        this.pendantData = pendantData;
    }

    public String getShowFloorComment() {
        return showFloorComment;
    }

    public void setShowFloorComment(String showFloorComment) {
        this.showFloorComment = showFloorComment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCommentLocationType() {
        return commentLocationType;
    }

    public void setCommentLocationType(int commentLocationType) {
        this.commentLocationType = commentLocationType;
    }

    public int getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(int parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public Decoration getDecoration() {
        return decoration;
    }

    public void setDecoration(Decoration decoration) {
        this.decoration = decoration;
    }

    public boolean isRepliedMark() {
        return repliedMark;
    }

    public void setRepliedMark(boolean repliedMark) {
        this.repliedMark = repliedMark;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getExpressionUrl() {
        return expressionUrl;
    }

    public void setExpressionUrl(String expressionUrl) {
        this.expressionUrl = expressionUrl;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(int likedCount) {
        this.likedCount = likedCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRemoveHotComment() {
        return isRemoveHotComment;
    }

    public void setRemoveHotComment(boolean removeHotComment) {
        isRemoveHotComment = removeHotComment;
    }
}