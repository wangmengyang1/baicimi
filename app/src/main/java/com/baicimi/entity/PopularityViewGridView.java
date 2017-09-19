package com.baicimi.entity;

/**
 * Created by Administrator on 2017/4/9.
 */
public class PopularityViewGridView {
    private int imageUri;
    private String lible;
    private String oldmoney;
    private String newmoney;
    private String usershoping;


    public PopularityViewGridView(int imageUri, String lible, String oldmoney, String newmoney, String usershoping) {
        this.imageUri = imageUri;
        this.lible = lible;
        this.oldmoney = oldmoney;
        this.newmoney = newmoney;
        this.usershoping = usershoping;
    }

    public PopularityViewGridView() {
    }

    public int getImageUri() {
        return imageUri;
    }

    public void setImageUri(int imageUri) {
        this.imageUri = imageUri;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public String getOldmoney() {
        return oldmoney;
    }

    public void setOldmoney(String oldmoney) {
        this.oldmoney = oldmoney;
    }

    public String getNewmoney() {
        return newmoney;
    }

    public void setNewmoney(String newmoney) {
        this.newmoney = newmoney;
    }

    public String getUsershoping() {
        return usershoping;
    }

    public void setUsershoping(String usershoping) {
        this.usershoping = usershoping;
    }
}
