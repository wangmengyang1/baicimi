package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/18.
 * 个人中心首页fragment 购物所得 listview实体类
 */
public class UserIntegralSignInShoppingEntry {
    private String date;
    private String state;
    private int imageUrl;
    private String lible;
    private String category;

    public UserIntegralSignInShoppingEntry(String date, String state, int imageUrl, String lible, String category) {
        this.date = date;
        this.state = state;
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.category = category;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
