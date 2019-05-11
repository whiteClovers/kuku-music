package com.xq.serviceadmin.entity.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.List;


@JsonIgnoreProperties({"isMusician", "userId", "topComments", "moreHot", "hotComments", "more"})
public class CommentReturn {

    private boolean isMusician;
    private int userId;
    private List<String> topComments;
    private boolean moreHot;
    private List<HotComments> hotComments;
    private int code;
    private List<Comments> comments;
    private int total;
    private boolean more;

    public boolean isMusician() {
        return isMusician;
    }

    public void setMusician(boolean musician) {
        isMusician = musician;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getTopComments() {
        return topComments;
    }

    public void setTopComments(List<String> topComments) {
        this.topComments = topComments;
    }

    public boolean isMoreHot() {
        return moreHot;
    }

    public void setMoreHot(boolean moreHot) {
        this.moreHot = moreHot;
    }

    public List<HotComments> getHotComments() {
        return hotComments;
    }

    public void setHotComments(List<HotComments> hotComments) {
        this.hotComments = hotComments;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }
}