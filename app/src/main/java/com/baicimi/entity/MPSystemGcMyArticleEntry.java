package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/12.
 * 个人中心首页 幂聊首页 全球生活汇 回收站  我的文章 listview实体类
 */
public class MPSystemGcMyArticleEntry {
    private String date;
    private String lible;
    private boolean state;


    public MPSystemGcMyArticleEntry(String date, String lible, boolean state) {
        this.date = date;
        this.lible = lible;
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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
