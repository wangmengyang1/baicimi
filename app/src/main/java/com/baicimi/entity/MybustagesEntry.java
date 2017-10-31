package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/31.
 * 个人中心  首页  资产中心  幂钱包   我的分期实体类
 */
public class MybustagesEntry {
    private String lible;
    private String consumption;
    private String date;
    private String money;
    private String consumptionNumber;
    private String state;
    private String result;

    public MybustagesEntry(String lible, String consumption, String date, String money, String consumptionNumber, String state, String result) {
        this.lible = lible;
        this.consumption = consumption;
        this.date = date;
        this.money = money;
        this.consumptionNumber = consumptionNumber;
        this.state = state;
        this.result = result;
    }


    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getConsumptionNumber() {
        return consumptionNumber;
    }

    public void setConsumptionNumber(String consumptionNumber) {
        this.consumptionNumber = consumptionNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
