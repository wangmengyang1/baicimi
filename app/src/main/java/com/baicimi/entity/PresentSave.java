package com.baicimi.entity;

/**
 * 文 件 名：PresentSave
 * 描    述：礼品寄存适配器数据实体类
 * 时    间：2017/3/21
 * 版    权：王梦阳
 *
 */
public class PresentSave {
    int imagecommodity;//商品
    String lible;//标题
    String describe;//描述
    String validitydate;//有效期


    public PresentSave() {
    }

    public PresentSave(int imagecommodity, String validitydate, String describe, String lible) {
        this.imagecommodity = imagecommodity;
        this.validitydate = validitydate;
        this.describe = describe;
        this.lible = lible;
    }

    public int getImagecommodity() {
        return imagecommodity;
    }

    public void setImagecommodity(int imagecommodity) {
        this.imagecommodity = imagecommodity;
    }

    public String getLible() {
        return lible;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getValiditydate() {
        return validitydate;
    }

    public void setValiditydate(String validitydate) {
        this.validitydate = validitydate;
    }
}
