package com.baicimi.fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.DistributionOrderGoodsAdapter;
import com.baicimi.adapter.GridViewHeadAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.DistributionOrderGoodsEntry;
import com.baicimi.entity.TeacherStatusRegisterEntry;
import com.baicimi.image.GlideImageLoader;
import com.baicimi.interfaces.DistributionNumberOnitemClick;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 * 分销订货 首页
 */
public class DistributionOrderGoodsFragment extends BaseFragment implements  View.OnClickListener {

    private View view;



    //头部轮播图集合
    List<Integer> images = new ArrayList<>();
    List<String> title = new ArrayList<>();

    private ImageView back;

    private FragmentManager fragmentManager;
    private int showIndex = 5;
    private FragmentTransaction fragmentTransaction;
    private List<Fragment> listFragment = new ArrayList<>();

    private TextView hotcommodity , cosmetics , beautymakeup , personalbelongings ;

    private RelativeLayout shoppintBack;
    private ImageView shoppintImage;



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.distribution_order_good_fragment , container , false);


        //头部轮播方法
        initBanner();


        //底部fragment切换
        initFragmentLayout();




        back = (ImageView) view.findViewById(R.id.back_distribution_order_good);
        back.setOnClickListener(this);

        return view;
    }
    //底部fragment切换
    private void initFragmentLayout() {
        fragmentManager = getActivity().getSupportFragmentManager();
        listFragment.clear();
        listFragment.add(new InventoryDistributionFragment());
        listFragment.add(new ShortcutOrderGoodsDistrict());
        listFragment.add(new TodayCosmeticsFragment(false));
        listFragment.add(new ShoppingBagFragment());


        hotcommodity = (TextView) view.findViewById(R.id.distribution_order_good_fragment_hotcommodity);
        cosmetics = (TextView) view.findViewById(R.id.distribution_order_good_fragment_cosmetics);
        beautymakeup = (TextView) view.findViewById(R.id.distribution_order_good_fragment_beautymakeup);
        personalbelongings = (TextView) view.findViewById(R.id.distribution_order_good_fragment_greenfood);
        shoppintBack = (RelativeLayout) view.findViewById(R.id.distribution_order_good_fragment_shoppintback);
        shoppintImage = (ImageView) view.findViewById(R.id.geren_toobar);
//        infantmom = (TextView) view.findViewById(R.id.distribution_order_good_fragment_infantmom);
//        shortcutOrderGoodsDistrict = (TextView) view.findViewById(R.id.distribution_order_good_fragment_shortcutOrderGoodsDistrict);
//        inventory = (TextView) view.findViewById(R.id.distribution_order_good_fragment_inventory);

        hotcommodity.setOnClickListener(this);
        cosmetics.setOnClickListener(this);
        beautymakeup.setOnClickListener(this);
        personalbelongings.setOnClickListener(this);
        shoppintBack.setOnClickListener(this);
        shoppintImage.setOnClickListener(this);
//        infantmom.setOnClickListener(this);
//        shortcutOrderGoodsDistrict.setOnClickListener(this);
//        inventory.setOnClickListener(this);


        setShowFragment(1);
    }

    //中部fragment导航栏初始化
    private void initTextView(){
        hotcommodity.setTextColor(Color.BLACK);
        hotcommodity.setBackgroundColor(Color.parseColor("#f1f1f1"));
        cosmetics.setTextColor(Color.parseColor("#6f6f6f"));
        cosmetics.setBackgroundColor(Color.parseColor("#f1f1f1"));
        beautymakeup.setTextColor(Color.parseColor("#6f6f6f"));
        beautymakeup.setBackgroundColor(Color.parseColor("#f1f1f1"));
        personalbelongings.setTextColor(Color.parseColor("#6f6f6f"));
        personalbelongings.setBackgroundColor(Color.parseColor("#f1f1f1"));
//        infantmom.setTextColor(Color.parseColor("#6f6f6f"));
//        infantmom.setBackgroundColor(Color.parseColor("#f1f1f1"));
//        shortcutOrderGoodsDistrict.setTextColor(Color.parseColor("#6f6f6f"));
//        shortcutOrderGoodsDistrict.setBackgroundColor(Color.parseColor("#f1f1f1"));
//        inventory.setTextColor(Color.parseColor("#6f6f6f"));
//        inventory.setBackgroundColor(Color.parseColor("#f1f1f1"));
    }


    @Override
    protected void initData() {

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
        Banner banner = (Banner)view.findViewById(R.id.distribution_order_good_fragment_banner);
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


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_distribution_order_good:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.distribution_order_good_fragment_hotcommodity:
                initTextView();
                hotcommodity.setTextColor(Color.WHITE);
                hotcommodity.setBackgroundColor(Color.RED);
                setShowFragment(2);
                break;
            case R.id.distribution_order_good_fragment_cosmetics:
                initTextView();
                cosmetics.setTextColor(Color.WHITE);
                cosmetics.setBackgroundColor(Color.RED);
                setShowFragment(2);
                break;
            case R.id.distribution_order_good_fragment_beautymakeup:
                initTextView();
                beautymakeup.setTextColor(Color.WHITE);
                beautymakeup.setBackgroundColor(Color.RED);
                setShowFragment(1);
                break;
            case R.id.distribution_order_good_fragment_greenfood:
                initTextView();
                personalbelongings.setTextColor(Color.WHITE);
                personalbelongings.setBackgroundColor(Color.RED);
                setShowFragment(0);
                break;
            case R.id.distribution_order_good_fragment_shoppintback:
                initTextView();
                setShowFragment(3);
                break;
            case R.id.geren_toobar:
                initTextView();
                setShowFragment(3);
                break;
//            case R.id.distribution_order_good_fragment_infantmom:
//                initTextView();
//                infantmom.setTextColor(Color.WHITE);
//                infantmom.setBackgroundColor(Color.RED);
//                setShowFragment(2);
//                break;
//            case R.id.distribution_order_good_fragment_shortcutOrderGoodsDistrict:
//                initTextView();
//                shortcutOrderGoodsDistrict.setTextColor(Color.WHITE);
//                shortcutOrderGoodsDistrict.setBackgroundColor(Color.RED);
//                setShowFragment(1);
//                break;
//            case R.id.distribution_order_good_fragment_inventory:
//                initTextView();
//                inventory.setTextColor(Color.WHITE);
//                inventory.setBackgroundColor(Color.RED);
//                setShowFragment(0);
//                break;
        }
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
                    fragmentTransaction.add(R.id.distribution_order_good_fragment_framelayout , listFragment.get(index) , tag);
                }
                showIndex = index;
                fragmentTransaction.commit();
            }

        }
    }


}
