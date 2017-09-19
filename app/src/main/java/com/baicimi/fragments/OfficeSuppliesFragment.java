package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.OfficsSuppliesAdapter;
import com.baicimi.adapter.TodayCosmeticsAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.OfficsSuppliesEntry;
import com.baicimi.interfaces.OfficeSuppliesOnitemClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */
public class OfficeSuppliesFragment extends BaseFragment implements OfficeSuppliesOnitemClick{

    private View view;
    private ListView listView;
    private List<OfficsSuppliesEntry> list = new ArrayList<>();
    private OfficsSuppliesAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.office_supplies_fragment , container , false);

        //listview布局填充
        initListView();

        return view;
    }
    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.office_supplies_fragment_listview);
        list.clear();
        list.add(new OfficsSuppliesEntry(new String("柏树针员工名片 50张*2") , R.drawable.office_supplies_adapter_image_01 , new String("¥87.80") , 1));
        list.add(new OfficsSuppliesEntry(new String("柏树针员工名片 50张*2") , R.drawable.office_supplies_adapter_image_01 , new String("¥87.80") , 1));
        list.add(new OfficsSuppliesEntry(new String("柏树针员工名片 50张*2") , R.drawable.office_supplies_adapter_image_01 , new String("¥87.80") , 1));
        adapter = new OfficsSuppliesAdapter(getContext() , list , this);
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void setOfficeSuppliesOnitemClick(View view, int i, long l) {
        if(view != null){
            TextView textView = (TextView) this.view.findViewById(R.id.office_supplies_adapter_number);
            switch ((int) l){
                case R.id.office_supplies_adapter_add:
                    int i2 = list.get(i).getNumber() + 1;
                    textView.setText(i2 + "");
                    list.get(i).setNumber(i2);
                    adapter.notifyDataSetChanged();

                    break;
                case R.id.office_supplies_adapter_subtract:
                    int i1 = list.get(i).getNumber() - 1;
                    if(i1 <= 0){
                        textView.setText(0 + "");
                        list.get(i).setNumber(0);
                        adapter.notifyDataSetChanged();
                    }else{
                        textView.setText(i1 + "");
                        list.get(i).setNumber(i1);
                        adapter.notifyDataSetChanged();
                    }

                    break;
            }
        }
    }




    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        OfficsSuppliesAdapter listAdapter = (OfficsSuppliesAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount(); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


}
