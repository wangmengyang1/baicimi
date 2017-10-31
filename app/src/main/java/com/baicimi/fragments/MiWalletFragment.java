package com.baicimi.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.activitys.ShowFragmentActivity;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/8/22.
 * 幂钱包界面
 */
public class MiWalletFragment extends BaseFragment {
    @ViewInject(R.id.img_erweima)
    private ImageView imageView;
    private TextView resultTextView;

    private ImageView live_server;


    private ImageView intimacyPayment;


    public static final int RESULT_OK = -1;
    /**
     * 显示扫描结果
     */
    private TextView mTextView ;
    /**
     * 显示扫描拍的图片
     */
    private ImageView mImageView;

    private int indext;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_miwallet, container, false);

        return view;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.login_back,R.id.img_kajuan,R.id.img_my_code,R.id.zhanghu_yue,R.id.img_mixinyongfen,R.id.img_shoujichongzhi,
            R.id.img_quanqiuhui,R.id.img_erweima , R.id.fragment_miwallet_live_server , R.id.fragment_miwallet_brand_card ,
            R.id.fragment_miwallet_intimacy_payment , R.id.fragment_miwallet_image_mybystages})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
            case R.id.img_my_code:
//                startFragment(new MyCodeFragment(),null);
                startFragment(new MiWalldtMyCodeFragment(),null);//我的积分（新）
                break;
            case R.id.zhanghu_yue:
                startFragment(new ZhanghuYuEFragment(),null);
                break;
            case R.id.img_mixinyongfen:
                startFragment(new MiXinYongFragment(),null);
                break;
            case R.id.img_shoujichongzhi:
                startFragment(new PhoneChongZhiFragment(),null);
                break;
            case R.id.img_quanqiuhui:
                startFragment(new QuanQiuHuiFragment(),null);
                break;
            case R.id.img_erweima:
                startActivity(new Intent(getActivity(),
                        ShowFragmentActivity.class));
                break;
            case R.id.fragment_miwallet_live_server://生活服务首页
                startFragment(new MiWalletLiveServer());
                break;
            case R.id.fragment_miwallet_brand_card://添加银行卡
                startFragment(new MiWalletLiveBrandCard());
                break;
            case R.id.fragment_miwallet_intimacy_payment://亲密付
                startFragment(new IntimacyPaymentHomePageFragment());
                break;

            case R.id.fragment_miwallet_image_mybystages://我的分期
//                startFragment(new MiWalletFragmentMybustages());
                startFragment(new MiWalletMybustagesFirst());
                break;
            case R.id.img_kajuan:
                //优惠券

                if (indext % 3 == 0){
                    startFragment(new MiWalletDiscountCouponFirst("团购优惠券"));
                }else if (indext % 3 == 1){
                    startFragment(new MiWalletDiscountCouponFirst("限量优惠券"));
                }else if (indext % 3 == 2){
                    startFragment(new MiWalletDiscountCouponFirst("政府采购优惠券"));
                }
                indext++;
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 处理扫描结果（在界面上显示）
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            resultTextView.setText(scanResult);
        }
    }

}
