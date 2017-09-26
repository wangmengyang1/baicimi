package com.baicimi.entity;

/**
 * Created by Administrator on 2017/8/22.
 * 分销订货入口订货清单实体类
 */
public class DistributionOrderGoodsEntry {
    private String lible;
    private String specification;
    private int imageUrl;
    private String money;
    private int number;
    private String expressage;
    private String amountMoney;
    private boolean delete;


    public DistributionOrderGoodsEntry(String lible, String specification, int imageUrl, String money, int number, String expressage, String amountMoney  ,boolean delete) {
        this.lible = lible;
        this.specification = specification;
        this.imageUrl = imageUrl;
        this.money = money;
        this.number = number;
        this.expressage = expressage;
        this.amountMoney = amountMoney;
        this.delete = delete;
    }


    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getExpressage() {
        return expressage;
    }

    public void setExpressage(String expressage) {
        this.expressage = expressage;
    }

    public String getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(String amountMoney) {
        this.amountMoney = amountMoney;
    }
}
