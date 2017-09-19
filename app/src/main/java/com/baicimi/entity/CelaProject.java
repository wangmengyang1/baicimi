package com.baicimi.entity;

/**
 * Created by Administrator on 2017/3/27.
 */
public class CelaProject {
    private int ImageId;
    private String categoryName;
    private String[] category;

    public CelaProject(int imageId, String categoryName, String[] category) {
        ImageId = imageId;
        this.categoryName = categoryName;
        this.category = category;
    }

    public CelaProject(int imageId, String categoryName) {
        ImageId = imageId;
        this.categoryName = categoryName;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }
}
