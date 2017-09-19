package com.baicimi.entity;

/**
 * Created by Administrator on 2017/8/17.
 * 个人中心 领取积分实体类
 */
public class PresonCenterdeGetIntegralEntry {
    private int commodityImage;
    private String lible;
    private String newMoney;
    private String oldMoney;
    private String shoppingUser;

    public PresonCenterdeGetIntegralEntry(int commodityImage, String lible, String newMoney, String oldMoney, String shoppingUser) {
        this.commodityImage = commodityImage;
        this.lible = lible;
        this.newMoney = newMoney;
        this.oldMoney = oldMoney;
        this.shoppingUser = shoppingUser;
    }


    public int getCommodityImage() {
        return commodityImage;
    }

    public void setCommodityImage(int commodityImage) {
        this.commodityImage = commodityImage;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public String getNewMoney() {
        return newMoney;
    }

    public void setNewMoney(String newMoney) {
        this.newMoney = newMoney;
    }

    public String getOldMoney() {
        return oldMoney;
    }

    public void setOldMoney(String oldMoney) {
        this.oldMoney = oldMoney;
    }

    public String getShoppingUser() {
        return shoppingUser;
    }

    public void setShoppingUser(String shoppingUser) {
        this.shoppingUser = shoppingUser;
    }
}
