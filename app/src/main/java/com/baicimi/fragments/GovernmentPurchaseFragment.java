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
 * Created by Administrator on 2017/9/27.
 * 个人中心订单政府采购页面
 */

public class GovernmentPurchaseFragment  extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView readly , myorderform;
    private int index;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.government_purchase_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.government_purchase_fragment_back);
        back.setOnClickListener(this);

        readly = (TextView) view.findViewById(R.id.government_purchase_fragment_readly);
        readly.setOnClickListener(this);

        myorderform = (TextView) view.findViewById(R.id.government_purchase_fragment_myorderform);
        myorderform.setOnClickListener(this);
        return view;
    }
    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.government_purchase_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.government_purchase_fragment_readly:
                //申请说明
                startFragment(new GovernmentPurchaseReadlyFragment());

                break;
            case R.id.government_purchase_fragment_myorderform:
                //我的政府采购
                startFragment(new GovernmentPurchaseMyorderformFragment());
                break;
        }
    }
}
