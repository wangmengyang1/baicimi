package com.baicimi.bean;

/**
 * Created by tan on 2016/12/13.
 */
public class GrouBuyMeiZhuangGvBean {
    private String name;
    private String used_price;
    private String person_groubuy_price;
    private String groubuy_price;
    private int imageUrl;

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

    public String getUsed_price() {
        return used_price;
    }

    public void setUsed_price(String used_price) {
        this.used_price = used_price;
    }

    public String getPerson_groubuy_price() {
        return person_groubuy_price;
    }

    public void setPerson_groubuy_price(String person_groubuy_price) {
        this.person_groubuy_price = person_groubuy_price;
    }

    public String getGroubuy_price() {
        return groubuy_price;
    }

    public void setGroubuy_price(String groubuy_price) {
        this.groubuy_price = groubuy_price;
    }


    public GrouBuyMeiZhuangGvBean(String name, String used_price, String person_groubuy_price, String groubuy_price, int imageUrl) {
        this.name = name;
        this.used_price = used_price;
        this.person_groubuy_price = person_groubuy_price;
        this.groubuy_price = groubuy_price;
        this.imageUrl = imageUrl;
    }
}
