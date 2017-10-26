package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/26.
 * 个人中心 会员积分 积分查询 实体类
 */
public class FragmentInquireListEntry {
    private int imageUrl;
    private String lible;
    private String content;

    public FragmentInquireListEntry(int imageUrl, String lible, String content) {
        this.imageUrl = imageUrl;
        this.lible = lible;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
