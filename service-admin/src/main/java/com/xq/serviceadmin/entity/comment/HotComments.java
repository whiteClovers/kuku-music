package com.xq.serviceadmin.entity.comment;


import java.util.List;


public class HotComments {

    private CloudMusicUser user;
    private List<String> beReplied;
    private String pendantData;
    private String showFloorComment;
    private int status;
    private int commentLocationType;
    private int parentCommentId;
    private String decoration;
    private boolean repliedMark;
    private long commentId;
    private String expressionUrl;
    private boolean liked;
    private long time;
    private int likedCount;
    private String content;
    public void setUser(CloudMusicUser user) {
         this.user = user;
     }
     public CloudMusicUser getUser() {
         return user;
     }

    public void setBeReplied(List<String> beReplied) {
         this.beReplied = beReplied;
     }
     public List<String> getBeReplied() {
         return beReplied;
     }

    public void setPendantData(String pendantData) {
         this.pendantData = pendantData;
     }
     public String getPendantData() {
         return pendantData;
     }

    public void setShowFloorComment(String showFloorComment) {
         this.showFloorComment = showFloorComment;
     }
     public String getShowFloorComment() {
         return showFloorComment;
     }

    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

    public void setCommentLocationType(int commentLocationType) {
         this.commentLocationType = commentLocationType;
     }
     public int getCommentLocationType() {
         return commentLocationType;
     }

    public void setParentCommentId(int parentCommentId) {
         this.parentCommentId = parentCommentId;
     }
     public int getParentCommentId() {
         return parentCommentId;
     }

    public void setDecoration(String decoration) {
         this.decoration = decoration;
     }
     public String getDecoration() {
         return decoration;
     }

    public void setRepliedMark(boolean repliedMark) {
         this.repliedMark = repliedMark;
     }
     public boolean getRepliedMark() {
         return repliedMark;
     }

    public void setCommentId(long commentId) {
         this.commentId = commentId;
     }
     public long getCommentId() {
         return commentId;
     }

    public void setExpressionUrl(String expressionUrl) {
         this.expressionUrl = expressionUrl;
     }
     public String getExpressionUrl() {
         return expressionUrl;
     }

    public void setLiked(boolean liked) {
         this.liked = liked;
     }
     public boolean getLiked() {
         return liked;
     }

    public void setTime(long time) {
         this.time = time;
     }
     public long getTime() {
         return time;
     }

    public void setLikedCount(int likedCount) {
         this.likedCount = likedCount;
     }
     public int getLikedCount() {
         return likedCount;
     }

    public void setContent(String content) {
         this.content = content;
     }
     public String getContent() {
         return content;
     }

    public boolean isRepliedMark() {
        return repliedMark;
    }

    public boolean isLiked() {
        return liked;
    }
}