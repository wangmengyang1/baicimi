package com.baicimi.fragments;

/**
 * Created by Administrator on 2018/1/26.
 */
public class TallyBookDetailEntry {
    private int imageUrl;
    private String lible;
    private String money;

    public TallyBookDetailEntry(int imageUrl, String lible, String money) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.money = money;
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
