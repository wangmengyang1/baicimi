package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/18.
 * 个人中心  我的快递 listview布局填充
 */
public class MyExpressFragmentEntry {
    private int imageUrl;
    private String state;
    private String date;
    private String lible;
    private String expressage;//快递


    public MyExpressFragmentEntry(int imageUrl, String state, String date, String lible, String expressage) {
        this.imageUrl = imageUrl;
        this.state = state;
        this.date = date;
        this.lible = lible;
        this.expressage = expressage;
    }


    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public String getExpressage() {
        return expressage;
    }

    public void setExpressage(String expressage) {
        this.expressage = expressage;
    }
}
