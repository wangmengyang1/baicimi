package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/24.
 * 积分商城  兑换排行， listview布局实体类
 */
public class ConversionRankingEntry {
    private int imageUrl;
    private String lible;
    private String content;

    public ConversionRankingEntry(int imageUrl, String lible, String content) {
        this.imageUrl = imageUrl;
        this.lible = lible;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
