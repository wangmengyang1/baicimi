package com.baicimi.entity;

/**
 * Created by Administrator on 2017/11/27.
 * 试用申请 试用报告
 */
public class TryoutApplyForFragmentSecondEntry {
    private int imageUrl;
    private int userImage;

    public TryoutApplyForFragmentSecondEntry(int imageUrl, int userImage) {
        this.imageUrl = imageUrl;
        this.userImage = userImage;
    }


    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }
}
