package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/7.
 * 运动页面 首页 健康管理 listview实体类
 */
public class FootPaintHealthManagerEntry {
    private int imageUrl;
    private String lible;
    private String date;
    private String content;


    public FootPaintHealthManagerEntry(int imageUrl, String lible, String date, String content) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.date = date;
        this.content = content;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
