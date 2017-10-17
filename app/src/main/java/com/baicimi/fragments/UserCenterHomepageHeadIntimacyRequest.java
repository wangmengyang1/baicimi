package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.HomepageHeadIntimacyAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.HomepageHeadIntimacyEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 * 发起亲密付
 */
public class UserCenterHomepageHeadIntimacyRequest extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private ListView listview;
    private List<HomepageHeadIntimacyEntry> list = new ArrayList<>();
    private HomepageHeadIntimacyAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.usercentr_homepagehead_intimacy_request , container , false);

        back = (ImageView) view.findViewById(R.id.usercenter_homepagehead_request_fragment_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listview = (ListView) view.findViewById(R.id.usercenter_homepagehead_intimacy_request_listview);
        list.clear();
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "join"));
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "mark"));
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "yoyo"));
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "ben"));
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "landy"));
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "join"));
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "mark"));
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "yoyo"));
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "ben"));
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "landy"));
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "mark"));
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "yoyo"));
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "ben"));
        list.add(new HomepageHeadIntimacyEntry(R.drawable.user_integral_gridview_item_image_41ss , "landy"));
        adapter = new HomepageHeadIntimacyAdapter(list , getContext());
        listview.setAdapter(adapter);
        fixListViewHeight(listview);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usercenter_homepagehead_request_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }



    //动态计算GridView的高度
    public void fixListViewHeight(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        HomepageHeadIntimacyAdapter listAdapter = (HomepageHeadIntimacyAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
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

}
