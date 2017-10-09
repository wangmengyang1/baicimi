package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/9.
 * 商品详情，信息，客户服务，问题详情，常见问题实体类
 */
public class FrequentlyQuestionEntry {
    private String lible;
    private String conent;

    public FrequentlyQuestionEntry(String lible, String conent) {
        this.lible = lible;
        this.conent = conent;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public String getConent() {
        return conent;
    }

    public void setConent(String conent) {
        this.conent = conent;
    }
}
