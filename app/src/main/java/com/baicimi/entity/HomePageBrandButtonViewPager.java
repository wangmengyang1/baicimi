package com.baicimi.entity;

/**
 * Created by Administrator on 2017/8/22.
 * 品牌首页布局底部viewpager实体类
 */
public class HomePageBrandButtonViewPager {
    private int imageUrl;
    private String  lible;
    private String content;
    private int attention;
    private int libleImager;
    private boolean attentionSelect = false;

    public HomePageBrandButtonViewPager(int imageUrl, String lible, String content, int attention, int libleImager , boolean attentionSelect) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.content = content;
        this.attention = attention;
        this.libleImager = libleImager;
        this.attentionSelect = attentionSelect;
    }

    public HomePageBrandButtonViewPager(int imageUrl, String lible, String content, int attention) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.content = content;
        this.attention = attention;
    }


    public boolean isAttentionSelect() {
        return attentionSelect;
    }

    public void setAttentionSelect(boolean attentionSelect) {
        this.attentionSelect = attentionSelect;
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

    public int getAttention() {
        return attention;
    }

    public void setAttention(int attention) {
        this.attention = attention;
    }

    public int getLibleImager() {
        return libleImager;
    }

    public void setLibleImager(int libleImager) {
        this.libleImager = libleImager;
    }


    @Override
    public String toString() {
        return "HomePageBrandButtonViewPager{" +
                "imageUrl=" + imageUrl +
                ", lible='" + lible + '\'' +
                ", content='" + content + '\'' +
                ", attention=" + attention +
                ", libleImager=" + libleImager +
                '}';
    }
}
