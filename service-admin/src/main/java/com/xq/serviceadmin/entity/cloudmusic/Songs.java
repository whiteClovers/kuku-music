package com.xq.serviceadmin.entity.cloudmusic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.List;


@JsonIgnoreProperties({"alias", "hMusic", "mMusic", "lMusic", "bMusic", "disc", "hearTime", "ringtone", "transName", "sign"})
public class Songs {
    private String name;
    private long id;
    private int position;
    private List<String> alias;
    private int status;
    private int fee;
    private int copyrightId;
    private String disc;
    private int no;
    private List<Artists> artists;
    private Album album;
    private boolean starred;
    private int popularity;
    private int score;
    private int starredNum;
    private long duration;
    private int playedNum;
    private int dayPlays;
    private int hearTime;
    private String ringtone;
    private String crbt;
    private String audition;
    private String copyFrom;
    private String commentThreadId;
    private String rtUrl;
    private int ftype;
    private List<String> rtUrls;
    private int copyright;
    private int rtype;
    private String rurl;
    private String mp3Url;
    private int mvid;
    private String transName;
    private String sign;

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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<String> getAlias() {
        return alias;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getCopyrightId() {
        return copyrightId;
    }

    public void setCopyrightId(int copyrightId) {
        this.copyrightId = copyrightId;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public List<Artists> getArtists() {
        return artists;
    }

    public void setArtists(List<Artists> artists) {
        this.artists = artists;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStarredNum() {
        return starredNum;
    }

    public void setStarredNum(int starredNum) {
        this.starredNum = starredNum;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getPlayedNum() {
        return playedNum;
    }

    public void setPlayedNum(int playedNum) {
        this.playedNum = playedNum;
    }

    public int getDayPlays() {
        return dayPlays;
    }

    public void setDayPlays(int dayPlays) {
        this.dayPlays = dayPlays;
    }

    public int getHearTime() {
        return hearTime;
    }

    public void setHearTime(int hearTime) {
        this.hearTime = hearTime;
    }

    public String getRingtone() {
        return ringtone;
    }

    public void setRingtone(String ringtone) {
        this.ringtone = ringtone;
    }

    public String getCrbt() {
        return crbt;
    }

    public void setCrbt(String crbt) {
        this.crbt = crbt;
    }

    public String getAudition() {
        return audition;
    }

    public void setAudition(String audition) {
        this.audition = audition;
    }

    public String getCopyFrom() {
        return copyFrom;
    }

    public void setCopyFrom(String copyFrom) {
        this.copyFrom = copyFrom;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public String getRtUrl() {
        return rtUrl;
    }

    public void setRtUrl(String rtUrl) {
        this.rtUrl = rtUrl;
    }

    public int getFtype() {
        return ftype;
    }

    public void setFtype(int ftype) {
        this.ftype = ftype;
    }

    public List<String> getRtUrls() {
        return rtUrls;
    }

    public void setRtUrls(List<String> rtUrls) {
        this.rtUrls = rtUrls;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    public int getRtype() {
        return rtype;
    }

    public void setRtype(int rtype) {
        this.rtype = rtype;
    }

    public String getRurl() {
        return rurl;
    }

    public void setRurl(String rurl) {
        this.rurl = rurl;
    }

    public String getMp3Url() {
        return mp3Url;
    }

    public void setMp3Url(String mp3Url) {
        this.mp3Url = mp3Url;
    }

    public int getMvid() {
        return mvid;
    }

    public void setMvid(int mvid) {
        this.mvid = mvid;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", position=" + position +
                ", alias=" + alias +
                ", status=" + status +
                ", fee=" + fee +
                ", copyrightId=" + copyrightId +
                ", disc='" + disc + '\'' +
                ", no=" + no +
                ", artists=" + artists +
                ", album=" + album +
                ", starred=" + starred +
                ", popularity=" + popularity +
                ", score=" + score +
                ", starredNum=" + starredNum +
                ", duration=" + duration +
                ", playedNum=" + playedNum +
                ", dayPlays=" + dayPlays +
                ", hearTime=" + hearTime +
                ", ringtone='" + ringtone + '\'' +
                ", crbt='" + crbt + '\'' +
                ", audition='" + audition + '\'' +
                ", copyFrom='" + copyFrom + '\'' +
                ", commentThreadId='" + commentThreadId + '\'' +
                ", rtUrl='" + rtUrl + '\'' +
                ", ftype=" + ftype +
                ", rtUrls=" + rtUrls +
                ", copyright=" + copyright +
                ", rtype=" + rtype +
                ", rurl='" + rurl + '\'' +
                ", mp3Url='" + mp3Url + '\'' +
                ", mvid=" + mvid +
                ", transName='" + transName + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}