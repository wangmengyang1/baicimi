package com.baicimi.entity;

/**
 * Created by Administrator on 2017/11/21.
 * 个人中心，帮助中心首页 点此咨询提问跳转页面 gridview实体类
 */
public class UserCenterHelpCenterConsultEntry {
    private int imageUrl;
    private String lible;

    public UserCenterHelpCenterConsultEntry(int imageUrl, String lible) {
        this.imageUrl = imageUrl;
        this.lible = lible;
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
}
