package com.baicimi.entity;

/**
 * Created by Administrator on 2018/1/6.
 * 分销订货 首页 购物袋 实体类
 */
public class ShoppingBagEntry {
    private boolean stateDelte;
    private int imageUrl;
    private String lible;
    private String content;
    private String capacity;
    private String inventory;
    private String money;
    private int count;


    public ShoppingBagEntry(boolean stateDelte, int imageUrl, String lible, String content, String capacity, String inventory, String money, int count) {
        this.stateDelte = stateDelte;
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.content = content;
        this.capacity = capacity;
        this.inventory = inventory;
        this.money = money;
        this.count = count;
    }


    public boolean isStateDelte() {
        return stateDelte;
    }

    public void setStateDelte(boolean stateDelte) {
        this.stateDelte = stateDelte;
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

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
