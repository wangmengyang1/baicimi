package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.baicimi.R;
import com.baicimi.adapter.GreenFoodGridViewAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.ShaiXuanListBean;
import com.baicimi.image.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 * 绿色食品首页布局
 */
public class GreenFoodFragment extends BaseFragment{

    private View view;
    //头部轮播图集合
    List<Integer> images = new ArrayList<>();
    List<String> title = new ArrayList<>();

    private GridView gridView_01 , gridView_02 ,gridView_03 ,gridView_04 ,gridView_05 ;
    private List<ShaiXuanListBean> list_01 , list_02 , list_03 , list_04 , list_05 ;
    private GreenFoodGridViewAdapter adapter_01 ,adapter_02 ,adapter_03 ,adapter_04 ,adapter_05 ;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.green_food_fragment , container , false);
        //头部轮播方法
        initBanner();


        //gridview布局填充
        initGridView();

        return view;
    }

    //gridview布局填充
    private void initGridView() {
        gridView_01 = (GridView) view.findViewById(R.id.green_food_fragment_gridview_01);
        list_01 = new ArrayList<>();

        list_01.add(new ShaiXuanListBean("" , "水清浅青岛红苹果" , "5000" , "100" , "9899.00" , "8908.00" , R.drawable.green_food_image_15));
        list_01.add(new ShaiXuanListBean("" , "水清浅山东大枣" , "5000" , "100" , "9899.00" , "8908.00" , R.drawable.green_food_image_15));
        adapter_01 = new GreenFoodGridViewAdapter( list_01 , getContext() ,this);
        gridView_01.setAdapter(adapter_01);
    }


    //头部轮播方法
    private void initBanner() {
        title.clear();
        images.clear();
        for(int i = 0 ; i < 3 ; i++){

            title.add(new String(""));
            images.add(R.drawable.green_food_image_14);
        }

        //头部轮播图片
        Banner banner = (Banner)view.findViewById(R.id.green_food_fragment_banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.FlipHorizontal);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(title);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
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
    protected void initData() {

    }
}
