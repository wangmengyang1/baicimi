package com.baicimi.entity;

/**
 * Created by Administrator on 2017/8/24.
 * 分销商购买首页日化listview实体类
 */
public class TodayCosmeticsEntry {
    private int imageUrl;
    private String discountsPrice;
    private String marketPrice;
    private String content;
    private String evaluate;
    private String goodReputation;
    private String  salesVolume;
    private int buyNumber;

    public TodayCosmeticsEntry(int imageUrl, String discountsPrice, String marketPrice, String content, String evaluate, String goodReputation, String salesVolume, int buyNumber) {
        this.imageUrl = imageUrl;
        this.discountsPrice = discountsPrice;
        this.marketPrice = marketPrice;
        this.content = content;
        this.evaluate = evaluate;
        this.goodReputation = goodReputation;
        this.salesVolume = salesVolume;
        this.buyNumber = buyNumber;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDiscountsPrice() {
        return discountsPrice;
    }

    public void setDiscountsPrice(String discountsPrice) {
        this.discountsPrice = discountsPrice;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getGoodReputation() {
        return goodReputation;
    }

    public void setGoodReputation(String goodReputation) {
        this.goodReputation = goodReputation;
    }

    public String getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(String salesVolume) {
        this.salesVolume = salesVolume;
    }

    public int getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(int buyNumber) {
        this.buyNumber = buyNumber;
    }
}
