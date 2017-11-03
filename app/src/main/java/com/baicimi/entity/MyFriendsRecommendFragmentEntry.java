package com.baicimi.entity;

/**
 * Created by Administrator on 2017/11/2.
 * 个人中心  百万行动计划  推荐好友listview实体类
 */
public class MyFriendsRecommendFragmentEntry {
    private String name;
    private String phoneNumber;
    private String email;
    private String weichect;
    private String state;
    private boolean check;


    public MyFriendsRecommendFragmentEntry(String name, String phoneNumber, String email, String weichect, String state, boolean check) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.weichect = weichect;
        this.state = state;
        this.check = check;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeichect() {
        return weichect;
    }

    public void setWeichect(String weichect) {
        this.weichect = weichect;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
