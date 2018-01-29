package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.OrderFormDealsucceedDissmessDialog;

/**
 * Created by Administrator on 2017/12/27.
 * 评价管理   物流评价 写评价
 */
public class EvaluateManagementFragmentWirte extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView dissmess;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.evaluate_mange_ment_fragment_write , container , false);

        back = (ImageView) view.findViewById(R.id.evaluate_mange_ment_fragment_write_back);
        back.setOnClickListener(this);

        dissmess = (TextView) view.findViewById(R.id.evaluate_namege_ment_fragment_write_dissmess);
        dissmess.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.evaluate_mange_ment_fragment_write_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.evaluate_namege_ment_fragment_write_dissmess:
                //评价成功
                //提交
                OrderFormDealsucceedDissmessDialog orderFormDealsucceedDissmessDialog = new OrderFormDealsucceedDissmessDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                orderFormDealsucceedDissmessDialog.show();
                break;
        }
    }
}
