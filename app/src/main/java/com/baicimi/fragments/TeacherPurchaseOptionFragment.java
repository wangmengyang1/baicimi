package com.baicimi.fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.HomePageViewButtonAdapte;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.HomePageBrandButtonViewPager;
import com.baicimi.image.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */
public class TeacherPurchaseOptionFragment extends BaseFragment implements View.OnClickListener {

    private FragmentManager fragmentManager;
    private int showIndex = 5;
    private FragmentTransaction fragmentTransaction;
    private List<Fragment> listFragment = new ArrayList<>();
    private View view;

    //头部轮播图集合
    List<Integer> images = new ArrayList<>();
    List<String> title = new ArrayList<>();

    private ImageView back;

    private GridView gridView;
    private List<HomePageBrandButtonViewPager> list;

    private TextView officesupplies , sports , clothing , accessory;




    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.teacher_putchase_option_fragment , container , false);

        //头部轮播方法
        initBanner();

        //fragment布局填充
        initFragmentLayout();

        back = (ImageView) view.findViewById(R.id.back_teacher_putchase_option_fragment);
        back.setOnClickListener(this);

        //底部GridView布局填充
        initGridView();

        //顶部导航栏布局调整
        initHeadBar();


        return view;
    }
    //顶部导航栏布局调整
    private void initHeadBar() {
        officesupplies = (TextView) view.findViewById(R.id.distributor_putchase_option_officesupplies);
        sports = (TextView) view.findViewById(R.id.distributor_putchase_option_sports);
        clothing = (TextView) view.findViewById(R.id.distributor_putchase_option_clothing);
        accessory = (TextView) view.findViewById(R.id.distributor_putchase_option_accessory);

        officesupplies.setOnClickListener(this);
        sports.setOnClickListener(this);
        clothing.setOnClickListener(this);
        accessory.setOnClickListener(this);

    }


    private void initHeadTextView(){
        officesupplies.setTextColor(Color.BLACK);
        sports.setTextColor(Color.BLACK);
        clothing.setTextColor(Color.BLACK);
        accessory.setTextColor(Color.BLACK);
    }


    //底部GridView布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.teacher_putchase_option_gridview_fragment);
        list = new ArrayList<>();
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_11 , new String("御泥坊") , new String("我的御用面膜") , 1234 , R.drawable.home_page_brand_gridview_image_01 , false));
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_12 , new String("佰草集旗") , new String("中草药高端护理品牌") , 1234 , R.drawable.home_page_brand_gridview_image_02 , false));
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_13 , new String("温碧泉") , new String("补水就用温碧泉") , 1234 , R.drawable.home_page_brand_gridview_image_03 , false));
        list.add(new HomePageBrandButtonViewPager(R.drawable.home_page_brand_fragment_image_14 , new String("玛丽黛佳") , new String("新艺术彩妆品牌") , 1234 , R.drawable.home_page_brand_gridview_image_04 , false));
        HomePageViewButtonAdapte buttonAdapte = new HomePageViewButtonAdapte(getContext() , list);
        gridView.setAdapter(buttonAdapte);
        fixGridViewHeight(gridView);
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


    //头部轮播方法
    private void initBanner() {
        for(int i = 0 ; i < 3 ; i++){

            title.add(new String(""));
            images.add(R.drawable.home_page_brand_fragment_image_21);
        }

//        images.add(R.mipmap.new_ningfei_3);
//        images.add(R.mipmap.new_ningfei_4);

        //头部轮播图片
        Banner banner = (Banner)view.findViewById(R.id.teacher_putchase_option_banner_fragment);
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


    //fragment布局填充
    private void initFragmentLayout() {
        fragmentManager = getActivity().getSupportFragmentManager();
        listFragment.clear();
        listFragment.add(new TodayCosmeticsFragment(true));
//        listFragment.add(new OfficeSuppliesFragment());
        setShowFragment(0);
    }


    //显示fragment
    private void setShowFragment(int index){

        if(index == showIndex){
            return;
        }

        if (index > listFragment.size()){
            return;
        }else{
            if(listFragment.get(index) == null){
                return;
            }else{
                String tag = listFragment.get(index).getTag();
                fragmentTransaction = fragmentManager.beginTransaction();
                // 3 控制Fragment 的动画
                fragmentTransaction.setCustomAnimations(R.anim.slide_left_enter, R.anim.slide_right_exit, R.anim.slide_right_enter,
                        R.anim.slide_left_exit);
                if(listFragment.get(index).isAdded()){
                    //如果已经添加了，则显示
                    fragmentTransaction.hide(listFragment.get(showIndex));
                    fragmentTransaction.show(listFragment.get(index));
                }else{
                    //如果没有添加，则添加之后显示
                    fragmentTransaction.add(R.id.teacher_putchase_option_framelayout_fragment , listFragment.get(index) , tag).show(listFragment.get(index));
                }
                showIndex = index;
                fragmentTransaction.commit();
            }

        }
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_teacher_putchase_option_fragment:
                ((MainActivity)getActivity()).goBack();//返回到上一界面
                break;
            case R.id.distributor_putchase_option_officesupplies:
                initHeadTextView();
                officesupplies.setTextColor(Color.parseColor("#f05a4b"));
                break;
            case R.id.distributor_putchase_option_sports:
                initHeadTextView();
                sports.setTextColor(Color.parseColor("#f05a4b"));
                break;
            case R.id.distributor_putchase_option_clothing:
                initHeadTextView();
                clothing.setTextColor(Color.parseColor("#f05a4b"));
                break;
            case R.id.distributor_putchase_option_accessory:
                initHeadTextView();
                accessory.setTextColor(Color.parseColor("#f05a4b"));
                break;
        }
    }
}
