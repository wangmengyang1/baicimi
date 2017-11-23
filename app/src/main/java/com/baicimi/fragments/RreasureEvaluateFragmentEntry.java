package com.baicimi.fragments;

/**
 * Created by Administrator on 2017/11/23.
 * 个人中心 我的订单首页  评价管理  宝贝评价首页 我的评论 listview布局填充
 */
public class RreasureEvaluateFragmentEntry {
    private int imageUrl;
    private String lible;
    private String date;

    public RreasureEvaluateFragmentEntry(int imageUrl, String lible, String date) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.date = date;
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
}
