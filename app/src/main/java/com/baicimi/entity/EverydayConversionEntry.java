package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/23.
 * 积分商城 限时兑换 每日必兑实体类
 */
public class EverydayConversionEntry {
    private String time;
    private String state;
    private int imageUrl;
    private String name;
    private String money;
    private String integerMoney;
    private String number;


    public EverydayConversionEntry(String time, String state, int imageUrl, String name, String money, String integerMoney, String number) {
        this.time = time;
        this.state = state;
        this.imageUrl = imageUrl;
        this.name = name;
        this.money = money;
        this.integerMoney = integerMoney;
        this.number = number;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getIntegerMoney() {
        return integerMoney;
    }

    public void setIntegerMoney(String integerMoney) {
        this.integerMoney = integerMoney;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
