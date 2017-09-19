package com.baicimi.entity;

/**
 * Created by Administrator on 2017/8/31.
 * 我的团购待发货实体类
 */
public class OnMyIndentNotYetShippedEntry {
    private String store;
    private String state;
    private int imageUrl;
    private String content;
    private String newMoney;
    private String oldMoney;
    private String number;
    private String aggregate;
    private boolean freightInsurance;
    private boolean guarantee;


    public OnMyIndentNotYetShippedEntry(String store, String state, int imageUrl, String content, String newMoney, String oldMoney, String number, String aggregate, boolean freightInsurance, boolean guarantee) {
        this.store = store;
        this.state = state;
        this.imageUrl = imageUrl;
        this.content = content;
        this.newMoney = newMoney;
        this.oldMoney = oldMoney;
        this.number = number;
        this.aggregate = aggregate;
        this.freightInsurance = freightInsurance;
        this.guarantee = guarantee;
    }


    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewMoney() {
        return newMoney;
    }

    public void setNewMoney(String newMoney) {
        this.newMoney = newMoney;
    }

    public String getOldMoney() {
        return oldMoney;
    }

    public void setOldMoney(String oldMoney) {
        this.oldMoney = oldMoney;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAggregate() {
        return aggregate;
    }

    public void setAggregate(String aggregate) {
        this.aggregate = aggregate;
    }

    public boolean isFreightInsurance() {
        return freightInsurance;
    }

    public void setFreightInsurance(boolean freightInsurance) {
        this.freightInsurance = freightInsurance;
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }
}
