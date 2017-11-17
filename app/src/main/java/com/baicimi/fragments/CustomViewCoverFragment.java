package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.CustomViewCoverAdapter;
import com.baicimi.base.BaseFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/16.
 * 个人中心，封面设置分类页 自定义封面
 */
public class CustomViewCoverFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private GridView gridView_01 , getGridView_02;
    private List<Integer> list_01 , list_02;
    private ImageView back;
    private CustomViewCoverAdapter adapter_01 , adapter_02;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.custom_view_cover_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.custom_view_cover_fragment_back);
        back.setOnClickListener(this);

        //GridView布局填充
        initGridViewFirst(R.id.custom_view_cover_fragment_gridview_01 , list_01 , adapter_01);
        initGridViewFirst(R.id.custom_view_cover_fragment_gridview_02 , list_02 , adapter_02);

        return view;
    }

    private void initGridViewFirst(int id  , List<Integer> list , CustomViewCoverAdapter adapter) {
        gridView_01 = (GridView) view.findViewById(id);
        list = new ArrayList<>();
        list.clear();
        for (int i = 0 ; i < 9 ;i++){
            list.add(R.drawable.tupian_image_02);
        }
        adapter = new CustomViewCoverAdapter(list , getContext());
        gridView_01.setAdapter(adapter);
        fixGrdiViewHeight03(gridView_01);
    }

    @Override
    protected void initData() {

    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight03(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        CustomViewCoverAdapter listAdapter = (CustomViewCoverAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount() / 3); index++) {
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
            case R.id.custom_view_cover_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
