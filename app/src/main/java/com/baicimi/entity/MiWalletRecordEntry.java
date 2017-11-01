package com.baicimi.entity;

/**
 * Created by Administrator on 2017/11/1.
 * 个人中心   资产中心  幂钱包   我的收支记录实体类
 */
public class MiWalletRecordEntry {
    private String date;
    private String content;
    private String state;
    private String money;


    public MiWalletRecordEntry(String date, String content, String state, String money) {
        this.date = date;
        this.content = content;
        this.state = state;
        this.money = money;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
