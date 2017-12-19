package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/19.
 * 个人中心首页 爱心捐赠首页fragment 实体类
 */
public class LoveDonateFragmentEntry {
    private String lible;
    private int imageUrl;
    private String content;
    private int userImage;
    private String name;
    private String address;


    public LoveDonateFragmentEntry(String lible, int imageUrl, String content, int userImage, String name, String address) {
        this.lible = lible;
        this.imageUrl = imageUrl;
        this.content = content;
        this.userImage = userImage;
        this.name = name;
        this.address = address;
    }

    public LoveDonateFragmentEntry(int imageUrl, String address, String lible) {
        this.imageUrl = imageUrl;
        this.address = address;
        this.lible = lible;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
