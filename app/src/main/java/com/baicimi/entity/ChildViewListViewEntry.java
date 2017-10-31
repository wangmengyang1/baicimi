package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/31.
 */
public class ChildViewListViewEntry {

    private String lible;
    private String content;
    private String number;

    public ChildViewListViewEntry(String lible, String content, String number) {
        this.lible = lible;
        this.content = content;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
