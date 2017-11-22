package com.baicimi.entity;

/**
 * Created by Administrator on 2017/11/22.
 * 个人中心  我的生活助手  红包  红包领取详情  listview实体类
 */
public class RedPacketGetthedetailsEntry {
    private int imageurl;
    private String username;
    private String lible;
    private String date;
    private boolean ischecked;

    public RedPacketGetthedetailsEntry(int imageurl, String username, String lible, String date, boolean ischecked) {
        this.imageurl = imageurl;
        this.username = username;
        this.lible = lible;
        this.date = date;
        this.ischecked = ischecked;
    }


    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean ischecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }
}
