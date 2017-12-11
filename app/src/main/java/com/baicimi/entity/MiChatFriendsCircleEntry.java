package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/11.
 * 个人中心首页 幂聊首页 幂友圈 listview实体类
 */
public class MiChatFriendsCircleEntry {
    private int imageFirst;
    private int imageSecond;
    private String lible;
    private String dateAddress;
    private int userImage;
    private String username;
    private String userAddress;


    public MiChatFriendsCircleEntry(int imageFirst, int imageSecond, String lible, String dateAddress, int userImage, String username, String userAddress) {
        this.imageFirst = imageFirst;
        this.imageSecond = imageSecond;
        this.lible = lible;
        this.dateAddress = dateAddress;
        this.userImage = userImage;
        this.username = username;
        this.userAddress = userAddress;
    }


    public int getImageFirst() {
        return imageFirst;
    }

    public void setImageFirst(int imageFirst) {
        this.imageFirst = imageFirst;
    }

    public int getImageSecond() {
        return imageSecond;
    }

    public void setImageSecond(int imageSecond) {
        this.imageSecond = imageSecond;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public String getDateAddress() {
        return dateAddress;
    }

    public void setDateAddress(String dateAddress) {
        this.dateAddress = dateAddress;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
