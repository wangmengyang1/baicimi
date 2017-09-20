package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.RosePersonalEssayListAdapter;
import com.baicimi.adapter.RosePersonalZanListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.RoseEssayListBean;
import com.baicimi.ui.MyListView;

import java.util.ArrayList;

/**
 * Created by tan on 2017/2/13.
 * 个人中心我的文章
 */
public class RosePersonalEssayFragment extends BaseFragment {
    private ListView listView;
    private ArrayList<RoseEssayListBean> arrayList;
    private RosePersonalEssayListAdapter essayListAdapter;
    final RoseEssayListBean zanListAdapter = new RoseEssayListBean();
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_rose_essay,container,false);

        listView = (ListView) view.findViewById(R.id.myessay_lv);

        arrayList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            zanListAdapter.setName("心善，心正，心宽...一切从心开始");
            arrayList.add(zanListAdapter);
        }
        essayListAdapter = new RosePersonalEssayListAdapter(getContext(), arrayList);
        listView.setAdapter(essayListAdapter);
        fixGridViewHeight(listView);
        return view;
    }

    @Override
    protected void initData() {

    }

    //动态计算Gridview的高度
    public void fixGridViewHeight(ListView listView ) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        RosePersonalEssayListAdapter gridAdapter = (RosePersonalEssayListAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (gridAdapter == null) {
            return;
        }
        for (int index = 0; index < gridAdapter.getCount(); index++) {
            View listViewItem = gridAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (gridAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}
