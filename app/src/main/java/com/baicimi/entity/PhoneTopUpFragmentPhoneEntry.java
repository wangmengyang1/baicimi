package com.baicimi.entity;

/**
 * Created by Administrator on 2018/1/8.
 * 个人中心首页 手机充值 充话费 GridView实体类
 */
public class PhoneTopUpFragmentPhoneEntry {
    private String lible;
    private String content;
    private boolean state;

    public PhoneTopUpFragmentPhoneEntry(String lible, String content, boolean state) {
        this.lible = lible;
        this.content = content;
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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
