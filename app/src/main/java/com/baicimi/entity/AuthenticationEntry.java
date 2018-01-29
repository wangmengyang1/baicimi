package com.baicimi.entity;

/**
 * Created by Administrator on 2017/8/21.
 * 账号认证实体类
 */
public class AuthenticationEntry {
    private int imageUrl;
    private String lible;

    public AuthenticationEntry(int imageUrl, String lible) {
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
