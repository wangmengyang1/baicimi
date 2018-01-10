package com.baicimi.entity;

/**
 * Created by Administrator on 2018/1/9.
 * 个人中心首页 手机充值 充话费 手机充值账单、 listview实体类
 */
public class PhoneTopUpBillEntry {
    private String date;
    private int imageUrl;
    private String money;
    private String content;

    public PhoneTopUpBillEntry(String date, int imageUrl, String money, String content) {
        this.date = date;
        this.imageUrl = imageUrl;
        this.money = money;
        this.content = content;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
