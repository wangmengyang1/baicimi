package com.baicimi.event;

/**
 * 文件名：CityEvent
 * 描    述：城市名称传递事件
 * 时    间：2016-03-02
 * 版    权：
 */
public class CityEvent {
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CityEvent(String city) {
        this.city = city;
    }

    private String city;
}
