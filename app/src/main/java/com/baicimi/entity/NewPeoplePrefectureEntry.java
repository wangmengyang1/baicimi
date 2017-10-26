package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/25.
 * 积分商城  新人专区  listview实体类
 */
public class NewPeoplePrefectureEntry {
    private int imageUrl;
    private String lible;
    private String number;
    private String integer;

    public NewPeoplePrefectureEntry(int imageUrl, String lible, String number, String integer) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.number = number;
        this.integer = integer;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInteger() {
        return integer;
    }

    public void setInteger(String integer) {
        this.integer = integer;
    }
}
