package com.baicimi.entity;

/**
 * Created by Administrator on 2017/11/3.
 * 个人中心  客户服务  投诉与建议二级页面listvie实体类
 */
public class ComplaintSuggestSecondEntry {
    private String topNumber;
    private int imageUrl;
    private String name;
    private String addeptNumber;
    private String codeNumber;


    public ComplaintSuggestSecondEntry(String topNumber, int imageUrl, String name, String addeptNumber, String codeNumber) {
        this.topNumber = topNumber;
        this.imageUrl = imageUrl;
        this.name = name;
        this.addeptNumber = addeptNumber;
        this.codeNumber = codeNumber;
    }


    public String getTopNumber() {
        return topNumber;
    }

    public void setTopNumber(String topNumber) {
        this.topNumber = topNumber;
    }

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

    public String getAddeptNumber() {
        return addeptNumber;
    }

    public void setAddeptNumber(String addeptNumber) {
        this.addeptNumber = addeptNumber;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }
}
