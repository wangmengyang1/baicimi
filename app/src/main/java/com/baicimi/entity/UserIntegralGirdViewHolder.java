package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/18.
 */
public class UserIntegralGirdViewHolder {
    private int imageUrl;
    private String lible;
    private String number;
    private String oldNumber;
    private String shoppNumber;

    public UserIntegralGirdViewHolder(int imageUrl, String lible, String number, String oldNumber, String shoppNumber) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.number = number;
        this.oldNumber = oldNumber;
        this.shoppNumber = shoppNumber;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(String oldNumber) {
        this.oldNumber = oldNumber;
    }

    public String getShoppNumber() {
        return shoppNumber;
    }

    public void setShoppNumber(String shoppNumber) {
        this.shoppNumber = shoppNumber;
    }
}
