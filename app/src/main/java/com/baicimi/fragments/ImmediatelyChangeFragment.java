package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.ImmediatelyChangeAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.ImmediatelyChangeEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 * 积分商城   新人专区 立即兑换
 */
public class ImmediatelyChangeFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private GridView gridView;
    private List<ImmediatelyChangeEntry> list = new ArrayList<>();
    private ImmediatelyChangeAdapter adapter;

    private TextView conversion;//立即兑换

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.immediately_change_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.immediately_change_fragment_back);
        back.setOnClickListener(this);

        //GridView布局填充
        initGridView();

        conversion = (TextView) view.findViewById(R.id.immediately_change_fragment_conversion);
        container.setOnClickListener(this);
        return view;
    }

    //GridView布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.immediately_change_fragment_gridview);
        list.clear();
        list.add(new ImmediatelyChangeEntry(R.drawable.user_integral_fragment_code_second_image_07 , "宁菲洗发水" , "8200"));
        list.add(new ImmediatelyChangeEntry(R.drawable.user_integral_fragment_code_second_image_07 , "宁菲洗发水" , "8200"));
        list.add(new ImmediatelyChangeEntry(R.drawable.user_integral_fragment_code_second_image_07 , "宁菲洗发水" , "8200"));
        list.add(new ImmediatelyChangeEntry(R.drawable.user_integral_fragment_code_second_image_07 , "宁菲洗发水" , "8200"));
        list.add(new ImmediatelyChangeEntry(R.drawable.user_integral_fragment_code_second_image_07 , "宁菲洗发水" , "8200"));
        list.add(new ImmediatelyChangeEntry(R.drawable.user_integral_fragment_code_second_image_07 , "宁菲洗发水" , "8200"));
        adapter = new ImmediatelyChangeAdapter(list , getContext());
        gridView.setAdapter(adapter);
        fixGrdiViewHeight03(gridView);
    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight03(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        ImmediatelyChangeAdapter listAdapter = (ImmediatelyChangeAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()/3); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 20;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+30);
        listView.setLayoutParams(params);
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.immediately_change_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.immediately_change_fragment_conversion:

                break;
        }
    }
}
