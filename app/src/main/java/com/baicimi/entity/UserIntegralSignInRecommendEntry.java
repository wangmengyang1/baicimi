package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/18.
 */
public class UserIntegralSignInRecommendEntry {
    private String date;
    private String lible;

    public UserIntegralSignInRecommendEntry(String date, String lible) {
        this.date = date;
        this.lible = lible;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }
}
