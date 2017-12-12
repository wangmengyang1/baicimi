package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/12.
 * 个人中心首页 幂聊首页 全球生活汇 回收站 我的图片 listview实体类
 */
public class MPSystemGcMyPictureEntry {
    private int imageUrl;
    private String date;

    public MPSystemGcMyPictureEntry(int imageUrl, String date) {
        this.imageUrl = imageUrl;
        this.date = date;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

