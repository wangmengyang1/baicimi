package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/16.
 * 政府采购订单支付页面下拉菜单实体类
 */
public class CustomGovernmentEntry {
    private String lible;
    private String content;


    public CustomGovernmentEntry(String lible, String content) {
        this.lible = lible;
        this.content = content;
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
