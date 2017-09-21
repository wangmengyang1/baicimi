package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.datetime.MyCountDownTimer;
import com.baicimi.image.GlideImageLoader;
import com.baicimi.view.ShopingPackageDialog;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/10/14.
 * 首页美妆个护页面
 */
public class MeiZhuangFragment extends BaseFragment implements View.OnClickListener {
    /**
     * 定义图片横向轮播变量
     * */
    private LinearLayout mGallery,mGallery2;
    private int[] mImgIds,mImgIds2;
    private LayoutInflater mInflater,mInflater2;

    //设置顶部按钮点击事件
    private LinearLayout cosmetics;//彩妆
    private LinearLayout skincare;//护肤
    private LinearLayout hairdressing;//美发
    private LinearLayout man;//男士
    private LinearLayout aromatherapy;//香薰
    private LinearLayout suit;//套装
    private LinearLayout hotsale;//热卖
    private LinearLayout hot_search;//热搜

    //热卖推荐
    private View recommend_02;
    private View recommend_03;
    private View recommend_04;
    //新品上市
    private View new_appear_market_01;
    private View new_appear_market_02;
    private View new_appear_market_03;
    private View new_appear_market_04;
    //品牌活动
    private View brand_activity_01;
    private View brand_activity_02;
    private View brand_activity_03;
//    //专属分类

    //猜你喜欢
    private LinearLayout guess_me_love_01;
    private LinearLayout guess_me_love_02;
    private LinearLayout guess_me_love_03;
    private LinearLayout guess_me_love_04;
    private LinearLayout guess_me_love_05;
    private LinearLayout guess_me_love_06;
    //了解更多
    private ImageView img;
    //优惠闪购倒计时
    private TextView textView_dt;
    private MyCountDownTimer downTimer;

    //头部轮播图集合
    List<Integer> images = new ArrayList<>();
    List<String> titles = new ArrayList<>();


    private ImageView shopingPackage_01 , shopingPackage_02 ,shopingPackage_03 ,shopingPackage_04 ,shopingPackage_05 ,shopingPackage_06 ;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_meizhuang,container,false);

        images.clear();
        titles.clear();

        for(int i = 0 ; i < 3 ; i++){
            images.add(R.mipmap.beautymakeup_hand);
            titles.add(new String(""));
        }

        //头部轮播图片
        Banner banner = (Banner)view.findViewById(R.id.fragment_meizhuang_banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                startFragment(new SerchGoodsFragment(),null);
            }
        });



        /**
         * 图片横向轮播/品牌推荐
         * */
        mInflater = LayoutInflater.from(getContext());
        mImgIds = new int[]{R.mipmap.bestseller_recommend_01, R.mipmap.bestseller_recommend_02, R.mipmap.bestseller_recommend_03,
                R.mipmap.bestseller_recommend_04, R.mipmap.bestseller_recommend_05 ,R.mipmap.bestseller_recommend_06};
        mGallery = (LinearLayout) view.findViewById(R.id.remaituijian);

        for (int i = 0; i < mImgIds.length; i++) {
            View view = mInflater.inflate(R.layout.activity_index_gallery_item,
                    mGallery, false);
            img = (ImageView) view
                    .findViewById(R.id.id_index_gallery_item_image);
            Glide.with(getContext())
                    .load(mImgIds[i])
                    .into(img);
//            img.setImageResource(mImgIds[i]);
            img.setOnClickListener(this);
            mGallery.addView(view);

        }

        /**
         * 图片横向轮播/热门品牌
         * */
        mInflater2 = LayoutInflater.from(getContext());
        mImgIds2 = new int[]{R.mipmap.remen1, R.mipmap.remen2, R.mipmap.remen3,
                R.mipmap.remen4, R.mipmap.remen4, R.mipmap.remen4};
        mGallery2 = (LinearLayout) view.findViewById(R.id.id_gallery2);

        for (int i = 0; i < mImgIds2.length; i++) {

            View view = mInflater2.inflate(R.layout.activity_index_gallery_item2,
                    mGallery2, false);
            ImageView img1 = (ImageView) view
                    .findViewById(R.id.id_index_gallery_item_image3);
            Glide.with(getContext())
                    .load(mImgIds2[i])
                    .into(img1);
//            img1.setImageResource(mImgIds2[i]);
            img1.setOnClickListener(this);
            mGallery2.addView(view);

            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startFragment(new BrandFragmentSecond());
                }
            });

        }






        //控件查找类
        initListUI();

        /**
         * 美妆头部控件查找点击事件（8个按键）
         * 修改日期：2017-3-23
         * 修改人：王梦阳
         *
         */
        //头部按键
        initUI();

        //倒计时
        getTimer();


        //购物包弹窗
        initShopingPackage();

        return view;
    }
    //购物包弹窗
    private void initShopingPackage() {
        shopingPackage_01 = (ImageView) view.findViewById(R.id.fragment_meizhuang_shoping_package_01);
        shopingPackage_02 = (ImageView) view.findViewById(R.id.fragment_meizhuang_shoping_package_02);
        shopingPackage_03 = (ImageView) view.findViewById(R.id.fragment_meizhuang_shoping_package_03);
        shopingPackage_04 = (ImageView) view.findViewById(R.id.fragment_meizhuang_shoping_package_04);
        shopingPackage_05 = (ImageView) view.findViewById(R.id.fragment_meizhuang_shoping_package_05);
        shopingPackage_06 = (ImageView) view.findViewById(R.id.fragment_meizhuang_shoping_package_06);
        shopingPackage_01.setOnClickListener(this);
        shopingPackage_02.setOnClickListener(this);
        shopingPackage_03.setOnClickListener(this);
        shopingPackage_04.setOnClickListener(this);
        shopingPackage_05.setOnClickListener(this);
        shopingPackage_06.setOnClickListener(this);
    }

    //控件查找类
    private void initListUI() {
        recommend_02 = view.findViewById(R.id.meizhuang_hot_recommend_02);
        recommend_03 = view.findViewById(R.id.meizhuang_hot_recommend_03);
        recommend_04 = view.findViewById(R.id.meizhuang_hot_recommend_04);
        recommend_02.setOnClickListener(this);
        recommend_03.setOnClickListener(this);
        recommend_04.setOnClickListener(this);

        new_appear_market_01 = view.findViewById(R.id.meizhuang_new_appear_market_01);
        new_appear_market_02 = view.findViewById(R.id.meizhuang_new_appear_market_02);
        new_appear_market_03 = view.findViewById(R.id.meizhuang_new_appear_market_03);
        new_appear_market_04 = view.findViewById(R.id.meizhuang_new_appear_market_04);
        new_appear_market_01.setOnClickListener(this);
        new_appear_market_02.setOnClickListener(this);
        new_appear_market_03.setOnClickListener(this);
        new_appear_market_04.setOnClickListener(this);

        brand_activity_01 = view.findViewById(R.id.meizhuang_brand_activity_01);
        brand_activity_02 = view.findViewById(R.id.meizhuang_brand_activity_02);
        brand_activity_03 = view.findViewById(R.id.meizhuang_brand_activity_03);
        brand_activity_01.setOnClickListener(this);
        brand_activity_02.setOnClickListener(this);
        brand_activity_03.setOnClickListener(this);


        guess_me_love_01 = (LinearLayout) view.findViewById(R.id.meizhuang_guess_me_love_01);
        guess_me_love_02 = (LinearLayout) view.findViewById(R.id.meizhuang_guess_me_love_02);
        guess_me_love_03 = (LinearLayout) view.findViewById(R.id.meizhuang_guess_me_love_03);
        guess_me_love_04 = (LinearLayout) view.findViewById(R.id.meizhuang_guess_me_love_04);
        guess_me_love_05 = (LinearLayout) view.findViewById(R.id.meizhuang_guess_me_love_05);
        guess_me_love_06 = (LinearLayout) view.findViewById(R.id.meizhuang_guess_me_love_06);
        guess_me_love_01.setOnClickListener(this);
        guess_me_love_02.setOnClickListener(this);
        guess_me_love_03.setOnClickListener(this);
        guess_me_love_04.setOnClickListener(this);
        guess_me_love_05.setOnClickListener(this);
        guess_me_love_06.setOnClickListener(this);
    }

    //头部按键
    private void initUI() {
        cosmetics = (LinearLayout) view.findViewById(R.id.frgment_meizhuang_cosmetics);
        skincare = (LinearLayout) view.findViewById(R.id.frgment_meizhuang_skincare);
        hairdressing = (LinearLayout) view.findViewById(R.id.frgment_meizhuang_hairdressing);
        man = (LinearLayout) view.findViewById(R.id.frgment_meizhuang_man);
        aromatherapy = (LinearLayout) view.findViewById(R.id.frgment_meizhuang_aromatherapy);
        suit = (LinearLayout) view.findViewById(R.id.frgment_meizhuang_suit);
        hotsale = (LinearLayout) view.findViewById(R.id.frgment_meizhuang_hotsale);
        hot_search = (LinearLayout) view.findViewById(R.id.frgment_meizhuang_hot_search);
        //点击事件
        cosmetics.setOnClickListener(this);
        skincare.setOnClickListener(this);
        hairdressing.setOnClickListener(this);
        man.setOnClickListener(this);
        aromatherapy.setOnClickListener(this);
        suit.setOnClickListener(this);
        hotsale.setOnClickListener(this);
        hot_search.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.frgment_meizhuang_cosmetics:
                //页面跳转到商品筛选页面
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.frgment_meizhuang_skincare:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.frgment_meizhuang_hairdressing:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.frgment_meizhuang_man:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.frgment_meizhuang_aromatherapy:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.frgment_meizhuang_suit:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.frgment_meizhuang_hotsale:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.frgment_meizhuang_hot_search:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.meizhuang_hot_recommend_02:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.meizhuang_hot_recommend_03:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.meizhuang_hot_recommend_04:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.meizhuang_new_appear_market_01:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.meizhuang_new_appear_market_02:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.meizhuang_new_appear_market_03:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.meizhuang_new_appear_market_04:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.meizhuang_brand_activity_01:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.meizhuang_brand_activity_02:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.meizhuang_brand_activity_03:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.meizhuang_guess_me_love_01:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.meizhuang_guess_me_love_02:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.meizhuang_guess_me_love_03:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.meizhuang_guess_me_love_04:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.meizhuang_guess_me_love_05:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.meizhuang_guess_me_love_06:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.id_index_gallery_item_image:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.id_index_gallery_item_image3:
                startFragment(new PopularityBrandFragment() , null);
                break;
            case R.id.fragment_meizhuang_shoping_package_01:
                ShopingPackageDialog shopingPackageDialog01 = new ShopingPackageDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                shopingPackageDialog01.show();
                break;
            case R.id.fragment_meizhuang_shoping_package_02:
                ShopingPackageDialog shopingPackageDialog02 = new ShopingPackageDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                shopingPackageDialog02.show();
                break;
            case R.id.fragment_meizhuang_shoping_package_03:
                ShopingPackageDialog shopingPackageDialog03 = new ShopingPackageDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                shopingPackageDialog03.show();
                break;
            case R.id.fragment_meizhuang_shoping_package_04:
                ShopingPackageDialog shopingPackageDialog04 = new ShopingPackageDialog(getContext(), R.style.MeiGuiMeiShiSecondMyorderFive);
                shopingPackageDialog04.show();
                break;
            case R.id.fragment_meizhuang_shoping_package_05:
                ShopingPackageDialog shopingPackageDialog05 = new ShopingPackageDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                shopingPackageDialog05.show();
                break;
            case R.id.fragment_meizhuang_shoping_package_06:
                ShopingPackageDialog shopingPackageDialog06 = new ShopingPackageDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                shopingPackageDialog06.show();
                break;

        }
    }

    //倒计时
    private void getTimer(){
        textView_dt = (TextView) view.findViewById(R.id.meizhuang_downtimer);
        downTimer = new MyCountDownTimer(System.currentTimeMillis() , 1000 , textView_dt);
        downTimer.start();
    }

    @Override
    public void onDetach() {
        if (view != null){
            view = null;

        }
        System.gc();
        super.onDetach();


    }

}
