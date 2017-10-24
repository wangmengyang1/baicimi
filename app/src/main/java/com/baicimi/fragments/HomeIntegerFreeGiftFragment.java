package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.HomeIntegerFreeGiftAdapter;
import com.baicimi.adapter.HomeIntegerFreeGiftEntry;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 * 积分商城 免费礼品
 */

public class HomeIntegerFreeGiftFragment extends BaseFragment {

    private View view;
    private ListView listviewFirst , listviewSecond , listviewThread;
    private List<HomeIntegerFreeGiftEntry> listFirst = new ArrayList<>();
    private List<HomeIntegerFreeGiftEntry> listSecond = new ArrayList<>();
    private List<HomeIntegerFreeGiftEntry> listThread = new ArrayList<>();
    private HomeIntegerFreeGiftAdapter adapterFirst;
    private HomeIntegerFreeGiftAdapter adapterSecond;
    private HomeIntegerFreeGiftAdapter adapterThread;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.home_integer_free_gift_fragmetn , container , false);

        //fistListView布局填充
        initFistListView();
        //secondListView布局填充
        initSecondListView();
        //threadListView布局填充
        initThreadListView();

        return view;
    }

    //threadListView布局填充
    private void initThreadListView() {
        listviewThread = (ListView) view.findViewById(R.id.home_integer_free_gift_listview_thread);
        listThread.clear();
        listThread.add(new HomeIntegerFreeGiftEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00" , "积分：6556" , "数量：16556"));
        adapterThread = new HomeIntegerFreeGiftAdapter(listFirst , getContext());
        listviewThread.setAdapter(adapterThread);
    }

    //secondListView布局填充
    private void initSecondListView() {
        listviewSecond = (ListView) view.findViewById(R.id.home_integer_free_gift_listview_second);
        listSecond.clear();
        listSecond.clear();
        listSecond.add(new HomeIntegerFreeGiftEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00" , "积分：6556" , "数量：16556"));
        listSecond.add(new HomeIntegerFreeGiftEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00" , "积分：6556" , "数量：16556"));
        adapterSecond = new HomeIntegerFreeGiftAdapter(listFirst , getContext());
        listviewSecond.setAdapter(adapterSecond);
    }

    //fistListView布局填充
    private void initFistListView() {
        listviewFirst = (ListView) view.findViewById(R.id.home_integer_free_gift_listview_first);
        listFirst.clear();
        listFirst.add(new HomeIntegerFreeGiftEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00" , "积分：6556" , "数量：16556"));
        adapterFirst = new HomeIntegerFreeGiftAdapter(listFirst , getContext());
        listviewFirst.setAdapter(adapterFirst);
    }

    @Override
    protected void initData() {

    }
}
