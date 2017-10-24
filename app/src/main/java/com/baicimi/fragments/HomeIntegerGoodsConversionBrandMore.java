package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.ConversionRankingAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.ConversionRankingEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 * 积分商城  兑换排行 热门品牌  查看更多
 *
 */
public class HomeIntegerGoodsConversionBrandMore extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listviewSecond ;
    private List<ConversionRankingEntry> listSecond = new ArrayList<>();
    private ConversionRankingAdapter adapterSecond;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.home_integer_goods_conversion_brand_more , container , false);

        //SecondListView布局填充
        initSecondListView();

        back = (ImageView) view.findViewById(R.id.home_integer_goods_conversion_brand_more_back);
        back.setOnClickListener(this);

        return view;
    }


    //SecondListView布局填充
    private void initSecondListView() {
        listviewSecond = (ListView) view.findViewById(R.id.homeinteger_goods_conversion_brand_more_listview);
        listSecond.clear();
        listSecond.add(new ConversionRankingEntry(R.drawable.home_integer_conversion_08 , "梦露MULU" , "17890人兑换"));
        listSecond.add(new ConversionRankingEntry(R.drawable.home_integer_conversion_08 , "梦露MULU" , "17890人兑换"));
        listSecond.add(new ConversionRankingEntry(R.drawable.home_integer_conversion_08 , "梦露MULU" , "17890人兑换"));
        adapterSecond = new ConversionRankingAdapter(listSecond , getContext() , true);
        listviewSecond.setAdapter(adapterSecond);
        fixGrdiViewHeight03(listviewSecond);
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

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_integer_goods_conversion_brand_more_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级文件
                break;
        }
    }
}
