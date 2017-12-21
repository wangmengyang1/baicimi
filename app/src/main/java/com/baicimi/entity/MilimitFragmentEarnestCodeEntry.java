package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/21.
 * 个人中心首页 我的生活助手  幂额度首页 幂信用积分 gridview实体类
 */
public class MilimitFragmentEarnestCodeEntry {
    private int imageUrl;
    private String lible;
    private String content;
    private String buttonFirst;
    private boolean stateFirst;
    private String buttonSecond;
    private boolean stateSecond;
    private int backgroundColor;

    public MilimitFragmentEarnestCodeEntry(int imageUrl, String lible, String content, String buttonFirst, boolean stateFirst, String buttonSecond, boolean stateSecond, int backgroundColor) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.content = content;
        this.buttonFirst = buttonFirst;
        this.stateFirst = stateFirst;
        this.buttonSecond = buttonSecond;
        this.stateSecond = stateSecond;
        this.backgroundColor = backgroundColor;
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

    public String getButtonFirst() {
        return buttonFirst;
    }

    public void setButtonFirst(String buttonFirst) {
        this.buttonFirst = buttonFirst;
    }

    public boolean isStateFirst() {
        return stateFirst;
    }

    public void setStateFirst(boolean stateFirst) {
        this.stateFirst = stateFirst;
    }

    public String getButtonSecond() {
        return buttonSecond;
    }

    public void setButtonSecond(String buttonSecond) {
        this.buttonSecond = buttonSecond;
    }

    public boolean isStateSecond() {
        return stateSecond;
    }

    public void setStateSecond(boolean stateSecond) {
        this.stateSecond = stateSecond;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}



