package com.baicimi.bean;

/**
 * Created by tan on 2016/9/5.
 * 商品列表ListView
 */
public class ShaiXuanListBean {
    private String img_goods_shaixuan;
    private String tv_goods_name;
    private String tv_jifendikou_num;
    private String jifendikou_mony_num;
    private String tv_now_price;
    private String tv_used_price;
    private int imageUrl;

    public ShaiXuanListBean(String img_goods_shaixuan, String tv_goods_name, String tv_jifendikou_num, String jifendikou_mony_num, String tv_now_price, String tv_used_price, int imageUrl) {
        this.img_goods_shaixuan = img_goods_shaixuan;
        this.tv_goods_name = tv_goods_name;
        this.tv_jifendikou_num = tv_jifendikou_num;
        this.jifendikou_mony_num = jifendikou_mony_num;
        this.tv_now_price = tv_now_price;
        this.tv_used_price = tv_used_price;
        this.imageUrl = imageUrl;
    }


    public ShaiXuanListBean() {
    }


    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImg_goods_shaixuan() {
        return img_goods_shaixuan;
    }

    public void setImg_goods_shaixuan(String img_goods_shaixuan) {
        this.img_goods_shaixuan = img_goods_shaixuan;
    }

    public String getTv_goods_name() {
        return tv_goods_name;
    }

    public void setTv_goods_name(String tv_goods_name) {
        this.tv_goods_name = tv_goods_name;
    }

    public String getTv_jifendikou_num() {
        return tv_jifendikou_num;
    }

    public void setTv_jifendikou_num(String tv_jifendikou_num) {
        this.tv_jifendikou_num = tv_jifendikou_num;
    }

    public String getJifendikou_mony_num() {
        return jifendikou_mony_num;
    }

    public void setJifendikou_mony_num(String jifendikou_mony_num) {
        this.jifendikou_mony_num = jifendikou_mony_num;
    }

    public String getTv_now_price() {
        return tv_now_price;
    }

    public void setTv_now_price(String tv_now_price) {
        this.tv_now_price = tv_now_price;
    }

    public String getTv_used_price() {
        return tv_used_price;
    }

    public void setTv_used_price(String tv_used_price) {
        this.tv_used_price = tv_used_price;
    }
}
