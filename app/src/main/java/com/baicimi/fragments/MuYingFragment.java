package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.HeadPinPaiActivityGvAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.ShaiXuanListBean;
import com.baicimi.datetime.MyCountDownTimer;
import com.baicimi.image.GlideImageLoader;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/10/14.
 * 首页母婴用品页面
 */
public class MuYingFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    /**
     * 母婴用品gridview
     * */
    private GridView gridView;


    private List<ShaiXuanListBean> listBeen;
    private HeadPinPaiActivityGvAdapter xuanGvAdapter;
    final ShaiXuanListBean shaiXuanListBean_list=new ShaiXuanListBean();

    //头部类控件
    private ImageView mommy;
    private ImageView paperdiaper;
    private ImageView feed;
    private ImageView bauble;
//    private ImageView category;
    //热卖推荐
    private View hot_recommend_01;
    private View hot_recommend_02;
    private View hot_recommend_03;
    private View hot_recommend_04;
    private View hot_recommend_05;
    //新品上市
    private View new_appear_market_01;
    private View new_appear_market_02;
    private View new_appear_market_03;
    private View new_appear_market_04;
    //玩具
    private View bauble_01;
    private View bauble_02;
    private View bauble_03;
    //活动专场
    private View activity_performance_01;
    private View activity_performance_02;
    private View activity_performance_03;
    //优惠闪购倒计时
    private TextView downTimer_my;
    private MyCountDownTimer downTimer;

    //头部轮播图集合
    List<Integer> images = new ArrayList<>();
    List<String> titles = new ArrayList<>();

    private int[] mImgIds,mImgIds2;
    private LinearLayout mGallery,mGallery2;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_muying_use,container,false);

        //头部轮播方法
        initBanner();

        /**
         * 母婴用品头部按键查找以及点击事件设置
         * 修改时间：2016-3-23
         * 修改人：王梦阳
         */
        //控件查找以及点击事件
        initUI();

        //倒计时
        getTimer();


        /**
         * 底部GridView
         * */
        gridView= (GridView) view.findViewById(R.id.muyin_grideview1);
        listBeen=new ArrayList<>();
        for (int i=0;i<6;i++){
            shaiXuanListBean_list.setTv_goods_name("洗发水");
            shaiXuanListBean_list.setTv_jifendikou_num("5000");
            shaiXuanListBean_list.setJifendikou_mony_num("100");
            shaiXuanListBean_list.setTv_now_price("8908.00");
            shaiXuanListBean_list.setTv_used_price("9008.00");
            listBeen.add(shaiXuanListBean_list);
        }
        xuanGvAdapter=new HeadPinPaiActivityGvAdapter(getActivity(),listBeen , this);
        gridView.setAdapter(xuanGvAdapter);
        fixListViewHeight(gridView);

        //热门品牌
        initHotBrnners();

        return view;
    }
    //热门品牌
    private void initHotBrnners() {
        /**
         * 图片横向轮播/热门品牌
         * */
        LayoutInflater mInflater2 = LayoutInflater.from(getContext());
        mImgIds2 = new int[]{R.mipmap.remen1, R.mipmap.remen2, R.mipmap.remen3,
                R.mipmap.remen4, R.mipmap.remen4, R.mipmap.remen4};
        mGallery2 = (LinearLayout) view.findViewById(R.id.id_gallery2_muying);

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

    //控件查找以及点击事件
    private void initUI() {
        mommy = (ImageView) view.findViewById(R.id.fragment_muying_mommy);
        paperdiaper = (ImageView) view.findViewById(R.id.fragment_muying_paperdiaper);
        feed = (ImageView) view.findViewById(R.id.fragment_muying_feed);
        bauble = (ImageView) view.findViewById(R.id.fragment_muying_bauble);
//        category = (ImageView) view.findViewById(R.id.muying_more_category);
        //设置点击事件
        mommy.setOnClickListener(this);
        paperdiaper.setOnClickListener(this);
        feed.setOnClickListener(this);
        bauble.setOnClickListener(this);
//        category.setOnClickListener(this);

        hot_recommend_01 = view.findViewById(R.id.muying_hot_recommend_01);
        hot_recommend_02 = view.findViewById(R.id.muying_hot_recommend_02);
        hot_recommend_03 = view.findViewById(R.id.muying_hot_recommend_03);
        hot_recommend_04 = view.findViewById(R.id.muying_hot_recommend_04);
        hot_recommend_05 = view.findViewById(R.id.muying_hot_recommend_05);
        hot_recommend_01.setOnClickListener(this);
        hot_recommend_02.setOnClickListener(this);
        hot_recommend_03.setOnClickListener(this);
        hot_recommend_04.setOnClickListener(this);
        hot_recommend_05.setOnClickListener(this);

        new_appear_market_01 = view.findViewById(R.id.muying_new_appear_market_01);
        new_appear_market_02 = view.findViewById(R.id.muying_new_appear_market_02);
        new_appear_market_03 = view.findViewById(R.id.muying_new_appear_market_03);
        new_appear_market_04 = view.findViewById(R.id.muying_new_appear_market_04);
        new_appear_market_01.setOnClickListener(this);
        new_appear_market_02.setOnClickListener(this);
        new_appear_market_03.setOnClickListener(this);
        new_appear_market_04.setOnClickListener(this);

        bauble_01 = view.findViewById(R.id.muying_bauble_01);
        bauble_02 = view.findViewById(R.id.muying_bauble_02);
        bauble_03 = view.findViewById(R.id.muying_bauble_03);
        bauble_01.setOnClickListener(this);
        bauble_02.setOnClickListener(this);
        bauble_03.setOnClickListener(this);

        activity_performance_01 = view.findViewById(R.id.muying_activity_performance_01);
        activity_performance_02 = view.findViewById(R.id.muying_activity_performance_02);
        activity_performance_03 = view.findViewById(R.id.muying_activity_performance_03);
        activity_performance_01.setOnClickListener(this);
        activity_performance_02.setOnClickListener(this);
        activity_performance_03.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_muying_mommy:
                //页面跳转到商品筛选页面
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_muying_paperdiaper:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_muying_feed:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_muying_bauble:
                startFragment(new SerchGoodsFragment(),null);
                break;
//            case R.id.muying_more_category:
//                startFragment(new SerchGoodsFragment(),null);
//                break;
            case R.id.muying_hot_recommend_01:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.muying_hot_recommend_02:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.muying_hot_recommend_03:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.muying_hot_recommend_04:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.muying_hot_recommend_05:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.muying_new_appear_market_01:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.muying_new_appear_market_02:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.muying_new_appear_market_03:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.muying_new_appear_market_04:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.muying_bauble_01:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.muying_bauble_02:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.muying_bauble_03:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.muying_activity_performance_01:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.muying_activity_performance_02:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.muying_activity_performance_03:
                startFragment(new SerchGoodsFragment(),null);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        //第二个值需要进行设置（数据暂无）
        startFragment(new GoodsDetailsFragment(),null);
    }


    //倒计时
    private void getTimer(){
        downTimer_my = (TextView) view.findViewById(R.id.muying_downtimer);
        downTimer = new MyCountDownTimer(System.currentTimeMillis() , 1000 , downTimer_my);
        downTimer.start();
    }


    //头部轮播方法
    private void initBanner() {
        images.clear();
        titles.clear();
        for(int i = 0 ; i < 3 ; i++){
            images.add(R.mipmap.muying1);
            titles.add(new String(""));
        }

        //头部轮播图片
        Banner banner = (Banner)view.findViewById(R.id.fragment_muying_banner);
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
    }


    //动态计算listview的高度
    public void fixListViewHeight(GridView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        HeadPinPaiActivityGvAdapter listAdapter = (HeadPinPaiActivityGvAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount()/2; index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


    @Override
    public void onDetach() {
        if (view != null){
            xuanGvAdapter = null;
            view = null;

        }
        System.gc();
        super.onDetach();


    }

}
