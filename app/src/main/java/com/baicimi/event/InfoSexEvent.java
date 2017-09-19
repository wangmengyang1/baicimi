package com.baicimi.event;

/**
 * 文件名：InfoSexEvent
 * 描    述：性别传递事件
 * 时    间：2016-01-18
 * 版    权：
 */
public class InfoSexEvent {

    private int sex;

    public InfoSexEvent(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }


}