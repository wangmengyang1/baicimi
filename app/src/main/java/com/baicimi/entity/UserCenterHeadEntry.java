package com.baicimi.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 * 个人中心首页底部listview实体类
 *
 */
public class UserCenterHeadEntry {
    private int imageUrl;
    private String lible;
    private String[] listContent;

    public UserCenterHeadEntry(int imageUrl, String lible, String[] listContent) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.listContent = listContent;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public String[] getListContent() {
        return listContent;
    }

    public void setListContent(String[] listContent) {
        this.listContent = listContent;
    }
}
