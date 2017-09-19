package com.baicimi.entity;

/**
 * Created by Administrator on 2017/9/15.
 * 利用单例模式的唯一性进行数据传送
 */

public class CommodityNumberEntry {
    private static CommodityNumberEntry commodityNumberEntry = new CommodityNumberEntry();


    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private CommodityNumberEntry(){};

    public static CommodityNumberEntry commodityNumberEntryIntereal(){
        if (commodityNumberEntry != null){
            return commodityNumberEntry;
        }else {
            return new CommodityNumberEntry();
        }
    }
}
