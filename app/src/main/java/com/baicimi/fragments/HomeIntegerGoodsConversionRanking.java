package com.baicimi.fragments;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.ConversionRankingAdapter;
import com.baicimi.adapter.EverydayConversionAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.ConversionRankingEntry;
import com.baicimi.entity.EverydayConversionEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 * 积分上商城  兑换排行首页
 */

public class HomeIntegerGoodsConversionRanking extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listviewFirst , listviewSecond ;
    private List<ConversionRankingEntry> listFirst = new ArrayList<>();
    private List<ConversionRankingEntry> listSecond = new ArrayList<>();
    private ConversionRankingAdapter adapterFirst , adapterSecond;
    private ImageView back;

    private List<EverydayConversionEntry> listThread = new ArrayList<>();
    private EverydayConversionAdapter adapteThread;
    private ListView listviewThread;

    private TextView brandMore , hot_commodity_more;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.home_integer_goods_conversion_ranking , container , false);

        //firstlistview布局填充
        initFirstListView();
        //SecondListView布局填充
        initSecondListView();

        back = (ImageView) view.findViewById(R.id.home_integer_goods_conversion_ranking_back);
        back.setOnClickListener(this);

        //Threadlistview布局填充
        initThreadListView();

        brandMore = (TextView) view.findViewById(R.id.home_integer_goods_conversion_brand_more);//热门品牌更多
        hot_commodity_more = (TextView) view.findViewById(R.id.home_integer_goods_conversion_hot_commodity_more);//热门商品更多
        brandMore.setOnClickListener(this);
        hot_commodity_more.setOnClickListener(this);

        return view;
    }

    //Threadlistview布局填充
    private void initThreadListView() {
        listviewThread = (ListView) view.findViewById(R.id.homeinteger_goods_conversion_ranking_listview_thread);
        listThread.clear();
        listThread.add(new EverydayConversionEntry("9:00场" , "进行中" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        listThread.add(new EverydayConversionEntry("9:00场" , "进行中" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        listThread.add(new EverydayConversionEntry("9:00场" , "进行中" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        listThread.add(new EverydayConversionEntry("9:00场" , "进行中" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
//        listThread.add(new EverydayConversionEntry("9:00场" , "兑换结束" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        adapteThread = new EverydayConversionAdapter(listThread , getContext() , 4 , this);
        listviewThread.setAdapter(adapteThread);
        fixGrdiViewHeight04(listviewThread);
    }

    //SecondListView布局填充
    private void initSecondListView() {
        listviewSecond = (ListView) view.findViewById(R.id.homeinteger_goods_conversion_ranking_listview_second);
        listSecond.clear();
        listSecond.add(new ConversionRankingEntry(R.drawable.home_integer_conversion_08 , "梦露MULU" , "17890人兑换"));
        listSecond.add(new ConversionRankingEntry(R.drawable.home_integer_conversion_08 , "梦露MULU" , "17890人兑换"));
        listSecond.add(new ConversionRankingEntry(R.drawable.home_integer_conversion_08 , "梦露MULU" , "17890人兑换"));
        adapterSecond = new ConversionRankingAdapter(listSecond , getContext() , true);
        listviewSecond.setAdapter(adapterSecond);
        fixGrdiViewHeight03(listviewSecond);
    }

    //firstlistview布局填充
    private void initFirstListView() {
        listviewFirst = (ListView) view.findViewById(R.id.homeinteger_goods_conversion_ranking_listview_first);
        listFirst.clear();
        listFirst.add(new ConversionRankingEntry(R.drawable.home_integer_conversion_07 , "欧诗漫补水霜" , "17890人兑换"));
        listFirst.add(new ConversionRankingEntry(R.drawable.home_integer_conversion_07 , "欧诗漫补水霜" , "17890人兑换"));
        listFirst.add(new ConversionRankingEntry(R.drawable.home_integer_conversion_07 , "欧诗漫补水霜" , "17890人兑换"));
        listFirst.add(new ConversionRankingEntry(R.drawable.home_integer_conversion_07 , "欧诗漫补水霜" , "17890人兑换"));
        adapterFirst = new ConversionRankingAdapter(listFirst , getContext() , false);
        listviewFirst.setAdapter(adapterFirst);
        fixGrdiViewHeight03(listviewFirst);
    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        ConversionRankingAdapter listAdapter = (ConversionRankingAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+40);
        listView.setLayoutParams(params);
    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight04(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        EverydayConversionAdapter listAdapter = (EverydayConversionAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+40);
        listView.setLayoutParams(params);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_integer_goods_conversion_ranking_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.home_integer_goods_conversion_brand_more:
                //热门品牌更多
                startFragment(new HomeIntegerGoodsConversionBrandMore());
                break;
            case R.id.home_integer_goods_conversion_hot_commodity_more:
                //热门商品更多
                startFragment(new HomeIntegerGoodsHotCommodityMore());
                break;
        }
    }
}
