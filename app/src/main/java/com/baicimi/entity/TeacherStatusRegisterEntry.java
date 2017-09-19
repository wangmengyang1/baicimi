package com.baicimi.entity;

/**
 * Created by Administrator on 2017/8/16.
 * 教师、学生注册通道实体类
 */
public class TeacherStatusRegisterEntry {
    private int imageUrl;
    private String lible;

    public TeacherStatusRegisterEntry(int imageUrl, String lible) {
        this.imageUrl = imageUrl;
        this.lible = lible;
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
}
