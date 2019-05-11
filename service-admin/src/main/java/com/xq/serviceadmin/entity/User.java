package com.xq.serviceadmin.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`user`")
public class User implements Serializable {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "JDBC")
    private Integer userId;

    /**
     * 用户名
     */
    @Column(name = "user_nickName")
    private String userNickname;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 邮箱
     */
    @Column(name = "emali")
    private String emali;

    /**
     * 出生日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "birth")
    private Date birth;

    /**
     * 性别
     */
    @Column(name = "gender")
    private String gender;

    /**
     * 地址
     */
    @Column(name = "addr")
    private String addr;

    /**
     * 自我描述
     */
    @Column(name = "`desc`")
    private String desc;

    /**
     * 收藏歌单
     */
    @Column(name = "coll_list")
    private String collList;

    /**
     * 我的歌单
     */
    @Column(name = "my_list")
    private String myList;

    /**
     * 头像
     */
    @Column(name = "pic")
    private String pic;

    /**
     * 注册时间
     */
    @Column(name = "reg_time")
    private Date regTime;

    private static final long serialVersionUID = 1L;

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
     * 获取用户名
     *
     * @return user_nickName - 用户名
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * 设置用户名
     *
     * @param userNickname 用户名
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取邮箱
     *
     * @return emali - 邮箱
     */
    public String getEmali() {
        return emali;
    }

    /**
     * 设置邮箱
     *
     * @param emali 邮箱
     */
    public void setEmali(String emali) {
        this.emali = emali;
    }

    /**
     * 获取出生日期
     *
     * @return birth - 出生日期
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 设置出生日期
     *
     * @param birth 出生日期
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取地址
     *
     * @return addr - 地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置地址
     *
     * @param addr 地址
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 获取自我描述
     *
     * @return desc - 自我描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置自我描述
     *
     * @param desc 自我描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取收藏歌单
     *
     * @return coll_list - 收藏歌单
     */
    public String getCollList() {
        return collList;
    }

    /**
     * 设置收藏歌单
     *
     * @param collList 收藏歌单
     */
    public void setCollList(String collList) {
        this.collList = collList;
    }

    /**
     * 获取我的歌单
     *
     * @return my_list - 我的歌单
     */
    public String getMyList() {
        return myList;
    }

    /**
     * 设置我的歌单
     *
     * @param myList 我的歌单
     */
    public void setMyList(String myList) {
        this.myList = myList;
    }

    /**
     * 获取头像
     *
     * @return pic - 头像
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置头像
     *
     * @param pic 头像
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 获取注册时间
     *
     * @return reg_time - 注册时间
     */
    public Date getRegTime() {
        return regTime;
    }

    /**
     * 设置注册时间
     *
     * @param regTime 注册时间
     */
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userNickname=").append(userNickname);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", realName=").append(realName);
        sb.append(", emali=").append(emali);
        sb.append(", birth=").append(birth);
        sb.append(", gender=").append(gender);
        sb.append(", addr=").append(addr);
        sb.append(", desc=").append(desc);
        sb.append(", collList=").append(collList);
        sb.append(", myList=").append(myList);
        sb.append(", pic=").append(pic);
        sb.append(", regTime=").append(regTime);
        sb.append("]");
        return sb.toString();
    }
}