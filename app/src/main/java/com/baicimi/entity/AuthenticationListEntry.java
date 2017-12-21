package com.baicimi.entity;

import android.widget.TextView;

/**
 * Created by Administrator on 2017/12/21.
 * 个人中心首页 我的生活助手  幂额度首页   幂信用积分开通成功 listivew实体类
 */
public class AuthenticationListEntry {
    private String lible;
    private String content;
    private String tag;
    private boolean tagState;
    private int imageUrl;


    public AuthenticationListEntry(String lible, String content, String tag, boolean tagState, int imageUrl) {
        this.lible = lible;
        this.content = content;
        this.tag = tag;
        this.tagState = tagState;
        this.imageUrl = imageUrl;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isTagState() {
        return tagState;
    }

    public void setTagState(boolean tagState) {
        this.tagState = tagState;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
