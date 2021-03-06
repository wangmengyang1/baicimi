package com.baicimi.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.MyViewPagerFragmetAdapterSecond;
import com.baicimi.base.BaseFragment;
import com.baicimi.datetime.MyCountDownTimer;
import com.baicimi.image.GlideImageLoader;
import com.baicimi.interfaces.DistributionNumberOnitemClick;
import com.baicimi.ui.PersonUserPagerSlidingTabStrip;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/10/14.
 * 首页个人用品页面
 */
public class PerSonUseFragment extends BaseFragment implements View.OnClickListener , DistributionNumberOnitemClick {

    private ViewPager viewPager_huodpng;
    private PersonUserPagerSlidingTabStrip tabs;
    DisplayMetrics dm;

    private GeDianFragment geDianFragment , chuangShangFragment , juJiaFragment , huWaiFragment;
    private String[] titles = {"个护电器", "床上用品", "居家休闲", "户外运动"};

    //头部分类的控件

    //热卖推荐
    private View hot_recommend_01;
    private View hot_recommend_02;
    private View hot_recommend_03;
    //新品上市
    private View new_appear_market_01;
//    private View new_appear_market_02;
//    private View new_appear_market_03;
//    private View new_appear_market_04;
    //优惠闪购
    private RelativeLayout favorable_sales_01;
    private RelativeLayout favorable_sales_02;
    //活动专场
    private LinearLayout activity_session_01;
    private LinearLayout activity_session_02;
    private LinearLayout activity_session_03;
    //事件倒计时
    private TextView downTimer_tv;
    private MyCountDownTimer downTimer;


    //头部轮播图集合
    List<Integer> images = new ArrayList<>();
    List<String> title = new ArrayList<>();


    private MyViewPagerFragmetAdapterSecond myViewPagerFragmetAdapterSecond;
    private List<Fragment> listFragment = new ArrayList<>();

    private LinearLayout electric , beddings , relaxations , accs , sports , lvxing , packageas;


    private LinearLayout mGallery,mGallery2;
    private int[] mImgIds,mImgIds2;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_person_use,container,false);

        //头部轮播方法
        initBanner();

        initAddFragment();


        //活动专场viewpage
        dm = getResources().getDisplayMetrics();
        viewPager_huodpng = (ViewPager) view.findViewById(R.id.vp_huodong);
        tabs = (PersonUserPagerSlidingTabStrip) view.findViewById(R.id.huodongzhuanchang);
        viewPager_huodpng.setAdapter(new MyViewPagerFragmetAdapterSecond(getChildFragmentManager() , listFragment , titles));
        tabs.setViewPager(viewPager_huodpng);

        /**
         * 个人用品头部按键查找以及点击事件设置
         * 修改时间：2016-3-23
         * 修改人：王梦阳
         */
        //控件查找以及点击事件
//        initUI();

        //倒计时
        getTimer();


        //导航栏布局填充
        initNavigation();

        //品牌
        initBrnner();


        return view;
    }

    //品牌
    private void initBrnner() {
        /**
         * 图片横向轮播/热门品牌
         * */
        LayoutInflater mInflater2 = LayoutInflater.from(getContext());
        mImgIds2 = new int[]{R.mipmap.remen1, R.mipmap.remen2, R.mipmap.remen3,
                R.mipmap.remen4, R.mipmap.remen4, R.mipmap.remen4};
        mGallery2 = (LinearLayout) view.findViewById(R.id.id_gallery2_person_user);

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
    }

    //导航栏布局填充
    private void initNavigation() {
        electric = (LinearLayout) view.findViewById(R.id.fragment_person_user_electric);
        beddings = (LinearLayout) view.findViewById(R.id.fragment_person_user_beddings);
        relaxations = (LinearLayout) view.findViewById(R.id.fragment_person_user_relaxation);
        accs = (LinearLayout) view.findViewById(R.id.fragment_person_user_acc);
        sports = (LinearLayout) view.findViewById(R.id.fragment_person_user_sports);
        lvxing = (LinearLayout) view.findViewById(R.id.fragment_person_user_lvxing);
        packageas = (LinearLayout) view.findViewById(R.id.fragment_person_user_package);
        electric.setOnClickListener(this);
        beddings.setOnClickListener(this);
        relaxations.setOnClickListener(this);
        accs.setOnClickListener(this);
        sports.setOnClickListener(this);
        lvxing.setOnClickListener(this);
        packageas.setOnClickListener(this);
    }

    private void initAddFragment() {
        listFragment.clear();
        listFragment.add(new GeDianFragment(this));
        listFragment.add(new GeDianFragment(this));
        listFragment.add(new GeDianFragment(this));
        listFragment.add(new GeDianFragment(this));
    }

    //控件查找以及点击事件
//    private void initUI() {
//        person = (TextView) view.findViewById(R.id.fragment_person_electric);
//        beddingarticle = (TextView) view.findViewById(R.id.fragment_person_beddingarticle);
//        relaxation = (TextView) view.findViewById(R.id.fragment_person_home_relaxation);
//        acc = (TextView) view.findViewById(R.id.fragment_person_acc);
//        outdoor = (TextView) view.findViewById(R.id.fragment_person_outdoor);
//        travel = (TextView) view.findViewById(R.id.fragment_person_travel);
//        packages = (TextView) view.findViewById(R.id.fragment_person_packages);
//        more = (TextView) view.findViewById(R.id.fragment_person_more);
//        //为控件设置点击事件
//        person.setOnClickListener(this);
//        beddingarticle.setOnClickListener(this);
//        relaxation.setOnClickListener(this);
//        acc.setOnClickListener(this);
//        outdoor.setOnClickListener(this);
//        travel.setOnClickListener(this);
//        packages.setOnClickListener(this);
//        more.setOnClickListener(this);
//
//
//        hot_recommend_01 = view.findViewById(R.id.person_use_hot_recommend_01);
//        hot_recommend_02 = view.findViewById(R.id.person_use_hot_recommend_02);
//        hot_recommend_03 = view.findViewById(R.id.person_use_hot_recommend_03);
//        hot_recommend_01.setOnClickListener(this);
//        hot_recommend_02.setOnClickListener(this);
//        hot_recommend_03.setOnClickListener(this);
//
//        new_appear_market_01 = view.findViewById(R.id.person_use_new_appear_market_01);
////        new_appear_market_02 = view.findViewById(R.id.person_use_new_appear_market_02);
////        new_appear_market_03 = view.findViewById(R.id.person_use_new_appear_market_03);
////        new_appear_market_04 = view.findViewById(R.id.person_use_new_appear_market_04);
//        new_appear_market_01.setOnClickListener(this);
////        new_appear_market_02.setOnClickListener(this);
////        new_appear_market_03.setOnClickListener(this);
////        new_appear_market_04.setOnClickListener(this);
//
//        favorable_sales_01 = (RelativeLayout) view.findViewById(R.id.person_user_favorable_sales_01);
//        favorable_sales_02 = (RelativeLayout) view.findViewById(R.id.person_user_favorable_sales_02);
//        favorable_sales_01.setOnClickListener(this);
//        favorable_sales_02.setOnClickListener(this);
//
//        activity_session_01 = (LinearLayout) view.findViewById(R.id.person_use_activity_session_01);
//        activity_session_02 = (LinearLayout) view.findViewById(R.id.person_use_activity_session_02);
//        activity_session_03 = (LinearLayout) view.findViewById(R.id.person_use_activity_session_03);
//        activity_session_01.setOnClickListener(this);
//        activity_session_02.setOnClickListener(this);
//        activity_session_03.setOnClickListener(this);
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_person_user_electric:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_person_user_beddings:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_person_user_relaxation:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_person_user_acc:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_person_user_sports:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_person_user_lvxing:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_person_user_package:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.person_use_hot_recommend_01:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.person_use_hot_recommend_02:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.person_use_hot_recommend_03:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.person_use_new_appear_market_01:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.person_user_favorable_sales_01:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.person_user_favorable_sales_02:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.person_use_activity_session_01:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.person_use_activity_session_02:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.person_use_activity_session_03:
                startFragment(new GoodsDetailsFragment(),null);
                break;
        }
    }

    @Override
    public void setNumberOnitemClick(View view, int i, long l) {
        if(this.view != null){
            int viewHeight = i;
            ViewGroup.LayoutParams layoutParams = viewPager_huodpng.getLayoutParams();
            layoutParams.height = 1865;
            viewPager_huodpng.setLayoutParams(layoutParams);
        }
    }


    @Override
    protected void initData() {

    }


    //倒计时
    private void getTimer(){
        downTimer_tv = (TextView) view.findViewById(R.id.fragment_person_use_downtimer);
        downTimer = new MyCountDownTimer(System.currentTimeMillis() , 1000 , downTimer_tv);
        downTimer.start();
    }


    //头部轮播方法
    private void initBanner() {
        title.clear();
        images.clear();
        for(int i = 0 ; i < 3 ; i++){

            title.add(new String(""));
            images.add(R.mipmap.gerenlunbi1);
        }

        //头部轮播图片
        Banner banner = (Banner)view.findViewById(R.id.fragment_person_use_banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(title);
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
    }
}
