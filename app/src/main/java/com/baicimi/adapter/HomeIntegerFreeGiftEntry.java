package com.baicimi.adapter;

/**
 * Created by Administrator on 2017/10/24.
 * 积分商城 免费礼品 实体类
 */
public class HomeIntegerFreeGiftEntry {
    private int imageUrl;
    private String lible;
    private String money;
    private String integerNumber;
    private String number;

    public HomeIntegerFreeGiftEntry(int imageUrl, String lible, String money, String integerNumber, String number) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.money = money;
        this.integerNumber = integerNumber;
        this.number = number;
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

    public String getIntegerNumber() {
        return integerNumber;
    }

    public void setIntegerNumber(String integerNumber) {
        this.integerNumber = integerNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
