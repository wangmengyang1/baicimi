package com.baicimi.conf;


/**
 * Created by tan on 2016/8/31.
 */
public interface Constant {

    interface MyURL {
        String GIFT_CLASSIFY = "http://api.liwushuo.com/v2/item_categories/tree";//分类界面临时接口
        String REGISTER="http://www.baicimi.com/index/apireg.html?data=";//注册接口输入手机号码
        String PassWordNum="http://www.baicimi.com/index/apigetcode.html?phone=";//动态码短信验证码接口
        String INPortPassWordNum="http://www.baicimi.com/index/apitjcode.html?phone=";//输入动态码短信验
        String INPortPassWord=" http://www.baicimi.com/index/apiregs.html?phone=";//输入注册密码
        String LOGIN="  http://www.baicimi.com/index/apilogin.html?name=";//登录接口


    }

    //保存二维码扫描结果
    public static final String SCAN_RESULT="scan_result";
}
