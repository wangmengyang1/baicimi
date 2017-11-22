package com.baicimi.entity;

/**
 * Created by Administrator on 2017/11/22.
 * 个人中心首页  我的生活助手  红包首页 listview 实体类
 */
public class UserCenterRedPacketEntry {
    private String username;
    private String date;
    private String money;

    public UserCenterRedPacketEntry(String username, String date, String money) {
        this.username = username;
        this.date = date;
        this.money = money;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
