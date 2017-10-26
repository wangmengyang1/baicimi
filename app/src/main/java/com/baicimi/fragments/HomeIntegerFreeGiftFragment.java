package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.EverydayConversionAdapter;
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
        listThread.add(new HomeIntegerFreeGiftEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00" , "积分：6556" , "数量：16556", "绑定三张以上银行卡"));
        listThread.add(new HomeIntegerFreeGiftEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00" , "积分：6556" , "数量：16556"  , "认证人生重要时刻"));
        adapterThread = new HomeIntegerFreeGiftAdapter(listThread , getContext());
        listviewThread.setAdapter(adapterThread);
        fixGrdiViewHeight03(listviewThread);
    }

    //secondListView布局填充
    private void initSecondListView() {
        listviewSecond = (ListView) view.findViewById(R.id.home_integer_free_gift_listview_second);
        listSecond.clear();
        listSecond.add(new HomeIntegerFreeGiftEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00" , "积分：6556" , "数量：16556" , "V2专区"));
        listSecond.add(new HomeIntegerFreeGiftEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00" , "积分：6556" , "数量：16556", "V3专区"));
        adapterSecond = new HomeIntegerFreeGiftAdapter(listSecond , getContext());
        listviewSecond.setAdapter(adapterSecond);
        fixGrdiViewHeight03(listviewSecond);
    }

    //fistListView布局填充
    private void initFistListView() {
        listviewFirst = (ListView) view.findViewById(R.id.home_integer_free_gift_listview_first);
        listFirst.clear();
        listFirst.add(new HomeIntegerFreeGiftEntry(R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00" , "积分：6556" , "数量：16556" , "ischeck"));
        adapterFirst = new HomeIntegerFreeGiftAdapter(listFirst , getContext());
        listviewFirst.setAdapter(adapterFirst);
        fixGrdiViewHeight03(listviewFirst);
    }

    @Override
    protected void initData() {

    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        HomeIntegerFreeGiftAdapter listAdapter = (HomeIntegerFreeGiftAdapter) listView.getAdapter();
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

}
