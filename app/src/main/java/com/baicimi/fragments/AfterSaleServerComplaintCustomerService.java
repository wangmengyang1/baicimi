package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/2.
 * 退货申请首页 投诉页面 等待幂客服介入
 */
public class AfterSaleServerComplaintCustomerService extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView layoutFirstState , layoutSecondState;
    private LinearLayout layoutFirst , layoutSecond;
    private boolean firstState , secondState;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.after_sale_server_complaint_customer_server , container , false);

        back = (ImageView) view.findViewById(R.id.after_sale_server_complaint_customer_server_back);
        back.setOnClickListener(this);

        //详细与订单信息展开
        initUnfold();


        return view;
    }

    //详细与订单信息展开
    private void initUnfold() {
        layoutFirstState = (TextView) view.findViewById(R.id.after_sale_server_complaint_customer_server_layoutstate_first);
        layoutSecondState = (TextView) view.findViewById(R.id.after_sale_server_complaint_customer_server_layoutstate_second);

        layoutFirst = (LinearLayout) view.findViewById(R.id.after_sale_server_complaint_customer_server_layout_first);
        layoutSecond = (LinearLayout) view.findViewById(R.id.after_sale_server_complaint_customer_server_layout_second);

        layoutFirstState.setOnClickListener(this);
        layoutSecondState.setOnClickListener(this);

        layoutFirst.setAlpha(0);
        layoutSecond.setAlpha(0);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.after_sale_server_complaint_customer_server_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.after_sale_server_complaint_customer_server_layoutstate_first:
                if (firstState){
                    layoutFirst.setVisibility(View.INVISIBLE);
                    layoutFirst.setAlpha(1);
                }else{
                    layoutFirst.setAlpha(0);
                }

                firstState = !firstState;
                break;
            case R.id.after_sale_server_complaint_customer_server_layoutstate_second:
                if (secondState){
                    layoutSecond.setVisibility(View.INVISIBLE);
                    layoutSecond.setAlpha(1);
                }else{
                    layoutSecond.setAlpha(0);
                }

                secondState = !secondState;
                break;
        }
    }
}
