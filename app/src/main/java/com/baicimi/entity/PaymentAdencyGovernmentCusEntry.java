package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/14.
 */
public class PaymentAdencyGovernmentCusEntry {
    private String date;
    private String lible;
    private String code;
    private String state;

    public PaymentAdencyGovernmentCusEntry(String date, String lible, String code, String state) {
        this.date = date;
        this.lible = lible;
        this.code = code;
        this.state = state;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
