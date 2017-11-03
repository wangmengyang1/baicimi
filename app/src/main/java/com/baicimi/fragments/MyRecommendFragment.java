package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.GridViewHeadAdapter;
import com.baicimi.adapter.MyRecommendAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MyRecommendEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 * 个人中心  百万行动计划  我要推荐页面
 */
@SuppressLint("ValidFragment")
public class MyRecommendFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private String libleString;
    private ImageView back;
    private TextView lible;

    private ListView listView;
    private List<MyRecommendEntry> list = new ArrayList<>();
    private MyRecommendAdapter adapter;


    public MyRecommendFragment(String libleString) {
        this.libleString = libleString;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.my_recommend_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.my_reconmmend_fragment_back);
        back.setOnClickListener(this);

        lible = (TextView) view.findViewById(R.id.my_reconmmend_fragment_lible);
        lible.setText(libleString);

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.my_reconmmend_fragment_listview);
        list.clear();
        list.add(new MyRecommendEntry(R.drawable.image_convertion_01 , "礼品名称：洁丽雅纯棉毛巾4条装" , "价值（元）：29.99" , "积分：1200" , "已推荐成功人数：10人"));
        list.add(new MyRecommendEntry(R.drawable.image_convertion_01 , "礼品名称：洁丽雅纯棉毛巾4条装" , "价值（元）：29.99" , "积分：1200" , "已推荐成功人数：10人"));
        list.add(new MyRecommendEntry(R.drawable.image_convertion_01 , "礼品名称：洁丽雅纯棉毛巾4条装" , "价值（元）：29.99" , "积分：1200" , "已推荐成功人数：10人"));
        list.add(new MyRecommendEntry(R.drawable.image_convertion_01 , "礼品名称：洁丽雅纯棉毛巾4条装" , "价值（元）：29.99" , "积分：1200" , "已推荐成功人数：10人"));
        adapter = new MyRecommendAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
    }



    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MyRecommendAdapter listAdapter = (MyRecommendAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount(); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            totalHeight += 16;
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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.my_reconmmend_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
