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
import com.baicimi.adapter.TryoutApplyForAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.TryoutApplyForEntry;
import com.baicimi.image.GlideImageLoader;
import com.baicimi.interfaces.DistributionNumberOnitemClick;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5.
 * 试用申请
 */

public class TryoutApplyforFragment extends BaseFragment implements DistributionNumberOnitemClick{

    private View view;
    //头部轮播图集合
    List<Integer> images = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    //横向滑动
    private LinearLayout horizontalLayout;
    private View layout_01;

    private GridView gridView;
    private List<TryoutApplyForEntry> list = new ArrayList<>();
    private TryoutApplyForAdapter tryoutApplyForAdapter;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.tryout_applyfor_fragment , container , false);


        //头部轮播方法
        initBanner();

        //横向滑动布局填充
        initHorizontalLayout();

        //底部GridView布局填充
        initGridView();

        return view;
    }

    //底部GridView布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.tryout_applyfor_fragment_gridview);
        list.clear();
        list.add(new TryoutApplyForEntry(R.drawable.tyrout_applyfor_fragment_image_09 , new String("官方授权 自然堂乐园补水保湿") , new String("¥112.00") , new String("20") , 1234));
        list.add(new TryoutApplyForEntry(R.drawable.tyrout_applyfor_fragment_image_09 , new String("官方授权 自然堂乐园补水保湿") , new String("¥112.00") , new String("20") , 1234));
        list.add(new TryoutApplyForEntry(R.drawable.tyrout_applyfor_fragment_image_09 , new String("官方授权 自然堂乐园补水保湿") , new String("¥112.00") , new String("20") , 1234));
        list.add(new TryoutApplyForEntry(R.drawable.tyrout_applyfor_fragment_image_09 , new String("官方授权 自然堂乐园补水保湿") , new String("¥112.00") , new String("20") , 1234));
        list.add(new TryoutApplyForEntry(R.drawable.tyrout_applyfor_fragment_image_09 , new String("官方授权 自然堂乐园补水保湿") , new String("¥112.00") , new String("20") , 1234));
        list.add(new TryoutApplyForEntry(R.drawable.tyrout_applyfor_fragment_image_09 , new String("官方授权 自然堂乐园补水保湿") , new String("¥112.00") , new String("20") , 1234));
        tryoutApplyForAdapter = new TryoutApplyForAdapter(getContext() , list ,this);
        gridView.setAdapter(tryoutApplyForAdapter);
        fixListViewHeight(gridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //我的试用申请
                startFragment(new TryoutApplyForMeFragment());
            }
        });
    }

    //横向滑动布局填充
    private void initHorizontalLayout() {
        horizontalLayout = (LinearLayout) view.findViewById(R.id.tryout_applyfor_fragment_horizontal_layout);
        for(int i = 0 ; i < 7 ; i++){
            layout_01 = LayoutInflater.from(getContext()).inflate(R.layout.horizontallayout_item_fragment , null);
            ImageView imageView = (ImageView) layout_01.findViewById(R.id.horizontallayout_item_fragment_imageurl);
            Glide.with(getContext())
                    .load(R.drawable.tyrout_applyfor_fragment_image_05)
                    .into(imageView);
            horizontalLayout.addView(layout_01);
        }

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
        Banner banner = (Banner)view.findViewById(R.id.tryout_applyfor_fragment_banner);
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
                //试用报告
                startFragment(new TryoutApplyForFragmentSecond(),null);
            }
        });

    }


    @Override
    protected void initData() {

    }


    //动态计算listview的高度
    public void fixListViewHeight(GridView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        TryoutApplyForAdapter listAdapter = (TryoutApplyForAdapter) listView.getAdapter();
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
            tryoutApplyForAdapter = null;
            view = null;

        }
        System.gc();
        super.onDetach();


    }

    @Override
    public void setNumberOnitemClick(View view, int i, long l) {
        if(this.view != null){
            switch ((int) l){
                case R.id.tryoutapply_for_adapter_fragment_layout:
                    TextView tagNumber = (TextView) this.view.findViewById(R.id.tryoutapply_for_adapter_fragment_tagnumber_tv);
                    int count = list.get(i).getTagNumber();
                    count++;
                    tagNumber.setText(count + "");
                    list.get(i).setTagNumber(count);
                    tryoutApplyForAdapter.notifyDataSetChanged();
                    break;
            }
        }
    }
}
