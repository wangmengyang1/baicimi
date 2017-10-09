package com.baicimi.fragments;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.GridViewHeadAdapter;
import com.baicimi.adapter.HomePageViewButtonAdapte;
import com.baicimi.adapter.ViewPagerAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.HomePageBrandButtonViewPager;
import com.baicimi.entity.HomePageBrandHeadEntry;
import com.baicimi.image.GlideImageLoader;
import com.baicimi.interfaces.DistributionNumberOnitemClick;
import com.baicimi.interfaces.DistributionNumberOnitemClickVP;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 * 品牌首页
 */

public class HomePageBrandFragment extends BaseFragment implements DistributionNumberOnitemClickVP{

    private View view;

    //头部轮播图集合
    List<Integer> images = new ArrayList<>();
    List<String> title = new ArrayList<>();

    private ViewPager viewPager_01 , viewPager_02;
    private List<View> vp01_list  , vp02_list;
    private ViewPagerAdapter adapter_01 , adapter_02;
    private GridView gridviewHead;
    private View vpHeadItem;
    private View viewButton;
    private GridView gridView;
    private List<HomePageBrandButtonViewPager> list;

    private View view_01 , view_02 , view_03;
    private HomePageViewButtonAdapte buttonAdapte;

    private List<BaseAdapter> listAdapter = new ArrayList<>();
    private int viewPagerItem = 0;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.home_page_brand_fragment , container , false);


        //头部轮播方法
        initBanner();

        //顶部viewpager布局填充
        initHeadViewPager();

        //底部viewpager布局填充
        initButtonViewPager();

        view_01 = view.findViewById(R.id.home_page_Brand_fragment_view_01);
        view_02 = view.findViewById(R.id.home_page_Brand_fragment_view_02);
        view_03 = view.findViewById(R.id.home_page_Brand_fragment_view_03);


        return view;
    }



    private void initViewShow(){
        view_01.setBackgroundColor(Color.parseColor("#f1f1f1"));
        view_02.setBackgroundColor(Color.parseColor("#f1f1f1"));
        view_03.setBackgroundColor(Color.parseColor("#f1f1f1"));
    };

    //底部viewpager布局填充
    private void initButtonViewPager() {
        viewPager_02 = (ViewPager) view.findViewById(R.id.home_page_brand_fragment_viewpager_button);
        vp02_list = new ArrayList<>();
        vp02_list.clear();
//        vp02_list.add(initAddViewButton());
//        vp02_list.add(initAddViewButton());
        vp02_list.add(initAddViewButton());
        adapter_02 = new ViewPagerAdapter( vp02_list);
        viewPager_02.setAdapter(adapter_02);
        ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) gridView.getLayoutParams();
        params.height = gridView.getLayoutParams().height;
        viewPager_02.setLayoutParams(params);

        viewPager_02.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPagerItem = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager_02.setCurrentItem(0);
    }

    //底部viewpager布局填充
    private View initAddViewButton() {
        viewButton = LayoutInflater.from(getContext()).inflate(R.layout.home_page_viewpager_button_item , null);
        gridView = (GridView) viewButton.findViewById(R.id.home_page_viewpager_button_item_gridview);
        list = new ArrayList<>();
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_11 , new String("御泥坊") , new String("我的御用面膜") , 1234, R.drawable.home_page_brand_gridview_image_01 , false));
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_12 , new String("佰草集旗") , new String("中草药高端护理品牌") , 1234 , R.drawable.home_page_brand_gridview_image_02 , false));
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_13 , new String("温碧泉") , new String("补水就用温碧泉") , 1234 , R.drawable.home_page_brand_gridview_image_03 , false));
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_14 , new String("玛丽黛佳") , new String("新艺术彩妆品牌") , 1234 , R.drawable.home_page_brand_gridview_image_04 , false));
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_15 , new String("蜜丝佛陀") , new String("化妆师额化妆品") ,1234, R.drawable.home_page_brand_gridview_image_05 , false));
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_16 , new String("欧诗漫") , new String("带来珍珠般的灵动肌肤") , 1234 , R.drawable.home_page_brand_gridview_image_06 , false));
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_17 , new String("一叶子") , new String("新鲜的力量") , 1234 , R.drawable.home_page_brand_gridview_image_07 , false));
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_18 , new String("森山药妆") , new String("台湾面膜知名品牌") , 1234 , R.drawable.home_page_brand_gridview_image_08 , false));
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_19 , new String("雅芳") , new String("魅力因为有你") , 1234 , R.drawable.home_page_brand_gridview_image_09 , false));
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_20 , new String("BEELY旗舰店") , new String("换货柔嫩自信美肌") , 1234 , R.drawable.home_page_brand_gridview_image_10 , false));
        buttonAdapte = new HomePageViewButtonAdapte(getContext() , list , this , HomePageBrandFragment.this);
        listAdapter.add(buttonAdapte);
        gridView.setAdapter(buttonAdapte);
        fixGridViewHeight(gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startFragment(new GoodsDetailsFragment());
            }
        });
        return viewButton;
    }

    //顶部viewpager布局填充
    private void initHeadViewPager() {
        viewPager_01 = (ViewPager) view.findViewById(R.id.home_page_brand_fragment_viewpager_head);
        vp01_list = new ArrayList<>();
        vp01_list.clear();
        vp01_list.add(initAddView());
        vp01_list.add(initAddView());
        vp01_list.add(initAddView());
        adapter_01 = new ViewPagerAdapter( vp01_list);
        viewPager_01.setAdapter(adapter_01);
        ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) gridviewHead.getLayoutParams();
        params.height = gridviewHead.getLayoutParams().height;
        viewPager_01.setLayoutParams(params);

        viewPager_01.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                initViewShow();
                switch (position ){
                    case 0:
                        view_01.setBackgroundColor(Color.BLACK);
                        break;
                    case 1:
                        view_02.setBackgroundColor(Color.BLACK);
                        break;
                    case 2:
                        view_03.setBackgroundColor(Color.BLACK);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //填充头部viewpager布局
    private View initAddView() {
        vpHeadItem = LayoutInflater.from(getContext()).inflate(R.layout.home_page_brand_fragment_viewpager_item_head , null);
        gridviewHead = (GridView) vpHeadItem.findViewById(R.id.home_page_brand_fragment_viewpager_head_gridview);
        List<HomePageBrandHeadEntry> list_gvHead = new ArrayList<>();
        list_gvHead.clear();
        list_gvHead.add(new HomePageBrandHeadEntry(R.drawable.home_page_brand_fragment_image_02));
        list_gvHead.add(new HomePageBrandHeadEntry(R.drawable.home_page_brand_fragment_image_09));
        list_gvHead.add(new HomePageBrandHeadEntry(R.drawable.home_page_brand_fragment_image_04));
        list_gvHead.add(new HomePageBrandHeadEntry(R.drawable.home_page_brand_fragment_image_05));
        list_gvHead.add(new HomePageBrandHeadEntry(R.drawable.home_page_brand_fragment_image_06));
        list_gvHead.add(new HomePageBrandHeadEntry(R.drawable.home_page_brand_fragment_image_07));
        list_gvHead.add(new HomePageBrandHeadEntry(R.drawable.home_page_brand_fragment_image_08));
        list_gvHead.add(new HomePageBrandHeadEntry(R.drawable.home_page_brand_fragment_image_09));
        list_gvHead.add(new HomePageBrandHeadEntry(R.drawable.home_page_brand_fragment_image_10));
        GridViewHeadAdapter adapter_gridviewHead = new GridViewHeadAdapter(getContext() , list_gvHead);
        gridviewHead.setAdapter(adapter_gridviewHead);
        fixListViewHeight(gridviewHead);

        gridviewHead.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startFragment(new BrandFragmentSecond());
            }
        });

        return vpHeadItem;
    }


    //头部轮播方法
    private void initBanner() {
        title.clear();
        images.clear();
        for(int i = 0 ; i < 3 ; i++){

            title.add(new String(""));
            images.add(R.drawable.home_page_brand_fragment_image_01);
        }

        //头部轮播图片
        Banner banner = (Banner)view.findViewById(R.id.home_page_brand_fragment_banner);
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
        banner.setDelayTime(3500);
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
        GridViewHeadAdapter listAdapter = (GridViewHeadAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount()/3; index++) {
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

    //动态计算listview的高度
    public void fixGridViewHeight(GridView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        HomePageViewButtonAdapte listAdapter = (HomePageViewButtonAdapte) listView.getAdapter();
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
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+10);
        listView.setLayoutParams(params);
    }



    @Override
    protected void initData() {

    }

    @Override
    public void onDetach() {
        if (view != null){
            adapter_01 = null;
            adapter_02 = null;
            view = null;
        }
        System.gc();
        super.onDetach();
    }

    /**
     * 问题描述：在viewpager中嵌套GridView，更新数据之后UI显示数据结果出现错乱，
     * 经打印，数据源没有问题，初步判算是因为viewpager中多个adapter的问题。尚未解决
     * **/
    @Override
    public void setNumberOnitemClick(View view, int i, long l , BaseAdapter baseAdapter) {
        if (this.view != null){
            switch ((int) l){
                case R.id.home_page_view_button_adapter_layout_tag:
                    TextView tagNumber = (TextView) this.view.findViewById(R.id.home_page_view_button_adapter_attention);
                    int count = list.get(i).getAttention() + 1;
                    tagNumber.setText(count + "");
                    list.get(i).setAttention(count);
                    listAdapter.get(viewPagerItem).notifyDataSetChanged();
                    adapter_02.notifyDataSetChanged();
                    break;
                case R.id.home_page_view_button_layout:
                    TextView eylt_attention = (TextView) this.view.findViewById(R.id.home_page_view_button_adapter_eylt_attention_tv);
                    LinearLayout button_layout = (LinearLayout) this.view.findViewById(R.id.home_page_view_button_layout);
                    boolean selected = list.get(i).isAttentionSelect();
                    selected = (!selected);
                    if(selected){
                        eylt_attention.setVisibility(View.VISIBLE);
                        button_layout.setVisibility(View.INVISIBLE);
                    }else{
                        eylt_attention.setVisibility(View.GONE);
                        button_layout.setVisibility(View.VISIBLE);
                    }
                    list.get(i).setAttentionSelect(selected);
                    listAdapter.get(viewPagerItem).notifyDataSetChanged();
                    adapter_02.notifyDataSetChanged();
                    break;
                case R.id.home_page_view_button_adapter_eylt_attention_tv:
                    TextView eylt_attentions = (TextView) this.view.findViewById(R.id.home_page_view_button_adapter_eylt_attention_tv);
                    LinearLayout button_layouts = (LinearLayout) this.view.findViewById(R.id.home_page_view_button_layout);
                    boolean selecteds = list.get(i).isAttentionSelect();
                    selecteds = (!selecteds);
                    if(selecteds){
                        eylt_attentions.setVisibility(View.VISIBLE);
                        button_layouts.setVisibility(View.INVISIBLE);
                    }else{
                        eylt_attentions.setVisibility(View.GONE);
                        button_layouts.setVisibility(View.VISIBLE);
                    }
                    list.get(i).setAttentionSelect(selecteds);
                    listAdapter.get(viewPagerItem).notifyDataSetChanged();
                    adapter_02.notifyDataSetChanged();
                    break;
            }

        }
    }
}
