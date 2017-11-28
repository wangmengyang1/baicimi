package com.baicimi.entity;

/**
 * Created by Administrator on 2017/11/28.
 * 个人中心  密码找回 验证身份 listview实体类
 */
public class UserIdentityAuthenticationEntry {
    private String lible;
    private String content;


    public UserIdentityAuthenticationEntry(String lible, String content) {
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
