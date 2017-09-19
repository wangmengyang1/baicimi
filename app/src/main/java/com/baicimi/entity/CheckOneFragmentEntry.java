package com.baicimi.entity;

/**
 * Created by Administrator on 2017/8/25.
 * 商品详情消息界面listview实体类
 */
public class CheckOneFragmentEntry {
    private int userImage;
    private String userName;
    private String date;
    private String content;
    private String comment;
    private String shareNumber;
    private String liekNumber;

    private int checkOneFragmentGridviewEntry;

    public CheckOneFragmentEntry(int userImage, String userName, String date, String content, String comment, String shareNumber, String liekNumber, int checkOneFragmentGridviewEntry) {
        this.userImage = userImage;
        this.userName = userName;
        this.date = date;
        this.content = content;
        this.comment = comment;
        this.shareNumber = shareNumber;
        this.liekNumber = liekNumber;
        this.checkOneFragmentGridviewEntry = checkOneFragmentGridviewEntry;
    }


    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(String shareNumber) {
        this.shareNumber = shareNumber;
    }

    public String getLiekNumber() {
        return liekNumber;
    }

    public void setLiekNumber(String liekNumber) {
        this.liekNumber = liekNumber;
    }

    public int getCheckOneFragmentGridviewEntry() {
        return checkOneFragmentGridviewEntry;
    }

    public void setCheckOneFragmentGridviewEntry(int checkOneFragmentGridviewEntry) {
        this.checkOneFragmentGridviewEntry = checkOneFragmentGridviewEntry;
    }


}
