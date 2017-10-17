package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.UrgeDeliverDialog;
import com.baicimi.view.UrgeDeliverSecondDialog;

/**
 * Created by Administrator on 2017/9/19.
 * 退货申请首页
 */

public class AfterSaleServerOrderFormSalesFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private TextView refundandreturntheproduct;
    private ImageView back;

    private int urgedthedeliveryIndex;
    private TextView urgedthedelivery , refund;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.after_sale_server_fragment , container , false);

        refundandreturntheproduct = (TextView) view.findViewById(R.id.order_form_fragment_refundandreturntheproduct);
//        refundandreturntheproduct.setOnClickListener(this);
        refundandreturntheproduct.setVisibility(View.GONE);

        back = (ImageView) view.findViewById(R.id.after_sale_server_fragment_back);
        back.setOnClickListener(this);

        urgedthedelivery = (TextView) view.findViewById(R.id.order_form_fragment_urgedthedelivery);
//        urgedthedelivery.setOnClickListener(this);
        urgedthedelivery.setVisibility(View.GONE);


        refund = (TextView) view.findViewById(R.id.order_form_fragment_refund);
        refund.setVisibility(View.GONE);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.order_form_fragment_refundandreturntheproduct:
//                startFragment(new AfterSaleServerRefundanFragment());//退货退款
//                break;
            case R.id.after_sale_server_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一界面
                break;
//            case R.id.order_form_fragment_urgedthedelivery:
//                //催促发货
//                if (urgedthedeliveryIndex == 0){
//                    UrgeDeliverDialog urgeDeliverDialog = new UrgeDeliverDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
//                    urgeDeliverDialog.show();
//                    urgedthedeliveryIndex++;
//                }else{
//                    UrgeDeliverSecondDialog urgeDeliverSecondDialog = new UrgeDeliverSecondDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
//                    urgeDeliverSecondDialog.show();
//                    urgedthedeliveryIndex++;
//                }
//                break;
        }
    }
}
