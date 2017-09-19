package com.baicimi.entity;

/**
 * Created by Administrator on 2017/9/18.
 * 我的订单实体类
 */
public class MyOrderFormEntry {
    private int imageUrl;
    private String money;
    private String address;
    private String state;
    private String payment;
    private String date;

    public MyOrderFormEntry(int imageUrl, String money, String address, String state, String payment, String date) {
        this.imageUrl = imageUrl;
        this.money = money;
        this.address = address;
        this.state = state;
        this.payment = payment;
        this.date = date;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
