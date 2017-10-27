package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/27.
 * 个人中心  幂友对我的操作弹窗实体类
 */
public class MifridedsJurisdtionEntry {
    private int imageUrl;
    private String name;
    private boolean ischeck;

    public MifridedsJurisdtionEntry(int imageUrl, String name, boolean ischeck) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.ischeck = ischeck;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean ischeck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }
}
