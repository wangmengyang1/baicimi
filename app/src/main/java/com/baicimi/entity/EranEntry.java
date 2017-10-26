package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/26.
 * 个人中心，会员积分页面 赚取积分 实体类
 */
public class EranEntry {
    private int imageUrl;
    private String lible;
    private String moreFirst;
    private String moreSecond;
    private String content;

    public EranEntry(int imageUrl, String lible, String moreFirst, String moreSecond, String content) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.moreFirst = moreFirst;
        this.moreSecond = moreSecond;
        this.content = content;
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

    public String getMoreFirst() {
        return moreFirst;
    }

    public void setMoreFirst(String moreFirst) {
        this.moreFirst = moreFirst;
    }

    public String getMoreSecond() {
        return moreSecond;
    }

    public void setMoreSecond(String moreSecond) {
        this.moreSecond = moreSecond;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
