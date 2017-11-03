package com.baicimi.entity;

/**
 * Created by Administrator on 2017/11/3.
 * 个人中心 我的生活助手 礼品寄存处列表布局实体类
 */
public class FragmentPresentSaveFirstEntry {
    private int imageUrl;
    private String lible;
    private String content;
    private String deadline;
    private boolean isExpire;
    private boolean isloseEfficacy;


    public FragmentPresentSaveFirstEntry(int imageUrl, String lible, String content, String deadline, boolean isExpire, boolean isloseEfficacy) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.content = content;
        this.deadline = deadline;
        this.isExpire = isExpire;
        this.isloseEfficacy = isloseEfficacy;
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean isExpire() {
        return isExpire;
    }

    public void setExpire(boolean expire) {
        isExpire = expire;
    }

    public boolean isloseEfficacy() {
        return isloseEfficacy;
    }

    public void setIsloseEfficacy(boolean isloseEfficacy) {
        this.isloseEfficacy = isloseEfficacy;
    }
}


