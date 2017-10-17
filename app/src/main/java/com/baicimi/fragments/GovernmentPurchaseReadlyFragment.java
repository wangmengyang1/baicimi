package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/10/16.
 * 个人中心  政府采购  申请说明
 */
public class GovernmentPurchaseReadlyFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.government_purchase_readly_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.government_purchase_fragment_readly_back);
        back.setOnClickListener(this);


        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.government_purchase_fragment_readly_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
        }
    }
}
