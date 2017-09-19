package com.baicimi.entity;

/**
 * Created by Administrator on 2017/8/24.
 * 分销商购买首页办公用品实体类
 */
public class OfficsSuppliesEntry {
    private String lible;
    private int imageUrl;
    private String money;
    private int number;

    public OfficsSuppliesEntry(String lible, int imageUrl, String money, int number) {
        this.lible = lible;
        this.imageUrl = imageUrl;
        this.money = money;
        this.number = number;
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
