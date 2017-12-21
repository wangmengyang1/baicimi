package com.baicimi.fragments;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.baicimi.R;
import com.baicimi.adapter.MilimitFragmentEarnestCodeAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MilimitFragmentEarnestCodeEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/20.
 * 个人中心首页 我的生活助手  幂额度首页 幂信用积分
 */
public class MilimitFragmentEarnestCode extends BaseFragment{

    private View view;

    private GridView gridViewFirst , gridViewSecond;
    private List<MilimitFragmentEarnestCodeEntry> listFirst = new ArrayList<>();
    private List<MilimitFragmentEarnestCodeEntry> listSecond = new ArrayList<>();

    private MilimitFragmentEarnestCodeAdapter adapterFirst;
    private MilimitFragmentEarnestCodeAdapter adapterSecond;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_limit_fragment_earnest_code , container , false);

        //girdview 布局填充
        initGirdView();
        initGirdViewSecond();

        return view;
    }

    //girdview 布局填充
    private void initGirdViewSecond() {
        gridViewSecond = (GridView) view.findViewById(R.id.mi_limit_fragment_earnest_code_gridview_second);
        listSecond.clear();
        listSecond.add(new MilimitFragmentEarnestCodeEntry(R.drawable.mi_limit_image_18 ,
                "推荐朋友" , "推荐朋友成为百次幂会员，可获得积分，并在被推荐者每次购买商品时，都会有想当比例积分自动转到你的个人账户下。" ,
                "去看看" , true , "现在兑换" , true , Color.parseColor("#c4c4c4")));
        listSecond.add(new MilimitFragmentEarnestCodeEntry(R.drawable.mi_limit_image_19 ,
                "晒图留言" , "推荐朋友成为百次幂会员，可获得积分，并在被推荐者每次购买商品时，都会有想当比例积分自动转到你的个人账户下。。" ,
                "我去晒图" , true , "开始兑换" , false , Color.parseColor("#f8f8f8")));
        listSecond.add(new MilimitFragmentEarnestCodeEntry(R.drawable.mi_limit_image_20 ,
                "购买商品" , "线上购买，在百次幂商城购买任意商品都可获得积分，系统根据成交金额自动将获得的积分转入到您的个人积分账户中，线下购买" ,
                "去逛逛" , true , "开始兑换" , false , Color.parseColor("#c4c4c4")));
        listSecond.add(new MilimitFragmentEarnestCodeEntry(R.drawable.mi_limit_image_21 ,
                "每日签到" , "百次幂商城APP每日签到即可获得相应积分。" ,
                "马上签到" , true , "开始兑换" , false , Color.parseColor("#f8f8f8")));
        listSecond.add(new MilimitFragmentEarnestCodeEntry(R.drawable.mi_limit_image_22 ,
                "积分活动" , "参加百次幂积分商城活动，即可赚钱或获赠相应积分。" ,
                "去看看" , true , "开始兑换" , false , Color.parseColor("#c4c4c4")));
        listSecond.add(new MilimitFragmentEarnestCodeEntry(R.drawable.mi_limit_image_23 ,
                "社区评论" , "全球生活汇APP上发帖与互动也可获得相应积分。" ,
                "去玫瑰社区" , true , "开始兑换" , false , Color.parseColor("#f8f8f8")));

        adapterSecond = new MilimitFragmentEarnestCodeAdapter(listSecond , getContext());
        gridViewSecond.setAdapter(adapterSecond);
        fixGrdiView(gridViewSecond);
    }

    //girdview 布局填充
    private void initGirdView() {
        gridViewFirst = (GridView) view.findViewById(R.id.mi_limit_fragment_earnest_code_gridview_first);
        listFirst.clear();
        listFirst.add(new MilimitFragmentEarnestCodeEntry(R.drawable.mi_limit_image_14 ,
                "兑换礼品" , "在百次幂积分商城上兑换礼品，礼品包含大牌化妆品，使用日用品，进口母婴产品等价值百元的高品质产品。" ,
                "现在兑换" , true , "开始兑换" , false , Color.parseColor("#c4c4c4")));
        listFirst.add(new MilimitFragmentEarnestCodeEntry(R.drawable.mi_limit_image_15 ,
                "抵用现金" , "可在百次幂商城购买商品时抵用现金使用。" ,
                "去逛逛" , true , "开始兑换" , false , Color.parseColor("#f8f8f8")));
        listFirst.add(new MilimitFragmentEarnestCodeEntry(R.drawable.mi_limit_image_16 ,
                "积分提现" , "所累积积分还可存入积分银行，提现到个人银行卡。" ,
                "现在兑换" , false , "开始兑换" , false , Color.parseColor("#c4c4c4")));
        listFirst.add(new MilimitFragmentEarnestCodeEntry(R.drawable.mi_limit_image_17 ,
                "换你所爱" , "到星巴克，肯德基，HM等上千家百次幂合作品牌店中，用积分抵用现金消费使用。" ,
                "现在兑换" , false , "开始兑换" , false , Color.parseColor("#f8f8f8")));

        adapterFirst = new MilimitFragmentEarnestCodeAdapter(listFirst , getContext());
        gridViewFirst.setAdapter(adapterFirst);
        fixGrdiView(gridViewFirst);
    }



    //动态计算GridView的高度
    public void fixGrdiView(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MilimitFragmentEarnestCodeAdapter listAdapter = (MilimitFragmentEarnestCodeAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()/2); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 10;
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
}
