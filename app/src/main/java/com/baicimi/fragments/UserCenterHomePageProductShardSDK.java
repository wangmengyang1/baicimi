package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.ProductShardSdkAdapter;
import com.baicimi.adapter.UserCenterHomePageSecondAdapter;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 * 分享（产品分享）
 */
public class UserCenterHomePageProductShardSDK extends BaseFragment implements View.OnClickListener {

    private View view;
    private GridView gridView;
    private List<Integer> list = new ArrayList<>();
    private ProductShardSdkAdapter adapter;
    private ImageView back;
    private LinearLayout layout_first;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.usercenter_homepage_product_shardsdk , container , false);

        //GridView布局填充
        initGridView();

        back = (ImageView) view.findViewById(R.id.usercenter_homepage_product_shardsdk_back);
        back.setOnClickListener(this);

        layout_first = (LinearLayout) view.findViewById(R.id.usercenter_homepage_product_shardsdk_second_layout);
        layout_first.setOnClickListener(this);
        return view;
    }

    //GridView布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.usercenter_homepage_product_shardsdk_gridview);
        list.clear();
        list.add(R.drawable.usercenter_home_page_shardsdk_image_04);
        list.add(R.drawable.usercenter_home_page_shardsdk_image_05);
        list.add(R.drawable.usercenter_home_page_shardsdk_image_06);
        list.add(R.drawable.usercenter_home_page_shardsdk_image_07);
        list.add(R.drawable.usercenter_home_page_shardsdk_image_08);
        list.add(R.drawable.usercenter_home_page_shardsdk_image_09);
        list.add(R.drawable.usercenter_home_page_shardsdk_image_10);
        adapter = new ProductShardSdkAdapter(list , getContext());
        gridView.setAdapter(adapter);
        fixGrdiViewHeight03(gridView);
    }

    @Override
    protected void initData() {

    }

    //动态计算GridView的高度
    public void fixGrdiViewHeight03(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        ProductShardSdkAdapter listAdapter = (ProductShardSdkAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index <= (listAdapter.getCount() /6); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usercenter_homepage_product_shardsdk_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.usercenter_homepage_product_shardsdk_second_layout:
                //分享
                startFragment(new UserCenterHomePageShardSDK());
                break;
        }
    }
}
