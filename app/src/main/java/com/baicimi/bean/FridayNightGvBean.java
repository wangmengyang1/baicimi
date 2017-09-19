package com.baicimi.bean;

/**
 * Created by tan on 2016/12/1.
 */
public class FridayNightGvBean {
    private String name;
    private String used_price;
    private String now_price;
    private int number;
    private int imageUrl;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsed_price() {
        return used_price;
    }

    public void setUsed_price(String used_price) {
        this.used_price = used_price;
    }

    public String getNow_price() {
        return now_price;
    }

    public void setNow_price(String now_price) {
        this.now_price = now_price;
    }

    public FridayNightGvBean(String name, String used_price, String now_price, int number, int imageUrl) {
        this.name = name;
        this.used_price = used_price;
        this.now_price = now_price;
        this.number = number;
        this.imageUrl = imageUrl;
    }
}
