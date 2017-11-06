package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.HomeIntegerFreeGiftAdapter;
import com.baicimi.adapter.NewPeoplePrefectureAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.NewPeoplePrefectureEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 * 积分商城   新人专区
 */

public class HomeIntegerNewPeoplePrefecture extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listviewFirst , listviewSecond  ,listviewThread;
    private List<NewPeoplePrefectureEntry> listFirst = new ArrayList<>();
    private List<NewPeoplePrefectureEntry> listSecond = new ArrayList<>();
    private List<NewPeoplePrefectureEntry> listThread = new ArrayList<>();
    private NewPeoplePrefectureAdapter adapterFirst;
    private NewPeoplePrefectureAdapter adapterSecond;
    private NewPeoplePrefectureAdapter adapterThread;

    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.home_integer_home_people_prefecture , container , false);

        //firstlistview布局填充
        initFirstListView();
        //secondListviw布局填充
        initSecondListView();
        //threadlistview布局填充
        initThreadListView();


        back = (ImageView) view.findViewById(R.id.home_integer_home_people_perfecture_back);
        back.setOnClickListener(this);
        return view;
    }

    //threadlistview布局填充
    private void initThreadListView() {
        listviewThread = (ListView) view.findViewById(R.id.home_integer_home_people_prefecture_listview_thread);
        listThread.clear();
        listThread.add(new NewPeoplePrefectureEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "数量：16556" , "积分：6556"));
        listThread.add(new NewPeoplePrefectureEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "数量：16556" , "积分：6556"));
        adapterThread = new NewPeoplePrefectureAdapter(listThread , getContext() , this);
        listviewThread.setAdapter(adapterThread);
        fixGrdiViewHeight03(listviewThread);
    }

    //secondListviw布局填充
    private void initSecondListView() {
        listviewSecond = (ListView) view.findViewById(R.id.home_integer_home_people_prefecture_listview_second);
        listSecond.clear();
        listSecond.add(new NewPeoplePrefectureEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "数量：16556" , "积分：6556"));
        listSecond.add(new NewPeoplePrefectureEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "数量：16556" , "积分：6556"));
        adapterSecond = new NewPeoplePrefectureAdapter(listSecond , getContext(), this);
        listviewSecond.setAdapter(adapterSecond);
        fixGrdiViewHeight03(listviewSecond);
    }

    //firstlistview布局填充
    private void initFirstListView() {
        listviewFirst = (ListView) view.findViewById(R.id.home_integer_home_people_prefecture_listview_first);
        listFirst.clear();
        listFirst.add(new NewPeoplePrefectureEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "数量：16556" , "积分：6556"));
        listFirst.add(new NewPeoplePrefectureEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "数量：16556" , "积分：6556"));
        listFirst.add(new NewPeoplePrefectureEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "数量：16556" , "积分：6556"));
        adapterFirst = new NewPeoplePrefectureAdapter(listFirst , getContext(), this);
        listviewFirst.setAdapter(adapterFirst);
        fixGrdiViewHeight03(listviewFirst);

    }

    @Override
    protected void initData() {

    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        NewPeoplePrefectureAdapter listAdapter = (NewPeoplePrefectureAdapter) listView.getAdapter();
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
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+80);
        listView.setLayoutParams(params);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_integer_home_people_perfecture_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
