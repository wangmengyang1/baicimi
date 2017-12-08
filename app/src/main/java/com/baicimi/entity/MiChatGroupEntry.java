package com.baicimi.entity;

import android.widget.ImageView;

/**
 * Created by Administrator on 2017/12/8.
 */
public class MiChatGroupEntry {
    private int imageUrl;
    private String lible;

    public MiChatGroupEntry(int imageUrl, String lible) {
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
