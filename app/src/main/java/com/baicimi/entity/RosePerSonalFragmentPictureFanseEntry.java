package com.baicimi.entity;

/**
 * Created by Administrator on 2018/1/10.
 * 全球生活汇  首页 他的图片 他的粉丝 listview 实体类
 */
public class RosePerSonalFragmentPictureFanseEntry {
    private int imageUrl;
    private String lible;
    private String content;


    public RosePerSonalFragmentPictureFanseEntry(int imageUrl, String lible, String content) {
        this.imageUrl = imageUrl;
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
