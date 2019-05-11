package com.xq.serviceadmin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "music_list")
public class MusicList implements Serializable {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "list_id")
    @GeneratedValue(generator = "JDBC")
    private Integer listId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 歌单名
     */
    @Column(name = "list_name")
    private String listName;

    /**
     * 歌单图片
     */
    @Column(name = "list_pic")
    private String listPic;

    /**
     * 创建时间
     */
    @Column(name = "crea_time")
    private Date creaTime;

    /**
     * 标签（收藏还是创建）
     */
    @Column(name = "`label`")
    private String label;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户ID
     *
     * @return list_id - 用户ID
     */
    public Integer getListId() {
        return listId;
    }

    /**
     * 设置用户ID
     *
     * @param listId 用户ID
     */
    public void setListId(Integer listId) {
        this.listId = listId;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取歌单名
     *
     * @return list_name - 歌单名
     */
    public String getListName() {
        return listName;
    }

    /**
     * 设置歌单名
     *
     * @param listName 歌单名
     */
    public void setListName(String listName) {
        this.listName = listName;
    }

    /**
     * 获取歌单图片
     *
     * @return list_pic - 歌单图片
     */
    public String getListPic() {
        return listPic;
    }

    /**
     * 设置歌单图片
     *
     * @param listPic 歌单图片
     */
    public void setListPic(String listPic) {
        this.listPic = listPic;
    }

    /**
     * 获取创建时间
     *
     * @return crea_time - 创建时间
     */
    public Date getCreaTime() {
        return creaTime;
    }

    /**
     * 设置创建时间
     *
     * @param creaTime 创建时间
     */
    public void setCreaTime(Date creaTime) {
        this.creaTime = creaTime;
    }

    /**
     * 获取标签（收藏还是创建）
     *
     * @return label - 标签（收藏还是创建）
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置标签（收藏还是创建）
     *
     * @param label 标签（收藏还是创建）
     */
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", listId=").append(listId);
        sb.append(", userId=").append(userId);
        sb.append(", listName=").append(listName);
        sb.append(", listPic=").append(listPic);
        sb.append(", creaTime=").append(creaTime);
        sb.append(", label=").append(label);
        sb.append("]");
        return sb.toString();
    }
}