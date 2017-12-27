package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.LogisticsEvaluateFragmentSecondParticularsAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.LogisticsEvaluateFragmentSecondParticularsEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/27.
 * 评价管理   物流评价   分销点/店详情
 */
public class LogisticsEvaluateFragmentSecondParticulars extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listView;
    private List<LogisticsEvaluateFragmentSecondParticularsEntry> list = new ArrayList<>();
    private LogisticsEvaluateFragmentSecondParticularsAdapter adapter;

    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.logistics_evaluate_fragment_second_particulars, container, false);

        //listview布局填充
        initListView();

        back = (ImageView) view.findViewById(R.id.logistics_evaluate_fragment_second_particulars_back);
        back.setOnClickListener(this);
        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.logistics_evaluate_fragment_second_particulars_listview);
        list.clear();
        list.add(new LogisticsEvaluateFragmentSecondParticularsEntry("这家门店是良心店家那，服务贼拉好，昨天忘记拿东西走了，当天就主动送上门了，每次购物那个服务人员都面带微笑，特耐心。网上购物特别的安心，正品保证支持支持！必须支持！"
                , R.drawable.user_integral_fragment_code_second_image_21, R.drawable.user_integral_fragment_code_second_image_22, false, "帅帅的小斌", false));
        list.add(new LogisticsEvaluateFragmentSecondParticularsEntry("这家门店是良心店家那，服务贼拉好，昨天忘记拿东西走了，当天就主动送上门了，每次购物那个服务人员都面带微笑，特耐心。网上购物特别的安心，正品保证支持支持！必须支持！"
                , R.drawable.user_integral_fragment_code_second_image_21, R.drawable.user_integral_fragment_code_second_image_22, true, "帅帅的小斌", true));
        list.add(new LogisticsEvaluateFragmentSecondParticularsEntry("这家门店是良心店家那，服务贼拉好，昨天忘记拿东西走了，当天就主动送上门了，每次购物那个服务人员都面带微笑，特耐心。网上购物特别的安心，正品保证支持支持！必须支持！"
                , R.drawable.user_integral_fragment_code_second_image_21, R.drawable.user_integral_fragment_code_second_image_22, true, "帅帅的小斌", true));
        adapter = new LogisticsEvaluateFragmentSecondParticularsAdapter(list, getContext(), this);

        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        LogisticsEvaluateFragmentSecondParticularsAdapter listAdapter = (LogisticsEvaluateFragmentSecondParticularsAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 45;
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
            case R.id.logistics_evaluate_fragment_second_particulars_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
