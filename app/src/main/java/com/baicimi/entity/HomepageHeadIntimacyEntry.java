package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/16.
 * 个人中心首页  亲密付  发起亲密付实体类
 *
 */
public class HomepageHeadIntimacyEntry {
    private int imageUrl;
    private String name;


    public HomepageHeadIntimacyEntry(int imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }


    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
