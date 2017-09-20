package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.RosePersonalAllAdapter;
import com.baicimi.adapter.RosePersonalZanListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.RoseZanListBean;
import com.baicimi.ui.MyListView;

import java.util.ArrayList;

/**
 * Created by tan on 2017/2/21.
 * 玫瑰社区个人中心赞
 */
public class RosePersonalZanFragment extends BaseFragment {
    private ListView listView;
    private ArrayList<RoseZanListBean> arrayList;
    private RosePersonalZanListAdapter zanListAdapter;
    final RoseZanListBean roseZanListBean = new RoseZanListBean();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_personal_zan, container, false);

        listView = (ListView) view.findViewById(R.id.rose_zan_list);

        arrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            roseZanListBean.setName("GERRY");
            arrayList.add(roseZanListBean);
        }
        zanListAdapter = new RosePersonalZanListAdapter(getActivity(), arrayList);
        listView.setAdapter(zanListAdapter);
        fixGridViewHeight(listView);
        return view;
    }


    @Override
    protected void initData() {

    }

    //动态计算Gridview的高度
    public void fixGridViewHeight(ListView listView ) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        RosePersonalZanListAdapter gridAdapter = (RosePersonalZanListAdapter) listView.getAdapter();
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
