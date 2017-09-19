package com.baicimi.entity;

/**
 * Created by Administrator on 2017/8/25.
 * 信息页面，评论listview中GridView实体类
 */
public class CheckOneFragmentGridViewEntry {
    private int imageUrl;

    public CheckOneFragmentGridViewEntry(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
