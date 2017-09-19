package com.baicimi.fragments;

import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.baicimi.R;
import com.baicimi.adapter.HeadPinPaiActivityGvAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.ShaiXuanListBean;
import com.baicimi.image.GlideImageLoader;
import com.baicimi.view.MyViewPager;
import com.bumptech.glide.Glide;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by tan on 2016/10/14.
 * 首页畅销热卖页面
 */
public class ChangXiaoFragment extends BaseFragment {
    private ScheduledExecutorService scheduledExecutorService;
    private View huodong1,huodong2,huodong3,huodong4;
    private GridView gridView,gridView1,gridView2,gridView3;
    private List<ShaiXuanListBean> listBeen;
    private HeadPinPaiActivityGvAdapter xuanGvAdapter;
    final ShaiXuanListBean shaiXuanListBean_list=new ShaiXuanListBean();


    //头部轮播图集合
    List<Integer> images = new ArrayList<>();
    List<String> title = new ArrayList<>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_changxiao, container, false);

        //头部轮播方法
        initBanner();

        /**
         * 品牌活动跳转
         * */
        huodong1=view.findViewById(R.id.huodong1);
        huodong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startFragment(new PinPaiFragment(),null);
                startFragment(new GoodsDetailsFragment(),null);
            }
        });
        huodong2=view.findViewById(R.id.huodong2);
        huodong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startFragment(new PinPaiFragment(),null);
                startFragment(new GoodsDetailsFragment(),null);
            }
        });

        huodong3=view.findViewById(R.id.huodong3);
        huodong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startFragment(new PinPaiFragment(),null);
                startFragment(new GoodsDetailsFragment(),null);
            }
        });
        huodong4=view.findViewById(R.id.huodong4);
        huodong4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startFragment(new PinPaiFragment(),null);
                startFragment(new GoodsDetailsFragment(),null);
            }
        });


        /**
         * 洗发水
         * */
        gridView= (GridView) view.findViewById(R.id.xifa_grideview);
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

        /**
         * 沐浴露
         * */
        gridView1= (GridView) view.findViewById(R.id.muyu_grideview);
        listBeen=new ArrayList<>();
        for (int i=0;i<6;i++){
            shaiXuanListBean_list.setTv_goods_name("湿美白蚕丝面膜贴女没...");
            shaiXuanListBean_list.setTv_jifendikou_num("5000");
            shaiXuanListBean_list.setJifendikou_mony_num("100");
            shaiXuanListBean_list.setTv_now_price("8908.00");
            shaiXuanListBean_list.setTv_used_price("9008.00");
            listBeen.add(shaiXuanListBean_list);
        }
        xuanGvAdapter=new HeadPinPaiActivityGvAdapter(getActivity(),listBeen , this);
        gridView1.setAdapter(xuanGvAdapter);
        fixListViewHeight(gridView1);

        /**
         * 洗衣液
         * */
        gridView2= (GridView) view.findViewById(R.id.xiyi_grideview);
        listBeen=new ArrayList<>();
        for (int i=0;i<6;i++){
            shaiXuanListBean_list.setTv_goods_name("湿美白蚕丝面膜贴女没...");
            shaiXuanListBean_list.setTv_jifendikou_num("5000");
            shaiXuanListBean_list.setJifendikou_mony_num("100");
            shaiXuanListBean_list.setTv_now_price("8908.00");
            shaiXuanListBean_list.setTv_used_price("9008.00");
            listBeen.add(shaiXuanListBean_list);
        }
        xuanGvAdapter=new HeadPinPaiActivityGvAdapter(getActivity(),listBeen , this);
        gridView2.setAdapter(xuanGvAdapter);
        fixListViewHeight(gridView2);

        /**
         * 洗洁精
         * */
        gridView3= (GridView) view.findViewById(R.id.xijiejing_grideview);
        listBeen=new ArrayList<>();
        for (int i=0;i<6;i++){
            shaiXuanListBean_list.setTv_goods_name("湿美白蚕丝面膜贴女没...");
            shaiXuanListBean_list.setTv_jifendikou_num("5000");
            shaiXuanListBean_list.setJifendikou_mony_num("100");
            shaiXuanListBean_list.setTv_now_price("8908.00");
            shaiXuanListBean_list.setTv_used_price("9008.00");
            listBeen.add(shaiXuanListBean_list);
        }
        xuanGvAdapter=new HeadPinPaiActivityGvAdapter(getActivity(),listBeen , this);
        gridView3.setAdapter(xuanGvAdapter);
        fixListViewHeight(gridView3);
        return view;
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



    @OnClick({R.id.xifa,R.id.muyu,R.id.xiyiye,R.id.ximiannai})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.xifa:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.muyu:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.xiyiye:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.ximiannai:
                startFragment(new SerchGoodsFragment(),null);
                break;
        }
    }

    @Override
    protected void initData() {

    }


    //头部轮播方法
    private void initBanner() {
        title.clear();
        images.clear();
        for(int i = 0 ; i < 2 ; i++){

            title.add(new String(""));
            images.add(R.mipmap.changxiaolunboq1);
            title.add(new String(""));
            images.add(R.mipmap.changxiaolunboq2);
        }


        //头部轮播图片
        Banner banner = (Banner)view.findViewById(R.id.fragment_chaogxciao_banner);
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
