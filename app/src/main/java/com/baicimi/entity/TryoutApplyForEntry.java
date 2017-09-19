package com.baicimi.entity;

/**
 * Created by Administrator on 2017/9/7.
 * 试用申请GridView实体类
 */
public class TryoutApplyForEntry {
    private int imageUrl;
    private String lible;
    private String newMoney;
    private String number;
    private int tagNumber;

    public TryoutApplyForEntry(int imageUrl, String lible, String newMoney, String number) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.newMoney = newMoney;
        this.number = number;
    }

    public TryoutApplyForEntry(int imageUrl, String lible, String newMoney, String number, int tagNumber) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.newMoney = newMoney;
        this.number = number;
        this.tagNumber = tagNumber;
    }

    public int getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(int tagNumber) {
        this.tagNumber = tagNumber;
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

    public String getNewMoney() {
        return newMoney;
    }

    public void setNewMoney(String newMoney) {
        this.newMoney = newMoney;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
