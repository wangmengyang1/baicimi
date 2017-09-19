package com.baicimi.fragments;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.DistributionOrderGoodsAdapter;
import com.baicimi.adapter.TodayCosmeticsAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.TodayCosmeticsEntry;
import com.baicimi.interfaces.DistributionNumberOnitemClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */
public class TodayCosmeticsFragment extends BaseFragment implements DistributionNumberOnitemClick, View.OnClickListener {

    private View view;

    private ListView listView;
    private List<TodayCosmeticsEntry> list_lv = new ArrayList<>();
    private TodayCosmeticsAdapter adapter;

    private TextView sales , news , price_one , price_two , attention;




    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.today_cosmetics_fragment , container , false);

        //listview布局填充
        initListView();

        //顶部导航栏布局设置
        initHeadTextViewBar();

        return view;
    }

    //顶部导航栏布局设置
    private void initHeadTextViewBar() {
        sales = (TextView) view.findViewById(R.id.today_cosmetics_fragment_sales);
        news = (TextView) view.findViewById(R.id.today_cosmetics_fragment_news);
        price_one = (TextView) view.findViewById(R.id.today_cosmetics_fragment_price_one);
        price_two = (TextView) view.findViewById(R.id.today_cosmetics_fragment_price_two);
        attention = (TextView) view.findViewById(R.id.today_cosmetics_fragment_price_attention);

        sales.setOnClickListener(this);
        news.setOnClickListener(this);
        price_one.setOnClickListener(this);
        price_two.setOnClickListener(this);
        attention.setOnClickListener(this);
    }

    private void initTextViewSetColor(){
        sales.setTextColor(Color.BLACK);
        news.setTextColor(Color.BLACK);
        price_one.setTextColor(Color.BLACK);
        price_two.setTextColor(Color.BLACK);
        attention.setTextColor(Color.BLACK);
    }


    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.today_cosmetics_fragment_listview);
        list_lv.add(new TodayCosmeticsEntry(R.drawable.today_cosmetics_adapter_image_01 , new String("积分价：¥159.00") , new String("商城价：¥259.00") , new String("澳雅婷蜗牛原液6件套补水护肤套装洁净系列") , new String("259") , new String("97") , new String("98120") , 1 ));
        list_lv.add(new TodayCosmeticsEntry(R.drawable.today_cosmetics_adapter_image_01 , new String("积分价：¥159.00") , new String("商城价：¥259.00") , new String("澳雅婷蜗牛原液6件套补水护肤套装洁净系列") , new String("259") , new String("97") , new String("98120") , 1 ));
        list_lv.add(new TodayCosmeticsEntry(R.drawable.today_cosmetics_adapter_image_01 , new String("积分价：¥159.00") , new String("商城价：¥259.00") , new String("澳雅婷蜗牛原液6件套补水护肤套装洁净系列") , new String("259") , new String("97") , new String("98120") , 1 ));
        adapter = new TodayCosmeticsAdapter(getContext() , list_lv , this);
        listView.setAdapter(adapter);
        fixListViewHeight(listView);

    }



    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        TodayCosmeticsAdapter listAdapter = (TodayCosmeticsAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount(); index++) {
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
    protected void initData() {

    }

    @Override
    public void setNumberOnitemClick(View view, int i, long l) {
        if(!(view == null)){

            TextView textview = (TextView) this.view.findViewById(R.id.today_cosmetics_adapter_number);
            switch ((int) l){
                case R.id.today_cosmetics_adapter_subtract:


                    int i1 = list_lv.get(i).getBuyNumber() - 1;
                    if(i1 <= 0){
                        textview.setText(0 + "");
                        list_lv.get(i).setBuyNumber(0);
                        adapter.notifyDataSetChanged();
                    }else{
                        textview.setText(i1 + "");
                        list_lv.get(i).setBuyNumber(i1);
                        adapter.notifyDataSetChanged();
                    }

                    break;
                case R.id.today_cosmetics_adapter_add:
                    int i2 = list_lv.get(i).getBuyNumber() + 1;
                    textview.setText(i2 + "");
                    list_lv.get(i).setBuyNumber(i2);
                    adapter.notifyDataSetChanged();
                    break;
                case R.id.today_cosmetics_adapter_shopcup:
                    startFragment(new ShopingCarFragment());
                    break;
                case R.id.today_cosmetics_adapter_immediatelyshop:
                    startFragment(new GoodsDetailsFragment());
                    break;
                case R.id.today_cosmetics_adapter_imageurl:
                    startFragment(new GoodsDetailsFragment());
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.today_cosmetics_fragment_sales:
                initTextViewSetColor();
                sales.setTextColor(Color.parseColor("#f05a4b"));
                break;
            case R.id.today_cosmetics_fragment_news:
                initTextViewSetColor();
                news.setTextColor(Color.parseColor("#f05a4b"));
                break;
            case R.id.today_cosmetics_fragment_price_one:
                initTextViewSetColor();
                price_one.setTextColor(Color.parseColor("#f05a4b"));
                break;
            case R.id.today_cosmetics_fragment_price_two:
                initTextViewSetColor();
                price_two.setTextColor(Color.parseColor("#f05a4b"));
                break;
            case R.id.today_cosmetics_fragment_price_attention:
                initTextViewSetColor();
                attention.setTextColor(Color.parseColor("#f05a4b"));
                break;
        }
    }
}
