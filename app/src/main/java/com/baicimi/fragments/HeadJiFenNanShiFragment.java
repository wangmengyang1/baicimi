package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.baicimi.R;
import com.baicimi.adapter.HeadPinPaiActivityGvAdapter;
import com.baicimi.adapter.MuYingGoodsGvAdapter;
import com.baicimi.adapter.NanShiGoodsGvAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.MuYingYongPinGridViewBean;
import com.baicimi.interfaces.DistributionNumberOnitemClick;
import com.baicimi.ui.MyGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/10/21.
 * 首页积分商城男士
 */
public class HeadJiFenNanShiFragment extends BaseFragment {
    /**
     * 母婴用品gridview
     * */
    private GridView gridView;
    private List<MuYingYongPinGridViewBean> listBeen;
    private NanShiGoodsGvAdapter xuanGvAdapter;
    final MuYingYongPinGridViewBean shaiXuanListBean_list=new MuYingYongPinGridViewBean();

    private DistributionNumberOnitemClick distributionNumberOnitemClick;


    public HeadJiFenNanShiFragment() {
    }

    public HeadJiFenNanShiFragment(DistributionNumberOnitemClick distributionNumberOnitemClick) {
        this.distributionNumberOnitemClick = distributionNumberOnitemClick;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.nanshi_gridview,container,false);


        /**
         * 母婴用品gridview
         * */
        gridView= (GridView) view.findViewById(R.id.nanshi_gv);
        listBeen=new ArrayList<>();
        for (int i=0;i<10;i++){
            shaiXuanListBean_list.setTv_goods_message("官方授权 自然堂乐园补水保湿");
            shaiXuanListBean_list.setTv_buy_um("积分9999");
            listBeen.add(shaiXuanListBean_list);
        }
        xuanGvAdapter=new NanShiGoodsGvAdapter(getContext(),listBeen , this);
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



    //动态计算listview的高度
    public void fixListViewHeight(GridView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        NanShiGoodsGvAdapter listAdapter = (NanShiGoodsGvAdapter) listView.getAdapter();
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
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1) + 25);
        listView.setLayoutParams(params);
    }

}
