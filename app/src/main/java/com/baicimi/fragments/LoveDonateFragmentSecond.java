package com.baicimi.fragments;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.LoveDonateFragmentListAdapter;
import com.baicimi.adapter.LoveDonateFragmentSecondAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.LoveDonateDialog;
import com.baicimi.view.LoveDonateSecondDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 * 个人中心首页 爱心捐赠   资助进行中
 */
public class LoveDonateFragmentSecond extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listView;
    private List<Integer> list = new ArrayList<>();
    private LoveDonateFragmentSecondAdapter adapter;

    private TextView wantsupport;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.love_donate_fragment_second , container , false);

        //listview布局填充
        initListView();

        wantsupport = (TextView) view.findViewById(R.id.love_donate_fragment_second_wantsupport);
        wantsupport.setOnClickListener(this);
        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.love_donate_fragment_second_listview);
        list.clear();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        adapter = new LoveDonateFragmentSecondAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }

    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        LoveDonateFragmentSecondAdapter listAdapter = (LoveDonateFragmentSecondAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 25;
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.love_donate_fragment_second_wantsupport:
                LoveDonateSecondDialog addf = new LoveDonateSecondDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFiveGrivaty);
                Window win = addf.getWindow();
                WindowManager.LayoutParams params = new WindowManager.LayoutParams();
                params.gravity = Gravity.BOTTOM;
                win.setAttributes(params);
                addf.show();
                break;
        }
    }
}
