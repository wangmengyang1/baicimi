package com.baicimi.entity;

/**
 * Created by Administrator on 2017/9/15.
 * 个人中心全部实体类
 */
public class RosePersonalAllEntry {
    private int imageUrl;
    private String lible;
    private String name;
    private String address;

    public RosePersonalAllEntry(int imageUrl, String lible, String name, String address) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.name = name;
        this.address = address;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
