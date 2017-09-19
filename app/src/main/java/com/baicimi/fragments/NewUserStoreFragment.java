package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.NewUserListViewAdapter;
import com.baicimi.adapter.PopularityViewAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.NewUserEntry;
import com.baicimi.image.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 * 新人福利专区
 */

public class NewUserStoreFragment extends BaseFragment implements View.OnClickListener {


    private View view;
    private ImageView user_back;//返回
    private ListView listView;
    private NewUserListViewAdapter adapter;
    private List<NewUserEntry> list = new ArrayList<>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.new_user_store , container , false);
        user_back = (ImageView) view.findViewById(R.id.new_user_store_back);
        user_back.setOnClickListener(this);

        //listview适配数据
        listviewGet();
        return view;
    }

    //listview适配数据
    private void listviewGet() {
        listView = (ListView) view.findViewById(R.id.new_user_store_listview);
        //添加数据源
        for(int i = 0 ; i < 8 ; i++){
            NewUserEntry  nue = new NewUserEntry(R.mipmap.new_user_listview_01 , new String("眼线笔") , new String("MI-HDFJRWS") , new String("刚刚兑换") , new String("积分10") , new String("（限量10份/每天）") , new String("5468215人兑换"));
            list.add(nue);
        }
        adapter = new NewUserListViewAdapter(getContext() , list);
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
    }

    @Override
    protected void initData() {

    }

//    //头部轮播的方法
//    private void bannerGet() {
//        //添加需要轮播的图片
//        lists.add(new Integer(R.mipmap.luxury_second_category_banner));
//        lists.add(new Integer(R.mipmap.luxury_second_category_banner_02));
//        lists.add(new Integer(R.mipmap.luxury_second_category_banner));
//        lists.add(new Integer(R.mipmap.luxury_second_category_banner_02));
//        lists.add(new Integer(R.mipmap.luxury_second_category_banner));
//
////        //添加标题
////        date.add(new String("显示1"));
////        date.add(new String("显示2"));
////        date.add(new String("显示3"));
////        date.add(new String("显示4"));
////        date.add(new String("显示5"));
//
//        banner = (Banner) view.findViewById(R.id.new_user_store_banner);
//        //设置banner样式
//        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
//        //设置图片加载器
//        banner.setImageLoader(new GlideImageLoader());
//        //设置图片集合
//        banner.setImages(lists);
//        //设置banner动画效果
//        banner.setBannerAnimation(Transformer.DepthPage);
//        //设置标题集合（当banner样式有显示title时）
////        banner.setBannerTitles(date);
//        banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
//        //设置自动轮播，默认为true
//        banner.isAutoPlay(true);
//        //设置轮播时间
//        banner.setDelayTime(2000);
//        //设置指示器位置（当banner模式中有指示器时）
//        banner.setIndicatorGravity(BannerConfig.CENTER);
//        //banner设置方法全部调用完毕时最后调用
//        banner.start();
//    }


    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        NewUserListViewAdapter gridAdapter = (NewUserListViewAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (gridAdapter == null) {

            return;
        }

        for (int index = 0; index < listView.getCount(); index++) {
            View listViewItem = gridAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (gridAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.new_user_store_back:
                ((MainActivity) getActivity()).goBack();//返回到上层界面
                break;
        }
    }
}
