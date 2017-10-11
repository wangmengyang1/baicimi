package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/11.
 * 我的团购未成团参团人数详情实体类
 */
public class NoreachEntry {
    private int imageUrl;
    private String name;
    private String number;


    public NoreachEntry(int imageUrl, String name, String number) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
