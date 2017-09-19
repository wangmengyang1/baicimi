package com.baicimi.event;

/**
 * 文件名：InfoNameBus
 * 描    述：姓名传递事件
 * 作    者：穆琨
 * 时    间：2016-03-01
 */
public class InfoLoveNameEvent {

    private String name;

    public InfoLoveNameEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

}