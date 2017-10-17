package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/17.
 * 用于保存政府订单页面支付详情页下拉菜单中的数据
 */
public class BooleanEntry {
    private Boolean aBoolean;
    private Integer index;

    public BooleanEntry(Integer index) {
        this.index = index;
    }

    public BooleanEntry(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }


    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
