package com.baicimi.entity;

/**
 * Created by Administrator on 2017/4/10.
 */
public class NewUserEntry {
    private int imageUrl;
    private String lible;
    private String lible_content;
    private String lible_state;
    private String new_integral;
    private String integral_number;
    private String exchange_number;


    public NewUserEntry(int imageUrl, String lible, String lible_content, String lible_state, String new_integral, String integral_number, String exchange_number) {
        this.imageUrl = imageUrl;
        this.lible = lible;
        this.lible_content = lible_content;
        this.lible_state = lible_state;
        this.new_integral = new_integral;
        this.integral_number = integral_number;
        this.exchange_number = exchange_number;
    }

    public NewUserEntry() {
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

    public String getLible_content() {
        return lible_content;
    }

    public void setLible_content(String lible_content) {
        this.lible_content = lible_content;
    }

    public String getLible_state() {
        return lible_state;
    }

    public void setLible_state(String lible_state) {
        this.lible_state = lible_state;
    }

    public String getNew_integral() {
        return new_integral;
    }

    public void setNew_integral(String new_integral) {
        this.new_integral = new_integral;
    }

    public String getIntegral_number() {
        return integral_number;
    }

    public void setIntegral_number(String integral_number) {
        this.integral_number = integral_number;
    }

    public String getExchange_number() {
        return exchange_number;
    }

    public void setExchange_number(String exchange_number) {
        this.exchange_number = exchange_number;
    }
}
