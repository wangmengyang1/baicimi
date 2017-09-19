package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.interfaces.IntimacPaymentFirstInterface;
import com.baicimi.view.IntimacyPaymentDialog;

/**
 * Created by Administrator on 2017/8/16.
 */

public class IntimacyPaymentHomePageFragment extends BaseFragment implements View.OnClickListener ,IntimacPaymentFirstInterface{

    private View view;
    private ImageView back;
    private TextView dredge , byDredge , strategyTV;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.intimacy_payment_home_page , container , false);
        back = (ImageView) view.findViewById(R.id.back_intimacy_payment);
        back.setOnClickListener(this);

        dredge = (TextView) view.findViewById(R.id.intimacy_payment_home_page_textview_dredge);
        dredge.setOnClickListener(this);
        byDredge = (TextView) view.findViewById(R.id.intimacy_payment_home_page_textview_bydredge);
        byDredge.setOnClickListener(this);

        strategyTV = (TextView) view.findViewById(R.id.intimacy_payment_user_strategy_textivew);
        strategyTV.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_intimacy_payment:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.intimacy_payment_home_page_textview_dredge:
                startFragment(new IntimacyPaymentFirstFragment(0 , this));//开通
                break;
            case R.id.intimacy_payment_home_page_textview_bydredge:
                startFragment(new IntimacyPaymentFirstFragment(1 , this));//求开通
                break;
            case R.id.intimacy_payment_user_strategy_textivew:
                startFragment(new IntimacyPaymentUserMessageFragment());//攻略
                break;
        }
    }

    @Override
    public void getMessage(boolean state) {
        if(state){
            IntimacyPaymentDialog intimacyPaymentDialog = new IntimacyPaymentDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderSecond , this);
            intimacyPaymentDialog.setContentView(R.layout.intimacy_payment_dialog_view_fragment);
            intimacyPaymentDialog.show();
        }else{

        }
    }
}
