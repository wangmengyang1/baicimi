package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/13.
 * 个人中心首页 幂聊首页 全球生活汇 文件 我的图片 grievid实体类
 */
public class MPFileMyMyPictureEntry {
    private String lible;
    private int imageUrl;
    private String date;

    public MPFileMyMyPictureEntry(String lible, int imageUrl , String date) {
        this.lible = lible;
        this.imageUrl = imageUrl;
        this.date = date;
    }


    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
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
