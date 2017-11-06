package com.baicimi.fragments;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.CheckOneFragmentListViewAdapter;
import com.baicimi.adapter.ViewPagerAdapter;
import com.baicimi.adapter.ViewPagerAdapterItem;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.CheckOneFragmentEntry;
import com.baicimi.entity.CommodityNumberEntry;
import com.baicimi.entity.ShopingPackageMessage;
import com.baicimi.image.GlideImageLoader;
import com.baicimi.ui.ShareModel;
import com.baicimi.ui.SharePopupWindow;
import com.baicimi.ui.VertiaclTransformer;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import me.kaelaela.verticalviewpager.VerticalViewPager;
import me.kaelaela.verticalviewpager.transforms.ZoomOutTransformer;

/**
 * Created by tan on 2016/9/5.
 * 商品页
 */
public class CheckOneFragment extends BaseFragment implements View.OnClickListener {
    private Button btn_mmesage, btn_wancheng;
    private RelativeLayout re_share, re_fuwu,re_yingyang,re_guide;
    private PopupWindow window_xinxi, window_share, window_fuwu;


    private String text = "金属色交织薄围巾";
    private String imageurl = "http://h.hiphotos.baidu.com/image/pic/item/ac4bd11373f082028dc9b2a749fbfbedaa641bca.jpg";
    private String title = "拍拍搜";
    private String url = "www.baidu.com";

    private SharePopupWindow share;



    //头部轮播图集合
    List<Integer> images = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    private View view_window;

    private ListView listView;
    private List<CheckOneFragmentEntry> list = new ArrayList<>();
    private CheckOneFragmentListViewAdapter adapter;
    private TextView message_tv , commect_tv;
    private LinearLayout layout_02;
    private TextView back_tv;

//    private ImageView imageView;

    private ImageView back;

    //头部轮播图集合
    List<Integer> image_head = new ArrayList<>();
    List<String> title_head = new ArrayList<>();

    private ImageView back_head , packages;
    private ImageView yuandian_01 , yuandian_04 ,yuandian_03 ,yuandian_02;

    //购物包数据变化
    private TextView shopPackageNumber;

    private int countNumber = 0;

    private VerticalViewPager verticalViewPager;
    private List<View> list_vp = new ArrayList<>();
    private ViewPagerAdapterItem adapter_vp;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.check_one_item, container, false);
        btn_mmesage = (Button) view.findViewById(R.id.btn_message);
        btn_mmesage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopwindowmessage();
            }
        });


        //头部轮播方法
//        initBannerHead();

        back_head = (ImageView) view.findViewById(R.id.login_back1);
        back_head.setOnClickListener(this);
        packages = (ImageView) view.findViewById(R.id.btn_gouwuche);
        packages.setOnClickListener(this);

        yuandian_01 = (ImageView) view.findViewById(R.id.check_one_yuandian_01);
        yuandian_02 = (ImageView) view.findViewById(R.id.check_one_yuandian_02);
        yuandian_03 = (ImageView) view.findViewById(R.id.check_one_yuandian_03);
        yuandian_04 = (ImageView) view.findViewById(R.id.check_one_yuandian_04);


        //进行eventbus注册
        EventBus.getDefault().register(this);


        shopPackageNumber = (TextView) view.findViewById(R.id.img_gouwuche1_item_01);
        countNumber += CommodityNumberEntry.commodityNumberEntryIntereal().getCount();
        shopPackageNumber.setText(countNumber + "");
        countNumber = 0;

        //头部viewpager滑动
        initVerticalViewPager();

        return view;
    }

    //头部viewpager滑动
    private void initVerticalViewPager() {
        verticalViewPager = (VerticalViewPager)view.findViewById(R.id.check_one_item_viewpager_01);
        list_vp.clear();
        for (int i = 0 ; i < 30 ; i++){
            list_vp.add(LayoutInflater.from(getContext()).inflate(R.layout.viewpager_item_01 , null));
        }

        adapter_vp = new ViewPagerAdapterItem(list_vp);
        verticalViewPager.setAdapter(adapter_vp);
        verticalViewPager.setPageTransformer(true, new ZoomOutTransformer());

    }

    @Override
    public void onStop() {
        super.onStop();
        //使用完毕之后解除注册
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN )
    public void getMsgEvent(ShopingPackageMessage event){
        countNumber += event.getShopingPackageMessageNumber();
        shopPackageNumber.setText(countNumber + "");
        CommodityNumberEntry.commodityNumberEntryIntereal().setCount(countNumber);
    }



    private void setImageViewSrc(){
        yuandian_01.setImageResource(R.drawable.yuandian_huise);
        yuandian_02.setImageResource(R.drawable.yuandian_huise);
        yuandian_03.setImageResource(R.drawable.yuandian_huise);
        yuandian_04.setImageResource(R.drawable.yuandian_huise);
    }

    //头部轮播方法
//    private void initBannerHead() {
//        title_head.clear();
//        image_head.clear();
//        for(int i = 0 ; i < 4 ; i++){
//
//            title_head.add(new String(""));
//            image_head.add(R.mipmap.img_details1);
//        }
//
//
//        //头部轮播图片
//        Banner banner = (Banner)view.findViewById(R.id.check_one_item_banner);
//        //设置banner样式
//        banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
//        //设置图片加载器
//        banner.setImageLoader(new GlideImageLoader());
//        //设置图片集合
//        banner.setImages(image_head);
//        //设置banner动画效果
//        banner.setBannerAnimation(VertiaclTransformer.class);
//        //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(title_head);
//        //设置自动轮播，默认为true
//        banner.isAutoPlay(true);
//        //设置轮播时间
//        banner.setDelayTime(2500);
//        //设置指示器位置（当banner模式中有指示器时）
//        banner.setIndicatorGravity(BannerConfig.CENTER);
//        //banner设置方法全部调用完毕时最后调用
//        banner.start();
//
////        banner.setOnBannerListener(new OnBannerListener() {
////            @Override
////            public void OnBannerClick(int position) {
////                if (position == 0){
////                    setImageViewSrc();
////                    yuandian_01.setImageResource(R.drawable.yuandian_luse);
////                }else if (position == 1){
////                    setImageViewSrc();
////                    yuandian_02.setImageResource(R.drawable.yuandian_luse);
////                }else if (position == 2){
////                    setImageViewSrc();
////                    yuandian_03.setImageResource(R.drawable.yuandian_luse);
////                }else if (position == 3){
////                    setImageViewSrc();
////                    yuandian_04.setImageResource(R.drawable.yuandian_luse);
////                }
////            }
////        });
//
//
//    }


    /**
     * 显示信息窗口
     */
    private void showPopwindowmessage() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        view_window = inflater.inflate(R.layout.message_diolog, null);


        back = (ImageView) view_window.findViewById(R.id.back_distributor_putchase_optionss);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closePopupXinxiWindow();
            }
        });

        //头部轮播方法
        initBanner();

        //评论布局填充
        initCommentAdd();

        //在评论和信息之间进行切换
        initRelayout();


        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window_xinxi = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);

        //调用父亲变暗的方法
        changeWindowAlpha(getActivity(), 0.5f);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window_xinxi.setFocusable(true);
        window_xinxi.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        window_xinxi.setBackgroundDrawable(new BitmapDrawable());

//        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xFFffffff);
//        window.setBackgroundDrawable(dw);
//        //在参照的View控件下方显示
//        window.showAsDropDown(MainActivity.this.findViewById(R.id.start));

        // 设置popWindow的显示和消失动画
        window_xinxi.setAnimationStyle(R.style.AnimBottom);
        //设置在底部显示
        window_xinxi.showAtLocation(view.findViewById(R.id.btn_message),
                Gravity.CENTER, 0, 0);

        /**
         * *popWindow消失监听方法
         */
        window_xinxi.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });

        //点击分享
        ShareSDK.initSDK(getContext());
        re_share = (RelativeLayout) view_window.findViewById(R.id.re_share_ss);
        re_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                share = new SharePopupWindow(getContext());
////                share.setPlatformActionListener(MainActivity.this);
//                ShareModel model = new ShareModel();
//                model.setImageUrl(imageurl);
//                model.setText(text);
//                model.setTitle(title);
//                model.setUrl(url);
//                share.initShareParams(model);
//                share.showShareWindow();
//
//                // 显示窗口 (设置layout在PopupWindow中显示的位置)
//                share.showAtLocation(view.findViewById(R.id.btn_message),
//                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
//                closePopupXinxiWindow();
                closePopupXinxiWindow();
                //分享
                startFragment(new UserCenterHomePageProductShardSDK());
            }
        });

        re_fuwu = (RelativeLayout) view_window.findViewById(R.id.re_fuwu_ss);
        re_fuwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupXinxiWindow();
               startFragment(new KeHuFuWuFragment(),null);
            }
        });

        re_yingyang = (RelativeLayout) view_window.findViewById(R.id.re_yingyang_ss);
        re_yingyang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupXinxiWindow();
                startFragment(new BaoYangFragment(),null);
            }
        });

        re_guide = (RelativeLayout) view_window.findViewById(R.id.re_chicun_ss);
        re_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupXinxiWindow();
                startFragment(new UseGUideFragment(),null);
            }
        });

        RelativeLayout re_gognxiao = (RelativeLayout) view_window.findViewById(R.id.re_gognxiao_ss);
        re_gognxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closePopupXinxiWindow();
                startFragment(new ProductEffectFragment(),null);
            }
        });




    }

    private void initRelayout() {
        message_tv = (TextView) view_window.findViewById(R.id.message_diolog_message_tectview);
        commect_tv = (TextView) view_window.findViewById(R.id.message_diolog_message_commecy);
        layout_02 = (LinearLayout) view_window.findViewById(R.id.message_diolot_layout_02);
        message_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_02.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                message_tv.setTextColor(Color.WHITE);
                message_tv.setBackgroundColor(Color.parseColor("#fe0036"));
                commect_tv.setTextColor(Color.parseColor("#737373"));
                commect_tv.setBackgroundColor(Color.parseColor("#eaeaea"));
            }
        });

        commect_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout_02.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                commect_tv.setTextColor(Color.WHITE);
                commect_tv.setBackgroundColor(Color.parseColor("#fe0036"));
                message_tv.setTextColor(Color.parseColor("#737373"));
                message_tv.setBackgroundColor(Color.parseColor("#eaeaea"));

            }
        });

    }


    //评论布局填充
    private void initCommentAdd() {
        listView = (ListView) view_window.findViewById(R.id.message_giolog_listview);
        list.clear();
        list.add(new CheckOneFragmentEntry(R.drawable.check_one_fragment_listview_image_03 , new String("逗比就是你") , new String("今天 19:26") ,new String("太好看了，但还是没有我的小妹仙女好看...小妹仙女最好看了，这件产品怎么这么丑啊") , new String("6") , new String("125") , new String("2659") , R.drawable.check_one_fragment_listview_image_02));
        adapter = new CheckOneFragmentListViewAdapter(getContext() , list);
        listView.setAdapter(adapter);
    }


    //头部轮播方法
    private void initBanner() {
        titles.clear();
        images.clear();
        for(int i = 0 ; i < 3 ; i++){

            titles.add(new String(""));
            images.add(R.drawable.home_page_brand_fragment_image_21);
        }


        //头部轮播图片
        Banner banner = (Banner)view_window.findViewById(R.id.message_diolog_banner);
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

    /**
     * 改变popwindow背景的方法
     *
     * @param alpha
     */
    private static void changeWindowAlpha(FragmentActivity activity, float alpha) {
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.alpha = alpha;
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        activity.getWindow().setAttributes(params);
    }


    /**
     * 关闭信息窗口
     */
    private void closePopupXinxiWindow() {
        if (window_xinxi != null && window_xinxi.isShowing()) {
            window_xinxi.dismiss();
            window_xinxi = null;
            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.alpha = 1.0f;
            getActivity().getWindow().setAttributes(params);
        }
    }

    /**
     * 关闭分享窗口
     */
    private void closePopupShareWindow() {
        if (window_share != null && window_share.isShowing()) {
            window_share.dismiss();
            window_share = null;
            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.alpha = 1.0f;
            getActivity().getWindow().setAttributes(params);
        }
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_back1:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.btn_gouwuche:
                //购物车界面
                startFragment(new ShopingCarFragment(), null);
                break;
        }
    }
}
