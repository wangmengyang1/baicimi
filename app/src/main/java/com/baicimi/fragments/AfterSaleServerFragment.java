package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/19.
 * 退货申请首页
 */

public class AfterSaleServerFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private TextView refundandreturntheproduct;
    private ImageView back;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.after_sale_server_fragment , container , false);

        refundandreturntheproduct = (TextView) view.findViewById(R.id.order_form_fragment_refundandreturntheproduct);
        refundandreturntheproduct.setOnClickListener(this);

        back = (ImageView) view.findViewById(R.id.after_sale_server_fragment_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.order_form_fragment_refundandreturntheproduct:
                startFragment(new AfterSaleServerRefundanFragment());
                break;
            case R.id.after_sale_server_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一界面
                break;
        }
    }
}
