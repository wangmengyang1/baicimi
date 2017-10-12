package com.baicimi.fragments;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.GrouBuyPersonGvAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.GrouBuyMeiZhuangGvBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/12/13.
 * 团购页面
 */
public class GrouBuyFragment extends BaseFragment implements View.OnClickListener {
    private GridView myGridView,myGridView1,myGridView2,myGridView3,myGridView4;
    private List<GrouBuyMeiZhuangGvBean> list , list_second , list_third , list_four , list_five;
    private GrouBuyPersonGvAdapter personGvAdapter , muYiingGvAdapter , xuanGvAdapter , rihuaGvAdapter , foodGvAdapter;


    private TextView choiceness_tv , lobby_tv;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_groubuying,container,false);

        myGridView= (GridView) view.findViewById(R.id.tuangog_meizhuang_gv);
        myGridView1= (GridView) view.findViewById(R.id.tuangog_muying_gv);
        myGridView2= (GridView) view.findViewById(R.id.tuangog_personuse_gv);
        myGridView3= (GridView) view.findViewById(R.id.tuangog_meizhuang_gv_05);
        myGridView4= (GridView) view.findViewById(R.id.tuangog_meizhuang_gv_04);

//        //美妆个护布局填充
        initMyGridViewFirst();
//
//        //母婴用品布局填充
        initMyGridViewSecond();
//        //个人用品布局填充
        initMyGridViewThred();
        //日化用品布局填充
        initMyGridViewFour();
        //绿色食品布局填充
        initMyGridViewFive();


        //团购精选及大厅切换效果
        initChoiceness();

        return view;
    }
    //绿色食品布局填充
    private void initMyGridViewFive() {
        list_five = new ArrayList<>();
        list_five.clear();
        list_five.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_21));
        list_five.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_22));
        list_five.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_23));
        list_five.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_24));
        list_five.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_25));
        list_five.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_26));


        foodGvAdapter=new GrouBuyPersonGvAdapter(getContext(),list_five);
        myGridView4.setAdapter(foodGvAdapter);
        fixGridViewHeight(myGridView4);
        myGridView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                startFragment(new GrouBuyDetailFragment(),null);
                startFragment(new GoodsDetailsGrouBuyFragment(),null);
            }
        });

    }

    //日化用品布局填充
    private void initMyGridViewFour() {
        list_four = new ArrayList<>();
        list_four.clear();
        list_four.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_21));
        list_four.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_22));
        list_four.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_23));
        list_four.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_24));
        list_four.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_25));
        list_four.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_26));


        rihuaGvAdapter=new GrouBuyPersonGvAdapter(getContext(),list_four);
        myGridView3.setAdapter(rihuaGvAdapter);
        fixGridViewHeight(myGridView3);
        myGridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                startFragment(new GrouBuyDetailFragment(),null);
                startFragment(new GoodsDetailsGrouBuyFragment(),null);
            }
        });

    }


    //团购精选及大厅切换效果
    private void initChoiceness() {
        choiceness_tv = (TextView) view.findViewById(R.id.fragment_groubuying_choiceness_tv);
        lobby_tv = (TextView) view.findViewById(R.id.fragment_groubuying_lobby_tv);
        choiceness_tv.setOnClickListener(this);
        lobby_tv.setOnClickListener(this);
    }

    //个人用品布局填充
    private void initMyGridViewThred() {
        list_third = new ArrayList<>();
        list_third.clear();
        list_third.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_21));
        list_third.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_22));
        list_third.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_23));
        list_third.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_24));
        list_third.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_25));
        list_third.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_26));


        personGvAdapter=new GrouBuyPersonGvAdapter(getContext(),list_third);
        myGridView2.setAdapter(personGvAdapter);
        fixGridViewHeight(myGridView2);
        myGridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                startFragment(new GrouBuyDetailFragment(),null);
                startFragment(new GoodsDetailsGrouBuyFragment(),null);
            }
        });


    }

    //母婴用品布局填充
    private void initMyGridViewSecond() {
        list_second = new ArrayList<>();
        list_second.clear();
        list_second.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_15));
        list_second.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_16));
        list_second.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_17));
        list_second.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_18));
        list_second.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_19));
        list_second.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_20));
        muYiingGvAdapter=new GrouBuyPersonGvAdapter(getContext(),list_second);
        myGridView1.setAdapter(muYiingGvAdapter);
        fixGridViewHeight(myGridView1);
        myGridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                startFragment(new GrouBuyDetailFragment(),null);
                startFragment(new GoodsDetailsGrouBuyFragment(),null);
            }
        });
    }

    //美妆个护布局填充
    private void initMyGridViewFirst() {
        list = new ArrayList<>();
        list.clear();
        list.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_09));
        list.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_10));
        list.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_11));
        list.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_12));
        list.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_13));
        list.add(new GrouBuyMeiZhuangGvBean(new String("官方授权 自然堂乐园补水保湿") , new String("原价¥320") , new String("单人团¥120") , new String("¥15.7") , R.drawable.image_tuangou_14));

        xuanGvAdapter=new GrouBuyPersonGvAdapter(getContext(),list);
        myGridView.setAdapter(xuanGvAdapter);
        fixGridViewHeight(myGridView);
        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                startFragment(new GrouBuyDetailFragment(),null);
                startFragment(new GoodsDetailsGrouBuyFragment(),null);
            }
        });


    }


    @Override
    protected void initData() {

    }

    @Override
    public void onResume() {
        super.onResume();
        System.gc();
    }


    //动态计算listview的高度
    public void fixGridViewHeight(GridView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        GrouBuyPersonGvAdapter listAdapter = (GrouBuyPersonGvAdapter) listView.getAdapter();
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
    public void onDetach() {
        if (view != null){
            personGvAdapter = null;
            muYiingGvAdapter = null;
            xuanGvAdapter = null;
            view = null;

        }
        System.gc();
        super.onDetach();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_groubuying_choiceness_tv:
                choiceness_tv.setTextColor(Color.parseColor("#c22737"));
                choiceness_tv.setBackgroundResource(R.drawable.user_center_title_bar_indicator_layer_list);
                lobby_tv.setTextColor(Color.parseColor("#5a5a5a"));
                lobby_tv.setBackgroundResource(R.drawable.background_null);
                break;
            case R.id.fragment_groubuying_lobby_tv:
                lobby_tv.setTextColor(Color.parseColor("#c22737"));
                lobby_tv.setBackgroundResource(R.drawable.user_center_title_bar_indicator_layer_list);
                choiceness_tv.setTextColor(Color.parseColor("#5a5a5a"));
                choiceness_tv.setBackgroundResource(R.drawable.background_null);
                break;
        }
    }
}
