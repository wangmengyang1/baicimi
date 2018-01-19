package com.baicimi.entity;

/**
 * Created by Administrator on 2018/1/18.
 * 个人中心设置界面 地址管理 listview实体类
 */
public class UserCenterHomePagerSettingAddressManagerEntry {
    private String name;
    private String number;
    private String address;
    private boolean ischeck;


    public UserCenterHomePagerSettingAddressManagerEntry(String name, String number, String address, boolean ischeck) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.ischeck = ischeck;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean ischeck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }
}
