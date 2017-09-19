package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.PresonCenterdGetIntegraAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.PresonCenterdeGetIntegralEntry;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */
public class PersonCenteredGetIntegral extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private GridView gridView;
    private List<PresonCenterdeGetIntegralEntry> list = new ArrayList<>();
    private PresonCenterdGetIntegraAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.person_centered_get_integral_fragment , container , false);

        //grdiview布局填充
        initGridView();

        back = (ImageView) view.findViewById(R.id.login_back_get_integral);
        back.setOnClickListener(this);

        return view;
    }

    //grdiview布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.person_centered_get_integral_fragment_gridview);
        list.clear();
        list.add(new PresonCenterdeGetIntegralEntry(R.drawable.preson_centered_get_integral_fragment_image_06 , new String("官方授权 自然堂官方补水保湿") , new String("¥39") , new String("100") , new String("54543人购买")));
        list.add(new PresonCenterdeGetIntegralEntry(R.drawable.preson_centered_get_integral_fragment_image_07 , new String("官方授权 自然堂官方补水保湿") , new String("¥39") , new String("100") , new String("54543人购买")));
        list.add(new PresonCenterdeGetIntegralEntry(R.drawable.preson_centered_get_integral_fragment_image_08 , new String("官方授权 自然堂官方补水保湿") , new String("¥39") , new String("100") , new String("54543人购买")));
        list.add(new PresonCenterdeGetIntegralEntry(R.drawable.preson_centered_get_integral_fragment_image_09 , new String("官方授权 自然堂官方补水保湿") , new String("¥39") , new String("100") , new String("54543人购买")));
        list.add(new PresonCenterdeGetIntegralEntry(R.drawable.preson_centered_get_integral_fragment_image_10 , new String("官方授权 自然堂官方补水保湿") , new String("¥39") , new String("100") , new String("54543人购买")));
        list.add(new PresonCenterdeGetIntegralEntry(R.drawable.preson_centered_get_integral_fragment_image_11 , new String("官方授权 自然堂官方补水保湿") , new String("¥39") , new String("100") , new String("54543人购买")));
        adapter = new PresonCenterdGetIntegraAdapter(getContext() , list);
        gridView.setAdapter(adapter);
        fixListViewHeight(gridView);
    }

    //动态计算GridView的高度
    public void fixListViewHeight(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        PresonCenterdGetIntegraAdapter listAdapter = (PresonCenterdGetIntegraAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()/2); index++) {
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
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_back_get_integral:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
        }
    }
}
