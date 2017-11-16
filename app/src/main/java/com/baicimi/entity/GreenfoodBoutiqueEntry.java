package com.baicimi.entity;

/**
 * Created by Administrator on 2017/11/15.
 * 绿色食品，精品炼成记 listview实体类
 */
public class GreenfoodBoutiqueEntry {
    private int imageUrl;
    private String string;


    public GreenfoodBoutiqueEntry(int imageUrl, String string) {
        this.imageUrl = imageUrl;
        this.string = string;
    }


    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
