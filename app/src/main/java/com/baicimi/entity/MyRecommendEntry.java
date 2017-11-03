package com.baicimi.entity;

/**
 * Created by Administrator on 2017/11/2.
 * 个人中心  百万行动计划  我要推荐页面listview实体类
 */
public class MyRecommendEntry {
    private int imageUrl;
    private String lible;
    private String money;
    private String code;
    private String userNumber;


    public MyRecommendEntry(int imageUrl, String lible, String money, String code, String userNumber) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.money = money;
        this.code = code;
        this.userNumber = userNumber;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
