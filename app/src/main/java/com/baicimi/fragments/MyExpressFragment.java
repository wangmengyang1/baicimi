package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.MyExpressFragmentAdapter;
import com.baicimi.adapter.UserIntegralSignInShoppingAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MyExpressFragmentEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 * 个人中心  我的快递
 */
public class MyExpressFragment extends BaseFragment {

    private View view;
    private ListView listView;
    private List<MyExpressFragmentEntry> list = new ArrayList<>();
    private MyExpressFragmentAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.my_express_fragment , container , false);

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.my_express_fragment_listview);
        list.clear();
        list.add(new MyExpressFragmentEntry(R.drawable.user_integral_fragment_15 , "已签收" , "2017/08/09" , "布艺抱枕沙发靠垫布艺抱枕沙发靠垫" , "圆通快递：721006012089"));
        list.add(new MyExpressFragmentEntry(R.drawable.user_integral_fragment_15 , "已签收" , "2017/08/09" , "布艺抱枕沙发靠垫布艺抱枕沙发靠垫" , "圆通快递：721006012089"));
        list.add(new MyExpressFragmentEntry(R.drawable.user_integral_fragment_15 , "已签收" , "2017/08/09" , "布艺抱枕沙发靠垫布艺抱枕沙发靠垫" , "圆通快递：721006012089"));
        adapter = new MyExpressFragmentAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }

    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MyExpressFragmentAdapter listAdapter = (MyExpressFragmentAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 40;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }



    @Override
    protected void initData() {

    }
}
