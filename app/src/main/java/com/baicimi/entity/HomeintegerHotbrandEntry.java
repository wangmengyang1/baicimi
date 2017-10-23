package com.baicimi.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 * 首页  积分商城 热门品牌二级页面listview实体类
 */
public class HomeintegerHotbrandEntry {
    private String lible;
    private List<Integer> list;

    public HomeintegerHotbrandEntry(String lible, List<Integer> list) {
        this.lible = lible;
        this.list = list;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
