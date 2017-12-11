package com.baicimi.fragments;

/**
 * Created by Administrator on 2017/12/11.
 * 个人中心首页 幂聊首页 通讯录 我的朋友 listview实体类
 */
public class MiChatAddressBookMyFriendsEntry {
    private int imageUrl;
    private String lible;
    private String content;
    private int state;


    public MiChatAddressBookMyFriendsEntry(int imageUrl, String lible, String content, int state) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.content = content;
        this.state = state;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
