package com.baicimi.entity;

import android.widget.ImageView;

/**
 * Created by Administrator on 2017/8/28.
 * 个人中心首页底部GridView实体类
 */
public class UserCenterHomePageEntrySecond {
    private int imageUrl;
    private String lible;
    private String content;
    private String newMoney;
    private String oldMoney;

    public UserCenterHomePageEntrySecond(int imageUrl, String lible, String content) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.content = content;
    }


    public UserCenterHomePageEntrySecond(int imageUrl, String lible, String content, String newMoney, String oldMoney) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.content = content;
        this.newMoney = newMoney;
        this.oldMoney = oldMoney;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
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


    public String getNewMoney() {
        return newMoney;
    }

    public void setNewMoney(String newMoney) {
        this.newMoney = newMoney;
    }

    public String getOldMoney() {
        return oldMoney;
    }

    public void setOldMoney(String oldMoney) {
        this.oldMoney = oldMoney;
    }
}
