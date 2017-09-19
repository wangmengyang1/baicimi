package com.baicimi.entity;

/**
 * Created by Administrator on 2017/9/18.
 */
public class PaymentAdencyEntry {
    private int imageUrl;
    private String lible;
    private String content;
    private String specification;
    private String price;


    public PaymentAdencyEntry(int imageUrl, String lible, String content, String specification, String price) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.content = content;
        this.specification = specification;
        this.price = price;
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
