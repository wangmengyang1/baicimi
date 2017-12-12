package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/12.
 * 人中心首页 幂聊首页 全球生活汇 新建 gridview实体类
 */
public class MPNewBookEntry {
    private int imageUrl;
    private String lible;

    public MPNewBookEntry(int imageUrl, String lible) {
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
