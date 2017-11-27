package com.baicimi.entity;

/**
 * Created by Administrator on 2017/11/27.
 * 试用申请 我的试用申请listview实体类
 */
public class TryoutApplyForMeEntry {
    private int imageUrl;
    private String money;
    private String indentNumber;
    private String lible;
    private String state;
    private String applyFor;


    public TryoutApplyForMeEntry(int imageUrl, String money, String indentNumber, String lible, String state, String applyFor) {
        this.imageUrl = imageUrl;
        this.money = money;
        this.indentNumber = indentNumber;
        this.lible = lible;
        this.state = state;
        this.applyFor = applyFor;
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

    public String getIndentNumber() {
        return indentNumber;
    }

    public void setIndentNumber(String indentNumber) {
        this.indentNumber = indentNumber;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getApplyFor() {
        return applyFor;
    }

    public void setApplyFor(String applyFor) {
        this.applyFor = applyFor;
    }
}
