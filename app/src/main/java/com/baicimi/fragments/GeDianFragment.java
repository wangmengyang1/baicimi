package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.baicimi.R;
import com.baicimi.adapter.GeRenGoodsGvAdapter;
import com.baicimi.adapter.HeadPinPaiActivityGvAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.GeRenYongPinGridViewBean;
import com.baicimi.bean.ShaiXuanListBean;
import com.baicimi.interfaces.DistributionNumberOnitemClick;
import com.baicimi.ui.MyGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/10/20.
 * 活动专场个护电器界面
 */
public class GeDianFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    /** 母婴用品gridview
     */
    private GridView gridView;

    private List<ShaiXuanListBean> listBeen;
    private HeadPinPaiActivityGvAdapter xuanGvAdapter;
    final ShaiXuanListBean shaiXuanListBean_list=new ShaiXuanListBean();
    private DistributionNumberOnitemClick distributionNumberOnitemClick;


    public GeDianFragment() {
    }

    public GeDianFragment(DistributionNumberOnitemClick distributionNumberOnitemClick) {
        this.distributionNumberOnitemClick = distributionNumberOnitemClick;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.head_gridview,container,false);


        /**
         * 底部GridView
         * */
        gridView= (GridView) view.findViewById(R.id.persan_bottom_vp);
        listBeen=new ArrayList<>();
        for (int i=0;i<6;i++){
            shaiXuanListBean_list.setTv_goods_name("洗发水");
            shaiXuanListBean_list.setTv_jifendikou_num("5000");
            shaiXuanListBean_list.setJifendikou_mony_num("100");
            shaiXuanListBean_list.setTv_now_price("8908.00");
            shaiXuanListBean_list.setTv_used_price("9008.00");
            listBeen.add(shaiXuanListBean_list);
        }
        xuanGvAdapter=new HeadPinPaiActivityGvAdapter(getActivity(),listBeen , this);
        gridView.setAdapter(xuanGvAdapter);
        fixListViewHeight(gridView);

        int width =View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int height = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        view.measure(width,height);
        if(distributionNumberOnitemClick != null){
            distributionNumberOnitemClick.setNumberOnitemClick(view , view.getMeasuredHeight() , 0);

        }
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //需要数据进行传送（暂无数据）
        startFragment(new GoodsDetailsFragment(),null);
    }


    //动态计算listview的高度
    public void fixListViewHeight(GridView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        HeadPinPaiActivityGvAdapter listAdapter = (HeadPinPaiActivityGvAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount()/2; index++) {
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
