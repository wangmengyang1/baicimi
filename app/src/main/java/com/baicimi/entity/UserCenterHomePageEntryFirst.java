package com.baicimi.entity;

/**
 * Created by Administrator on 2017/8/28.
 * 个人中心首页GridView实体类
 */
public class UserCenterHomePageEntryFirst {
    private int imageUrl;
    private String lible;

    public UserCenterHomePageEntryFirst(int imageUrl, String lible) {
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
