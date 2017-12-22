package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/22.
 * 积分商城   新人专区 立即兑换 GridView实体类
 */
public class ImmediatelyChangeEntry {
    private int imageUrl;
    private String lible;
    private String numberCode;

    public ImmediatelyChangeEntry(int imageUrl, String lible, String numberCode) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.numberCode = numberCode;
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

    public String getNumberCode() {
        return numberCode;
    }

    public void setNumberCode(String numberCode) {
        this.numberCode = numberCode;
    }
}
