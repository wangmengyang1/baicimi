package com.baicimi.entity;

/**
 * Created by Administrator on 2017/12/7.
 * 运动页面 首页 每日任务 listview 实体类
 */
public class FootPaintEveryTaskEntry {
    private String lible;
    private String content;
    private boolean state;


    public FootPaintEveryTaskEntry(String lible, String content, boolean state) {
        this.lible = lible;
        this.content = content;
        this.state = state;
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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
