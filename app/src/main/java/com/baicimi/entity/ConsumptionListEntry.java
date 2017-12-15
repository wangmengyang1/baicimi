package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/15.
 * 我的资产，消费清单 listview布局填充
 *
 */
public class ConsumptionListEntry {
    private String date;
    private String state;
    private String lible;
    private String content;
    private String button;


    public ConsumptionListEntry(String date, String state, String lible, String content , String button) {
        this.date = date;
        this.state = state;
        this.lible = lible;
        this.content = content;
        this.button = button;
    }


    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
}
