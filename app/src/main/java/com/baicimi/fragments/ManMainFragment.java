package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.baicimi.R;
import com.baicimi.adapter.HeadPinPaiActivityGvAdapter;
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
 * Created by tan on 2016/10/14.
 * 首页男士主页页面
 */
public class ManMainFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /**
     * 男士主页用品gridview
     * */
    private GridView gridView;


    private List<ShaiXuanListBean> listBeen;
    private HeadPinPaiActivityGvAdapter xuanGvAdapter;
    final ShaiXuanListBean shaiXuanListBean_list=new ShaiXuanListBean();



    //头部轮播图集合
    List<Integer> images = new ArrayList<>();
    List<String> titles = new ArrayList<>();

    //热卖推荐
    private View hot_01 , hot_02 , hot_03 , hot_04 , hot_05 , hot_brand_06 , hot_brand_07 , new_08 , new_09 , new_10 , new_11;

    //活动专场
    private LinearLayout activity_12 , activity_13 , activity_14;


    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_manmain,container,false);

        //头部轮播方法
        initBanner();

        //热卖推荐以及活动专场点击事件
        initUI();



        /**
         * 底部GridView
         * */
        gridView= (GridView) view.findViewById(R.id.manmain_gv);
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


        return view;
    }

    private void initUI() {
        hot_01 = view.findViewById(R.id.fragment_manmain_hot_01);
        hot_02 = view.findViewById(R.id.fragment_manmain_hot_02);
        hot_03 = view.findViewById(R.id.fragment_manmain_hot_03);
        hot_04 = view.findViewById(R.id.fragment_manmain_hot_04);
        hot_05 = view.findViewById(R.id.fragment_manmain_hot_05);
        hot_brand_06 = view.findViewById(R.id.fragment_manmain_hot_brand_06);
        hot_brand_07 = view.findViewById(R.id.fragment_manmain_hot_brand_07);
        new_08 = view.findViewById(R.id.fragment_manmain_new_08);
        new_09 = view.findViewById(R.id.fragment_manmain_new_09);
        new_10 = view.findViewById(R.id.fragment_manmain_new_10);
        new_11 = view.findViewById(R.id.fragment_manmain_new_11);
        activity_12 = (LinearLayout) view.findViewById(R.id.fragment_manmain_activity_12);
        activity_13 = (LinearLayout) view.findViewById(R.id.fragment_manmain_activity_13);
        activity_14 = (LinearLayout) view.findViewById(R.id.fragment_manmain_activity_14);

        //设置监听事件
        hot_01.setOnClickListener(this);
        hot_02.setOnClickListener(this);
        hot_03.setOnClickListener(this);
        hot_04.setOnClickListener(this);
        hot_05.setOnClickListener(this);
        hot_brand_06.setOnClickListener(this);
        hot_brand_07.setOnClickListener(this);
        new_08.setOnClickListener(this);
        new_09.setOnClickListener(this);
        new_10.setOnClickListener(this);
        new_11.setOnClickListener(this);
        activity_12.setOnClickListener(this);
        activity_13.setOnClickListener(this);
        activity_14.setOnClickListener(this);

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




    //头部轮播方法
    private void initBanner() {
        images.clear();
        titles.clear();
        for(int i = 0 ; i < 3 ; i++){
            images.add(R.mipmap.nanshimain);
            titles.add(new String(""));
        }

        //头部轮播图片
        Banner banner = (Banner)view.findViewById(R.id.fragment_mainmain_banner);
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



    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_manmain_hot_01:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_manmain_hot_02:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_manmain_hot_03:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_manmain_hot_04:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_manmain_hot_05:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_manmain_hot_brand_06:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_manmain_hot_brand_07:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_manmain_new_08:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_manmain_new_09:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_manmain_new_10:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_manmain_new_11:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_manmain_activity_12:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_manmain_activity_13:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_manmain_activity_14:
                startFragment(new SerchGoodsFragment(),null);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startFragment(new GoodsDetailsFragment(),null);
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
