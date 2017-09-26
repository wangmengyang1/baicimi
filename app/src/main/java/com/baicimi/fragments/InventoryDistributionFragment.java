package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.DistributionOrderGoodsAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.DistributionOrderGoodsEntry;
import com.baicimi.interfaces.DistributionNumberOnitemClick;
import com.baicimi.view.ImageBrowseDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */
public class InventoryDistributionFragment extends BaseFragment implements DistributionNumberOnitemClick{

    private View view;

    private ListView listView;
    private List<DistributionOrderGoodsEntry> list = new ArrayList<>();
    private DistributionOrderGoodsAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.inventory_distribution_fragment , container , false);

        //listview布局填充
        initListView();
        return view;
    }


    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.distribution_order_good_fragment_listview);
        list.clear();
        for (int i = 0 ; i < 14 ; i++){
            list.add(new DistributionOrderGoodsEntry(new String("自然堂乐园补水保湿"), new String("250ML"), R.drawable.home_page_brand_fragment_image_22 ,new String("24") , 24 , new String("快递：50元") , new String("1810元") , false ));
        }
        adapter = new DistributionOrderGoodsAdapter(getContext() , list , this);
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
    }


    @Override
    protected void initData() {

    }

    @Override
    public void setNumberOnitemClick(View view, int i, long l) {

        switch ((int) l){
            case R.id.distribution_order_good_adapter_subtract_image:
                if(view == null){
                    return;
                }
                TextView textvew_add = (TextView) this.view.findViewById(R.id.distribution_order_good_adapter_number);
                int count_add = list.get(i).getNumber();
                count_add = count_add-1;
                if(count_add <= 0){
                    count_add = 0;
                }

                textvew_add.setText(count_add + "");
                list.get(i).setNumber(count_add);
                adapter.notifyDataSetChanged();
                break;
            case R.id.distribution_order_good_adapter_add_image:
                if(view == null){
                    return;
                }
                TextView textvew_sub = (TextView) this.view.findViewById(R.id.distribution_order_good_adapter_number);
                int count = list.get(i).getNumber();
                count = count+1;
                textvew_sub.setText(count + "");
                list.get(i).setNumber(count);
                adapter.notifyDataSetChanged();
                break;
            case R.id.distribution_order_good_adapter_imageurl:
                ImageBrowseDialog imageBrowseDialog = new ImageBrowseDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                imageBrowseDialog.show();

                break;
            case R.id.distribution_order_good_adapter_manager:
                list.get(i).setDelete(!(list.get(i).isDelete()));
                adapter.notifyDataSetChanged();
                break;
        }
    }


    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        DistributionOrderGoodsAdapter listAdapter = (DistributionOrderGoodsAdapter) listView.getAdapter();
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
