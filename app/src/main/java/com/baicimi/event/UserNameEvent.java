package com.baicimi.event;

/**
 * 文件名：InfoSexEvent
 * 描    述：性别传递事件
 * 时    间：2016-01-18
 * 版    权：
 */
public class UserNameEvent {

    private String name;

    public UserNameEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}