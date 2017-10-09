package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.FrequentlyQuestionAdapter;
import com.baicimi.adapter.TodayCosmeticsAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.FrequentlyQuestionEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/9.
 * 商品详情，信息，客户服务，问题详情，常见问题
 */
public class WentiDetailsFrequentlyQuention extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listView;
    private List<FrequentlyQuestionEntry> list = new ArrayList<>();
    private FrequentlyQuestionAdapter adapter;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.wenti_details_frequently_quention , container , false);

        //listview布局填充
        initListView();

        back = (ImageView) view.findViewById(R.id.wenti_detalis_frequently_question_back);
        back.setOnClickListener(this);

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.fragment_wenti_details_frequently_question_listview);
        list.clear();
        list.add(new FrequentlyQuestionEntry("1、如何使用积分抵扣现金？" , "选购商品时，在宝贝详情页勾选积分抵扣现金选项，即可使用积分抵扣现金。"));
        list.add(new FrequentlyQuestionEntry("2、订单提交后才发现信息填写错误怎么办？" , "在未发货时，您可以取消订单，重新下单，也可点击“客服”浮标与百次幂客服联系，修改订单错误信息。如已发货，可通过拒收后重拍的方法重新下单。"));
        list.add(new FrequentlyQuestionEntry("3、提交订单后什么时候发货？" , "提交订单后一般在24小时内发货，如有缺货情况，百次幂客服会提前告知。"));
        list.add(new FrequentlyQuestionEntry("4、在百次幂商城上购买的商品可以自取吗？" , "在百次幂商城上购买的商品可选择快递及自取两种形式，自取即到收货地址附近的百次幂分销点/店自行领取，每次自取商品可获得10积分回馈。"));
        list.add(new FrequentlyQuestionEntry("5、偏远地区可以送到吗？" , "一般偏远地区快递都可以普及到，特别偏远的地区可选择EMS。"));
        list.add(new FrequentlyQuestionEntry("6、退换货的运费谁来承担？" , "如因买家不喜欢、拍错、不合适或其他问题导致的退换货问题，运费又买家承担。如商品本身质量问题，或发错货等商城操作问题，运费由百次幂承担。"));
        list.add(new FrequentlyQuestionEntry("7、退货后什么时候退款？" , "退货后填写运单号与物流公司，24小时内款项自动退到支付账户内。"));
        list.add(new FrequentlyQuestionEntry("8、退货后退款到哪里？" , "退款退还到支付账户，如用幂钱包支付的款项，则退款直接退到幂钱包内。"));
        list.add(new FrequentlyQuestionEntry("9、我要如何查询我的包裹到哪里了？" , "在订单详情页中点击“查看物流”，可查询包裹的派送进度。也可自动联系百次幂分销点/店，询问包裹派送进度。"));
        list.add(new FrequentlyQuestionEntry("10、拒收包裹后什么时候退款？" , "拒收包裹后，百次幂收到拒收信息，在24小时内安排退款。"));
        adapter = new FrequentlyQuestionAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
    }

    @Override
    protected void initData() {

    }


    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        FrequentlyQuestionAdapter listAdapter = (FrequentlyQuestionAdapter) listView.getAdapter();
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
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+360);
        listView.setLayoutParams(params);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.wenti_detalis_frequently_question_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
        }
    }
}
