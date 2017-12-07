package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/7.
 * 运动页面 首页 赛事活动 listview实体类
 */
public class FootPaintActivityEntry {
    private int imageUrl;
    private String lible;
    private String content;
    private boolean state;

    public FootPaintActivityEntry(int imageUrl, String lible, String content, boolean state) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
