package com.baicimi.entity;

/**
 * Created by Administrator on 2017/10/26.
 * 个人中心，会员积分页面 使用积分listview 实体类
 *
 */
public class UseEntry {
    private int imageUrl;
    private String content;
    private String more;

    public UseEntry(int imageUrl, String content) {
        this.imageUrl = imageUrl;
        this.content = content;
    }

    public UseEntry(int imageUrl, String content, String more) {
        this.imageUrl = imageUrl;
        this.content = content;
        this.more = more;
    }


    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
