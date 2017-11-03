package com.baicimi.entity;

/**
 * Created by Administrator on 2017/11/2.
 * 个人中心  消息  消息中心 实体类
 */
public class UserCenterMessageCenterEntry {
    private int imageUrl;
    private String name;
    private String lible;
    private String content;
    private String date;
    private boolean isCheckd;

    public UserCenterMessageCenterEntry(int imageUrl, String name, String lible, String content, String date, boolean isCheckd) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.lible = lible;
        this.content = content;
        this.date = date;
        this.isCheckd = isCheckd;
    }


    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isCheckd() {
        return isCheckd;
    }

    public void setCheckd(boolean checkd) {
        isCheckd = checkd;
    }
}
