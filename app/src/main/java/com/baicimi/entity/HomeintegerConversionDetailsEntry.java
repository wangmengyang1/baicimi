package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/23.
 * 首页  积分商城 兑换详情实体类
 */
public class HomeintegerConversionDetailsEntry {
    private int imageUrl;
    private String number;
    private String conversionDate;

    public HomeintegerConversionDetailsEntry(int imageUrl, String number, String conversionDate) {
        this.imageUrl = imageUrl;
        this.number = number;
        this.conversionDate = conversionDate;
    }


    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getConversionDate() {
        return conversionDate;
    }

    public void setConversionDate(String conversionDate) {
        this.conversionDate = conversionDate;
    }
}
