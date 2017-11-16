package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.GreenFoodFragmentFruitsAdapter;
import com.baicimi.adapter.GreenfoodBoutiqueAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.GreenfoodBoutiqueEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 * 绿色食品，精品炼成记
 */
public class GreenfoodBoutique extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private ListView listView;
    private List<GreenfoodBoutiqueEntry> list;
    private GreenfoodBoutiqueAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.green_food_boutique , container , false);
        back = (ImageView) view.findViewById(R.id.green_food_boutique_back);
        back.setOnClickListener(this);


        //listview布局填充
        initListView();

        return view;
    }
    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.green_food_boutique_listview);
        list = new ArrayList<>();
        list.clear();
        list.add(new GreenfoodBoutiqueEntry(R.drawable.green_food_image_13 , "五常大米是生活中米饭的佳品，其颗粒饱满，质地坚硬，色泽清白透饭粒油亮，香味浓郁，素有\\''贡米\\''之称。"));
        list.add(new GreenfoodBoutiqueEntry(R.drawable.green_food_image_17 , "五常市位于黑龙江省南部。地处北纬44度零4分至45度26分和东经126度33分至128度14分之间。北接松嫩平原，距省城哈尔滨115公里；东南靠张广才岭西麓与尚志市相邻，东北部与阿城市相邻，西部、西南部、南部与吉林省的榆树、舒兰、蛟河毗邻，是黑吉两省经济结合部。幅员面积7512平方公里，五常地域呈狭长形，西北倾斜。"));
        list.add(new GreenfoodBoutiqueEntry(R.drawable.green_food_image_18 , "水请浅五常大米源自五常近千亩稻田，2014年承包，每年产量1200余吨。"));
        list.add(new GreenfoodBoutiqueEntry(R.drawable.green_food_image_19 , "从种植到收割，遵循水稻生长规律，聘请当地农民精心打理。"));
        list.add(new GreenfoodBoutiqueEntry(R.drawable.green_food_image_20 , "脱粒加工装袋也是由当地农民亲自完成。"));
        list.add(new GreenfoodBoutiqueEntry(R.drawable.green_food_image_21 , "装袋完成后，运往当地水稻深加工工厂进行深加工。"));
        list.add(new GreenfoodBoutiqueEntry(R.drawable.green_food_image_22 , "加工好的成品大米运往当地仓库储存。"));
        adapter = new GreenfoodBoutiqueAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
    }

    @Override
    protected void initData() {

    }


    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        GreenfoodBoutiqueAdapter listAdapter = (GreenfoodBoutiqueAdapter) listView.getAdapter();
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
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+250);
        listView.setLayoutParams(params);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.green_food_boutique_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
