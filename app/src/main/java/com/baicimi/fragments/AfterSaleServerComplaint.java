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
 * Created by Administrator on 2017/12/28.
 * 退货申请首页 投诉页面
 */
public class AfterSaleServerComplaint extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView submit;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.after_sale_server_complaint , container , false);
        back = (ImageView) view.findViewById(R.id.after_sale_server_complaint_back);
        back.setOnClickListener(this);

        submit = (TextView) view.findViewById(R.id.after_sale_server_complaint_submit);
        submit.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.after_sale_server_complaint_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.after_sale_server_complaint_submit:
                //等待幂客服接入
                startFragment(new AfterSaleServerComplaintCustomerService());
                break;
        }
    }
}
