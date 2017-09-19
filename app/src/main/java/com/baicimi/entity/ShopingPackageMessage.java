package com.baicimi.entity;

import com.baicimi.interfaces.MainShopPackageNumberClick;

/**
 * Created by Administrator on 2017/9/15.
 * 此类用于保存相关购物信息
 * 此处为单例模式（考虑到数据的唯一性）
 */

public class ShopingPackageMessage{

    public int shopingPackageMessageNumber = 0;


    public ShopingPackageMessage(int shopingPackageMessageNumber) {
        this.shopingPackageMessageNumber = shopingPackageMessageNumber;
    }

    public int getShopingPackageMessageNumber() {
        return shopingPackageMessageNumber;
    }

    public void setShopingPackageMessageNumber(int shopingPackageMessageNumber) {
        this.shopingPackageMessageNumber = shopingPackageMessageNumber;
    }

}
