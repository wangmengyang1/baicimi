package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/20.
 * 师生选购专区，教育快讯listview实体类
 */
public class TeacherEducationEntry {
    private int imageUrl;
    private String lible;
    private String content;

    public TeacherEducationEntry(int imageUrl, String lible, String content) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.content = content;
    }

    public TeacherEducationEntry(String lible, String content) {
        this.lible = lible;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
